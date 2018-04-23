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

@WebServlet("/CreateGame_Validate")
public class CreateGame_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession mySession = request.getSession(false);
		
		// TO DELETE IF NOT WORKING
//		if (request.getParameter("JSESSIONID") != null) {
//		    Cookie userCookie = new Cookie("JSESSIONID", request.getParameter("JSESSIONID"));
//		    response.addCookie(userCookie);
//		} else {
//		    String sessionId = mySession.getId();
//		    Cookie userCookie = new Cookie("JSESSIONID", sessionId);
//		    response.addCookie(userCookie);
//		}
		
		boolean errorPresent = false;
		String gamename = request.getParameter("namebar");
		String numPlayers = request.getParameter("numplayers");
		int numNumPlayers = 0;
		
		String username = request.getParameter("currUser");
		
		List<User> users = (List<User>)mySession.getAttribute("users");
		Database database = (Database)mySession.getAttribute("database");
		User u = users.get(database.indexOfUser(username));
		
		List<GameSession> games = (List<GameSession>)mySession.getAttribute("games");
		
		String pageToForward = "/UserSearch.jsp";
		
		if (gamename == null || gamename.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessageGameName", "<font color=\"red\">Game must have a name!</font>");
			pageToForward = "/CreateGame.jsp";
		} else {
			for (int i = 0; i < games.size(); i++) {
				if (games.get(i).getName().equals(gamename)) {
					errorPresent = true;
					request.setAttribute("errorMessageGameName", "<font color=\"red\">Name Taken!</font>");
					pageToForward = "/CreateGame.jsp";
				}
			}
		}
		if (numPlayers == null) {
			errorPresent = true;
			request.setAttribute("errorMessagePlayerNumber", "<font color=\"red\">Must select desired number of players!</font>");
			pageToForward = "/CreateGame.jsp";
		} else {
			if (numPlayers.equals("Single Player")) {
				numNumPlayers = 1;
			} else if (numPlayers.equals("Multiplayer (2 Players)")) {
				numNumPlayers = 2;
			}
			else if (numPlayers.equals("Multiplayer (3 Players)")) {
				numNumPlayers = 3;
			}
			else if (numPlayers.equals("Multiplayer (3 Players)")) {
				numNumPlayers = 4;
			}
		}
		
		if (!errorPresent) {
			
			String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			
			String code = "";
			int count = 7;
			while (count-- != 0) {
				int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
				code += (ALPHA_NUMERIC_STRING.charAt(character));
			}
			
			System.out.println(code);
			
			GameSession newGame = new GameSession(gamename, numNumPlayers, code);
			
			newGame.addPlayer(u);
			u.setCurrGame(code);
			games.add(newGame);
			
			mySession.setAttribute("loggedInGame", newGame);
			mySession.setAttribute("games", games);
			
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
