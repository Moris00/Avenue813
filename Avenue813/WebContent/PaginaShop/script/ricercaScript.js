/**
 * 
 */

function getXmlHttpRequest(){
	
	var xhr = false;
	var activeXoptions = new Array("Microsoft.XmlHttp", "MSXML4.XmlHttp", "MSXML3.XmlHttp", "MSXML2.XmlHttp", "MSXML.XmlHttp");
	
	try{
		xhr = new XMLHttpRequest();
	}catch(e){
		
	}
	
	if(!xhr){
		var created = false;
		for(var i = 0; i < activeXoptions.length && !created; i++){
			try{
				xhr = new ActiveXObject(activeXoptions[i]);
				created = true;
			}catch(e){}
		}
	}
}

function wait(state){
	if(state == true){
		//Show wait
	}else{
		//Hide wait
	}
}

function getReadyStateHandler(req, responseXmlHandler, id){
	return function(){
		if(req.readyState == 1){
			console.log("Server Connection");
		}else if(req.readyState == 2){
			console.log("Send Request");
		}else if(req.readyState == 3){
			console.log("Receive Response");
		}else if(req.readyState == 4){
			console.log("Request finished and response is ready");
			if(req.status == 200 || req.status == 304){
				responseXmlHandler(req.responseXML, id);
			}else{
				console.log("Response error "+req.status+" "+req.statusText);
			}
		}
	}
}

function ricercaAJAX(id, url, callback, parameter){
	
	var req = new XMLHttpRequest(); /*getXmlHttpRequest();*/
	try{
		if(parameter == "" || parameter == null){
			var bar = document.getElementById(id);
			bar.style.display = "none";
			return;
		}
		wait(true);
		req.onreadystatechange = getReadyStateHandler(req, callback, id);		
		req.open('POST', url, true);
		
		req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		req.send('param='+parameter);
		
	}catch(e1){
		wait(false);
	}
	
}