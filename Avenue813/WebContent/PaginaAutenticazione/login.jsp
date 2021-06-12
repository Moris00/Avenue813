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
			
			<form onsubmit="return isValidLogin()">
				<div class="login-content">
					<div class="content">
						<div class="textbox"><input type="text" name="username" id="username" required size=18 id="text" placeholder="Username"></div><br>
						<div class="textbox"><input type="password" name="password" id="password" required size=18 id="text"placeholder="Password"></div><br>
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