<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Registered_User_Menu</title>
	</head>
	<body>
		
		<div id="LogOut">
			<form method="POST" action="Homepage.jsp"><button name="LogoutButton" id="LogoutButton">Log Out</button></form>
		</div>
		
		
		
		<div id="Play_Single_Player_Div">
			<form method="POST" action=""><button name="Play_Single_Player" id="Play_Single_Player">Play Single Player</button></form>
		</div>
		<div id="Play_Multiplayer_Div">
			<form method="POST" action=""><button name="Play_Multiplayer" id="Play_Multiplayer">Play Multiplayer</button></form>
		</div>
		<div id="Change_Login_Info_Div">
			<form method="POST" action=""><button name="Change_Login_Info" id="Change_Login_Info">Change Login Info</button></form>
		</div>
		
	</body>
</html>