window.onload = function() {
	//adding functions to all buttons
	$('#login').on('click', login);
	//$('#register1').on('click', loadRegisterView);
	$('#logoutNav').on('click', logout);
	$('#reimbursementNav').on('click', viewReimbursement);
	$('#profileNav').on('click', viewProfile);
	
	//hiding the init of nav bar
	$('#logoutNav').hide();
	$('#reimbursementNav').hide();
	$('#profileNav').hide();
	$('#navUserRole').hide();
}


function login() {
	console.log("logging in");
	
	var username = $('#un1').val();
	var pass = $('#pw1').val();
	
	if(username == null || pass == null){
		$('#message').html('Invalid Credentials');
		return;
	}
	
	var user = {
		userId : 0,
		username : username,
		password : pass,
		firstname : "",
		lastname : "",
		email : "",
		userRoleId : -1
	};
	//console.log(user);
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			console.log(user);
			$('#navUser').val(user);
			if (user == null || user.username == null || user.password == null) {
				$('#message').html('Invalid Credentials');
			} else {
				$('#un1').val("");
				$('#pw1').val("");
				$('#view2').hide();
				$('#view').show();
				$('#navUserRole').val(user.userRoleId);
				$('#navUserId').val(user.userId);
				
				loadLandingView(user);
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.send(json);

}


function loadTable(user){
	console.log("in the loadTable");
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			var reimb = JSON.parse(xhr.responseText);
			console.log(reimb);
			var insert = "";
			if ($('#navUserRole').val() == 1) {
				$('#tableResolverOrAuthor').text("Resolver");
				//$('#addReimbursementForm').show();
				$('#approveOrDenyReimbursementForm').hide();
			} else {
				$('#tableResolverOrAuthor').text("Employee");
				$('#addReimbursementForm').hide();
				//$('approveOrDenyReimbursementForm').show();
				$('tableLead').text("Viewing all Reimbursements...");
			}

			for(let i = 0; i< reimb.length ; i++){
				//insert = "";
				if($('#radioPending').is(':checked')){
					if(reimb[i].statusId == 2 ||reimb[i].statusId == 3) continue;
				}else if($('#radioApproved').is(':checked')){
					if(reimb[i].statusId == 1 ||reimb[i].statusId == 3) continue;
				}else if($('#radioDenied').is(':checked')){
					if(reimb[i].statusId == 1 ||reimb[i].statusId == 2) continue;
				}
				
				insert += "<tr>";
				
				insert += "<td>" + reimb[i].id +"</td>";
		        insert += "<td>" + "$"+reimb[i].amount +"</td>";
		        insert += "<td>" + reimb[i].timeSubmitted +"</td>";
		        
		        if(reimb[i].timeResolved == null){
		        	insert += "<td>" + "" +"</td>";
		        }else{
		        	insert += "<td>" +reimb[i].timeResolved +"</td>";
		        }
		        
		        //Adding the Description
		        if(reimb[i].description == null){
		        	insert += "<td>" + "" +"</td>";
		        }else{
		        	insert += "<td>" + reimb[i].description +"</td>";
		        }
		        
		        //reimb[i].author;
		        
		        //Adding Resolver/Author
		        if ($('#navUserRole').val() == 1) {
		        	if(reimb[i].resolver == 0){
			        	insert += "<td>" + "" +"</td>";
			        }else{
			        	insert += "<td>" + reimb[i].resolver +"</td>";
			        }
				} else {
					if(reimb[i].author == 0){
			        	insert += "<td>" + "" +"</td>";
			        }else{
			        	insert += "<td>" + reimb[i].author +"</td>";
			        }
				}
		        
		        //Adding status
		        if(reimb[i].statusId == 1){
		        	insert += "<td>"+"Pending"+"</td>";
		        }else if (reimb[i].statusId == 2){
		        	insert += "<td>"+"Approved"+"</td>";
		        }else if (reimb[i].statusId == 3){
		        	insert += "<td>"+"Denied"+"</td>";
		        }else{
		        	insert += "<td>"+reimb[i].statusId+"</td>";
		        }

		        //Adding Type
		        if(reimb[i].typeId == 1){
		        	insert += "<td>" + "Lodging" +"</td>";
		        }else if(reimb[i].typeId == 2){
		        	insert += "<td>" + "Travel" +"</td>";
		        }else if (reimb[i].typeId == 3){
		        	insert += "<td>" + "Food" +"</td>";
		        }else if (reimb[i].typeId == 4){
		        	insert += "<td>" + "Other" +"</td>";
		        }else{
		        	insert += "<td>" + reimb[i].typeId +"</td>";
		        }
		        
					
		        insert += "</tr>";
		        
			}
			$('#reimbursementTable').html(insert);
			
		}
	}
	
	xhr.open("GET", "reimbursement", true);
	xhr.send();

	
}





function loadLandingView(user) {
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
			$('#name').html(user.firstname + " " + user.lastname);
			
			$('#reimbursementHome').on('click', viewReimbursement);
			$('#profileHome').on('click', viewProfile);
			
			switch(user.userRoleId){
			case(1):{
				$('#userTypeText').html('employee');
				break;
			}
			case(2):{
				$('#userTypeText').html('managerial');
			}
			}
		}
	}
	
	$('#logoutNav').show();
	$('#reimbursementNav').show();
	$('#profileNav').show();
	xhr.open("GET", "landing.view", true);
	
		
		
	
	
	xhr.send();
}

