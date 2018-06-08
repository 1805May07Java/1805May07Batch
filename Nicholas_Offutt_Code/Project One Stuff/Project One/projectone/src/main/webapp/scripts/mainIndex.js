window.onload =  function(){
    $('#logUser').on('click', userLogIn);
    $('#logAdmin').on('click', adminLogIn);
    $('#newregister').on('click', loadRegisterView);

};

function indexHandlers()
{
    //onload event listeners
    $('#logUser').on('click', userLogIn);
    $('#logAdmin').on('click', adminLogIn);
    $('#newregister').on('click', loadRegisterView);
}


// basic user login sequence
//step one verify
function userLogIn()
{
    console.log("in user login");

    var username = $('#userName').val();
    var pass = $('#password').val();
    var credentials = {
        userName : username,
        password : pass
    };

    var json = JSON.stringify(credentials);
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
			console.log(xhr.responseText);
            var views = JSON.parse(xhr.responseText);
            if(views == null)
            {
				$('#message').html('Invalid Credentials');
            }
            else
            {
				loadUserView();
			}
		}
	}

	xhr.open("POST", "userlogin", true);

	xhr.send(json);

}

//step two load the user view 
 function loadUserView()
 {
    console.log("loading user view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
            window.onload =  function(){
            //user navigation
            $('#userhome').on('click', loadUserView);
            $("#linksubmit").on('click', loadSubmissionView);
            getUserClaims();}
        }
    }

    xhr.open("GET", "viewuser", true);

	xhr.send();

 }

//step three load it with data
function getUserClaims()
{
    console.log("populating user tables");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            arrViews = JSON.parse(xhr.responseText);

                var cell1 = document.createElement("td");
                var cell2 = document.createElement("td");
                var cell3 = document.createElement("td");
                var cell4 = document.createElement("td");
                var cell5 = document.createElement("td");
                var cell6 = document.createElement("td");
                var cell7 = document.createElement("td");
                var cell8 = document.createElement("td");
                var cell9 = document.createElement("td");
                var cell10 = document.createElement("td");
                var cell11 = document.createElement("td");
                var cell12 = document.createElement("td");
                var cell13 = document.createElement("td");

            for(let i = 0; i< arrViews.length; i++)
            {
                var row = document.createElement("tr");
                
                cell1.innerHTML = arrViews[i].id;
                cell2.innerHTML = arrViews[i].authorFirst;
                cell3.innerHTML = arrViews[i].authorLast;
                cell4.innerHTML = arrViews[i].amount;
                cell5.innerHTML = arrViews[i].description;
                cell6.innerHTML = arrViews[i].submit;
                cell7.innerHTML = arrViews[i].resolved;
                cell8.innerHTML = arrViews[i].type;
                cell9.innerHTML = arrViews[i].status;
                cell10.innerHTML = arrViews[i].resolverFirst;
                cell11.innerHTML = arrViews[i].resolverLast;
                cell12.innerHTML = arrViews[i].reqId;
                cell13.innerHTML = arrViews[i].resolvId;

                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                row.appendChild(cell4);
                row.appendChild(cell5);
                row.appendChild(cell6);
                row.appendChild(cell7);
                row.appendChild(cell8);
                row.appendChild(cell9);
                row.appendChild(cell10);
                row.appendChild(cell11);
                row.appendChild(cell12);
                row.appendChild(cell13);

                document.getElementById("tablebody").appendChild(row);
            }
            fancyTables();
        }
    }

    xhr.open("GET", "loadUserViews", true);

	xhr.send();
}


//call to make our table look good
function fancyTables()
{
    console.log("were fancy!");
    $('#tableview').DataTable();
};



//step one for the admin
function adminLogIn()
{
    console.log("in admin login");
    var username = $('#userName').val();
    var pass = $('#password').val();
    var credentials = {
        userName : username,
        password : pass
    };

    var json = JSON.stringify(credentials);
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
			console.log(xhr.responseText);
            var views = JSON.parse(xhr.responseText);
            if(views == null)
            {
				$('#message').html('Invalid Credentials For Admin');
            }
            else
            {
				loadAdminView();
			}
		}
	}

	xhr.open("POST", "adminlogin", true);

	xhr.send(json);
}


