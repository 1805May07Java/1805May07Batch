window.onload = function(){
	$('#login').on('click', login);
}

function login(){
	console.log("logging in");
	var username = $("#username").val();
	var password = $("#password").val();
	console.log(username + " " + password);
	var user = {
			id : 0,
			username : username,
			password : password,
			firstname : "",
			lastname : "",
			email : "",
			role_id : 0
	}
	console.log("initialized user json");
	var json = JSON.stringify(user);
	console.log("stringified")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			console.log(xhr.responseText);
		}
	}
	xhr.open("POST", "login", true);
	xhr.send(json);
	console.log("http request sent");
}
