<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<link  rel="stylesheet" href="loginstyle.css">
		<script src ="scripts/correct_login.js"></script>
	</head>
	<body>
		<div class="login-div">
			
			<form name="loginForm" onsubmit="return isValidLogin()">
				<div class="login-content">
					<div class="content">
						<div class="textbox"><input type="text" name="username" id="username" size=18 id="text" placeholder="Username" onblur="return isValidUsername()"></div>
						<p id="error_username"></p>
						<div class="textbox"><input type="password" name="password" id="password" size=18 id="text"placeholder="Password" onblur="return isValidPassword()"></div>
						<p id="error_password"></p>
					</div>
					<div class="login">
						<input type="submit" value="Login" class="button">
						<input type="button" src="forgetten.jsp" value="Forget pass" class="button">
						<input type="button" onclick="location.href='register.jsp'" value="Register Page" class="button">
					</div>
				</div>
			</form>
			
		</div>
		
	</body>
</html>