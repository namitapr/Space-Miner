<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ChoicePage</title>
	</head>
	<body>
	
		<h3>What would you like to do?</h3>
		<form method="POST" action="CreateGame.jsp"><button name="CreateGameButton" id="CreateGameButton">Create a Game</button></form>
		<form method="POST" action="JoinGame"><button name="JoinGameButton" id="JoinGameButton">Join a Game</button></form>
		<form method="POST" action="ProfilePage.jsp"><button name="ProfilePageButton" id="ProfilePageButton">View Profile</button></form>
		
		<br />
		<br />
		<form method="POST" action="Homepage.jsp"><button name="LogoutButton" id="LogoutButton">Log Out</button></form>
		
	</body>
</html>