package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ComposeMessage
 */
@WebServlet("/ComposeMessage")
public class ComposeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		request.getParameter("to");
		String sub=request.getParameter("Subject");
		request.getParameter("Message");
		if(sub.equals("NULL")||sub.equals("")) {
			sub="No Subject";
		}
		HttpSession session=request.getSession(false);
		String usrid=(String) session.getAttribute("user_id");
		if(usrid==null){
			response.sendRedirect("SignIn.jsp");
		}
		else{
			try {
				Date date = new Date();
				String cdate=date.toString();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
				Statement stmt=con.createStatement();
				stmt.executeUpdate("insert into inbox values('"+request.getParameter("to")+"','"+usrid+"','"+sub+"','"+request.getParameter("Message")+"','"+cdate+"')");
				response.sendRedirect("sent");
			}
			catch (Exception e) {
				pw.print(e);
			}
		}
	}

}
