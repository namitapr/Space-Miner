<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>GeneralStatistics</title>
		<link rel="stylesheet" type="text/css" href="GeneralStatistics.css"/>
	</head>
	<body>
		<div id="GoHome">
			<form method="POST" action="Homepage.jsp"><button name="GoHome" id="GoHome">Return Home</button></form>
		</div>
		
		<div id="pageTitle">
			<h1>General Statistics</h1>
		</div>
		
		<div id="userInfoSection">
			<h4>Most Accumulated Points:</h4>
			<h6>User: <%= request.getAttribute("mostAccumulatedPointsUser") %></h6>
			<h6>Value: <%= request.getAttribute("mostAccumulatedPoints") %></h6>
			
			<h4>Top Win/Loss Ratio:</h4>
			<h6>User: <%= request.getAttribute("topWinLossUser") %></h6>
			<h6>Value: <%= request.getAttribute("topWinLoss") %></h6>
			
			<h4>Most Games Played:</h4>
			<h6>User: <%= request.getAttribute("topGamesPlayedUser") %></h6>
			<h6>Value: <%= request.getAttribute("topGamesPlayed") %></h6>
			
			<h4>Total Games Played: <%= request.getAttribute("totalGamesPlayed") %></h4>
			
			<h4>Total Points Accumulated: <%= request.getAttribute("totalPointsAccumulated") %></h4>
			
			<h4>Total Users: <%= request.getAttribute("totalUsers") %></h4>
		</div>
	</body>
</html>