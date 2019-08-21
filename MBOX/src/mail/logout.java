package mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
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
		HttpSession session  = request.getSession();
		if(session !=null) {
		try{      
		    session.removeAttribute("name");
			session.removeAttribute("user_id");
			session.removeAttribute("dob");
			session.removeAttribute("SQues");
			session.removeAttribute("SAnswer");
			session.removeAttribute("mobile");
			session.removeAttribute("email");
			session.removeAttribute("gender");
		    session.invalidate();                               
		    String pageToForward = request.getContextPath();
		    response.sendRedirect(pageToForward);
		    }
		catch (Exception e){
		    pw.println("error UserValidateServlet message : " +e.getMessage());
		    pw.println("error UserValidateServlet exception : " +e);
		}
		
		}
		if(session==null) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/SignIn.jsp");
			dispatcher.forward(request, response);
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
