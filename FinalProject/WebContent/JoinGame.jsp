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
	</head>
	<body>
		<div id="GotoChoices">
			<form method="POST" action="ChoicePage.jsp"><button name="GotoChoices" id="GotoChoices">Return to Choices</button></form>
		</div>
		
		<h3>Enter Game ID to Join:</h3>
		
		<form id="GameSearch" action="GameJoin_Validate">
			<h3>${errorMessageJoin}</h3>
			<div id="SearchbarArea">
				<input type="text" name="searchbar" id="searchbar" placeholder="Join Game..." size="20">
				<button name="submit">Join</button>
			</div>
			
		</form>
				
		<% List<User> responseResults = (List<User>)request.getAttribute("resultsList"); %>
		<% if (responseResults.size() == 0) { %>
			<font size="25" color="white">No Invites Found!</font>
		<%	} else { %>
			<table>
			<%
			for (int i = 0; i < responseResults.size(); i++) { %>
			
			<% if ((i == 0) || (i == 7) || (i == 14) || (i == 21)) { %>
				<tr>
			<% } %>
				<td>	
				
					<font size="3" color="black">@<%= responseResults.get(i) %></font>
					
				</td>
			<% if ((i == 6) || (i == 13) || (i == 20) || (i == 27)) { %>
				</tr>
			<% } %>
		
		<% }} %>
		</table>

	</body>
</html>