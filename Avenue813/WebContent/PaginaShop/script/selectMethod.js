function selectMethod(){
	var button = document.forms["pagament"]["metodo"];
	

	
	if(button.value == "Visa" || button.value == "Mastercard" || button.value == "American"){
		document.getElementById("details_user").style.display = "block";
		document.getElementById("details_card").style.display = "block";
		document.getElementById("add").style.display ="none";
	}else{
		if(document.getElementById("details_card").style.display == "block" ){
			document.getElementById("details_card").style.display = "none"
			
		}
		document.getElementById("details_user").style.display = "block";
		document.getElementById("add").style.display ="block";
	}
}