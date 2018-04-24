<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ page import ="javax.servlet.http.HttpServlet"%>
	<%@ page import ="javax.servlet.http.HttpServletRequest"%>
	<%@ page import ="javax.servlet.http.HttpServletResponse"%>
	<%@ page import ="javax.servlet.http.HttpSession"%>
	<%@ page import ="ProjectPackage.User" %>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Score_Display</title>
	</head>
	<body>
		<% 
		HttpSession mySession = request.getSession();
		%>
		<h1>Score Page</h1>
		<br /><br /><br />
		<% if (mySession.getAttribute("loggedInUser") != null) { %>
			<h3><%= ((User)mySession.getAttribute("loggedInUser")).getUsername() %> Score:</h3>
			<h4><%= mySession.getAttribute("score") %></h4>
		<% } else { %>
			<h3>Guest Score:</h3>
			<h4><%= mySession.getAttribute("score") %></h4>
		<% } %>
		
		<div id="ReturnToMenu_Div">
			<form method="POST" action="ReturnToMenu_Validate"><button name="ReturnToMenu" id="ReturnToMenu">Return To Menu</button></form>
		</div>
		
	</body>
</html>