package mail;


import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class view_Data
 */
@WebServlet("/view_Data")
public class view_Data extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	Blob image = null;
	byte[ ] imgData = null ;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_Data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String file_type="";
		//PrintWriter pw=response.getWriter();
		String id=request.getParameter("id");
		HttpSession session=request.getSession(false);
		String usrid=(String) session.getAttribute("user_id");
		if(usrid==null){
			response.sendRedirect("SignIn.jsp");
		}
		else{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select data,data_type from multi_media where receiver='"+usrid+"' And time='"+id+"'");	
			if (rs.next()) {
				file_type=rs.getString(2);
				image = rs.getBlob(1);
				imgData = image.getBytes(1,(int)image.length());
				}
			else {
				//pw.println("File not found for given id>");
				return;
				}
			if(file_type.equals("Image")) {
				response.setContentType("image/jpg");
				OutputStream o = response.getOutputStream();
				o.write(imgData);
		        o.flush();
		        o.close();
				
			}
			if(file_type.equals("PDF")) {
	        	response.setHeader("Content-Type", "application/pdf");
	        	OutputStream o = response.getOutputStream();
				o.write(imgData);
		        o.flush();
		        o.close();
	        	
			}
			if(file_type.equals(".doc/word")) {
				response.setContentType("application/msword");
	        	OutputStream o = response.getOutputStream();
				o.write(imgData);
		        o.flush();
		        o.close();
	        	
	        }
			if(file_type.equals("Audio")) {
	        	response.setContentType("video/mp4");
	        	OutputStream o = response.getOutputStream();
				o.write(imgData);
		        o.flush();
		        o.close();
	        	
	        }
			if(file_type.equals("Video")) {
	        	response.setContentType("video/mp4");
	        	OutputStream o = response.getOutputStream();
				o.write(imgData);
		        o.flush();
		        o.close();
	        	
	        }
			/*response.setHeader("Content-Type", "application/pdf");
		OutputStream o = response.getOutputStream();
			o.write(imgData);
	        o.flush();
	        o.close();*/
	        
		}
		catch(Exception e) {
			e.printStackTrace();
			//out.println("Unable To Display File");
			//pw.println("File Display Error=  "+e);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
