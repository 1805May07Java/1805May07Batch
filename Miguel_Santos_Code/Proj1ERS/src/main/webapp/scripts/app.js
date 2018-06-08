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
				$('#myModal').modal('toggle');
				$('#myModal').html("");
				// CLEAR MODAL HERE
				$('#loginname').html(user.firstname + " "+ user.lastname);
				$('#navigation').html('');
				//loadView();
				
				if(user.roleId == 1){
					loadEmpView();
					$('#navigation').append('<li class="nav-item "><a id="addER" class="nav-link" href="#">Add Reimbursement Request</a></li>');
					$('#addER').click(function(){
						$('#myModal').modal('toggle');
					});
					//Replace modal innerHTML add ER form here
					loadAddModal();
					$('#confirmER').click(function(){
						addNewER();
						$('#myModal').modal('toggle');
					});
					
				}
				else{
					loadManView();
					
					//replace modal innerHTML with approve or deny buttons here
					loadOptionModal();
					
					//place event listener for table row
				}
				
				$('#navigation').append('<li class="nav-item "><a id="loggout" class="nav-link" href="#">Logout</a></li>');
				console.log("adding logout function");
				$('#loggout').ready(function(){
					$('#loggout').on('click',logout)
				});
				loadData(user.roleId);
				//loadData();
			}
		}
	}
	xhr.open("POST", "login", true);
	xhr.send(json);
	console.log("http request sent");
}

function addNewER(){
	
	console.log("adding new Expense");
	var type_id = $("select[id=inputType]").val();
	var amount = $("#inputAmount").val();
	var description = $('#description').val();
	//document.getElementById('amount').value = 0;
	//document.getElementById('description').value = "";
	console.log(type_id + " " + amount + " " + description);
	var reimb = {
			amount : amount,
			description : description,
			type_id : type_id
	}
	
	var json = JSON.stringify(reimb);
	console.log(json);
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myTable').html('');
			loadData(1);
		}
	}

	xhr.open("POST", "data", true);
	xhr.send(json);
}

function loadOptionModal(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myModal').html(xhr.responseText);
		}
	}

	xhr.open("GET", "options", true);
	xhr.send();
}

function loadAddModal(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myModal').html(xhr.responseText);
		}
	}

	xhr.open("GET", "add", true);
	xhr.send();
}

function loadManView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);
		}
	}

	xhr.open("GET", "manager", true);
	xhr.send();
}
function loadEmpView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);
		}
	}

	xhr.open("GET", "employee", true);
	xhr.send();
}

function logout(){
	console.log("clicking log out");
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("logging out");
			location.reload();
		}
	}
	xhr.open("GET", "login", true);
	console.log("xhr opened");
	xhr.send();
	console.log("xhr sent");
}

function loadView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		console.log(xhr.readyState + " " + xhr.status);
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);
		}
	}

	xhr.open("GET", "view", true);
	xhr.send();
}

function loadData(id){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var data = JSON.parse(xhr.responseText);
			if (id == 1){
				var date = new Date()
				for(let i in data){
					var row = document.createElement("tr");
					var cell1 = document.createElement("td");
					var cell2 = document.createElement("td");
					var cell3 = document.createElement("td");
					var cell4 = document.createElement("td");
					var cell5 = document.createElement("td");
					var cell6 = document.createElement("td");
					var cell7 = document.createElement("td");
					
					cell1.innerHTML = data[i].status;
					cell2.innerHTML = data[i].type;
					cell3.innerHTML = data[i].description;
					cell4.innerHTML = data[i].amount;
					date = new Date(data[i].time_submitted);
					cell5.innerHTML = date.toLocaleString();
					cell6.innerHTML = data[i].resolver_ln;
					if(data[i].time_resolved == null){
						cell7.innerHTML = " ";
					}
					else{
						date = new Date(data[i].time_resolved);
						cell7.innerHTML = date.toLocaleString();
					}
					
					row.appendChild(cell1);
					row.appendChild(cell2);
					row.appendChild(cell3);
					row.appendChild(cell4);
					row.appendChild(cell5);
					row.appendChild(cell6);
					row.appendChild(cell7);
					
					document.getElementById("myTable").appendChild(row);
				}
			}
			else {
				var date = new Date()
				for(let i in data){
					var row = document.createElement("tr");
					var cell1 = document.createElement("td");
					var cell2 = document.createElement("td");
					var cell3 = document.createElement("td");
					var cell4 = document.createElement("td");
					var cell5 = document.createElement("td");
					var cell6 = document.createElement("td");
					var cell7 = document.createElement("td");
					var cell8 = document.createElement("td");
					var cell9 = document.createElement("td");
					
					date = new Date(data[i].time_submitted);
					cell1.innerHTML = date.toLocaleString();
					cell2.innerHTML = data[i].author_fn;
					cell3.innerHTML = data[i].author_ln;
					cell4.innerHTML = data[i].status;
					cell5.innerHTML = data[i].type;
					cell6.innerHTML = data[i].description;
					cell7.innerHTML = data[i].amount;
					cell8.innerHTML = data[i].resolver_ln;
					if(data[i].time_resolved == null){
						cell9.innerHTML = " ";
					}
					else{
						date = new Date(data[i].time_resolved);
						cell9.innerHTML = date.toLocaleString();
					}
					
					row.appendChild(cell1);
					row.appendChild(cell2);
					row.appendChild(cell3);
					row.appendChild(cell4);
					row.appendChild(cell5);
					row.appendChild(cell6);
					row.appendChild(cell7);
					row.appendChild(cell8);
					row.appendChild(cell9);
					
					document.getElementById("myTable").appendChild(row);
					
				}
				$('#tableview').ready(function(){			//Adds search functionality to Manager Data Table
					$("#myInput").on("keyup", function() {
					var value = $(this).val().toLowerCase();
					$("#myTable tr").filter(function() {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
					});
					});
					});
			}
		}
	}
	xhr.open("GET", "data", true);
	xhr.send();

}


