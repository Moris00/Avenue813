function isUsername(obj){
	var letters = /^[a-zA-Z0-9]+$/;
		if(obj.value.match(letters)){
			return true;
		}else{
			return false;
		}
}

function isValidLogin(){

}