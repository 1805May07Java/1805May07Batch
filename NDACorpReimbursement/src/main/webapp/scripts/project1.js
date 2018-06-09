window.onload = function () {
	$('#signupdiv').hide();
	$('#logIn').on('click', login);
	$('#signUp').on('click', signUp);
	$('#signUpnew').on('click', signUpNew)
	$('#pwnew2').on('blur', checkPw);
	$('#logout').on('click', logoutu);
	loadNav();
}

function signUpNew(){
	var ok = true;
	var user = {
			userID : 0, 
			userName : username, 
			password : pass,
			fName : "",
			lName : "",
			email : "",
			role : 1,
	};

	if(!($('#firstname').val())){
		ok = false;
	}
	if(!($('#lastname').val())){
		ok = false;
	}
	if(!($('#email').val())){
		ok = false;
	}
	if(!($('#usernamenew').val())){
		ok = false;
	}
	if(!($('#pwnew2').val())){
		ok = false;
	}

	if(ok===true){
		var fN = $('#firstname').val();
		var lN = $('#lastname').val();
		var eml = $('#email').val();
		var username = $('#usernamenew').val();
		var pass = $('#pwnew2').val();
		var user = {
				userID : 0, 
				userName : username, 
				password : pass,
				fName : fN,
				lName : lN,
				email : eml,
				role : 1
		};

		var json = JSON.stringify(user);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
				console.log(xhr.responseText);
				var user = JSON.parse(xhr.responseText);
				if(user == null){
					$('#allfields2').html('Username and/or Email Taken');
				}
				else{
					$('#firstname').val("");
					$('#lastname').val("");
					$('#email').val("");
					$('#usernamenew').val("");
					$('#pwnew').val("");
					$('#pwnew2').val("");
					$('#signupdiv').hide();
					loadLandingView(user);
				}
			}
		}

		xhr.open("POST", "signup", true);
		xhr.send(json);
	}
	else{
		$('#allfields2').html('Invalid Input');
	}
}

function logoutu(){

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
			loadNav();
			$('#logindiv').show();
			$('#view').html("");
			$('#addticketr').html("");
		}
	}
	xhr.open("GET", "logout", true);
	xhr.send();


}

function signUp(){
	$('#logindiv').hide();
	$('#signupdiv').show();
}

function loadNav() {
	$('#addticket').hide();
	$('#addticket').on('click', addTicket);
	$('#ad').hide();
	$('#approved').on('click', getAppr)
	$('#opentickets').on('click', getOpen)
	$('#denied').on('click', getDenied)
	$('#viewtick').hide();
	$('#viewtick').on('click', getTick)
	$('#upinfo').hide();
	$('#upinfo').on('click', updateInfo)
	$('#who').html("")
	$('#who').hide();
	$('#whoid').hide();
	$('#whorole').hide();
	$('#logout').hide();
}

function GetTodayDate() {
	var tdate = new Date();
	var dd = tdate.getDate(); //yields day
	var MM = tdate.getMonth(); //yields month
	var yyyy = tdate.getFullYear(); //yields year
	var currentDate= yyyy + "-" +( MM+1) + "-" + dd;

	return currentDate;
}

function addTicket(){

	getAddTicketView();
	var reimtypes = getReimTypes();

}

function sendTicket(){
	var ticket = {
			reimId : 0,
			reimAmmount : 0,
			dateSub : GetTodayDate(),
			dateRes : null,
			notes : "",
			author : $('#whoid').val(),
			resolver : null,
			status : 1,
			type : 5,		
	};
	var reimtypes = getReimTypes();

	var ok = true;
	if(!($('#reimamount').val())){
		ok = false;
	}
	if(!($('#reimdescr').val())){
		ok = false;
	}
	if(ok===true){
		ticket.reimAmmount = $('#reimamount').val();
		$('#reimamount').val("");
		ticket.notes = $('#reimdescr').val();
		$('#reimdescr').val("");
		var e = document.getElementById("reimtypes");
		var reimty = e.options[e.selectedIndex].value;
		ticket.type = $('#reimtypes').val();
		console.log(ticket);
		var json = JSON.stringify(ticket);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
				console.log(xhr.responseText);
				if(xhr.responseText === false){
					alert("invalid data")
				}
				$('#addticketr').html("");
				xtreme = false
				getTick();
			}
		}

		xhr.open("POST", "reim", true);
		xhr.send(json);
	}

}

function getAddTicketView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#addticketr').html(xhr.responseText);
			$('#reimamount').on('blur', checkReimAmount);
			$('#addreimbut').on('click', sendTicket);

		}
	}

	xhr.open("GET", "addticket.view", true);
	xhr.send();
}

