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

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
		//doGet(request, response);
		PrintWriter pw=response.getWriter();
		request.getParameter("ForgetPassUserName");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user_details where user_id= '"+request.getParameter("ForgetPassUserName")+"' ");
			if(rs.next()) {
				//pw.print("User Exist...");
				//pw.println("<a href=\"NextForgetPassword.jsp\">Click Here To Continue</a>");
				RequestDispatcher rd=request.getRequestDispatcher("/NextForgetPassword.jsp");
				rd.forward(request, response);
			}
			else {
				//pw.print("No Such User Exist...");
				//pw.println("<a href=\"SignIn.jsp\">Click Here To login</a>");
				RequestDispatcher rd=request.getRequestDispatcher("/ForgetPassword.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			pw.println(e);
		}
	}

}