//step two for the admin loading his view
function loadAdminView()
{
    console.log("loading admin view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
            window.onload =  function(){
            //admin navigation
            $('#adminhome').on('click', loadAdminView);
            $('#statuslink').on('click', loadStatusView);
            $('#approval').on('click', loadApprovalView);
            $('#employ').on('click', loadClaimsByUserView);
            getAllClaims();
            }
        }
    }

    xhr.open("GET", "viewadmin", true);

	xhr.send();
}



//load up all of the claims
function getAllClaims()
{
    console.log("populating all tables");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            arrViews = JSON.parse(xhr.responseText);

                var cell1 = document.createElement("td");
                var cell2 = document.createElement("td");
                var cell3 = document.createElement("td");
                var cell4 = document.createElement("td");
                var cell5 = document.createElement("td");
                var cell6 = document.createElement("td");
                var cell7 = document.createElement("td");
                var cell8 = document.createElement("td");
                var cell9 = document.createElement("td");
                var cell10 = document.createElement("td");
                var cell11 = document.createElement("td");
                var cell12 = document.createElement("td");
                var cell13 = document.createElement("td");

            for(let i = 0; i< arrViews.length; i++)
            {
                var row = document.createElement("tr");
                
                cell1.innerHTML = arrViews[i].id;
                cell2.innerHTML = arrViews[i].authorFirst;
                cell3.innerHTML = arrViews[i].authorLast;
                cell4.innerHTML = arrViews[i].amount;
                cell5.innerHTML = arrViews[i].description;
                cell6.innerHTML = arrViews[i].submit;
                cell7.innerHTML = arrViews[i].resolved;
                cell8.innerHTML = arrViews[i].type;
                cell9.innerHTML = arrViews[i].status;
                cell10.innerHTML = arrViews[i].resolverFirst;
                cell11.innerHTML = arrViews[i].resolverLast;
                cell12.innerHTML = arrViews[i].reqId;
                cell13.innerHTML = arrViews[i].resolvId;

                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                row.appendChild(cell4);
                row.appendChild(cell5);
                row.appendChild(cell6);
                row.appendChild(cell7);
                row.appendChild(cell8);
                row.appendChild(cell9);
                row.appendChild(cell10);
                row.appendChild(cell11);
                row.appendChild(cell12);
                row.appendChild(cell13);

                document.getElementById("tablebody").appendChild(row);
            }
            fancyTables();
        }
    }

    xhr.open("GET", "getallviews", true);

	xhr.send();
}



//load the status view
function loadStatusView()
{
    onsole.log("populating tables by status");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
             //handler for status view
            $('#selection').on('click', function(){getClaimsByStatus($('#selection').val())})
           
        }
    }

    xhr.open("GET", "viewstatus", true);

	xhr.send(out);
}

 
//load claims by Status into the table
function getClaimsByStatus(stat)
{
    var status = {status:stat};
    var out = JSON.stringify(stat);
    console.log("populating tables by status");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            arrViews = JSON.parse(xhr.responseText);

                var cell1 = document.createElement("td");
                var cell2 = document.createElement("td");
                var cell3 = document.createElement("td");
                var cell4 = document.createElement("td");
                var cell5 = document.createElement("td");
                var cell6 = document.createElement("td");
                var cell7 = document.createElement("td");
                var cell8 = document.createElement("td");
                var cell9 = document.createElement("td");
                var cell10 = document.createElement("td");
                var cell11 = document.createElement("td");
                var cell12 = document.createElement("td");
                var cell13 = document.createElement("td");

            for(let i = 0; i< arrViews.length; i++)
            {
                var row = document.createElement("tr");
                
                cell1.innerHTML = arrViews[i].id;
                cell2.innerHTML = arrViews[i].authorFirst;
                cell3.innerHTML = arrViews[i].authorLast;
                cell4.innerHTML = arrViews[i].amount;
                cell5.innerHTML = arrViews[i].description;
                cell6.innerHTML = arrViews[i].submit;
                cell7.innerHTML = arrViews[i].resolved;
                cell8.innerHTML = arrViews[i].type;
                cell9.innerHTML = arrViews[i].status;
                cell10.innerHTML = arrViews[i].resolverFirst;
                cell11.innerHTML = arrViews[i].resolverLast;
                cell12.innerHTML = arrViews[i].reqId;
                cell13.innerHTML = arrViews[i].resolvId;

                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                row.appendChild(cell4);
                row.appendChild(cell5);
                row.appendChild(cell6);
                row.appendChild(cell7);
                row.appendChild(cell8);
                row.appendChild(cell9);
                row.appendChild(cell10);
                row.appendChild(cell11);
                row.appendChild(cell12);
                row.appendChild(cell13);

                document.getElementById("tablebody").appendChild(row);
            }
            fancyTables();
        }
    }

    xhr.open("GET", "getallviews", true);

	xhr.send(out);
}


