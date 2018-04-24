<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ page import ="javax.servlet.http.HttpServlet"%>
	<%@ page import ="javax.servlet.http.HttpServletRequest"%>
	<%@ page import ="javax.servlet.http.HttpServletResponse"%>
	<%@ page import ="javax.servlet.http.HttpSession"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="ContinueAsGuest.css"/>
		<title>Registered_User_Menu</title>
	</head>
	<body>
		
		<div id="LogOut">
			<form method="POST" action="Homepage.jsp"><button name="LogoutButton" id="LogoutButton">Log Out</button></form>
		</div>
		
		<div id="Main">
		
			<% 
			HttpSession mySession = request.getSession(); 
			mySession.setAttribute("UserType", "Registered");
			%>
			
			<a href="https://tranquil-ocean-92682.herokuapp.com/" target="_blank">Play Multiplayer Game</a>
		
			<div class="container" id="Play_Single_Player_Div">
				<img id="ship1" src="https://i.pinimg.com/originals/e3/de/61/e3de617109c31eeb92563a7cd2051e67.png">
				<form method="POST" action="PlaySinglePlayer_Validate"><button name="Play_Single_Player" id="Play_Single_Player">Play Single Player</button></form>
			</div>
			<!-- <div class="container" id="Play_Multiplayer_Div">
				<img id="ship2" src="https://starpointgemini.com/beta/wp-content/themes/gemini/images/ships/cruiser.png">
				<form method="POST" action="https://tranquil-ocean-92682.herokuapp.com/"><button name="Play_Multiplayer" id="Play_Multiplayer">Play Multiplayer</button></form>
			</div> -->
			<div class="container" id="Change_Login_Info_Div">
				<img id="ship3" src="http://1.bp.blogspot.com/-ZRDN2sugdrg/UXa1qeFfjYI/AAAAAAAAVjo/1m10L-jCIgo/s1600/starcraft_2_render7E0.png">
				<form method="POST" action=""><button name="Change_Login_Info" id="Change_Login_Info">Change Login Info</button></form>
			</div>
			
		</div>
	</body>
</html>