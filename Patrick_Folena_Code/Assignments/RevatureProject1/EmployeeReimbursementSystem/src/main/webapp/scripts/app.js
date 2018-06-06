window.onload = function(){
	$('#login').on('click', login);
	//$('#InProgress').on('click', loadInternalView('22'));
	//$('#ReimbList').on('click', loadInternalView('23'));
	console.log("loaded");
}

function login(){
	console.log("logging in...");
	var username = $('#username').val();
	var password = $('#password').val();
	var user = {
			userID : 0,
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
				loadExternalView(user);
				$('#warnmessage').css('visibility', 'hidden');
			}
		}
	};
	xhr.open("POST", "login", true);
	xhr.send(json);
}

function loadExternalView(user) {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log(xhr.responseText);
			$('#root').html(xhr.responseText);
			$('#name').html(user.username);
		}
	}
	var stringView = (user.role) + ".view";
	console.log(stringView);
	xhr.open("GET", stringView, true);
	xhr.send();
}

function loadInternalView(pageIndex) {
	console.log("loadInternalView: " + pageIndex);
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#page').html(xhr.responseText);
		}
	}
	var pageView = pageIndex + ".view";
	console.log(pageView);
	xhr.open("GET", pageView, true);
	xhr.send();
}

function submitRequestForm(){
	var amount = $('#amount').val();
	var type = $('#typelist').val();
	var desc = $('#description').val();

	console.log(type);
	
	if(isNaN(amount) || amount <= 0)
	{
		alert("Error: Amount is an invalid Request Amount");
		return false;
	}
	amount = Number(amount).toFixed(2);
	
	$('#amount').val("");
	$('#description').val("");
	
	var request = {
			amount : amount,
			type : type,
			description : desc
	};
	
	var json = JSON.stringify(request);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status >= 200 && xhr.status <= 299){
				var request = JSON.parse(xhr.responseText);
				alert("Succesfully Submitted Request");
			}
			else{
				alert("Error Submitting Request: " + xhr.status);
			}
		}
	};
	xhr.open("POST", "submitRequest", true);
	xhr.send(json);
}

function loadAllRequest(page){
	$(".topButton").attr("disabled", true);

	console.log("RUNNING loadAllRequest")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log("loadAllRequest successful")
			if(xhr.status >= 200 && xhr.status <= 299){
				var list = JSON.parse(xhr.responseText);
				if(page == 11 || page == 12){
					if (page == 11){
						var xtraCol = '<td> N/I</td>';
					}
					
					for(var obj in list.reimlist){
						$('#reimbList').append(
								'<tr class=\'' + (list.reimlist[obj].Status) + '\'>' +
								'<td>' + (list.reimlist[obj].Submission) + '</td>' +
								'<td>' + (list.reimlist[obj].Amount) + '</td>' +
								'<td><span id=\'desc\'>' + (list.reimlist[obj].Description) + '</span></td>' +
								'<td>' + (list.reimlist[obj].Resolved) + '</td>' +
								'<td>' + (list.reimlist[obj].Resolver) + '</td>' +
								'<td>' + (list.reimlist[obj].Status) + '</td>' +
								xtraCol +
								'</tr>');
					}
				}
				else if (page == 0)
				{
					for(var obj in list.reimlist){
						$('#reimbList').append(
								'<tr name="hello" data-id=\'' + (list.reimlist[obj].ID) + '\' class=\'' + (list.reimlist[obj].Status) + '\'>' +
								'<td>' + (list.reimlist[obj].Submission) + '</td>' +
								'<td>' + (list.reimlist[obj].Requester) + '</td>' +
								'<td>' + (list.reimlist[obj].Amount) + '</td>' +
								'<td><span id=\'desc\'>' + (list.reimlist[obj].Description) + '</span></td>' +
								'<td>' + (list.reimlist[obj].Resolved) + '</td>' +
								'<td>' + (list.reimlist[obj].Resolver) + '</td>' +
								'<td>' + (list.reimlist[obj].Status) + '</td>' +
								'<td><input type="button" value="Approve" onClick = "updateTable(this, 2, 0)"/></td>' +
								'<td><input type="button" value="Deny" onClick = "updateTable(this, 1, 0)"/></td>' +
								'</tr>');
					}
				}
				
			}
			else{
				console.log("HELP");
				console.log(xhr.status);
			}
			$(".topButton").attr("disabled", false);
		}
	};
	xhr.open("GET", "getReimb", true);
	xhr.send();
}

function setStatusVisibility(status){
	switch(status){
	case '0':
		$(".Pending").css("display", "table-row");
		$(".Approved").css("display", "table-row");
		$(".Denied").css("display", "table-row");
		break;
	case '1':
		$(".Pending").css("display", "table-row");
		$(".Approved").css("display", "none");
		$(".Denied").css("display", "none");
		break;
	case '2':
		$(".Pending").css("display", "none");
		$(".Approved").css("display", "table-row");
		$(".Denied").css("display", "none");
		break;
	case '3':
		$(".Pending").css("display", "none");
		$(".Approved").css("display", "none");
		$(".Denied").css("display", "table-row");
		break;
	}
}

function updateTable(elem, status, page){
	var row = elem.parentNode.parentNode.getAttribute("data-id");
	console.log(row);
	var reimInfo = {
		id: row,
		status: status
	};
	
	var json = JSON.stringify(reimInfo);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
			refreshTable(page);
		}
	};
	xhr.open("POST", "updateReimbursement", true);
	xhr.send(json);
}

function refreshTable(page)
{
	if(page == 0){
		$('#reimbList > tbody').html('<tr>' +
			'<th>Submission Date</th>' +
			'<th>Requester</th>' +
			'<th>Amount</th>' +
			'<th>Description</th>' +
			'<th>Resolved on</th>' +
			'<th>Resolved by</th>' +
			'<th>Status</th>' +
			'<th>Accept</th>' +
			'<th>Decline</th>' +
			'</tr>')
	}
	else if (page == 11){
		$('#reimbList > tbody').html('<tr>' +
		'<th>Submission Date</th>' +
		'<th>Amount</th>' +
		'<th>Description</th>' +
		'<th>Resolved on</th>' +
		'<th>Resolved by</th>' +
		'<th>Status</th>' +
		'<th>Remove?</th>' +
		'</tr>')
	}
	else if (page == 12){
		$('#reimbList > tbody').html('<tr>' +
		'<th>Submission Date</th>' +
		'<th>Amount</th>' +
		'<th>Description</th>' +
		'<th>Resolved on</th>' +
		'<th>Resolved by</th>' +
		'<th>Status</th>' +
		'</tr>')
	}
		
	loadAllRequest(page);
}