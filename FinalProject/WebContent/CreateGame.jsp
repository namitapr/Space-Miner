<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>CreateGame</title>
	</head>
	<body>
	
		<div id="GotoChoices">
			<form method="POST" action="ChoicePage.jsp"><button name="GotoChoices" id="GotoChoices">Return to Choices</button></form>
		</div>
		
		<h2>Set Up Your Game</h2>
		
		<form class="setupform" name="setupform" action="CreateGame_Validate">

			<h5>Game Name: ${errorMessageGameName}</h5>
			<input type="text" name="namebar" id="namebar"
					placeholder="New Game">
			
			<h5>Select the Number of Players: ${errorMessagePlayerNumber}</h5>
			<div id="radioButtons">
				<table class="NumPlayers">
					<tr>
					
						<td><input type="radio" id="singleplayer" name="numplayers"
							value="singleplayer"> <label for="singleplayer">Single Player</label></td>
						
					</tr>
				</table>
				<br />
				<table class="NumPlayers">
					<tr>
					
						<td><input type="radio" id="multiplayer2p" name="numplayers"
							value="multiplayer2p"> <label for="multiplayer2p">Multiplayer (2 Players)</label></td>
					
						<td><input type="radio" id="multiplayer3p" name="numplayers"
							value="multiplayer3p"> <label for="multiplayer3p">Multiplayer (3 Players)</label></td>
	
						<td><input type="radio" id="multiplayer4p" name="numplayers"
							value="multiplayer4p"> <label for="multiplayer4p">Multiplayer (4 Players)</label></td>
							
					</tr>
				</table>
			</div>
			
			<br /><button name="submit">Continue...</button>
			
		</form>
		
		
	</body>
</html>