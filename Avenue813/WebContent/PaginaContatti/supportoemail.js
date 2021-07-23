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

function isValidName(obj){
	 
	var name = document.forms["formemail"]["name"];
	
	if(isName(obj)){
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