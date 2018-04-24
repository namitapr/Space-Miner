package ProjectPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet("/ResetInformation_Validate")
public class ResetInformation_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("inputUsername");
		String password = request.getParameter("inputPassword");
		String changedata = request.getParameter("changedata");
		
		boolean errorPresent = false;
		
		String pageToForward = "/ResetInformation.jsp";
		
		HttpSession session = request.getSession(false);
		
		List<User> users = (List<User>)session.getAttribute("users");
		Gson gson = (Gson)session.getAttribute("gson");
		Database database = (Database)session.getAttribute("database");
		String file = (String)session.getAttribute("file");
		
		if (changedata == null) {
			
			errorPresent = true;
			request.setAttribute("errorMessageUsername", "<font color=\"red\">Must Enter Information to Change</font>");
			pageToForward = "/ResetInformation.jsp";
			
		}
		else if (changedata.equals("username")) {
			if (username == null || username.trim().length() == 0) {
				errorPresent = true;
				request.setAttribute("errorMessageUsername", "<font color=\"red\">Entry Cannot Be Empty</font>");
				pageToForward = "/ResetInformation.jsp";
			}
			
			
			else if (username.trim().length() > 0) {
				// Search JSON for username availability
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getUsername().equals(username)) {
						errorPresent = true;
						request.setAttribute("errorMessageUsername", "<font color=\"red\">Username Taken</font>");
						pageToForward = "/ResetInformation.jsp";
						break;
					}
				}
			}
		}
		
		else if (changedata.equals("password")) {
			if (password == null || password.trim().length() == 0) {
				errorPresent = true;
				request.setAttribute("errorMessagePassword", "<font color=\"red\">Entry Cannot Be Empty</font>");
				pageToForward = "/ResetInformation.jsp";
			}
		}
		
		
		if (!errorPresent) {
			User user = (User)session.getAttribute("loggedInUser");
			if (changedata.equals("username")) {
				user.setUsername(username);
			} else {
				try {
					password = Hash.SHA512(password);
				} catch (HashException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user.setPassword(password);
			}
			
			database.setUsers(users);
			request.setAttribute("successMessage", "<font color=\"green\">SUCCESS!</font>");
			
			
			
			FileWriter fw;
			String jsonString = gson.toJson(database);
			try {
				fw = new FileWriter(file);
				fw.write(jsonString);
				System.out.println(jsonString);
				fw.flush();
				fw.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("users", users);
			request.setAttribute("file", file);
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}


}
