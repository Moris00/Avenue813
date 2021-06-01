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
			<form>
				<div class="registerbox">
					<div class="title">
						<h1>Registrati, ORA!!!</h1>
					</div>
					<div class="registercontent">
						<div class="informazioniutente">
							<div class="insert">
								<div class="first-half">
									<div class="righe"><label for="name">Nome:</label>
									<input type="text" id="name" placeholder="Inserisci il tuo nome"><br>
									</div>
									
									<div class="righe"><label for="cognome">Cognome:</label>
									<input type="text" id="cognome" placeholder="Inserisci il tuo cognome"><br>
									</div>
									
									<div class="righe"><label for="username">Username:</label>
									<input type="text" id="username" placeholder="Inserisci il tuo username"><br>
									</div>
									
									<div class="righe"><label for="username">Data di Nascita:</label>
									<input type="date" id="data_nascita"><br>
									</div>
									
								</div>
								<div class="second-half">
									<div class="righe"><label for="name">Email:</label>
									<input type="text" id="email" placeholder="Inserisci la tua email"><br>
									</div>
									
									<div class="righe"><label for="cognome">Password:</label>
									<input type="password" id="password" placeholder="Inserisci la tua password"><br>
									</div>
									
									<div class="righe"><label for="username">Conferma Password:</label>
									<input type="password" id="confermedpsw" placeholder="Reinserisci la tua password"><br>
									</div>
									
								</div>
							</div>
						</div>
					</div>
					
					
				</div>
			
			</form>
		
		</div>
	</body>
</html>