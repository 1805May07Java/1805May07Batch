window.onload = function(){
	$('#login').on('click', login);
	$('#register').on('click', loadRegisterView);
}

function login(){
	console.log("logging in");
	var username = $('#username').val();
	var pass = $('#password').val();
	var user = {
			id : 0, 
			username : username, 
			password : pass
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#message').html('Invalid Credentials');
			}
			else{
				// load landing page;
				
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.send(json);
	
	
}

function loadRegisterView(){
	console.log("loading register view");
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#view').html(xhr.responseText);
			//manipulate DOM of new html 
		}
	}
	
	xhr.open("GET", "regView", true);
	xhr.send();
	
	
}