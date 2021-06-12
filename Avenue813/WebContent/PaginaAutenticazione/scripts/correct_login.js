/**
 * 
 */

function isUsername(obj){
	var letters = /^[a-zA-Z0-9]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}

function isValidUsername(){
	
	var username = document.forms["loginForm"]["username"];
	
	if(username.value == ""){
		document.getElementById("error_username").innerHTML = "*Campo vuoto";
	}else{
		if(!isUsername(username)){
			document.getElementById("error_username").innerHTML = "*Input non valido";
		}else{
			document.getElementById("error_username").innerHTML = "";
		}
	}
	
}

function isValidPassword(){
	
	var username = document.forms["loginForm"]["password"];
	
	if(username.value == ""){
		document.getElementById("error_password").innerHTML = "*Campo vuoto";
	}else{
		if(!isUsername(username)){
			document.getElementById("error_password").innerHTML = "*Input non valido";
		}else{
			document.getElementById("error_password").innerHTML = "";
		}
	}
	
}

function isValidLogin(){
	var functions = [isValidUsername(), isValidPassword()];
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