<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>UserSearch</title>
		<link rel="stylesheet" type="text/css" href="UserSearch.css"/>
	</head>
	<body>
		
		<div id="pageTitle">
			<h3>Search for Users to Invite:</h3>
		</div>
		
		<div id="userInputSection">
			<form id="UserSearch" action="UserSearch_Validate">
				
				<div id="SearchbarArea">
					<input type="text" name="searchbar" id="searchbar" placeholder="Search for Users..." size="20">
					<br />
					<button name="submit" id="searchButton">Search</button>
				</div>
				
			</form>
		</div>
		
	</body>
</html>