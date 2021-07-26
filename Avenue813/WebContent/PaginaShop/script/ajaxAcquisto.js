
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