//loads up the view for checking claims by a user
function loadClaimsByUserView()
{
    console.log("loading claims by user view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
            //handler for claims by id view
            $('#find').on('click', function(){getClaimsByUser($('#userid').val())})
            
        }
    }

    xhr.open("GET", "viewuser", true);

	xhr.send();
}

//get claims by user
function getClaimsByUser(userId)
{
    console.log("getting claims by user.");
    var int = {id:userId};
    var out = JSON.stringify(int);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
           var arr = JSON.parse(xhr.responseText);
           var cell1 = document.createElement("td");
           var cell2 = document.createElement("td");
           var cell3 = document.createElement("td");
           var cell4 = document.createElement("td");
           var cell5 = document.createElement("td");
           var cell6 = document.createElement("td");
           var cell7 = document.createElement("td");
           var cell8 = document.createElement("td");
           var cell9 = document.createElement("td");
           var cell10 = document.createElement("td");
           var cell11 = document.createElement("td");
           var cell12 = document.createElement("td");
           var cell13 = document.createElement("td");

            for(let i = 0; i< arrViews.length; i++)
            {
                var row = document.createElement("tr");
                
                cell1.innerHTML = arrViews[i].id;
                cell2.innerHTML = arrViews[i].authorFirst;
                cell3.innerHTML = arrViews[i].authorLast;
                cell4.innerHTML = arrViews[i].amount;
                cell5.innerHTML = arrViews[i].description;
                cell6.innerHTML = arrViews[i].submit;
                cell7.innerHTML = arrViews[i].resolved;
                cell8.innerHTML = arrViews[i].type;
                cell9.innerHTML = arrViews[i].status;
                cell10.innerHTML = arrViews[i].resolverFirst;
                cell11.innerHTML = arrViews[i].resolverLast;
                cell12.innerHTML = arrViews[i].reqId;
                cell13.innerHTML = arrViews[i].resolvId;

                row.appendChild(cell1);
                row.appendChild(cell2);
                row.appendChild(cell3);
                row.appendChild(cell4);
                row.appendChild(cell5);
                row.appendChild(cell6);
                row.appendChild(cell7);
                row.appendChild(cell8);
                row.appendChild(cell9);
                row.appendChild(cell10);
                row.appendChild(cell11);
                row.appendChild(cell12);
                row.appendChild(cell13);

                document.getElementById("tablebody").appendChild(row);
            }
            fancyTables();
        }
    }

    xhr.open("POST", "claimsbyid", true);

	xhr.send(out);

}

//load the register view
function loadRegisterView()
{
    console.log("loading register user view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
          
            $('#firstname').on('blur',validateName);
            $('#lastname').on('blur',validateName);
            $('#userName').on('blur',validateName);
            $('#email').on('blur',validateName);
            $('passcode').on('blur', validateName);
            $('#userName').on('blur',validateName);
            $('#register').on('click', registerUser);
        
        }
    }

    xhr.open("GET", "viewregister", true);

	xhr.send();
}

//register a user
function registerUser()
{
    console.log("attempting registtartion");
    var inOne = $('#firstname').val();
    var inTwo = $('#lastname').val();
    var inThree = $('#userName').val();
    var inFour = $('#email').val();
    var inFive = $('#passcode').val();

    var user = { id: 0, userName: inThree, password: inFive, firstName: inOne, lastName: inTwo, email: inFour, roleId: 1};

    var out = JSON.stringify(user);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            var check = JSON.parse(xhr.responseText);
            if(check.id === 0)
            {
                $('#errorbox').html('Error could not complete. Please retry, User Name or Email may already be in use.');
            }
            else
            {
                $('#errorbox').html('Success');
            }
        }
    }
    xhr.open("POST", "register", true);

	xhr.send(out);
}


