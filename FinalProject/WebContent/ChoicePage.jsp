<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ChoicePage</title>
		<link rel="stylesheet" type="text/css" href="ChoicePage.css"/>
	</head>
	<body>
		<div id="LogOut">
			<form method="POST" action="Homepage.jsp"><button name="LogoutButton" id="LogoutButton">Log Out</button></form>
		</div>
		<div id="Main">
			<div id="Page_Title">
				<h1>What would you like to do?</h1>
			</div>
			<div class="container" id="CreateGameChoice">
				<img id="ship1" src="https://i.pinimg.com/originals/e3/de/61/e3de617109c31eeb92563a7cd2051e67.png">
				<form method="POST" action="CreateGame.jsp"><button name="CreateGameButton" id="CreateGameButton">Create a Game</button></form>
			</div>
			<div class="container" id="JoinGameChoice">
				<img id="ship2" src="https://starpointgemini.com/beta/wp-content/themes/gemini/images/ships/cruiser.png">
				<form method="POST" action="JoinGame"><button name="JoinGameButton" id="JoinGameButton">Join a Game</button></form>
			</div>
			<div class="container" id="ProfilePageChoice">
				<img id="ship3" src="http://1.bp.blogspot.com/-ZRDN2sugdrg/UXa1qeFfjYI/AAAAAAAAVjo/1m10L-jCIgo/s1600/starcraft_2_render7E0.png">
				<form method="POST" action="ProfilePage.jsp"><button name="ProfilePageButton" id="ProfilePageButton">View Profile</button></form>
			</div>
			
			<br />
			<br />
		</div>
	</body>
</html>