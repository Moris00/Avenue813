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
	
	var name = document.forms["formRegister"]["name"];
	
	if(name.value == ""){
		document.getElementById("error_name").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_name').style.color = "#ff0000";;
		return false;
	}else{
		if(!isName(name)){
			document.getElementById("error_name").innerHTML = "*Input errato";
			document.getElementById('error_name').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_name").innerHTML = "";
			return true;
		}
	}
	
}

function isValidSecondName(){
	
	var name = document.forms["formRegister"]["cognome"];
	
	if(name.value == ""){
		document.getElementById("error_secondname").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_secondname').style.color = "#ff0000";;
		return false;
	}else{
		if(!isName(name)){
			document.getElementById("error_secondname").innerHTML = "*Input errato";
			document.getElementById('error_secondname').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_secondname").innerHTML = "";
			return true;
		}
	}
	
}

function isValidUsername(){
	
	var name = document.forms["formRegister"]["username"];
	
	if(name.value == ""){
		document.getElementById("error_username").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_username').style.color = "#ff0000";;
		return false;
	}else{
		if(!isUsername(name)){
			document.getElementById("error_username").innerHTML = "*Input errato";
			document.getElementById('error_username').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_username").innerHTML = "";
			return true;
		}
	}
	
}

function isValidEmail(){
	
	var name = document.forms["formRegister"]["email"];
	
	if(name.value == ""){
		document.getElementById("error_email").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_email').style.color = "#ff0000";;
		return false;
	}else{
		if(!isEmail(name)){
			document.getElementById("error_email").innerHTML = "*Input errato";
			document.getElementById('error_email').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_email").innerHTML = "";
			return true;
		}
	}
	
}

function isValidPassword(){
	
	var name = document.forms["formRegister"]["password"];
	
	
	
	
	if(name.value == ""){
		document.getElementById("error_password").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_password').style.color = "#ff0000";;
		return false;
	}else{
		if(name.value.length < 8){
				document.getElementById("error_password").innerHTML = "*Password meno di 8 caratteri";
				document.getElementById('error_password').style.color = "#ff0000";;
				return false;
		}else{
			if(!isUsername(name)){
				document.getElementById("error_password").innerHTML = "*Input errato";
				document.getElementById('error_password').style.color = "#ff0000";;
				return false;
			}else{
				document.getElementById("error_password").innerHTML = "";
				return true;
			}
		}
	}
	
}

function isValidPassword2(){
	
	var name = document.forms["formRegister"]["confermedpsw"];
	var password = document.forms["formRegister"]["password"];
	
	
	if(name.value == ""){
		document.getElementById("error_password2").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_password2').style.color = "#ff0000";;
		return false;
	}else{
		if(name.value != password.value){
			document.getElementById("error_password2").innerHTML = "*Password diverse";
			document.getElementById('error_password2').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_password2").innerHTML = "";
			return true;
		}
	}
	
}


function timeToClear(){
	document.getElementById("error_name").innerHTML = "";
	document.getElementById("error_secondname").innerHTML = "";
	document.getElementById("error_username").innerHTML = "";
	document.getElementById("error_email").innerHTML = "";
	document.getElementById("error_password").innerHTML = "";
}



function isValidForm(){
	var functions = [isValidName(), isValidSecondName(), isValidUsername(), isValidPassword(), isValidEmail(), isValidPassword2()];
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
	
		
	while(i < n){
		if(functions[i]){
			return true;
		}
		i++;
	}
	
	
	
	
	
	
}