function getReimTypes(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var reimtypes = JSON.parse(xhr.responseText);
			//console.log(reimtypes);
			$('#reimtypes').empty();
			for(let i = 0; i < reimtypes.length; i++){
				var elem = document.createElement("option");
				elem.value = reimtypes[i].id;
				console.log(elem.value);
				elem.innerHTML = reimtypes[i].type;
				$('#reimtypes').append(elem);

			}
			return reimtypes;
		}
	}

	xhr.open("GET", "getreimtypes", true);
	xhr.send();

}

function getAppr(){
	reloadView();

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var reim = JSON.parse(xhr.responseText);
			makeTable(reim);
			$('#tablecap').text('Approved tickets');
		}
	}

	xhr.open("GET", "reim/apr", true);
	xhr.send();
}

function getOpen(){
	reloadView();

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var reim = JSON.parse(xhr.responseText);
			makeTable(reim);
			$('#tablecap').text('Open tickets click on status to Approve or deny');
			upOpen();
		}
	}

	xhr.open("GET", "reim/pend", true);
	xhr.send();
}

function upOpen(){
	$('tr').click(function (){
		/*}
	$('#reimtable').on('click', 'td', function(){*/
		txt = $(this).html();
		//console.log(txt);
		//a = $('td:first', $(this).parents('tr')).text();
		tickto = $(this).closest('tr').find('td:first').text();
		//console.log(tickto);
		//console.log(txt);
		//if(txt === 'Pending'){
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status==200){
					$('#addticketr').html(xhr.responseText);
					//console.log("callelist");
					elist();
					

				}
			}
			xhr.open("GET", "admin.view", true);
			xhr.send();
		//};
	})
}

function elist(){
	$('#approvetick').on('click', function(){
		var xhr = new XMLHttpRequest();
		var ticket = {
				ticketID : tickto, 
		};
		console.log("inelist");
		var json = JSON.stringify(ticket);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status==200){
				//$('tr').off();
				$('#addticketr').html("");
				getOpen();
				
			}
		}
		xhr.open("PUT", "reim/app", true);
		xhr.send(json);
		
	})
	$('#denytick').on('click', function(){
		var xhr = new XMLHttpRequest();
		var ticket = {
				ticketID : tickto, 
		};

		var json = JSON.stringify(ticket);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status==200){
				//$('tr').off();
				$('#addticketr').html("");
				getOpen();

			}
		}
		xhr.open("PUT", "reim/den", true);
		xhr.send(json);
	})
	
	
	//code to do with form here and this
}

function getDenied(){
	reloadView();

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var reim = JSON.parse(xhr.responseText);
			makeTable(reim);
			$('#tablecap').text('Denied tickets');
		}
	}

	xhr.open("GET", "reim/den", true);
	xhr.send();
}

function getTick(){
	$('#addticketr').html("");
	reloadView();

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status == 200){
			var reim = JSON.parse(xhr.responseText);
			makeTable(reim);
			$('#tablecap').text('All tickets');
		}
	}

	xhr.open("GET", "reim/all", true);
	xhr.send();
}

function makeTable(reim){
	//console.log(reim);
	$('#tmpholdtick').hide();
	$('#reimtable').empty();
	for(let i = 0; i < reim.length; i++){
		var row = document.createElement("tr");
		var cell1 = document.createElement("td");
		cell1.setAttribute("id", "reimidtosend");
		var cell2 = document.createElement("td");
		var cell3 = document.createElement("td");
		var cell4 = document.createElement("td");
		var cell5 = document.createElement("td");
		var cell6 = document.createElement("td");
		var cell7 = document.createElement("td");
		var cell8 = document.createElement("td");
		var cell9 = document.createElement("td");

		cell1.innerHTML = reim[i].reimId;
		cell2.innerHTML = reim[i].reimAmmount;
		cell3.innerHTML = reim[i].dateSub;
		cell4.innerHTML = reim[i].dateRes;
		cell5.innerHTML = reim[i].notes;
		cell6.innerHTML = reim[i].author;
		cell7.innerHTML = reim[i].resolver;
		cell8.innerHTML = reim[i].status;
		cell9.innerHTML = reim[i].type;

		row.appendChild(cell1);
		row.appendChild(cell2);
		row.appendChild(cell3);
		row.appendChild(cell4);
		row.appendChild(cell5);
		row.appendChild(cell6);
		row.appendChild(cell7);
		row.appendChild(cell8);
		row.appendChild(cell9);

		document.getElementById("reimtable").appendChild(row);	
	}
}

