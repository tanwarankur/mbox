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
 * Servlet implementation class DeletedMessageRecovery
 */
@WebServlet("/DeletedMessageRecovery")
public class DeletedMessageRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletedMessageRecovery() {
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
		HttpSession session=request.getSession(false);
		session.getAttribute("user_id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from deleted_mails where receiver_id='"+session.getAttribute("user_id")+"'");
			while(rs.next()) {
			String sender=rs.getString("sender_id");
			String time=rs.getString("date");
			Statement stmt1=con.createStatement();
				stmt1.executeUpdate("insert into inbox Select * from deleted_mails WHERE receiver_id='"+session.getAttribute("user_id")+"' AND sender_id='"+sender+"' AND date='"+time+"' ");
				stmt1.executeUpdate("delete from deleted_mails WHERE receiver_id='"+session.getAttribute("user_id")+"' AND sender_id='"+sender+"' AND date='"+time+"' ");	
			}
		}
		catch(Exception e) {
			pw.println(e);
		}
		finally {
			response.sendRedirect("inbox");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		String usrid=(String) session.getAttribute("user_id");
		if(usrid==null){
			response.sendRedirect("SignIn.jsp");
		
		if(session.getAttribute("password").equals(request.getParameter("password"))) {
			doGet(request, response);	
		}
		else {
			response.sendRedirect("DeleteRecov");
		}
	}

}
}
