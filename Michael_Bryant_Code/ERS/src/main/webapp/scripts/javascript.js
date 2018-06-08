window.onload = function(){
	$('#showPass').on('click', function(){
		$(this).is(':checked') ? $('#passwordIn').attr('type', 'text') : $('#passwordIn').attr('type', 'password');
	});
	$('#login').on('click', login);
	$('#register').on('click', register);
	
	
}

function register(){
	console.log("register");
	var user=null;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	if(xhr.readyState==4 && xhr.status ==200){
			console.log("reg response");
			loadNewView();
		
		}
	}
	
	xhr.open("POST", "register.view", true);
	xhr.send();
}

function loadNewView(){
	console.log("loading user view");
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("loading view AJAX request");
			$('#view').html(xhr.responseText);

		}
	}
	
	xhr.open("POST", "register.view", true);
	xhr.send();
}

function login(){
    console.log("logging in");
    
	var username = $('#username').val();
    var pass = $('#passwordIn').val();
    console.log(username);
    console.log(pass);
    
	var user = {
			username : username, 
			password : pass
	};
	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#message').text('Invalid Credentials');
			}
			else{
				loadUserView(user);
			}
		}
	}
	
	xhr.open("POST", "login", true);
	xhr.send(json);
	 
}

function loadUserView(user){
	console.log("loading user view");
	
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			console.log("loading view AJAX request");
			$('#view').html(xhr.responseText);
			$('#addReimb').on('click', addReimb);
			if(user != null){
			$('#name').html(user.firstName);
			loadReimbTable(user);
			}
			
			console.log(user);
		}
	}
	
	xhr.open("POST", "registered.view", true);
	xhr.send();
}

function loadReimbTable(user){
	console.log("Load that table");
	console.log(user.userRoleId);
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange= function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			if(user.userRoleId == 1){
				console.log(xhr.responseText)
				var list = JSON.parse(xhr.responseText);
				createTable(list);
			}else {
				var list = JSON.parse(xhr.responseText);
				createTable(list);
			}
		}
		
	}
	if(user.userRoleId == 1){
	xhr.open("POST", "admin.table", true);
	}else{
	xhr.open("POST", "employee.table", true);	
	}
	xhr.send();
	
}

function createTable(list){
	var insert ="";
	var row =1;
	console.log(list);
	
	for(let i = 0; i < list.length; i++){
		
		var statusId="";
		var reimbType ="";
		var resolved = "";
		var resolver= list[i].resolved;
		(list[i].resolver > 0) ? resolver : resolver = "N/A";
		
		switch(list[i].statusId){
		case 0: statusId= "Pending"; break;
		case 1: statusId="Approved"; break;
		case 2: statusId= "Declined"; break;
		}
		
		switch(list[i].reimbType){
		case 0: reimbType= "Lodging"; break;
		case 1: reimbType= "Travel"; break;
		case 2: reimbType= "Food"; break;
		case 3: reimbType= "Other"; break;
		}
		
		if(list[i].resolved == null){
			resolved = "Not yet";
			}else {
			resolved = list[i].resolved;
			}
		
		
		insert += "<tr>" +"<th scope=\"row\">" +row +"</th>";
		insert += "<td>" + list[i].id +"</td>";
		insert += "<td>$" + list[i].amount +"</td>";
		insert += "<td>" + list[i].submitted +"</td>";
		insert += "<td>" + resolved +"</td>";
		insert += "<td>" + list[i].description +"</td>";
		insert += "<td>" + list[i].author +"</td>";
		insert += "<td>" + resolver +"</td>";
		insert += "<td>" + statusId +"</td>";
		insert += "<td>" + reimbType +"</td>";
		insert += "</tr>";
		
		row++;
	}
	
	$('#ReimbTable').html(insert);

}


function addReimb(){
	var amount = $("#amount").val();
	var description = $("#description").val();
	var reimbType = $("#reimbType option:selected").val();
	
	switch(reimbType){
	case "Lodging": reimbType = 0; break;
	case "Travel": reimbType = 1; break;
	case "Food": reimbType = 2; break;
	case "Other": reimbType =3; break;
	}
	
	var reimb ={
			amount : amount,
			description: description,
			reimbType: reimbType
	};
	
	var json = JSON.stringify(reimb);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var user = JSON.parse(xhr.responseText);
			$("#amount").val("");
			$("#description").val("");
			$("#reimbType option:selected").val("");
			loadReimbTable(user);
			
			
		}
	}
	
	xhr.open("POST", "addReimb.mod", true);
	xhr.send(json);
	 
}

