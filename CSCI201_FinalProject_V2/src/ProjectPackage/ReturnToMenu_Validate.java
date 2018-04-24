package ProjectPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReturnToMenu_Validate")
public class ReturnToMenu_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageToForward;
		
		HttpSession mySession = request.getSession(false);
		
		String userType = (String)mySession.getAttribute("UserType");
		
		if (userType.equals("Registered")) {
			pageToForward = "/Registered_User_Menu.jsp";
		} else {
			pageToForward = "/ContinueAsGuest.jsp";
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(pageToForward);
		dispatch.forward(request, response);
		
	}

}
