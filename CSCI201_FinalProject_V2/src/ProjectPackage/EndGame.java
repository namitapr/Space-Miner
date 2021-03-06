package ProjectPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EndGame")
public class EndGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageToForward = "/ScorePage.jsp";
		
		String score = request.getParameter("score");
		
		HttpSession mySession = request.getSession(false);
		
		String userType = (String)mySession.getAttribute("UserType");
		mySession.setAttribute("score", score);
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
