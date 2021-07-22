<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String error = (String) request.getAttribute("errorLogin"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register Page</title>
		<style><%@include file="register.css"%></style>
	</head>
	<body>
	 <script><%@include file="scripts/correct_auth.js"%></script> 
		<div class="bodycontent">
			<form name="formRegister" onsubmit ="return isValidForm()" action="/Avenue813/RegisterServlet" method="POST">
				<div class="registerbox">
					<div class="title">
						<h1>REGISTER,NOW!!!</h1>
					</div>
					<div class="registercontent">
						<div class="informazioniutente">
							<div class="insert">
								<div class="first-half">
									<div class="righe"><label for="name">Name:</label>
									<input type="text" id="name" name = "name" placeholder="Inserisci il tuo nome" onblur="return isValidName()"><br>
									<p id="error_name"></p><br>
									</div>
									
									<div class="righe"><label for="cognome">Surname:</label>
									<input type="text" id="cognome" name="secondname"  placeholder="Inserisci il tuo cognome" onblur="return isValidSecondName()"><br>
									<p id="error_secondname"></p><br>
									</div>
									
									<div class="righe"><label for="username">Username:</label>
									<input type="text" id="username"  name="username"placeholder="Inserisci il tuo username" onblur="return isValidUsername()"><br>
									<p id="error_username"></p><br>
									</div>
									
								</div>
								<div class="second-half">
									<div class="righe"><label for="email">Email:</label>
									<input type="text" id="email" name="email" placeholder="Inserisci la tua email" onblur="return isValidEmail()"><br>
									<p id="error_email"></p><br>
									</div>
									
									<div class="righe"><label for="password">Password:</label>
									<input type="password" id="password" name="password" placeholder="Inserisci la tua password" onblur="return isValidPassword()"><br>
									<p id="error_password"></p><br>
									</div>
									
									<div class="righe"><label for="confermedpsw">Confirm Password:</label>
									<input type="password" id="confermedpsw" name="password2" placeholder="Reinserisci la tua password" onblur="return isValidPassword2()"><br>
									<p id="error_password2"></p><br>
									</div>
									
								</div>
							</div>
							
							<div class="space_button">
								<%if(error != null){ %><div class="div_error"><p id="error"><%=error%></div><%} %>
								<div class="buttons">
									<input type="submit" value="Registrati" id="register_button">
									<input type="reset" value="Azzera" id="reset_button">
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			
			</form>
		
		</div>		
	</body>
</html>