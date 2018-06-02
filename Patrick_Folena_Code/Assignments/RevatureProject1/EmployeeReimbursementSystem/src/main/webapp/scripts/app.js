window.onload = function(){
	$('#login').on('click', login);
	console.log("loaded");
}

function login(){
	console.log("logging in...");
	var username = $('#username').val();
	var password = $('#password').val();
	var user = {
			id : 0,
			username : username,
			password : password
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#username').val("");
				$('#password').val("");
				$('#warnmessage').css('visibility', 'visible');
			}
			else{
				console.log("LOGIN");
				loadView(user);
				$('#warnmessage').css('visibility', 'hidden');
			}
		}
	};
	xhr.open("POST", "login", true);
	xhr.send(json);
}

function loadView(user)
{
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#root').html(xhr.responseText);
		}
	}
	var stringView = (user.role) + ".view";
	xhr.open("GET", stringView, true);
	xhr.send();
}
