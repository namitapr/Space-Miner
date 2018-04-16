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
	</head>
	<body>
		
		<% List<User> responseResults = (List<User>)request.getAttribute("resultsList"); %>
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
				
					<font size="3" color="black">@<%= responseResults.get(i).getUsername() %></font>
					
					<form id="SendInvite" action="SendInvite">
						<input type="text" name="currUser" style="display:none;" value="<%= responseResults.get(i).getUsername() %>" />
						<button name="submit">Invite</button>
					</form>
					
				</td>
			<% if ((i == 6) || (i == 13) || (i == 20) || (i == 27)) { %>
				</tr>
			<% } %>
		
		<% }} %>
		</table>
		
	</body>
</html>