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

@WebServlet("/GameJoin_Validate")
public class GameJoin_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gameID = request.getParameter("searchbar");
		boolean errorPresent = false;
		boolean gameFound = false;
		String pageToForward = ""; // NEED TO CHANGE THIS LATER
		HttpSession mySession = request.getSession(false);
		
		if (gameID == null || gameID.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessageJoin", "<font color=\"red\">Must Enter Game Name!</font>");
			pageToForward = "/JoinGame.jsp";
		} else {
			List<GameSession> games = (List<GameSession>)mySession.getAttribute("games");
			for (int i = 0; i < games.size(); i++) {
				if (games.get(i).getId().equals(gameID)) {
					gameFound = true;
				}
			}
			
			if (!gameFound) {
				request.setAttribute("errorMessageJoin", "<font color=\"red\">Game Not Found!</font>");
				pageToForward = "/JoinGame.jsp";
			}
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
