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

@WebServlet("/GeneralStatistics_Validate")
public class GeneralStatistics_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageToForward = "/GeneralStatistics.jsp";
		
		HttpSession mySession = request.getSession(false);
		
		List<User> users = (List<User>)mySession.getAttribute("users");
		List<User> users_temp = (List<User>)mySession.getAttribute("users");
		
		int mostAccumulatedPoints = 0;
		String mostAccumulatedPointsUser = "";
		double topWinLoss = 0.0;
		String topWinLossUser = "";
		int topGamesPlayed = 0;
		String topGamesPlayedUser = "";
		
		int totalGamesPlayed = 0;
		int totalPointsAccumulated = 0;
		int totalUsers = users.size();
		
		for (int i = 0; i < users.size(); i++) {
			
			if (users.get(i).getStats().getPointsAccumulated() > mostAccumulatedPoints) {
				mostAccumulatedPoints = users.get(i).getStats().getPointsAccumulated();
				mostAccumulatedPointsUser = users.get(i).getUsername();
			}
			if ((((1.0) * users.get(i).getStats().getGamesWon()) / users.get(i).getStats().getGamesPlayed()) > topWinLoss) {
				topWinLoss = (((1.0) * users.get(i).getStats().getGamesWon()) / users.get(i).getStats().getGamesPlayed());
				topWinLossUser = users.get(i).getUsername();
			}
			if (users.get(i).getStats().getGamesPlayed() > topGamesPlayed) {
				topGamesPlayed = users.get(i).getStats().getGamesPlayed();
				topGamesPlayedUser = users.get(i).getUsername();
			}
			
			totalGamesPlayed += users.get(i).getStats().getGamesPlayed();
			totalPointsAccumulated += users.get(i).getStats().getPointsAccumulated();
			
		}
		
		request.setAttribute("mostAccumulatedPoints", mostAccumulatedPoints);
		request.setAttribute("mostAccumulatedPointsUser", mostAccumulatedPointsUser);
		request.setAttribute("topWinLoss", topWinLoss);
		request.setAttribute("topWinLossUser", topWinLossUser);
		request.setAttribute("topGamesPlayed", topGamesPlayed);
		request.setAttribute("topGamesPlayedUser", topGamesPlayedUser);
		request.setAttribute("totalGamesPlayed", totalGamesPlayed);
		request.setAttribute("totalPointsAccumulated", totalPointsAccumulated);
		request.setAttribute("totalUsers", totalUsers);
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
