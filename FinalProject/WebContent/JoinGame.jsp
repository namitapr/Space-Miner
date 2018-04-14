<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JoinGame</title>
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

	</body>
</html>