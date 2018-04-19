package ProjectPackage;

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

/**
 * Servlet implementation class EndGame
 */
@WebServlet("/EndGame")
public class EndGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession mySession = request.getSession(false);
		
		String score = request.getParameter("score");
		
		List<User> users = (List<User>)mySession.getAttribute("users");
		Database database = (Database)mySession.getAttribute("database");
		
		List<GameSession> games = (List<GameSession>)mySession.getAttribute("games");
		GameSession currGame = (GameSession)mySession.getAttribute("loggedInGame");
		
		User u = (User)mySession.getAttribute("loggedInUser");
		
		String pageToForward = "/WaitingForEnd.jsp";
		
		currGame.playerFinished();
		u.setCurrScore(score);
		
		if(currGame.gameFinished()) {
			pageToForward = "/FinalScores.jsp";
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
