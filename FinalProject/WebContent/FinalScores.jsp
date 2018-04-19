<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ page import ="java.util.List"%>
	<%@ page import ="ProjectPackage.GameSession" %>
	<%@ page import ="ProjectPackage.User" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% 
			HttpSession profileSession = request.getSession(false);
			GameSession gs = (GameSession)session.getAttribute("loggedInGame");
			List<User> players = gs.getPlayers();
			
			for(int i=0; i<players.size(); i++) {
		%> 
				<h3><%=players.get(i).getUsername() %></h3>  
				<h5><%=players.get(i).getCurrScore() %></h5>		
		
		<% }%>	
</body>
</html>