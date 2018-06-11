window.onload = function(){
	$('#login').on('click', login);
	$('#register').on('click', loadRegisterView);
	
    
    }

function addNewReim(){
    var author = document.getElementById("author").value;
    var amount = document.getElementById("amount").value;
    var description = document.getElementById("description").value;
    var status = document.getElementById("status");
    var resolver = document.getElementById("resolver");
    var resDate = document.getElementById("resDate");
    var subDate = document.getElementById("subDate");
    var newReim = {
    	"id" : id,
        "author": author, 
        "amount": amount, 
        "description" : description,
        "status" : status,
        "resolver" : resolver,
        "resDate" : resDate,
        "subDate" : subDate
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <=299){
            
            newReim = JSON.parse(xhr.responseText);
            addReimRow(newReim.innerHTML);
        }
    }

    xhr.open("POST", "http://localhost:8081/addreimbreq", true );
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(newReim));
}

function addReimRow(user){
    // getting input values
    var id = user.id;
	var author = user.author;
    var amount = user.amount;;
    var description = user.description;
    var status = user.status;
    var resolver = user.resolver;
    var resolved = user.resolved;
    var submitted = user.submitted;

    // generate  elements
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");
    var cell8 = document.createElement("td");

    // assign cells appropriate data
    cell1.innerHTML = id; // <td> </td>
    cell2.innerHTML = author;
    cell3.innerHTML = amount;
    cell4.innerHTML = description;
    cell5.innerHTML = status;
    cell6.innerHTML = resolver;
    cell7.innerHTML = resolved;
    cell8.innerHTML = submitted;

    // append each element to its parent

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);
    
    document.getElementById("tablebody").appendChild(row);

}

function login(){
	console.log("logging in");
	var username = $('#username').val();
	var pass = $('#password').val();

	var user = {
			id : 0,
			username : username, 
			password : pass,
			first_Name : null,
			last_Name : null,
			email : null,
			roleId : 0
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#message').html('Invalid Credentials');
			}
			else{
				loadLandingView(user);
				
			}
		}
	}
	
	xhr.open("POST", "http://localhost:8081/ERS/login", true);
	xhr.send(json);
	
	
}

function loadRegisterView(){
	console.log("loading register view");
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#view').html(xhr.responseText);
			// manipulate DOM of new html
		}
	}
	
	xhr.open("GET", "register.view", true);
	xhr.send();
}

function loadLandingView(user){
	console.log("loading landing view");

			
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
		
			$('#view').html(xhr.responseText);
			$('#name').html(user.username);
			$('#add').on('click', function() {submitrequest(user); loadLandingView(user)});
		
			if(user.roleId == 2){
				getAllReimbursements();
				
			}else{
				loadUserReq(user);
			}

			}
		}
	
	xhr.open("GET", "landing.view", true);
	xhr.send();
}

