<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reset_Information</title>
	</head>
	<body>
	
		<div id="GoToUserMenu">
			<form method="POST" action="Registered_User_Menu.jsp"><button name="MenuButton" id="MenuButton">Return to Menu</button></form>
		</div>
		
		<form method="POST" action="ResetInformation_Validate">
			<div id="userInputSection">
			<h3>Change User Information:</h3> ${successMessage}
			<h5>(Change one at a time)</h5>
				<div id="usernameSection">
					<h4>Username</h4>	
					<div style="color: #FF0000;"><input name="inputUsername" id="inputUsername" type="password" autocomplete="off">${errorMessageUsername}</div>
				</div>
				<div id="passwordSection">
					<h4>Password</h4>
					<div style="color: #FF0000;"><input name="inputPassword" id="inputPassword" type="password" autocomplete="off">${errorMessagePassword}</div>
				</div>
				
				<div id="radioButtons">
					<table class="changedata">
						<tr>
						
							<td><input type="radio" id="changeusername" name="changedata"
								value="changeusername"> <label for="changeusername">Change Username</label></td>
						</tr>
						<tr>
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