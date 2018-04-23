package ProjectPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class JoinGame
 */
@WebServlet("/JoinGame")
public class JoinGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageToForward = "/JoinGame.jsp";

		HttpSession userSearchSession = request.getSession(false);

		// TO DELETE IF NOT WORKING
//		if (request.getParameter("JSESSIONID") != null) {
//		    Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
//		    response.addCookie(userCookie);
//		} else {
//		    String sessionId = userSearchSession.getId();
//		    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
//		    response.addCookie(userCookie);
//		}
		
		
		
		Gson gson = (Gson)userSearchSession.getAttribute("gson");
		String file = (String)userSearchSession.getAttribute("file");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Database database = gson.fromJson(br, Database.class);
		List<User> users = database.getDatabase();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(((User)userSearchSession.getAttribute("loggedInUser")).getUsername())) {
				userSearchSession.setAttribute("loggedInUser", users.get(i));
			}
		}
		
		List<String> userInvites = ((User)userSearchSession.getAttribute("loggedInUser")).getInvites();

		userSearchSession.setAttribute("userInvites", userInvites);

		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
	}
}
