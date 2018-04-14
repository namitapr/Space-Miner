<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<%@ page import ="ProjectPackage.User" %>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ProfilePage</title>
	</head>
	<body>
		<div id="GotoChoices">
			<form method="POST" action="ChoicePage.jsp"><button name="GotoChoices" id="GotoChoices">Return to Choices</button></form>
		</div>
		
		<% 
		HttpSession profileSession = request.getSession(false);
		User user = (User)session.getAttribute("loggedInUser");
		%>
		
		<h1><%= user.getUsername() %></h1>
		<br />
		<h3>Statistics:</h3>
		<h5>Win/Loss Ratio: <%= (double)user.getStats().getGamesWon()/(double)user.getStats().getGamesPlayed() %></h5>
		<h5>Total Wins: <%= user.getStats().getGamesWon() %></h5>
		<h5>Total Games Played: <%= user.getStats().getGamesPlayed() %></h5>
		<h5>Total Points Accumulated: <%= user.getStats().getPointsAccumulated() %></h5>
		
		<br />
		<h3>Change User Information</h3>
		<h5>(Change one at a time)</h5>
		<form method="POST" action="ResetInformation_Validate">
			<div id="userInputSection">
				<div id="usernameSection">
					<h3>Username</h3>	
					<div style="color: #FF0000;"><input name="inputUsername" id="inputUsername" type="text">${errorMessageUsername}</div>
				</div>
				<div id="passwordSection">
					<h3>Password</h3>
					<div style="color: #FF0000;"><input name="inputPassword" id="inputPassword" type="text">${errorMessagePassword}</div>
				</div>
				
				<div id="radioButtons">
					<table class="changedata">
						<tr>
						
							<td><input type="radio" id="changeusername" name="changedata"
								value="changeusername"> <label for="changeusername">Change Username</label></td>
							<td><input type="radio" id="changepassword" name="changedata"
							value="changepassword"> <label for="changepassword">Change Password</label></td>
							
						</tr>
					</table>
				</div>
				
				<div id="submitButtonSection">
					<br /><input id="ChangeInfoButton" type="submit" value="Change Information">
				</div>
			</div>
		</form>
		
	</body>
</html>