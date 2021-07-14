function isName(obj){
	var letters = /^[a-zA-Z]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}

function isVia(obj){
	var letters = /^[A-Za-z0-9 ]{6,35}$/;
	
	if(obj.value.match(letters)){
			return true;
		}else{
			return false;
	}
}

function isTelefono(obj){
	var letters = /^[0-9]$/;
	
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
}

function isValidName(){
	var form = document.forms["pagament"]["nome"];
	
	if(isName(form)){
			document.getElementById("nome").style.borderColor = "green";
			return true;
	}else if(form.value == ""){
		document.getElementById("nome").style.borderColor = "pink";
		return false;
	}else{
		document.getElementById("nome").style.borderColor = "red";
		return false;
	}
	
	
}

function isValidSecondName(){
	var form = document.forms["pagament"]["cognome"];
	
	if(isName(form)){
			document.getElementById("cognome").style.borderColor = "green";
			return true;
	}else if(form.value == ""){
		document.getElementById("cognome").style.borderColor = "pink";
		return false;
	}else{
		document.getElementById("cognome").style.borderColor = "red";
		return false;
	}
		
}

function isValidCitta(){
	var form = document.forms["pagament"]["citta"];
	
	if(isName(form)){
			document.getElementById("citta").style.borderColor = "green";
			return true;
	}else if(form.value == ""){
		document.getElementById("citta").style.borderColor = "pink";
		return false;
	}else{
		document.getElementById("citta").style.borderColor = "red";
		return false;
	}
		
}

function isValidIndirizzo(){
	var ind = document.forms["pagament"]["indirizzo"];
	if(ind.value.length > 3){
			if(isVia(ind)){		
				document.getElementById("indirizzo").style.borderColor = "green";
				return true;
		}else if(ind.value == ""){
			document.getElementById("indirizzo").style.borderColor = "pink";
			return false;
		}else{
			document.getElementById("indirizzo").style.borderColor = "red";
			return false;
		}
	}else{
		document.getElementById("indirizzo").style.borderColor = "red";
		return false;
		}
	
}

function isValidTel(){
	var form = document.forms["pagament"]["telefono"];

	if(isTelefono(form) && form.value.length == 10){
			document.getElementById("telefono").style.borderColor = "green";
			return true;
	}else if(form.value == ""){
		document.getElementById("telefono").style.borderColor = "pink";
		return false;
	}else if(form.value.lenght < 10){
		document.getElementById("telefono").style.borderColor = "red";
		return false;
	}
	
}