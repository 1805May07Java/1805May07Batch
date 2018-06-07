/*
 * app.js
 * Author: Cole Vikupitz
 * 
 */


window.onload = function() {
	$('#login').on('click', authenticate);
    $('#createAccount').on('click', loadCreateUserView);
    $('#form-error').css("color", "red");
}


function loadLoginView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#login').on('click', authenticate);
            $('#createAccount').on('click', loadCreateUserView);
            $('#form-error').css("color", "red");
        }
    }

    xhr.open("GET", "login.view", true);
    xhr.send();
}


function loadResolvedView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
        }
    }

    xhr.open("GET", "resolved.view", true);
    xhr.send();
}


function loadPendingView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
        }
    }

    xhr.open("GET", "pending.view", true);
    xhr.send();
}


function loadNewRequestView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#form-error').css("color", "red");
        }
    }

    xhr.open("GET", "new-request.view", true);
    xhr.send();
}


function authenticate() {

	$('#id-error').html('');
	var email = $('#email').val();
	var password = $('#password').val();
	if (email == "" || password == "") {
		$('#id-error').html("** Please provide both your email and password **");
		return;
	}
	
	var user = {
		email : email, 
		password : password
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if (user == null) {
				$('#id-error').html("** Invalid login credentials **");
			} else {
				loadResolvedView();
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.send(json);
}


function submitNewRequest() {
	
	$('#form-error').html('');
	var amount = $('#amount').val();
	var type = $('#type').val();
	var desc = $('#description').val();
	
	if (amount == "" || type == "") {
		$('#form-error').html("** Please specify the amount and type **");
		return;
	}
	
	///FIXME
}


function togglePassword() {

    var entry = document.getElementById('password');
    if (entry.type === "password") {
        entry.type = "text";
    } else {
        entry.type = "password";
    }
}


function logout() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	loadLoginView();
        }
    }

    xhr.open("GET", "logout", true);
    xhr.send();
	
}










/*
function loadCreateUserView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#backToLogin').on('click', loadLoginView);
        }
    }

    xhr.open("GET", "create.view", true);
    xhr.send();
}


function comparePasswords() {

    var pw1 = $('#password').val();
    var pw2 = $('#password2').val();
    var msg = $('#pw-error');
    var button = $('#submit-button');

    if (pw1 === "" || pw2 === "") {
        msg.html("");
        button.prop("disabled", false);
        return;
    }
    if (pw1 !== pw2) {
        msg.css("color", "red");
        msg.html("Passwords do not match.");
        button.prop("disabled", true);
    } else {
        msg.css("color", "green");
        msg.html("Passwords match.");
        button.prop("disabled", false);
    }
}


function togglePasswords() {

    var entry1 = document.getElementById('password');
    var entry2 = document.getElementById('password2');
    if (entry1.type === "password") {
        entry1.type = "text";
        entry2.type = "text";
    } else {
        entry1.type = "password";
        entry2.type = "password";
    }
}
*/


