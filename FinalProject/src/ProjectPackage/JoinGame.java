package ProjectPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JoinGame
 */
@WebServlet("/JoinGame")
public class JoinGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageToForward = "/JoinGame.jsp";

		HttpSession userSearchSession = request.getSession(false);

		List<User> users = (List<User>)userSearchSession.getAttribute("users");
		Database database = (Database)userSearchSession.getAttribute("database");
		User loggedInUser = (User)request.getAttribute("loggedInUser");
		List<String> userInvites = loggedInUser.getInvites();

		request.setAttribute("resultsList", userInvites);

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
	}
}
