window.onload = function() {
	$('#loginForm').submit(login);
};

let login = function() {
	
	let username=$('#username').val();
	let password=$('#password').val();
	
	if (!username || !password) {
		error("Username and password cannot be blank");
		return;
	}
	
	$.ajax({
		method: "post",
		url: "login",
		data: `username:${username}\npassword:${password}`,
		
		success: function(resp, status, xhr) {
			if (resp === "logged in") {
				window.location.href = "/ers/home.html";
			} else {
				error();
			}
		},
	
		error: function(e) {
			console.log(`error ${e}`);
		}
	});
	
	return false;
};

let error = function(e) {
	$('#error')[0].innerText = e || 'Username or password not found'
};
