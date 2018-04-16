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
 * Servlet implementation class SendInvite
 */
@WebServlet("/SendInvite")
public class SendInvite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String currUser = request.getParameter("currUser");
			HttpSession userSearchSession = request.getSession(false);

			List<User> users = (List<User>)userSearchSession.getAttribute("users");
			Database database = (Database)userSearchSession.getAttribute("database");
			User loggedInUser = (User)request.getAttribute("loggedInUser");
			String gameID = loggedInUser.getCurrGame();
			
			for(int i=0; i<users.size(); i++) {
				if(users.get(i).getUsername().equals(currUser)) {
					users.get(i).addInvite(gameID);
				}
			}
	}

}
