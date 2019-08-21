package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class inbox
 */
@WebServlet("/inbox")
public class inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("commonbar.jsp").include(request, response);
		HttpSession session=request.getSession(false);
		String usrid=(String) session.getAttribute("user_id");
		if(usrid==null){
			response.sendRedirect("SignIn.jsp");
		}
		else{
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>");
			pw.println("INBOX-Mbox");
			pw.println("</TITLE>");
			pw.println("</head>");
			pw.println("<body  bgcolor=\"lavender\">");
			pw.print("<h3><span style='float:right'>Hi, "+session.getAttribute("name")+"</span></h3>");
			pw.print("<center>");
			pw.print("<h1>Inbox</h1>");
			pw.print("</center>");
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				pw.print("<p>"+msg+"</p>");
			}
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from inbox where receiver_id='"+usrid+"'");
				pw.print("<center>");
				
				pw.print("<table border='2' style='width:70%;' bgcolor='lavender'>");
				pw.print("<tr style='background-color:darkslategrey;color:white'><td>Sender</td><td>Message</td><td>time</td></tr>");
				
					while(rs.next()){
						pw.print("<tr><td>"+rs.getString("sender_id")+"</td><td><a href='ViewMail?id="+rs.getString("date")+"'>"+rs.getString("subject")+"</a></td><td>"+rs.getString("date")+"</td></tr>");
					
				}
				
				
				pw.print("</table>");
				
				pw.print("</center>");
				pw.print("</body>");
				pw.print("</html>");
				con.close();
			}
			catch(Exception e){
				pw.print(e);
				}
			}
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