function updateInfo(){
	$('#addticketr').html("");
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#view').html(xhr.responseText);
			getUpInfo();
			$('#updateu').on('click', upInfo);
			$('#pw2u').on('blur', checkPw2);
		}


	}
	xhr.open("GET", "updateuser.view", true);
	xhr.send();
}

function getUpInfo(){

	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var u = JSON.parse(xhr.responseText);
			$('#firstnameu').val(u.fName);
			$('#lastnameu').val(u.lName);
			$('#emailu').val(u.email);
			$('#usernameu').val(u.userName);
		}
	}
	xhr.open("GET", "getuser", true);
	xhr.send();
}

function upInfo(){
	var ok = true;
	var user = {
			userID : 0, 
			userName : username, 
			password : pass,
			fName : "",
			lName : "",
			email : "",
			role : 1,
	};

	if(!($('#firstnameu').val())){
		ok = false;
	}
	if(!($('#lastnameu').val())){
		ok = false;
	}
	if(!($('#emailu').val())){
		ok = false;
	}
	if(!($('#usernameu').val())){
		ok = false;
	}
	if(!($('#pw2u').val())){
		ok = false;
	}

	if(ok===true){
		var fN = $('#firstnameu').val();
		var lN = $('#lastnameu').val();
		var eml = $('#emailu').val();
		var username = $('#usernameu').val();
		var pass = $('#pw2u').val();
		var user = {
				userID : 0, 
				userName : username, 
				password : pass,
				fName : fN,
				lName : lN,
				email : eml,
				role : 1
		};

		var json = JSON.stringify(user);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
				console.log(xhr.responseText);
				var t = xhr.responseText;
				if(t == false){
					$('#allfields2').html('Username and/or Email Taken');
				}
				else{
					$('#firstnameu').val("");
					$('#lastnameu').val("");
					$('#emailu').val("");
					$('#usernameu').val("");
					$('#pwu').val("");
					$('#pw2u').val("");
					$('#view').html("");

					showTick();
				}
			}
		}

		xhr.open("PUT", "signup", true);
		xhr.send(json);
	}
	else{
		$('#allfields2').html('Invalid Input');
	}
}

function checkReimAmount(){
	var x = $('#reimamount').val();
	if(!(Number.isInteger(x))){
		$('#amountwrong').html = "must be a number";
		//$('#addreimb').attr("disabled", true);
	}
	else{
		$('#amountwrong').html = "";
		//$('#addreimb').attr("disabled", false);
	}
}

function checkPw(){
	if($('#pwnew').val() != $('#pwnew2').val()){
		document.getElementById("pwmatch").innerHTML = "Passwords Must Match";
		//$('#signUpnew').attr("disabled", true);
	}
	else{
		//$('#signUpnew').attr("disabled", false);
		document.getElementById("pwmatch").innerHTML = "";
	}
}

function checkPw2(){
	if($('#pwu').val() != $('#pw2u').val()){
		document.getElementById("pwmatchu").innerHTML = "Passwords Must Match";
		// $('#updateu').attr("disabled", true);
	}
	else{
		//$('#updateu').attr("disabled", false);
		document.getElementById("pwmatchu").innerHTML = "";
	}
}

function login(){
	var username = $('#username').val();
	var pass = $('#pw').val();
	var user = {
			userID : 0, 
			userName : username, 
			password : pass,
			fName : "",
			lName : "",
			email : "",
			role : 0
	};

	var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <= 299){
			//console.log(xhr.responseText);
			var user = JSON.parse(xhr.responseText);
			if(user == null){
				$('#allfields').html('Invalid Credentials');
			}
			else{
				$('#username').val("");
				$('#pw').val("");
				$('#logindiv').hide();
				loadLandingView(user);
			}
		}
	}

	xhr.open("POST", "login", true);
	xhr.send(json);
}

function loadLandingView(user){

	switch(user.role){
	case 1:{
		$('#addticket').show();
		$('#viewtick').show();
		$('#upinfo').show();
		$('#who').html("Welcome " + user.fName);
		$('#whoid').val(user.userID);
		$('#whorole').val(user.role);
		$('#who').show();
		$('#logout').show();
		getTick();
		break;
	}
	case 2:{
		$('#ad').show();
		$('#viewtick').show();
		$('#upinfo').show();
		$('#who').html("Welcome " + user.fName);
		$('#whoid').val(user.userID);
		$('#whorole').val(user.role);
		$('#who').show();
		$('#logout').show();
		getTick();
		break;
	}
	}
}

function reloadView(){
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "user.view", true);
	xhr.send();
}