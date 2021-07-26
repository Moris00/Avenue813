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
	alert("dfgh");
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










/*Funzioni AJAX Acquisto*/
function getXmlHttpRequest() {

    var xhr = false;
    var activeXoptions = new Array("Microsoft.XmlHttp", "MSXML4.XmlHttp",
            "MSXML3.XmlHttp", "MSXML2.XmlHttp", "MSXML.XmlHttp");

    try {
        xhr = new XMLHttpRequest();
        console.log("Get XML http request");
    } catch (e) {
    }

    if (!xhr) {
        var created = false;
        for (var i = 0; i < activeXoptions.length && !created; i++) {
            try {
                xhr = new ActiveXObject(activeXoptions[i]);
                created = true;
                console.log("Get ActiveXObject XML http request");
            } catch (e) {
            }
        }
    }
    return xhr;
}

function getReadyStateHandler(req, id, timeout) {
    return function() {
        if(timeout > 0) {
            handleWait(req, new Date().getTime(), timeout);
        }

        if (req.readyState == 1) {
            console.log("Server connection");
        } else if ( req.readyState == 2 ) {
            console.log("Send request");
        } else if ( req.readyState == 3 ) {
                console.log("Receive response");
                wait(false);
        } else if (req.readyState == 4) {
            console.log("Request finished and response is ready");
            if (req.status == 200 || req.status == 304) {
               setTimeout(sito,2000);
				
            } else {
                console.log("Response error "+ req.status + " " + req.statusText);
            }
        } else {
            wait(false);
        }
    };
}

function sito(){
	window.location.href= "/Avenue813/PaginaShop/shop.jsp";
	
}

function handleWait(req, start, maxTime) {

    if (req.owner) 
        return;
    else 
        req.owner = true; 

    checkTime = function() {

        if ( req.readyState == 4 ) {
            wait(false);
            return;
        }

        if((new Date().getTime() - start) > maxTime) {
            req.onreadystatechange = function(){
                console.log("Abort Ajax request"); 
                return;
            };
            req.abort();
            wait(false);
        } 
        else {
            setTimeout(checkTime, 2000);

        }
    }
    checkTime();

}


function ajaxCall(id, url, timeout) {
    alert(timeout);
    var req = new XMLHttpRequest();

	isValidName();

	if(!ris){
		alert("sono qua");
		return false;
	}

	var nome = document.getElementById("nome");
	var cognome = document.getElementById("cognome");
	var indirizzo = document.getElementById("indirizzo");
	var telefono = document.getElementById("telefono");
	
	var button = document.forms["pagament"]["metodo"];
	var metodo = button.value;
	alert(metodo);
	

    try {
        wait(true);

        req.onreadystatechange = getReadyStateHandler(req, id, timeout);
        req.open('POST', url, true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        console.log("Open and send request");
		req.send("nome="+nome.value+"&cognome="+cognome.value+"&indirizzo="+indirizzo.value+"&telefono="+telefono.value+"&metodo="+metodo);
		return true;
	
    } catch (e1) {
        wait(false);
    }
    
}

function wait(state) {
    if (state == true) {
        // Show wait
        var obj = document.getElementById("title_error");
        if(obj != null) {
            obj.style.color = "red";
            obj.innerHTML = "Acquisto in corso...";
        }
    } else {
        // Hide wait
        var obj = document.getElementById("title_error");
        if(obj != null) {
			obj.style.color = "green";
            obj.innerHTML = "Acquisto terminato!";
        }
    }
}