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
		<title>Continue_As_Guest</title>
	</head>
	<body>
		
		<div id="GoHome">
			<form method="POST" action="Homepage.jsp"><button name="GoHome" id="GoHome">Return Home</button></form>
		</div>
		
		<% 
		HttpSession mySession = request.getSession(); 
		mySession.setAttribute("UserType", "Guest");
		mySession.setAttribute("loggedInUser", null);
		%>
		
		<div id="Join_Single_Player_Div">
			<form method="POST" action="PlaySinglePlayer_Validate"><button name="Join_Single_Player" id="Join_Single_Player">Join Single Player</button></form>
		</div>
		
	</body>
</html>