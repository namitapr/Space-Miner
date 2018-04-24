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

/**
 * Servlet implementation class Signup_Validate
 */
@WebServlet("/Signup_Validate")
public class Signup_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		
		boolean errorPresent = false;
		
		String pageToForward = "/Registered_User_Menu.jsp";
		
		HttpSession session = request.getSession(false);
		
		List<User> users = (List<User>)session.getAttribute("users");
		Gson gson = (Gson)session.getAttribute("gson");
		Database database = (Database)session.getAttribute("database");
		String file = (String)session.getAttribute("file");
		
		if (username == null || username.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessageUsername", "<font color=\"red\">Entry Cannot Be Empty</font>");
			pageToForward = "/Signup.jsp";
		}
		
		
		else if (username.trim().length() > 0) {
			// Search JSON for username availability
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getUsername().equals(username)) {
					errorPresent = true;
					request.setAttribute("errorMessageUsername", "<font color=\"red\">Username Taken</font>");
					pageToForward = "/Signup.jsp";
					break;
				}
			}
		}
		
		if (password == null || password.trim().length() == 0) {
			errorPresent = true;
			request.setAttribute("errorMessagePassword", "<font color=\"red\">Entry Cannot Be Empty</font>");
			pageToForward = "/Signup.jsp";
		}
		
		if (!errorPresent) {
			// Add new user to JSON file
			User newUser = new User(username, password);
			users.add(newUser);
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
			
			session.setAttribute("users", users);
			request.setAttribute("file", file);
			
			session.setAttribute("loggedIn", true);
			session.setAttribute("indexOfUser", database.indexOfUser(username));
			session.setAttribute("loggedInUser", users.get(database.indexOfUser(username)));
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
