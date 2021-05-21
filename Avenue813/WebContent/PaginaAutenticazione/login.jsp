<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<link  rel="stylesheet" href="loginstyle.css">
	</head>
	<body>
		<div class="login-div">
			
			<form class="login-content">
				<div class="content">
					<p align=center><label for="username">Username</label><br>
					<input type="text" name="username" id="username" required size=18 id="text"><br>
					<label for="password">Password</label><br>
					<input type="password" name="password" id="password" required size=18 id="text"><br>
				</div>
				<div class="login">
					<input type="submit" value="Login">
					<input type="button" src="forgetten.jsp" value="Forget pass" id="button">
				</div>
			</form>
			
		</div>
		
	</body>
</html>