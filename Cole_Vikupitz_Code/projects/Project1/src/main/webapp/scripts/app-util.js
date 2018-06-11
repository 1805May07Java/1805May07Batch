/*
 *
 * app.js
 * Author: Cole Vikupitz
 * 
 */


var fullName = "";
var types;
var statuses;
var users;

window.onload = function() {
	
	$('#login').on('click', authenticate);
	$('#error-msg').css("color", "red");
	fetchTypes();
	fetchStatus();
	fetchUsers();
}


function loadLoginView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#error-msg').css("color", "red");
            $('#login').on('click', authenticate);
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
            $('#name').html("Logged in as: " + fullName);
            getResolved();
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
            $('#name').html("Logged in as: " + fullName);
            getPending();
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
            $('#name').html("Logged in as: " + fullName);
            $('#form-error').css("color", "red");
        }
    }

    xhr.open("GET", "new-request.view", true);
    xhr.send();
}


function loadFMResolvedView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#name').html("Logged in as: " + fullName);
            getFMResolved();
        }
    }

    xhr.open("GET", "fm-resolved.view", true);
    xhr.send();
}


function loadFMPendingView() {

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            $('#view').html(xhr.responseText);
            $('#name').html("Logged in as: " + fullName);
            getFMPending();
        }
    }

    xhr.open("GET", "fm-pending.view", true);
    xhr.send();
}


function authenticate() {

	$('#error-msg').html('');
	var email = $('#email').val();
	var password = $('#password').val();
	if (email == "" || password == "") {
		$('#error-msg').html("** Please provide both your email and password **");
		return;
	}
	
	var user = {
		email : email, 
		password : password
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			if (user == null) {
				$('#error-msg').html("** Invalid login credentials **");
			} else {
				fullName = user.firstName + " " + user.lastName;
				if (user.roleId == 1) {
					loadResolvedView();
				} else {
					loadFMResolvedView();
				}
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.send(json);
}


function getResolved() {
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var temp = JSON.parse(xhr.responseText);
			var table = document.getElementById("resolved");
			for (let i = 0; i < temp.length; i++) {
				var rev = users[temp[i].reviewer - 1];
				var row = document.createElement("tr");
				row.innerHTML = 
					'<td>$' + (Math.round(temp[i].amount * 100) / 100) +
					'</td><td>' + types[temp[i].type - 1].name +
					'</td><td>' + statuses[temp[i].status - 1].status +
					'</td><td>' + temp[i].submitted +
					'</td><td>' + temp[i].reviewed +
					'</td><td>' + rev.firstName + " " + rev.lastName +
					'</td><td>' + temp[i].description +
					'</td>';
				table.appendChild(row);
			}
		}
	}
	
	xhr.open("GET", "employee-resolved", true);
	xhr.send();
}


function getPending() {

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var temp = JSON.parse(xhr.responseText);
			var table = document.getElementById("pending");
			for (let i = 0; i < temp.length; i++) {
				var row = document.createElement("tr");
				var desc = (temp[i].description == null) ? "" : temp[i].description;
				row.innerHTML = 
					'<td>$' + (Math.round(temp[i].amount * 100) / 100) +
					'</td><td>' + types[temp[i].type - 1].name +
					'</td><td>' + temp[i].submitted +
					'</td><td>' + desc +
					'</td>';
				table.appendChild(row);
			}
		}
	}
	
	xhr.open("GET", "employee-pending", true);
	xhr.send();
}


function getFMResolved() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	var temp = JSON.parse(xhr.responseText);
        	var table = document.getElementById("fm_pending");
			for (let i = 0; i < temp.length; i++) {
				var row = document.createElement("tr");
				var sub = users[temp[i].sender - 1];
				var rev = users[temp[i].reviewer - 1];
				row.innerHTML = 
					'<td>$' + (Math.round(temp[i].amount * 100) / 100) +
					'</td><td>' + types[temp[i].type - 1].name +
					'</td><td>' + temp[i].submitted +
					'</td><td>' + sub.firstName + " " + sub.lastName +
					'</td><td>' + temp[i].reviewed +
					'</td><td>' + rev.firstName + " " + rev.lastName +
					'</td><td>' + statuses[temp[i].status - 1].status +
					'</td><td>' + temp[i].description +
					'</td>';
				table.appendChild(row);
			}
			$('#rtable').DataTable({
				paging: false,
				searching: false,
				info: false
			});
        }
    }

    xhr.open("GET", "fmanager-resolved", true);
    xhr.send();
}


function getFMPending() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	var temp = JSON.parse(xhr.responseText);
        	var table = document.getElementById("fm_pending");
			for (let i = 0; i < temp.length; i++) {
				var row = document.createElement("tr");
				row.id = temp[i].id;
				var sub = users[temp[i].sender - 1];
				row.innerHTML = 
					'<td>$' + (Math.round(temp[i].amount * 100) / 100) +
					'</td><td>' + types[temp[i].type - 1].name +
					'</td><td>' + temp[i].submitted +
					'</td><td>' + sub.firstName + " " + sub.lastName +
					'</td><td>' + temp[i].description +
					'</td>';
				row.addEventListener('click', function() {
					$('#pendingModalCenter').modal('toggle');
					$('#approve').on('click', function() {
						var reimb = {
							id : temp[i].id, 
							status : 2
						};
						var json = JSON.stringify(reimb);
						var xhr = new XMLHttpRequest();

						xhr.onreadystatechange = function() {
							if (xhr.readyState == 4 && xhr.status == 200) {
								$('#pendingModalCenter').modal('toggle');
								$("#" + temp[i].id).remove();
							}
						}
								
						xhr.open("POST", "fmanager-pending", true);
						xhr.send(json);
					});
					$('#deny').on('click', function() {
						var reimb = {
							id : temp[i].id, 
							status : 3
						};
						var json = JSON.stringify(reimb);
						var xhr = new XMLHttpRequest();

						xhr.onreadystatechange = function() {
							if (xhr.readyState == 4 && xhr.status == 200) {
								$('#pendingModalCenter').modal('toggle');
								$("#" + temp[i].id).remove();
							}
						}
								
						xhr.open("POST", "fmanager-pending", true);
						xhr.send(json);
					});
				});
				table.appendChild(row);
			}
        }
    }

    xhr.open("GET", "fmanager-pending", true);
    xhr.send();
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
	
	if (amount <= 0) {
		$('#form-error').html("** Please enter a valid amount **");
		return;
	}
	
	if (desc == null || desc == "") {
		desc = "N/A";
	}
	
	var request = {
		amount : amount,
		type : type,
		description : desc
	};
	var json = JSON.stringify(request);
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#amount').val('');
			$('#description').val('');
			$('#exampleModalCenter').modal('toggle');
		}
	}

	xhr.open("POST", "add-request", true);
	xhr.send(json);
}


function togglePassword() {

    var entry = document.getElementById('password');
    if (entry.type == "password") {
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


function fetchTypes() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	types = JSON.parse(xhr.responseText);
        }
    }

    xhr.open("GET", "types", true);
    xhr.send();
}


function fetchStatus() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	statuses = JSON.parse(xhr.responseText);
        }
    }

    xhr.open("GET", "status", true);
    xhr.send();
}


function fetchUsers() {
	
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
        	users = JSON.parse(xhr.responseText);
        }
    }

    xhr.open("GET", "users", true);
    xhr.send();	
}

