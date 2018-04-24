package ProjectPackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ProjectPackage.Database;
import ProjectPackage.User;

@WebServlet("/Login_Validate")
public class Login_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		try {
			password = Hash.SHA512(password);
		} catch (HashException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean errorPresent = false;
		boolean usernameCorrect = false;
		String matchingPassword = "";
		boolean passwordCorrect = false;

		String pageToForward = "/Registered_User_Menu.jsp";

		HttpSession session = request.getSession(false);

		List<User> users = (List<User>)session.getAttribute("users");
		String file = (String)session.getAttribute("file");
		Database database = (Database)session.getAttribute("database");

		if (username == null || username.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessageLogin", "<font color=\"red\">Login Failed</font>");
			pageToForward = "/Login.jsp";
		}
		else if (username.trim().length() > 0) {
			boolean userExists = false;
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().equals(username)) {
					usernameCorrect = true;
					matchingPassword += users.get(i).getPassword();
					userExists = true;
					break;
				}
			}
			if (!userExists) {
				request.setAttribute("errorMessageLogin", "<font color=\"red\">Login Failed</font>");
				pageToForward = "/Login.jsp";
			}
		}

		if (password == null || password.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessageLogin", "<font color=\"red\">Login Failed</font>");
			pageToForward = "/Login.jsp";
		}
		else if (password.trim().length() > 0) {
			if (password.equals(matchingPassword)) {
				passwordCorrect = true;
			}
			else
			{
				request.setAttribute("errorMessageLogin", "<font color=\"red\">Login Failed</font>");
				pageToForward = "/Login.jsp";
			}
		}

		if (!errorPresent && usernameCorrect && passwordCorrect) {
			session.setAttribute("loggedIn", true);
			session.setAttribute("indexOfUser", database.indexOfUser(username));
			session.setAttribute("loggedInUser", users.get(database.indexOfUser(username)));
			
		}

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
	}


}
