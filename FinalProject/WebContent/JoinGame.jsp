<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="ProjectPackage.User" %>
	<%@ page import ="ProjectPackage.Database" %>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JoinGamePage</title>
		<link rel="stylesheet" type="text/css" href="JoinGame.css"/>
	</head>
	<body>
		<div id="GotoChoices">
			<form method="POST" action="ChoicePage.jsp"><button name="GotoChoices" id="GotoChoices">Return to Choices</button></form>
		</div>
		
		<div id ="pageTitle">
			<h1>Enter Game ID to Join:</h1>
		</div>
		
		<div id="userInputSection">
			<form id="GameSearch" action="GameJoin_Validate">
				<h3>${errorMessageJoin}</h3>
				<div id="SearchbarArea">
					<input type="text" name="searchbar" id="searchbar" placeholder="Join Game..." size="20">
					<button name="submit" id="joinButton">Join</button>
				</div>
				
			</form>
				
		<% 
		
			HttpSession mySession = request.getSession(false);
			
			List<User> responseResults = (List<User>)mySession.getAttribute("userInvites"); 
		%>
		<% if (responseResults.size() == 0) { %>
			<font size="25" color="white">No Invites Found!</font>
		<%	} else { %>
			<table>
			<%
			for (int i = 0; i < responseResults.size(); i++) { %>
				<tr>
				<td>	
					<%= responseResults.get(i) %>
				</td>
				</tr>
		<% }} %>
		</table>
	</div>
	</body>
</html>