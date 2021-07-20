/**
 * 
 */
//Gestione della compatibilità
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

function getReadyStateHandler(req, responseXmlHandler){
	return function(){
		if(req.readyState == 1){
		}else if(req.readyState == 4){
			if(req.status == 200 || req.status == 304){
				responseXmlHandler(req.responseXML);
			}else{
				//window.alert("")
			}
		}else{
			wait(false);
		}
	}
}