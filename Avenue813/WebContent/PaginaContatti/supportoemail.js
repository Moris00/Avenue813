/**
 * 
 */

function isName(obj){
	var letters = /^[a-zA-Z ]+$/;
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

function isNumber(obj){
	var letters= /^[0-9]{10}$/;
	
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
	
}

function isValidName(){
	 
	var name = document.forms["formemail"]["name"];
	
	if(isName(name)){
		document.getElementById("name").style.borderColor = "green";
		return true;
	}else if(name.value == ""){
		document.getElementById("name").style.borderColor = "";
		return false;
	}else{
		document.getElementById("name").style.borderColor = "red";
		return false;
	}
	
}

function isValidSurname(){
	
	var surname = document.forms["formemail"]["surname"];
	
	if(isName(surname)){
		document.getElementById("surname").style.borderColor = "green";
		return true;	
	}else if(surname.value == ""){
		document.getElementById("surname").style.borderColor = "";
		return false;
	}else{
		document.getElementById("surname").style.borderColor = "red";
		return false;
	}
}

function isValidEmail(){
	
	var email = document.forms["formemail"]["email"];
	
	if(isEmail(email)){
		document.getElementById("email").style.borderColor = "green";
		return true;	
	}else if(email.value == ""){
		document.getElementById("email").style.borderColor = "";
		return false;
	}else {
		document.getElementById("email").style.borderColor = "red";
		return false;
	}
	
}

function isValidNumber(){
	
	var num = document.forms["formemail"]["phone"];
	
	if(isNumber(num)){
		document.getElementById("phone").style.borderColor = "green";
		return true;
	}else if(num.value == ""){
		document.getElementById("phone").style.borderColor ="";
		return false;
	}else{
		document.getElementById("phone").style.borderColor ="red";
		return false;
	}
}

function isEmptyText(){
	
	var text = document.getElementById("message");
	
	if(text.value == ""){
		text.style.borderColor = "red";
		return true;
	}else{
		text.style.borderColor = "green";
		return false;
	}
	
}

function isValidForm(){
	
	var funs = [isValidName(), isValidUsername(), isValidEmail(), isValidNumber(), !isEmptyText()];
	
	var i = 0;
	
	while(i < funs.length){
		if(!funs[i]){
			return false;
		}
		i++;
	}
	
	i = 0;
	
	while(i < funs.length){
		if(funs[i]){
			return true;
		}
		i++;
	}
	
	alert("Messaggio Inviato!");
	window.location("/Avenue813/PaginaHome/home.jsp");
	
}