function logout(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			console.log(xhr.responseText);
			//$('#view').html(xhr.responseText);
			$('#view').hide();
			$('#view2').show();
			$('#message').text("");
			
			$('#logoutNav').hide();
			$('#reimbursementNav').hide();
			$('#profileNav').hide();
		}
	}

	xhr.open("GET", "logout", true);
	xhr.send();
}

function viewProfile(){
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			populateProfile();
			$('#editProfileBtn').on('click', editProfile);
			$('#resetProfileBtn').on('click', populateProfile);
			$('#updateAlert').hide();
		}
	}

	xhr.open("GET", "profile.view", true);
	xhr.send();
}


function populateProfile(){
	
	//Clear the message boxes
	$('#messagePassword').text("");
	$('#messagePassword2').text("");
	$('#messageFirstname').text("");
	$('#updateAlert').hide();
	
	
	var xhr = new XMLHttpRequest();
	


	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			var user2 = JSON.parse(xhr.responseText);
			
			$('#un2').val(user2.username);
			
			$('#pw2').val(user2.password);
			$('#pw3').val(user2.password);
			$('#fn2').val(user2.firstname);
			$('#ln2').val(user2.lastname);
			$('#em2').val(user2.email);
			
			$('#updateAlert').hide();
			
		}
	}

	xhr.open("GET", "editProfile", true);
	xhr.send();
}

function editProfile(){
	//Clear the message boxes
	$('#messagePassword').text("");
	$('#messagePassword2').text("");
	$('#messageFirstname').text("");
	$('#updateAlert').hide();
	
	
	var tempUsername = $('#un2').val();
	var tempPassword = $('#pw2').val();
	var tempPassword2 = $('#pw3').val();
	var tempFirstname = $('#fn2').val();
	var tempLastname = $('#ln2').val();
	var tempEmail = $('#em2').val();
	
	if(tempPassword != tempPassword2){
		$('#messagePassword').text("These passwords must match.");
		$('#messagePassword2').text("These passwords must match.");
		return;
	}
	
	if(tempFirstname == 'Michael' && tempLastname =='Bryant'){
		$('#messageFirstname').text("Dont be ridiculous...");
		return;
	}

	
	var user2 = {
		userId : 0,
		username :tempUsername,
		password :tempPassword,
		firstname :tempFirstname,
		lastname :tempLastname,
		email :tempEmail,
		userRoleId : -1
	};
	
	var json = JSON.stringify(user2);	var xhr = new XMLHttpRequest();	xhr.onreadystatechange = function() {		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#updateAlert').show();		}	}	xhr.open("POST", "editProfile", true);	xhr.send(json);
}


function viewReimbursement(user){
	console.log("in the view reimbursement function");
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			//console.log(xhr.responseText);
			loadTable();
			$('#view').html(xhr.responseText);
			$('#confirmBtn').on('click', editReimb);
			$('#addNewReimb').on('click', addNewReimb);
			$('#filterBtn').on('click', loadTable);
		}
	}

	xhr.open("GET", "reimbursement.view", true);
	xhr.send();
}

function editReimb(user){
	console.log("in editReimb");
	$('#radioMessage').text("");
	
	var tempReimbId = $('#reimbId').val();
	if(tempReimbId == ""){
		$('#radioMessage').text("Enter a reimbursement Id.");
	}else if($('#radioApprove').is(':checked')){
		resolveReimb(2);
	}else if($('#radioDeny').is(':checked')){
		resolveReimb(3);
	}else{
		$('#radioMessage').text("Select a approve/deny option.");
	}
}

function resolveReimb(newStatus){
	var tempReimbId = $('#reimbId').val();
	var reimbursement = {
			id : tempReimbId,
			amount : "",
			timeSubmitted : "",
			timeResolved : "",
			description : "",
			author : 0,
			resolver : 0,
			statusId : newStatus,
			typeId : 0
	};
	
	var json = JSON.stringify(reimbursement);
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(reimbursement);
			loadTable();	
		}
	}

	xhr.open("POST", "resolveReimbursement", true);
	xhr.send(json);
}

function addNewReimb(user){
	console.log("in addNewReimb");
	
	//GET INFORMATION FROM THE MODAL
	var amountTemp = $('#addAmount').val();
	var typeTemp = $('#addType').val();
	var descriptionTemp = $('#addDescription').val();
	
	console.log(amountTemp);
	console.log(typeTemp);
	console.log(descriptionTemp);
	
	if(typeTemp == "Lodging"){
		typeTemp = 1;
	}else if(typeTemp == "Travel"){
		typeTemp = 2;
	}else if(typeTemp == "Food"){
		typeTemp = 3;
	}else{
		typeTemp = 4;
	}
	
	var reimbursement = {
			id : 0,
			amount : amountTemp,
			timeSubmitted : "",
			timeResolved : "",
			description : descriptionTemp,
			author : 0,
			resolver : 0,
			statusId : 0,
			typeId : typeTemp
	};
	console.log(reimbursement);

	
	var json = JSON.stringify(reimbursement);
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			//console.log(xhr.responseText);
			//var reimbursement = JSON.parse(xhr.responseText);
			console.log(reimbursement);
			loadTable();
			
		}
	}

	xhr.open("POST", "addreimbursement", true);
	xhr.send(json);
}

function showPassword(){
	  var x = document.getElementById("pw1");
	    if (x.type === "password") {
	        x.type = "text";
	    } else {
	        x.type = "password";
	    }
}







