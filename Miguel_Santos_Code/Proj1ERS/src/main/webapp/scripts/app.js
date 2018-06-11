window.onload = function(){
	$('#login').on('click', login);

}

function login(){
	var username = $("#username").val();
	var password = $("#password").val();
	document.getElementById('username').value = "";
	document.getElementById('password').value = "";
	var user = {
			id : 0,
			username : username,
			password : password,
			firstname : " ",
			lastname : " ",
			email : " ",
			roleId : 0
	}
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#loginmessage').html('Invlaid Credentials');
			}
			else {										//successful login:
				$('#myModal').modal('toggle');			//close modal
				$('#myModal').html("");					//and clear for new modal html

				$('#loginname').html(user.firstname + " "+ user.lastname);		//change navbar message with user's name
				$('#navigation').html('');										//clear navbar links

				if(user.roleId == 1){					//if employee,
					loadEmpView();						//load employee table headers and add appropriate navbar links
					$('#navigation').append('<li class="nav-item "><a id="addER" class="nav-link" href="#">Add Reimbursement Request</a></li>');
					$('#addER').click(function(){		//event listener for new navbar link
						$('#myModal').modal('toggle');
					});
					loadAddModal();						//load empty modal with form data
					//loadDropdownOptions();

				}
				else{									//if manager,
					loadManView();						//load table headers for manager
					loadOptionModal();
				}

				$('#navigation').append('<li class="nav-item "><a id="loggout" class="nav-link" href="">Logout</a></li>');
				$('#loggout').ready(function(){			//add logout navbar link and event listener
					$('#loggout').on('click',logout)
				});
				//loadData(user.roleId);
			}
		}
	}
	xhr.open("POST", "login", true);
	xhr.send(json);
}

function loadDropdownOptions(){							//pull types of reimbursement from db 
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var options = JSON.parse(xhr.responseText);

			for(let i in options){
				var opt = document.createElement("option");
				opt.innerHTML = options[i];
				opt.setAttribute("value", (parseInt(i)+1));	

				document.getElementById("inputType").appendChild(opt);

			}
		}
	}

	xhr.open("GET", "dropdown", true);
	xhr.send();
}

function addNewER(){							//submit new reimbursement request

	var type_id = $("select[id=inputType]").val();
	var amount = $("#inputAmount").val();
	var description = $('#description').val();
	document.getElementById('myForm').reset();
	var reimb = {
			amount : amount,
			description : description,
			type_id : type_id
	}

	var json = JSON.stringify(reimb);

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myTable').html('');		// clear table before loading updated table
			loadData(1);
		}
	}

	xhr.open("POST", "data", true);
	xhr.send(json);
}

function loadOptionModal(){							//loads partial html to modal for approve or deny of reimbs
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myModal').html(xhr.responseText);

		}
	}

	xhr.open("GET", "options", true);
	xhr.send();
}

function loadAddModal(){						//loads partial html to modal for expense submission form 
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myModal').html(xhr.responseText);

			$('#confirmER').on('click',function(){
				addNewER();
				$('#myModal').modal('toggle');
			});
			loadDropdownOptions();

		}
	}

	xhr.open("GET", "add", true);
	xhr.send();
}

function approveDeny(event){						
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#myModal').modal('toggle');
			$('#myTable').html('');		// clear table before loading updated table
			loadData(2);
		}
	}

	xhr.open("POST", "approve", true);
	xhr.send(event.data.reimb_id + ":" + event.data.approve);
}

function loadManView(){					//loads managers table
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);			//manager's table headers

			loadData(2);									//manager's data
			//---ADD EVENT LISTENER FOR ROWS
			$('#myTable').on('click', 'tr', function(){
				if(this.children[3].innerHTML == "Pending"){
					$('.modal-title').html(this.children[1].innerHTML + " " + this.children[2].innerHTML + "<br>reimbursement for:<br>" + this.children[5].innerHTML + "<br>for: $" + this.children[6].innerHTML );
					//---update EVENT LISTENERS FOR APPROVE OR DENY BUTTONS for current row 
					$('#approve').off();			//unbind any previous event listeners
					$('#deny').off();
					$('#approve').on('click', {reimb_id: this.attributes[0].value, approve: "1"}, approveDeny);
					$('#deny').on('click', {reimb_id: this.attributes[0].value, approve: "0"}, approveDeny);

					$('#myModal').modal('toggle');
				}

			});


		}
	}

	xhr.open("GET", "manager", true);
	xhr.send();
}
function loadEmpView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#sitebody').html(xhr.responseText);

			loadData(1);
		}
	}

	xhr.open("GET", "employee", true);
	xhr.send();
}

function logout(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			location.reload();
		}
	}
	xhr.open("GET", "login", true);
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

					row.setAttribute("data-id", data[i].id);	// store reimb_id as value in description td

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


