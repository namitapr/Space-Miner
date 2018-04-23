<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import ="ProjectPackage.User" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GuestChoicePage</title>
	</head>
	<body>
		
		<div id="LogOut">
			<form method="POST" action="Homepage.jsp"><button name="LogoutButton" id="LogoutButton">Log Out</button></form>
		</div>
		
		<% 
		HttpSession profileSession = request.getSession(false);
		profileSession.setAttribute("loggedInGame", null);
		User user = (User)session.getAttribute("loggedInUser");
		%>
		
		<div id="Page_Title">
			<h1>What would you like to do?</h1>
		</div>
		
		<div class="container" id="JoinGameChoice">
			<img id="ship2" src="https://starpointgemini.com/beta/wp-content/themes/gemini/images/ships/cruiser.png">
			<form method="POST" action="JoinGame">
				<%= user.getUsername() %><button name="JoinGameButton" id="JoinGameButton">Join a Game</button>
				<input type="text" name="currUser" id="currUser" style="display:none;" value="<%= user.getUsername() %>" />
			</form>
		</div>
		
	</body>
</html>