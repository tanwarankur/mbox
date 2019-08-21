package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw=response.getWriter();
		try {
			String usrid=request.getParameter("userName");
			String pswd=request.getParameter("password");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user_details where user_id='"+usrid+"' And password='"+pswd+"' ");
			if(rs.next()) {
					HttpSession session=request.getSession();  
			        session.setAttribute("name",rs.getString("name"));
			        session.setAttribute("user_id", rs.getString("user_id"));
			        session.setAttribute("password", rs.getString("password"));
			        session.setAttribute("dob", rs.getString("dob"));
			        session.setAttribute("mobile", rs.getString("mobile"));
			        session.setAttribute("email",rs.getString("email"));
			        session.setAttribute("gender",rs.getString("gender"));
			        session.setAttribute("SQues",rs.getString("s_question"));
			        session.setAttribute("SAnswer",rs.getString("s_answer"));
					RequestDispatcher dispatcher=request.getRequestDispatcher("/profile.jsp");
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher=request.getRequestDispatcher("/login_failed.jsp");
					dispatcher.forward(request, response);	
				}
			}
			
			catch(Exception e) {
			pw.println(e);	
			}
	}

}
