window.onload = function(){
	$('#login').on('click', login);

}



function login(){
	console.log("logging in");
	var username = $("#username").val();
	var password = $("#password").val();
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";
	console.log(username + " " + password);
	var user = {
			id : 0,
			username : username,
			password : password,
			firstname : " ",
			lastname : " ",
			email : " ",
			roleId : 0
	}
	console.log("initialized user json");
	var json = JSON.stringify(user);
	console.log(json);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#loginmessage').html('Invlaid Credentials');
			}
			else {
				$('#myModal').modal('toggle')
				$('#loginname').html(user.firstname + " "+ user.lastname);

				if(user.roleId == 1){
					$('#navigation').html('<li class="nav-item "><a id="addER" class="nav-link" href="#">Add Reimbursement Request</a></li>')
					$('#addER').click(function(){
						$('#addERModal').modal('toggle');
					});
					loadEmployeeView();
					//---ADD TABLE CONTENTS FOR EMPLOYEE
					//loadEmployeeData(user);
				}
				else{
					$('#navigation').html('');
					loadManagerView();
					//---ADD TABLE CONTENTS FOR MANAGER
					//loadManagerData();
				}
				$('#navigation').append('<li class="nav-item "><a class="nav-link" href="#">Logout</a></li>');
			}
		}
	}
	xhr.open("POST", "http://localhost:8083/Proj1ERS/login", true);
	xhr.send(json);
	console.log("http request sent");
}

function loadEmployeeView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);
		}
	}

	xhr.open("GET", "http://localhost:8083/Proj1ERS/employee.view", true);
	xhr.send();
}

function loadEmployeeData(user){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			
		}
	}
	xhr.open("POST", "http://localhost:8083/Proj1ERS/employee.data", true);
	xhr.send(user.id);

}

function loadManagerView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);
			//$('#name').html(user.username);
//			$('#tableview').ready(function(){
//			$("#myInput").on("keyup", function() {
//			var value = $(this).val().toLowerCase();
//			$("#myTable tr").filter(function() {
//			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
//			});
//			});
//			});
		}
	}

	xhr.open("GET", "http://localhost:8083/Proj1ERS/manager.view", true);
	xhr.send();
}

function loadManagerData(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			
		}
	}
	xhr.open("GET", "http://localhost:8083/Proj1ERS/data", true);
	xhr.send();
}


