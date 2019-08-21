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

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String user_id=request.getParameter("uname");
		String pswd=request.getParameter("pswd");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String sQues=request.getParameter("sQuestion");
		String sAns=request.getParameter("sAnswer");
		String email=request.getParameter("RegEmail");
		String mobile=request.getParameter("Mobile");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			stmt.executeUpdate("insert into user_details values('"+name+"','"+user_id+"','"+pswd+"','"+gender+"', '"+dob+"','"+sQues+"','"+sAns+"','"+email+"','"+mobile+"')"); 
		}
			catch(Exception e) {
			pw.println(e);	
			}
		RequestDispatcher dispatcher=request.getRequestDispatcher("/SignIn.jsp");
		dispatcher.forward(request, response);
	}

}
