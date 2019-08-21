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
 * Servlet implementation class NextForget
 */
@WebServlet("/NextForget")
public class NextForget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextForget() {
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
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mailbox","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select name, user_id from user_details where s_question='"+request.getParameter("SecurityQuestion")+"' AND s_answer='"+request.getParameter("SecurityAnswer")+"' AND (email='"+request.getParameter("RegMobile")+"' OR mobile='"+request.getParameter("RegMobile")+"') ");                          
			if(rs.next()) {
				HttpSession session=request.getSession();  
		        session.setAttribute("name",rs.getString("name"));
		        session.setAttribute("user_id", rs.getString("user_id"));
				RequestDispatcher dispatcher=request.getRequestDispatcher("/ChangePassword.jsp");
				dispatcher.forward(request, response);
			}
			else {
				pw.print("<html><head></head><body><b>You have provided the wrong data</b></body></html>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("/ForgetPassword.jsp");
				dispatcher.include(request, response);
			}
		}
		catch(Exception e) {
			pw.print(e);
		}
	}

}
