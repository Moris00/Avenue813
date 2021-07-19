/**
 * 
 */

function isName(obj){
	var letters = /^[a-zA-Z]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}

}

function isUsername(obj){
	var letters = /^[a-zA-Z0-9]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}

function isPasswords(obj){
	var letters = /^[a-zA-Z0-9]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}

function isEmail(obj){
	var letters = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}


function isValidName(){
	var nome = document.forms["dati"]["nome"];
	
	if(isName(nome)){
		document.getElementById("errore").innerHTML ="";
		document.getElementById("nome").style.borderColor = "green";
		return true;
	}else if(nome.value == ""){
		document.getElementById("errore").innerHTML ="Nome vuoto";
		document.getElementById("nome").style.borderColor = "black";
		return false;
	}else{
		document.getElementById("errore").innerHTML ="Nome errato!";
		document.getElementById("nome").style.borderColor = "black";
		return false;
	}
}

function isValidSName(){
	var cognome = document.forms["dati"]["cognome"];
	
	if(isName(cognome)){
		document.getElementById("errore").innerHTML ="";
		document.getElementById("cognome").style.borderColor = "green";
		return true;
	}else if(nome.value == ""){
		document.getElementById("errore").innerHTML ="Cognome vuoto";
		document.getElementById("cognome").style.borderColor = "black";
		return false;
	}else{
		document.getElementById("errore").innerHTML ="Cognome errato!";
		document.getElementById("cognome").style.borderColor = "red";
		return false;
	}
}

function isValidUsername(){
	
	var username = document.forms["dati"]["username"];
	
	if(username.value == ""){
		document.getElementById("errore").innerHTML = "Username vuoto";
		document.getElementById("username").style.borderColor = "black";
		return false;
	}else{
		if(!isUsername(username)){
			document.getElementById("errore").innerHTML = "Username non valido";
			document.getElementById("username").style.borderColor = "red";
			return false;
		}else{
			document.getElementById("errore").innerHTML = "";
			document.getElementById("username").style.borderColor = "green";
			return true;
		}
	}
	
}

function isValidEmail(){
	
	var name = document.forms["dati"]["email"];
	
	if(name.value == ""){
		document.getElementById("errore").innerHTML = "L'email e' vuoto";
		document.getElementById("email").style.borderColor = "black";
		return false;
	}else{
		if(!isEmail(name)){
			document.getElementById("errore").innerHTML = "Email errata";
			document.getElementById("email").style.borderColor = "red";
			return false;
		}else{
			document.getElementById("errore").innerHTML = "";
			document.getElementById("email").style.borderColor = "green";
			return true;
		}
	}
	
}

function isValidPassword(){
	
	var name = document.forms["dati"]["pass1"];
	
	
	
	
	if(name.value == ""){
		document.getElementById("errore").innerHTML = "Password e' vuoto";
		document.getElementById('pass1').style.color = "black";;
		return false;
	}else{
		if(name.value.length < 8){
				document.getElementById("errore").innerHTML = "Password meno di 8 caratteri";
				document.getElementById('pass1').style.borderColor = "red";
				return false;
		}else{
			if(!isUsername(name)){
				document.getElementById("errore").innerHTML = "Password errata";
				document.getElementById('pass1').style.borderColor = "red";
				return false;
			}else{
				document.getElementById("errore").innerHTML = "";
				document.getElementById('pass1').style.borderColor = "green";
				return true;
			}
		}
	}
	
}




function showPass1(){
	var pass = document.getElementById("pass1");
	
	if(pass.type === "password"){
		pass.type = "text";
	}else{
		pass.type = "password";
	}
}




function isValidForm(){
	var functions = [isValidName(), isValidSName(), isValidUsername(), isValidPassword(), isValidEmail()];
	var i = 0;
	var n = functions.length;
	while(i < n){
		if(!functions[i]){
			return false;
		}
		i++;
		
	}
	
	while(i < n){
		if(functions[i]){
			return true;
		}
		i++;
		
	}

	
	
	
	
}


