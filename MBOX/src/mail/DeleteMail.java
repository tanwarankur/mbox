package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class DeleteMail
 */
@WebServlet("/DeleteMail")
public class DeleteMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(false);
		String userid=(String) session.getAttribute("user_id");
		HttpSession msgsession=request.getSession(false);
		PrintWriter pw=response.getWriter();
		String sender=(String) msgsession.getAttribute("sender");
		String time=(String) msgsession.getAttribute("time");
		//pw.print(sender+" "+time+" "+" "+sub+" "+userid);
		 
		if(userid==null) {
			response.sendRedirect("SignIn.jsp");
		}
		else {
			
			
			try {
		Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into deleted_mails Select * from inbox WHERE receiver_id='"+userid+"' AND sender_id='"+sender+"' AND date='"+time+"' ");
			stmt.executeUpdate("delete from inbox WHERE receiver_id='"+userid+"' AND sender_id='"+sender+"' AND date='"+time+"' ");
			msgsession.removeAttribute("subject");
			msgsession.removeAttribute("sender");
			msgsession.removeAttribute("time");
			RequestDispatcher rd=request.getRequestDispatcher("inbox");
			rd.forward(request, response);
			}
			catch (Exception e) {
			pw.println(e);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
