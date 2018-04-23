package ProjectPackage;

import java.io.FileWriter;
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
		
		Gson gson = (Gson)mySession.getAttribute("gson");
		String file = (String)mySession.getAttribute("file");
		database.setUsers(users);
		
		FileWriter fw;
		String jsonString = gson.toJson(database);
		try {
			fw = new FileWriter(file);
			fw.write(jsonString);
			//System.out.println(jsonString);
			fw.flush();
			fw.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// MAYBE FIX THIS
		mySession.setAttribute("users", users);
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
