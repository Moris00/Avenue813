function isName(obj){
	var letters = /^[a-zA-Z ]+$/;
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
	var letters = /^[0-9]{10}$/;
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
}

function isCodice(obj){
	var letters = /^[0-9]{16}$/;
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
}

function isCVC(obj){
	var letters = /^[0-9]{3}$/;
	
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
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("nome").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("nome").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Nome non valido";
		return false;
	}
	
	
}

function isValidSecondName(){
	var form = document.forms["pagament"]["cognome"];
	
	if(isName(form)){
			document.getElementById("cognome").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("cognome").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("cognome").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Cognome non valido";
		return false;
	}
		
}

function isValidCitta(){
	var form = document.forms["pagament"]["citta"];
	
	if(isName(form)){
			document.getElementById("citta").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("citta").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("citta").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Citta' non valida";
		return false;
	}
		
}

function isValidIndirizzo(){
	var ind = document.forms["pagament"]["indirizzo"];
	if(ind.value.length > 3){
			if(isVia(ind)){		
				document.getElementById("indirizzo").style.borderColor = "green";
				document.getElementById("title_error").innerHTML = "";
				return true;
		}else if(ind.value == ""){
			document.getElementById("indirizzo").style.borderColor = "pink";
			document.getElementById("title_error").innerHTML = "Campo/i vuoto";
			return false;
		}else{
			document.getElementById("indirizzo").style.borderColor = "red";
			document.getElementById("title_error").innerHTML = "Indirizzo non valido";
			return false;
		}
	}else{
		document.getElementById("indirizzo").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Indirizzo non valido";
		return false;
		}
	
}

function isValidTel(){
	var form = document.forms["pagament"]["telefono"];

	if(isTelefono(form)){
			document.getElementById("telefono").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("telefono").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("telefono").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Numero di Telefono non valido";
		return false;
	}
}

function isValidNum(){
	var form = document.forms["pagament"]["codice"];
	
	
	if(form.value.length == 16){
		if(isCodice(form)){
			document.getElementById("codice").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
		}else if(form.value == ""){
			document.getElementById("codice").style.borderColor = "pink";
			document.getElementById("title_error").innerHTML = "Campo/i vuoto";
			return false;
		}else{
			document.getElementById("codice").style.borderColor = "red";
			document.getElementById("title_error").innerHTML = "Numero carta non valida";
		return false;
		}
	}else if(form.value == ""){
		document.getElementById("codice").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
			return false;
	}else{
		document.getElementById("codice").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Numero carta non valida";
		return false;
	}
			
}

function isValidInt(){
	var form = document.forms["pagament"]["intestatario"];
	
	if(isName(form)){
			document.getElementById("intestatario").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("intestatario").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("intestatario").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "Intestatario non valido";
		return false;
	}
}

function isValidCVC(){
	var form = document.forms["pagament"]["cvc"];
	
	if(isCVC(form)){
			document.getElementById("cvc").style.borderColor = "green";
			document.getElementById("title_error").innerHTML = "";
			return true;
	}else if(form.value == ""){
		document.getElementById("cvc").style.borderColor = "pink";
		document.getElementById("title_error").innerHTML = "Campo/i vuoto";
		return false;
	}else{
		document.getElementById("cvc").style.borderColor = "red";
		document.getElementById("title_error").innerHTML = "CVC non valido";
		return false;
	}
}

function isValidOrder(){
	var fun, n;
	var i = 0;
	var button = document.forms["pagament"]["metodo"];
	
	if(button.value == "Visa" || button.value == "Mastercard" || button.value == "American"){
		fun = [isValidName(), isValidSecondName(), isValidCitta(), isValidIndirizzo(), isValidTel(), isValidNum(), isValidInt(), isValidCVC()];
		n = fun.length;
		while(i < n){
			if(!fun[i]){
				return false;
			}
			i++;
		}
		
		while(i < n){
			if(fun[i]){
				return true;
			}
			i++;
		}
	}else{
		fun = [isValidName(), isValidSecondName(), isValidCitta(), isValidIndirizzo(), isValidTel()];
		i = 0;
		n = fun.length;
		while(i < n){
			if(!fun[i]){
				return false;
			}
			i++;
		}
		
		while(i < n){
			if(fun[i]){
				return true;
			}
			i++;
		}
	}
}


