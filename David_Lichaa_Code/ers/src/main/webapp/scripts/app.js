// load events on buttons
window.onload = function () {
	$('#loginButton').on('click', login);
}

/* Validates login. Sends AJAX POST request to LoginServlet. Expects back a User object.
   If the XHR.responseText returns null, that means our credentials are not valid. 
   If XHR.responseText returns with an object, we can load the appropriate dashboard */

function login() {
	//collect input field values
	let username = $('#loginField').val();
	let password = $('#passwordField').val();
	let userObj = {
		username: username,
		password: password
	}
	let json = JSON.stringify(userObj);
	// create XHR object
	let xhr = new XMLHttpRequest();

	//define callback function
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText != 'null') {
				let user = JSON.parse(xhr.responseText);
				//set the current user's id as the global
				globalUser = user;
				if (user.roleId == 1) { // manager
					$('#view').load("./partials/manager-dash.html");
				} else { // employee
					$('#view').load("./partials/employee-dash.html");
				}
			} else {
				$('#loginMessage').text('Invalid credentials');
			}
		}
	}
	xhr.open('POST', 'login', true);
	xhr.send(json);
}

function logout() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		location.reload();
	}
	xhr.open('GET', 'logout', true);
	xhr.send();
}

/* Sets the #action div to the response gathered from ViewRequestsEmp servlet */
function viewRequestsEmp() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#action').html(xhr.responseText);
		}
	}
	xhr.open('GET', 'ViewRequestsEmp', true);
	xhr.send();
}

/* Sets the #action div to the response gathered from SubmitRequest servlet */
function loadSubmitRequest() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let reimbTypes = JSON.parse(xhr.responseText);
			let htmlText = generateSubmitForm(reimbTypes);
			$('#action').html(htmlText);
			$('#submitRequest').on('click', insertRequest);
		}
	}
	xhr.open('GET', 'loadSubmitRequest', true);
	xhr.send();
}

/* Generate a string of HTML to allow user to submit reimbursement request */
function generateSubmitForm(arrayTypes) {
	let htmlText = `
	<div class="row">
	<div class="offset-md-3 col-md-6">
	<form>
		<div class="form-group">
	    	<label for="amountInput">Enter Amount</label>
			<input type="number" class="form-control" id="amount" />
		</div>
		<div class="form-group">
			<label for="passwordInput">Reimbursement</label>
			<select class="form-control" id="type">`


	for (let i = 0; i < arrayTypes.length; i++) {
		htmlText += `<option value="${arrayTypes[i].id}">${arrayTypes[i].type}</option>`;
	}
	htmlText += `</select>
		</div>
		<div class="form-group">
			<label for="descriptionInput">Description</label>
	 		<textarea class="form-control" rows="3" id="description" ></textarea>
		 </div>
	<button class="btn btn-success" type="button" id="submitRequest">Submit Request</button>
	</form>
	</div>
	</div>`;
	return htmlText;
}

function insertRequest() {
	let amount = $('#amount').val();
	let type = $('select option:selected').val();
	let description = $('#description').val();
	//TODO: input validation -- https://www.w3schools.com/Js/tryit.asp?filename=tryjs_validation_number
	let reimbursementObj = {
		amount: amount,
		typeId: type,
		description: description,
		author: globalUser.id
	};
	let json = JSON.stringify(reimbursementObj);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			alert('Your request has been submitted');
		}
	}
	xhr.open('POST', 'loadSubmitRequest', true);
	xhr.send(json);

}

function viewRequestsManager() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#action').html(xhr.responseText);
			$('#reimbursementType').change(function () { filterTest(7) });
			$(document).ready(function () {
				let reimbId;
				$(".updateStatus").click(function () {
					$("#myModal").modal("show");
					reimbId = $(this).attr('id');
				});

				$('#approveButton').click(function () {
					updateRequestStatus(parseInt(reimbId), 2);
				}); //approve this request
				$('#denyButton').click(function () {
					updateRequestStatus(parseInt(reimbId), 3);
				});  //deny this request
			});
		}
	}
	xhr.open('GET', 'ViewRequestsManager', true);
	xhr.send();
}

function updateRequestStatus(reimbId, approveDeny) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#action').html(xhr.responseText);
			$('#reimbursementType').change(function () { filterTest(7) });
			$(document).ready(function () {
				let reimbId;
				$(".updateStatus").click(function () {
					$("#myModal").modal("show");
					reimbId = $(this).attr('id');
				});

				$('#approveButton').click(function () {
					updateRequestStatus(parseInt(reimbId), 2);
				}); //approve this request
				$('#denyButton').click(function () {
					updateRequestStatus(parseInt(reimbId), 3);
				});  //deny this request
			});

		}
	}
	let args = [reimbId, approveDeny];
	let json = JSON.stringify(args);
	xhr.open('POST', 'ViewRequestsManager', true);
	xhr.send(json);
}

function filterTest(column) {
	let filterString = document.getElementById('reimbursementType').selectedOptions[0].innerText;
	let table = document.getElementsByTagName("tr");
	for (let i = 1; i < table.length; i++) {
		let currentRow = table[i].getElementsByTagName('td');
		if (filterString == 'Show all' || currentRow[column].innerText == filterString) {
			table[i].style.removeProperty('display');
		} else {
			table[i].style.display = 'none';
		}
	}
}
