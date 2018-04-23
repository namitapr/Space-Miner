package ProjectPackage;

import java.io.FileWriter;
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

import com.google.gson.Gson;

@WebServlet("/ContinueAsGuest_Validate")
public class ContinueAsGuest_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageToForward = "/GuestChoicePage.jsp";
		
		HttpSession session = request.getSession(false);
		List<User> users = (List<User>)session.getAttribute("users");
		Gson gson = (Gson)session.getAttribute("gson");
		Database database = (Database)session.getAttribute("database");
		String file = (String)session.getAttribute("file");
		
		int count = 0;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().substring(0, 5).equals("Guest")) {
				++count;
			}
		}
		
		User guestUser = new User("Guest" + (count + 1), "Guest" + (count + 1), new Statistics(0,0,0), new ArrayList<String>(), "", "0");
		users.add(guestUser);
		database.setUsers(users);
		
		FileWriter fw;
		String jsonString = gson.toJson(database);
		try {
			fw = new FileWriter(file);
			fw.write(jsonString);
			fw.flush();
			fw.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		session.setAttribute("users", users);
		session.setAttribute("loggedIn", true);
		session.setAttribute("indexOfUser", database.indexOfUser("Guest" + (count + 1)));
		session.setAttribute("loggedInUser", users.get(database.indexOfUser("Guest" + (count + 1))));
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