//enter the submission view 
function loadSubmissionView()
{
    console.log("loading submission view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
             //handlers for submission
             $('#submit').on('click', submitClaim);
             $('#amount').on('blur',validateAmount);
             $('#desc').on('blur',validateDesc);

            loadTypes();
        }
    }

    xhr.open("GET", "viewsubmit", true);

	xhr.send();
}


//loads up all available claim types
function loadTypes()
{
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            var arrType = JSON.parse(xhr.responseText);

            for(let i = 0; i<arrType.length; i++)
            {
                var elem = document.createElement('option');
                elem.value = arrType[i].type;
                elem.innerHTML = arrType[i].type;
                $('#type').append(elem);
            }
        }
    }

    xhr.open("GET", "loadtypes", true);

	xhr.send();
}

//loads up the approval view
function loadApprovalView()
{
    console.log("loading approval view");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            $('#mainview').html(xhr.responseText);
            //handle approve/deny 
            $('#approve').on('click', approveClaim);
            $('#deny').on('click', denyClaim);
        }
    }

    xhr.open("GET", "viewapproval", true);

	xhr.send();
}

function approveClaim()
{
    console.log("Attempting to approve claim.");
    var employee = $('#employeeid').val();
    var approve = 'Approved'
    var obj = {id: empolyee, decision: approve};
    var xhr = new XMLHttpRequest();
    var out = JSON.stringify(obj);
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            var check = JSON.parse(xhr.responseText);
            if(check.id === 0)
            {
                $('#infofield').html('Error could not complete. Either connection failed or claim already resolved.');
            }
            else
            {
                $('#infofield').html('Success');
            }
        }
    }

    xhr.open("PUT", "decideclaim", true);

	xhr.send(out);
}

function denyClaim()
{
    console.log("Attempting to deny claim.");
    var employee = $('#employeeid').val();
    var approve = 'Denied'
    var obj = {id: empolyee, decision: approve};
    var xhr = new XMLHttpRequest();
    var out = JSON.stringify(obj);
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            var check = JSON.parse(xhr.responseText);
            if(check.id === 0)
            {
                $('#infofield').html('Error could not complete. Either connection failed or claim already resolved.');
            }
            else
            {
                $('#infofield').html('Success');
            }
        }
    }

    xhr.open("PUT", "decideclaim", true);

	xhr.send(out);
}



//submit a new claim
function submitClaim()
{
    var money = $('#amount').val();
    var info = $('#desc').val();
    var type = $('#type').val();

    var claim = {amount: money, description: info, claimtype: type};
    var out = JSON.stringify(claim);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4 && (xhr.status >= 200 && xhr.status<300))
        {
            var check = JSON.parse(xhr.responseText);
            if(check.id < 0)
            {
                $('#errorbox').val('Success');
            }
            else
            {
                $('#errorbox').val('Failure');
            }
        }
    }
    xhr.open("POST", "submitclaim", true);

	xhr.send(out);
}

//validators
function validateAmount()
{
    var regex = /^\d+\.\d\d$/;
    var error = 'Invalid Amount, you must input a valid Currency amount such as 1.01.';
    var clear = '';
    if(regex.test($('#amount').val()))
    {
        $('#amount').prop('disabled', true);
        $('#errorbox').val(error);
    }
    else
    {
        $('#amount').prop('disabled', false);
        $('#errorbox').val(clear);
    }
}

function validateDesc()
{
    var regex = /.+/;
    var error = 'Invalid Description, you must input a description.';
    var clear = '';
    if(regex.test($('#desc').val()))
    {
        $('#desc').prop('disabled', true);
        $('#errorbox').val(error);
    }
    else
    {
        $('#desc').prop('disabled', false);
        $('#errorbox').val(clear);
    }
}

function validateName()
{
    var regex = /.+/;
    var error = 'Invalid, all fields must be filled.';
    var clear = '';
    if(regex.test($('#desc').val()))
    {
        $('#desc').prop('disabled', true);
        $('#errorbox').val(error);
    }
    else
    {
        $('#desc').prop('disabled', false);
        $('#errorbox').val(clear);
    }
}

function validateEmail()
{
}

function validatePassword()
{

}
