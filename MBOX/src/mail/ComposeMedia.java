package mail;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ComposeMedia
 */
@WebServlet("/MediaUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10,/*10MB*/  maxFileSize=1024*1024*50, /*50 MB*/maxRequestSize=1024*1024*100)
public class ComposeMedia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String dbURL = "jdbc:mysql://localhost:3306/mailbox";
    private String dbUser = "root";
    private String dbPass = "root";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeMedia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw=response.getWriter();
		Date date = new Date();
		HttpSession session=request.getSession(false);
		String usrid=(String) session.getAttribute("user_id");
		if(usrid==null){
			response.sendRedirect("SignIn.jsp");
		}
		else{
			InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("upload");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	         
	        Connection conn = null;
	        String message = null;
	        String cdate=date.toString();
	         
	        try {
	            // connects to the database
	        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	        	conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	        	
	        	//Setting data upload limit
	        	String querySetLimit = "SET GLOBAL max_allowed_packet=1024*1024*50;";  // 50 MB
	            Statement stSetLimit = conn.createStatement();
	            stSetLimit.execute(querySetLimit);
	        	
	           // Statement stmt=conn.createStatement();
	            // constructs SQL statement
	           String sql = "INSERT INTO multi_media (receiver, sender, time, data_type, data) values (?, ?, ?, ?, ?)";
	           PreparedStatement statement = conn.prepareStatement(sql);
	           statement.setString(1, request.getParameter("to"));
	           statement.setString(2, (String)session.getAttribute("user_id"));
	           statement.setString(3, cdate);
	           statement.setString(4, request.getParameter("media_type"));
	           if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                statement.setBlob(5, inputStream);
	            }
	           int row = statement.executeUpdate();
	            if (row > 0) {
	                message = "File Successfully Sent";
	            }
	           // stmt.executeUpdate("insert into multi_media values('"+request.getParameter("to")+"','"+(String)session.getAttribute("user_id")+"','"+cdate+"','"+request.getParameter("media_type")+"', '"+inputStream+"')");
	            // sends the statement to the database server
	            //message = "File Successfully Sent";
	            
	        }
	        catch (SQLException ex) {
	        	pw.print(ex);
	            message = "ERROR IN SENDING FILE: " + ex.getMessage();
	            ex.printStackTrace();
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // sets the message in request scope
	            request.setAttribute("Message", message);
	             
	            // forwards to the message page..
	            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
		}


		}
	}

}
