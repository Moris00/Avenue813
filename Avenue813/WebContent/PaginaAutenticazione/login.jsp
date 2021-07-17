<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String error = (String) request.getAttribute("errorLogin"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Page</title>
		<script src ="scripts/correct_login.js"></script>
		<style><%@include file="loginstyle.css" %></style>
	</head>
	<body>
	
		<div class="login-div">
		<br>
		          <h1 align="center">PLEASE ENTER YOUR CREDENTIAL</h1>
			
			<form name="loginForm" action="/Avenue813/LoginServlet" method="POST">
			<fieldset class="fields"> 
  		        <legend>Please provide your details below</legend> 
				<div class="login-content">
					<div class="content">
						<div class="textbox"><input type="text" name="username" id="username" size=20 id="text" placeholder="Username" onblur="return isValidUsername()"></div>
						<p id="error_username"></p>
						<div class="textbox"><input type="password" name="password" id="password" size=20 id="text" placeholder="Password" onblur="return isValidPassword()"></div>
						<p id="error_password"></p>
					</div>
					<% if(error != null){ %><div class="error_div"><p id="errorLogin"><%=request.getAttribute("errorLogin") %></div><%} %>
					<div class="login">
						<input type="submit" value="Login" class="button" >
						<input type="button" onclick="location.href='/Avenue813/PaginaAutenticazione/register.jsp'" value="Register Page" class="button" >
					</div>
				</div>
				</fieldset>
			</form>
			
		</div>
		
	</body>
</html>