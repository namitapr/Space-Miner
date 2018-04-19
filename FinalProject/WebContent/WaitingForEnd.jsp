<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%@ page import ="ProjectPackage.GameSession" %>
<script>
	<% HttpSession profileSession = request.getSession(false);
	GameSession gs = (GameSession)session.getAttribute("loggedInGame"); %>

	$(document).ready(function() {
		
		while(true) {
			if(<%=gs.gameFinished()%>){
				window.location.href = "FinalScores.jsp";
			}
		}
		
		
	});
</script>

</head>
<body>
	<div id="pageTitle">
		<h1>Waiting for other players to finish the game...</h1>
	</div>
</body>
</html>