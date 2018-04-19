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

import ProjectPackage.Database;
import ProjectPackage.User;

@WebServlet("/UserSearch_Validate")
public class UserSearch_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchUser = request.getParameter("searchbar");
		String pageToForward = "/UserResultsPage.jsp";
		
		HttpSession userSearchSession = request.getSession(false);
		List<User> users = (List<User>)userSearchSession.getAttribute("users");
		Database database = (Database)userSearchSession.getAttribute("database");
		List<User> userResults = new ArrayList<User>();
		
		if (searchUser.trim().equals("")) {
			for (int i = 0; i < users.size(); i++) {
				userResults.add(users.get(i));
			}
		}
		else {
			for (int i = 0; i < users.size(); i++) {

				String username = users.get(i).getUsername();

				if (username.length() >= searchUser.length()) {
					if (username.substring(0, searchUser.length()).equals(searchUser)) {
						userResults.add(users.get(i));
					}
				}
			}
		}
		
		request.setAttribute("resultsList", userResults);

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
	}

}
