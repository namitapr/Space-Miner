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
		<title>UserResultsPage</title>
		<link rel="stylesheet" type="text/css" href="UserResultsPage.css"/>
	</head>
	<body>
	<div id="NoInvite">
			<form id="SendInvite" method="POST" action="SendInvite"><button name="none" id="none">No Invite</button></form>
	</div>
	
	<% 
		HttpSession profileSession = request.getSession(false);
		User user = (User)session.getAttribute("loggedInUser");
		%>
		
		<div id="Page_Title">
			<h1>Users:</h1>
		</div>
		<div id="userInfoSection">
			<% List<User> responseResults = (List<User>)profileSession.getAttribute("userResults"); %>
			<% if (responseResults.size() == 0) { %>
				<font size="25" color="white">No User Found!</font>
			<%	} else { %>
				<table>
				<%
				for (int i = 0; i < responseResults.size(); i++) { %>
				
				<% if ((i == 0) || (i == 7) || (i == 14) || (i == 21)) { %>
					<tr>
				<% } %>
					<td>				<% // MAKE SURE TO ADD IN THAT YOU CANNOT INVITE YOURSELF %>
					
						<p id="username">@<%= responseResults.get(i).getUsername() %></p>
						
						<form id="SendInvite" action="SendInvite">
							<input type="text" name="currUser" id="currUser" style="display:none;" value="<%= responseResults.get(i).getUsername() %>" />
							<input type="text" name="loggedInUser" id="loggedInUser" style="display:none;" value="<%= user.getUsername() %>" />
							<button name="submit" id="inviteButton">Invite</button>
						</form>
						
					</td>
				<% if ((i == 6) || (i == 13) || (i == 20) || (i == 27)) { %>
					</tr>
				<% } %>
			
			<% }} %>
			</table>
		</div>
	</body>
</html>