function isName(obj){
	var letters = /^[a-zA-Z ]+$/;
	
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
}

function isPrezzo(obj){
	var letters = /^[0-9 \.]+$/;
	
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
	
}

function isQuantita(obj){
	var letters = /^[0-9]+$/;
	
	if(obj.value.match(letters)){
		return true;
	}else{
		return false;
	}
}

function isValidName(){
	var name = document.forms["add"]["nome_prodotto"];
	
	if(isName(name)){
		document.getElementById("nome_prodotto").style.borderColor = "green";
		document.getElementById("error").innerHTML = "";
		return true;
	}else if(name.value == "") {
		document.getElementById("nome_prodotto").style.borderColor = "pink";
		document.getElementById("error").innerHTML = "";
		return false;
	}else{
		document.getElementById("nome_prodotto").style.borderColor = "red";
		document.getElementById("error").innerHTML = "Nome prodotto errato!"
		return false;
	}
}

function isValidPrice(){
	var price = document.forms["add"]["prezzo"];
	
	if(isPrezzo(price)){
		document.getElementById("prezzo").style.borderColor = "green";
		document.getElementById("error").innerHTML = "";
		return true;
	}else if(price.value == ""){
		document.getElementById("prezzo").style.borderColor = "pink";
		document.getElementById("error").innerHTML = "";
		return false;
	}else{
		document.getElementById("prezzo").style.borderColor = "red";
		document.getElementById("error").innerHTML = "Prezzo prodotto errato!"
		return false;
	}	
}

function isValidQuantita(){
	var quantita = document.forms["add"]["quantita"];
	
	if(isQuantita(quantita)){
		document.getElementById("quantita").style.borderColor = "green";
		document.getElementById("error").innerHTML = "";
		return true;
	}else if(quantita.value == ""){
		document.getElementById("quantita").style.borderColor = "pink";
		document.getElementById("error").innerHTML = "";
		return false;
	}else{
		document.getElementById("quantita").style.borderColor = "red";
		document.getElementById("error").innerHTML = "Prezzo prodotto errato!"
		return false;
	}
}