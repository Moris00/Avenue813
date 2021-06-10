<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Register Page</title>
		<link  rel="stylesheet" href="register.css">
	</head>
	<body>
		<div class="bodycontent">
			<form name="formRegister">
				<div class="registerbox">
					<div class="title">
						<h1>Registrati, ORA!!!</h1>
					</div>
					<div class="registercontent">
						<div class="informazioniutente">
							<div class="insert">
								<div class="first-half">
									<div class="righe"><label for="name">Nome:</label>
									<input type="text" id="name" placeholder="Inserisci il tuo nome" onblur="return isValidForm()"><br>
									<p id="error"></p><br>
									</div>
									
									<div class="righe"><label for="cognome">Cognome:</label>
									<input type="text" id="cognome" placeholder="Inserisci il tuo cognome"><br>
									<p id="error"></p><br>
									</div>
									
									<div class="righe"><label for="username">Username:</label>
									<input type="text" id="username" placeholder="Inserisci il tuo username"><br>
									<p id="error"></p><br>
									</div>
									
									<div class="righe"><label for="username">Data di Nascita:</label>
									<input type="date" id="data_nascita"><br>
									<p id="error"></p><br>
									</div>
									
								</div>
								<div class="second-half">
									<div class="righe"><label for="name">Email:</label>
									<input type="text" id="email" placeholder="Inserisci la tua email"><br>
									<p id="error"></p><br>
									</div>
									
									<div class="righe"><label for="cognome">Password:</label>
									<input type="password" id="password" placeholder="Inserisci la tua password"><br>
									<p id="error"></p><br>
									</div>
									
									<div class="righe"><label for="username">Conferma Password:</label>
									<input type="password" id="confermedpsw" placeholder="Reinserisci la tua password"><br>
									<p id="error"></p><br>
									</div>
									
								</div>
							</div>
							
							<div class="space_button">
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
		
		<script>
		
			function allLetter(obj){
				var letters = /^[a-zA-Z]+$/;
				if(obj.value.match(letters)){
					return true;
				}else{
					return false;
				}
			}
		
		
		
			function isValidForm(){
				var uname = document.forms["formRegister"]["name"];
				
				if(uname.value == ""){
					document.getElementById("error").innerHTML = "*Il campo è vuoto";
					document.getElementById('error').style.color = "#ff0000";
					return false;
				}else{
					if(!allLetter(uname)){
						document.getElementById("error").innerHTML = "*Nome sbagliato";
						document.getElementById('error').style.color = "#ff0000";
						return false;
					}else{
							document.getElementById("error").innerHTML = "";
							document.getElementById('error').style.color = "#0a0a0a";
				
						return true;
					}
				}
				
				
				
			}
				
			
		
		</script>
		
	</body>
</html>