window.onload = function(){
	$('#login').on('click', login);
	$('#register').on('click', loadRegisterView);
}

function login(){
	console.log("logging in");
}

function loadRegisterView(){
	console.log("loading register view");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			
		}
	}
	
	xhr.open("GET", "/regView", true);
	xhr.send();
	
	
}