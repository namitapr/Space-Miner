<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ page import ="java.util.ArrayList"%>
	<%@ page import ="java.util.List"%>
	<%@ page import ="ProjectPackage.User" %>
	<%@ page import ="ProjectPackage.Database" %>
	<%@ page import ="com.google.gson.Gson"%>
	<%@ page import ="com.google.gson.GsonBuilder"%>
	<%@ page import ="java.io.BufferedReader"%>
	<%@ page import ="java.io.FileReader"%>
	<%@ page import ="javax.servlet.http.HttpServlet"%>
	<%@ page import ="javax.servlet.http.HttpServletRequest"%>
	<%@ page import ="javax.servlet.http.HttpServletResponse"%>
	<%@ page import ="javax.servlet.http.HttpSession"%>
	<%@ page import ="java.io.FileNotFoundException"%>

	<%
		String file = "";
		List<User> users = null;
		Database database = null;
		Gson gson = null;
		
		try {
			gson = new GsonBuilder().setPrettyPrinting().create();
			file = this.getServletContext().getRealPath("/test.json");
			BufferedReader br = new BufferedReader(new FileReader(file));
			database = gson.fromJson(br, Database.class);
			users = database.getDatabase();
		} catch (FileNotFoundException fnf) {
			System.out.println("That file could not be found.");
		}
		
		HttpSession mySession = request.getSession();
		
		mySession.setAttribute("users", users);
		mySession.setAttribute("file", file);
		mySession.setAttribute("database", database);
		mySession.setAttribute("gson", gson);
		mySession.setAttribute("loggedIn", false);
		mySession.setAttribute("loggedInUser", null);
		mySession.setAttribute("loggedInGame", null);
		
	%>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Homepage</title>
		<link rel="stylesheet" type="text/css" href="Homepage.css"/>
	</head>
	<body>
	
		<div id="Main">
			<div id="Page_Title">
				<h1>SPACE MINER</h1>
			</div>
			
				<div class="container" id="SignupChoice">
					<img id="ship1" src="https://i.pinimg.com/originals/e3/de/61/e3de617109c31eeb92563a7cd2051e67.png">
					<form method="POST" action="Signup.jsp"><button name="signup" id="signup">Sign Up</button></form>
				</div>
				<div class="container" id="LoginChoice">
					<img id="ship2" src="https://starpointgemini.com/beta/wp-content/themes/gemini/images/ships/cruiser.png">
					<form method="POST" action="Login.jsp"><button name="login" id="login">Login</button></form>
				</div>
				<div class="container" id="GuestChoice">
					<img id="ship3" src="http://1.bp.blogspot.com/-ZRDN2sugdrg/UXa1qeFfjYI/AAAAAAAAVjo/1m10L-jCIgo/s1600/starcraft_2_render7E0.png">
					<form method="POST" action="ContinueAsGuest.jsp"><button name="guest" id="guest">Continue As Guest</button></form>
				</div>
			
		</div>
		
	</body>
</html>