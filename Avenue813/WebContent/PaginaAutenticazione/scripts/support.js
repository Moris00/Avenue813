function isName(obj){
	var letters = /^[a-zA-Z]+$/;
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
	
	var name = document.forms["supporto"]["nome"];
	
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
	
	var name = document.forms["supporto"]["cognome"];
	
	if(name.value == ""){
		document.getElementById("error_surname").innerHTML = "*Il campo e' vuoto";
		document.getElementById('error_surname').style.color = "#ff0000";;
		return false;
	}else{
		if(!isName(name)){
			document.getElementById("error_surname").innerHTML = "*Input errato";
			document.getElementById('error_surname').style.color = "#ff0000";;
			return false;
		}else{
			document.getElementById("error_surname").innerHTML = "";
			return true;
		}
	}
	
}


function isValidEmail(){
	
	var name = document.forms["supporto"]["mail"];
	
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
function isValidForm(){
	var functions = [isValidName(), isValidSecondName(), isValidEmail()];
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
