function submitrequest(user){
	
	var amount = $('#amount').val();
	var description = $('#description').val();
		
	var userId = user.id;
	
	var req = {
		
		id : Math.floor((Math.random() * 1000) + 1),
		amount : amount,
		description : description,
		author : userId,
		status : 0,
        resolver : 0,
        resolved : "",
        submitted : ""
				
	};
	var json = JSON.stringify(req);
	console.log('test')
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			//loadUserReq(user)
			console.log(xhr.responseText);
			var req = JSON.parse(xhr.responseText);
	
		}
	}
	xhr.open("POST", "http://localhost:8081/ERS/addreimbreq", true);
	xhr.send(JSON.stringify(req));
	
}
function loadUserReq(user){
	var xhr = new XMLHttpRequest();
	var requests = [];
	var Reimbursement = {
			 id  : 0,
			 author  : 0, 
		     amount  : 0, 
		     description  : "",
		     status  : "",
		     resolver  : "",
		     resDate  : "",
		     subDate  : ""
	}	
		console.log(user);
		console.log("getting user reimbursements");
		
		requestsTable = document.getElementById('request-table');
				
		var json = JSON.stringify(user);
		
		xhr.onreadystatechange = function(){
			
			if(xhr.readyState == 4&& xhr.status == 200)
			{
				console.log("receivedresponse");
				console.log(xhr.responseText);
				let requests = JSON.parse(xhr.responseText);
				requests.forEach(Reimbursement=>
				{
					
					let row = document.createElement('tr');
					console.log(row);

	                let idCell = document.createElement('td');
	                idCell.innerHTML = Reimbursement.id;
	                row.appendChild(idCell);

	                let auth = document.createElement('td');
	                auth.innerHTML = Reimbursement.author;
	                row.appendChild(auth);
	                
	                let amt = document.createElement('td');
	                amt.innerHTML = Reimbursement.amount;
	                row.appendChild(amt);
	                
	                let desc = document.createElement('td');
	                desc.innerHTML = Reimbursement.description;
	                row.appendChild(desc);

	                let stat = document.createElement('td');
	                stat.innerHTML = Reimbursement.status;
	                row.appendChild(stat);
	          
	                let re = document.createElement('td');
	                re.innerHTML = Reimbursement.resolver;
	                row.appendChild(re);

	                let sd = document.createElement('td');
	                sd.innerHTML = Reimbursement.subDate;
	                row.appendChild(sd);

	               	console.log(row);
	               	requestsTable.appendChild(row);
	       
				});
			}
			}
			xhr.open('POST', "getuserreqs", true);
			xhr.send(json);
				
	}

function getAllReimbursements(){
	

	var requests = [];
	var Reimbursement = {
			 id  : 0,
			 author  : "", 
		     amount  : 0, 
		     description  : "",
		     status  : "",
		     resolver  : "",
		     resDate  : "",
		     subDate  : ""
	}	
						
		requestsTable = document.getElementById('request-table');
		let xhr = new XMLHttpRequest();
		xhr.open('GET', "http://localhost:8081/ERS/Rei");
		xhr.send();
		xhr.onreadystatechange=()=> 
		{
			if(xhr.readyState===4&&xhr.status===200)
			{
				console.log(xhr.responseText);
				let requests = JSON.parse(xhr.responseText);
				requests.forEach(Reimbursement=>
				{
					
					let row = document.createElement('tr');
					console.log(row);

	                let idCell = document.createElement('td');
	                idCell.innerHTML = Reimbursement.id;
	                row.appendChild(idCell);

	                let auth = document.createElement('td');
	                auth.innerHTML = Reimbursement.author;
	                row.appendChild(auth);
	                
	                let amt = document.createElement('td');
	                amt.innerHTML = Reimbursement.amount;
	                row.appendChild(amt);
	                
	                let desc = document.createElement('td');
	                desc.innerHTML = Reimbursement.description;
	                row.appendChild(desc);

	                let stat = document.createElement('td');
	                stat.innerHTML = Reimbursement.status;
	                row.appendChild(stat);
	          
	                let re = document.createElement('td');
	                re.innerHTML = Reimbursement.resolver;
	                row.appendChild(re);

	                let res = document.createElement('td');
	                res.innerHTML = Reimbursement.resolved;
	                row.appendChild(res);
	                
	                let sd = document.createElement('td');
	                sd.innerHTML = Reimbursement.submitted + "&nbsp&nbsp&nbsp<button type=button class='btn btn-success btn-sm'>Approve</button>" +
	                		"&nbsp<button type=button class='btn btn-danger btn-sm'>Deny</button>";
	                
	                row.appendChild(sd);
	                
	                row.setAttribute('onclick', "updateRow(event)");
	                
	               	console.log(row);
	               	requestsTable.appendChild(row);
	       
				});
			}
		}
	}

function updateRow(event){
	var row = event.target;
	
      
    $('.btn-success').click(function() {
    	var row = $(this).closest('tr');
    	row.hide();

    })
    $('.btn-danger').click(function() {
    	var row=$(this).closest('tr');
    	row.hide();
    })

    

}

