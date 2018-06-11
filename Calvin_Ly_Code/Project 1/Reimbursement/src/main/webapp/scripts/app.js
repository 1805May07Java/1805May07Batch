window.onload = function(){
    $('#login').on('click', login);
};

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
    };
    console.log("initialized user json");
    var json = JSON.stringify(user);
    console.log(json);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
            var user = JSON.parse(xhr.responseText);
            if(user == null){
                $('#loginmessage').html('Invalid Credentials');
            }
            else {
                $('#myModal').modal('toggle');
                $('#myModal').html("");
                $('#loginname').html(user.firstname + " "+ user.lastname);
                $('#navigation').html('');

                if(user.roleId == 1){
                    loadEmpView();
                    loadAddModal();
                    $('#navigation').append('<li class="nav-item "><a id="NewTicket" class="nav-link" href="#">New Ticket</a></li>');
                    $('#NewTicket').click(function(){
                        $('#myModal').modal('toggle');
                        $('#AddTicketButton').on('click', addNewTicket);
                    });

                }
                else{
                    loadManagerView();
                    loadManagerModal();
                    $('#navigation').append('<li class="nav-item "><a id="ChangeTicket" class="nav-link" href="#">Resolve Ticket</a></li>');
                    $('#navigation').append('<li class="nav-item "><a id="Refresh" class="nav-link" href="#">Refresh</a></li>');
                    $('#ChangeTicket').click(function(){
                        $('#myModal').modal('toggle');
                        $('#approve').click(function () {
                            var reimbid = $('#idnum').val();
                            var resolver = user.id;
                            var resolved_reimb = {
                                id: reimbid,
                                resolver_id: resolver,
                                status_id: 2
                            };
                            updateTicket(resolved_reimb);
                            $('#myModal').modal('toggle');

                            loadManagerView();
                            loadManagerModal();
                            setTimeout(loadData(user.roleId),1000);
                        });
                        $('#deny').click(function () {
                            var reimbid = $('#idnum').val();
                            var resolver = user.id;
                            var resolved_reimb = {
                                id: reimbid,
                                resolver_id: resolver,
                                status_id: 3
                            };
                            updateTicket(resolved_reimb);
                            $('#myModal').modal('toggle');

                            loadManagerView();
                            loadManagerModal();
                            setTimeout(loadData(user.roleId),1000);
                        });
                    });
                    // loadPendingData();
                    //tableRowClick(user.id);
                    $('#Refresh').click(function() {
                        loadManagerView();
                        loadManagerModal();
                        setTimeout(loadData(user.roleId),1000);
                    })
                }

                $('#navigation').append('<li class="nav-item "><a id="logout" class="nav-link" href="#">Logout</a></li>');
                console.log("adding logout function");
                $('#logout').ready(function(){
                    $('#logout').on('click',logout)
                });
                loadData(user.roleId);
            }
        }
    };
    xhr.open("POST", "login", true);
    xhr.send(json);
    console.log("http request sent");
}

function addNewTicket(){

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
    };

    var json = JSON.stringify(reimb);
    console.log(json);

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        console.log(xhr.readyState + " " + xhr.status);
        if(xhr.readyState == 4 && xhr.status==200){
            $('#myTable').html('');
            loadData(1);
        }
    };

    xhr.open("POST", "data", true);
    xhr.send(json);
    $('#myModal').modal('toggle');
}

function loadManagerModal(){
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        console.log(xhr.readyState + " " + xhr.status);
        if(xhr.readyState == 4 && xhr.status==200){
            $('#myModal').html(xhr.responseText);
        }
    };

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
    };

    xhr.open("GET", "add", true);
    xhr.send();
}

function loadManagerView(){
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        console.log(xhr.readyState + " " + xhr.status);
        if(xhr.readyState == 4 && xhr.status==200){
            $('#sitebody').html(xhr.responseText);
        }
    };

    xhr.open("GET", "mgr", true);
    xhr.send();
}
function loadEmpView(){
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        console.log(xhr.readyState + " " + xhr.status);
        if(xhr.readyState == 4 && xhr.status==200){
            $('#sitebody').html(xhr.responseText);
            $('#AddTicketButton').on('click', addNewTicket);
        }
    };

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
                var date = new Date();
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
                    // if(data[i].resolver_id==0)
                    //     cell6.innerHTML = " ";
                    // else
                    //     cell6.innerHTML = data[i].resolver_id;
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
                    var cell10 = document.createElement("td");

                    date = new Date(data[i].time_submitted);
                    cell1.innerHTML = '#'+data[i].id;
                    cell2.innerHTML = date.toLocaleString();
                    cell3.innerHTML = data[i].author_fn;
                    cell4.innerHTML = data[i].author_ln;
                    cell5.innerHTML = data[i].status;
                    cell6.innerHTML = data[i].type;
                    cell7.innerHTML = data[i].description;
                    cell8.innerHTML = data[i].amount;
                    if(data[i].resolver_id==0)
                        cell9.innerHTML = " ";
                    else
                        cell9.innerHTML = data[i].resolver_id;
                    if(data[i].time_resolved == null){
                        cell10.innerHTML = " ";
                    }
                    else{
                        date = new Date(data[i].time_resolved);
                        cell10.innerHTML = date.toLocaleString();
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
                    row.appendChild(cell10);

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
    };
    xhr.open("GET", "data", true);
    xhr.send();
}
function updateTicket(resolved_ticket) {
    var xhr = new XMLHttpRequest();
    var json = JSON.stringify(resolved_ticket);
    console.log(json);
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            //var user = JSON.parse(xhr.responseText);
            //loadManagerView(user);
        }
    };
    xhr.open('PUT', 'data', true);
    xhr.send(json);
}
function approve(id){
    var reimbid = $('#idnum').val();
    var resolver = id;
    var resolved_reimb = {
        id: reimbid,
        resolver_id: resolver,
        status_id: 2
    };
    updateTicket(resolved_reimb);
    $('#myModal').modal('toggle');

    loadManagerView();
    loadManagerModal();
    // setTimeout(loadData(user.roleId),1000);
}
function deny(id){
    var reimbid = $('#idnum').val();
    var resolver = id;
    var resolved_reimb = {
        id: reimbid,
        resolver_id: resolver,
        status_id: 3
    };
    updateTicket(resolved_reimb);
    $('#myModal').modal('toggle');

    loadManagerView();
    loadManagerModal();
    // setTimeout(loadData(user.roleId),1000);
}

// function tableRowClick(id) {
//     $('#myTable').on('click', 'tr', function (event) {
//         event = event || window.event; //for IE8 backward compatibility
//         var target = event.target || event.srcElement; //for IE8 backward compatibility
//         while (target && target.nodeName != 'TR') {
//             target = target.parentElement;
//         }
//         var cells = target.cells; //cells collection
//         //var cells = target.getElementsByTagName('td'); //alternative
//         if (!cells.length || target.parentNode.nodeName == 'THEAD') { // if clicked row is within thead
//             return;
//         }
//         var f1 = document.getElementById('reimbid');
//         var f2 = document.getElementById('status');
//         if (document.getElementById('status') == 'Approved') {
//             f2 = 2;
//         }
//         else if (document.getElementById('status') == 'Denied') {
//             f2 = 3;
//         }
//         else
//             f2 = 1;
//         var f3 = document.getElementById('resolver');
//         f1.value = cells[0].innerHTML;
//         f2.value = cells[1].innerHTML;
//         f3.value = cells[2].innerHTML;
//         var reimb_changed_data = {
//             id: document.getElementById('reimbid'),
//             status: 0,
//             resolver: 0
//         };
//         $('#myModal').modal("toggle");
//         $('#approve').on('click', function () {
//             reimb_changed_data.status = 2;
//             reimb_changed_data.resolver = id;
//             $('#myModal').modal("toggle");
//             var xhr = new XMLHttpRequest();
//             xhr.onreadystatechange = function () {
//                 if (xhr.readyState == 4 && xhr.status == 200) {
//                     var reimb_json = JSON.stringify(reimb_changed_data);
//                     xhr.open('PUT', 'data', true);
//                     xhr.send(reimb_json);
//                 }
//             }
//         });
//         $('#deny').on('click', function () {
//             reimb_changed_data.status = 3;
//             reimb_changed_data.resolver = id;
//             $('#myModal').modal("toggle");
//             var xhr = new XMLHttpRequest();
//             xhr.onreadystatechange = function () {
//                 if (xhr.readyState == 4 && xhr.status == 200) {
//                     var reimb_json = JSON.stringify(reimb_changed_data);
//                     xhr.open('PUT', 'data', true);
//                     xhr.send(reimb_json);
//                 }
//             };
//         });
//     })
// }

//video stuff below
$( document ).ready(function() {

    scaleVideoContainer();

    initBannerVideoSize('.video-container .poster img');
    initBannerVideoSize('.video-container .filter');
    initBannerVideoSize('.video-container video');

    $(window).on('resize', function() {
        scaleVideoContainer();
        scaleBannerVideoSize('.video-container .poster img');
        scaleBannerVideoSize('.video-container .filter');
        scaleBannerVideoSize('.video-container video');
    });

});

function scaleVideoContainer() {

    var height = $(window).height() + 5;
    var unitHeight = parseInt(height) + 'px';
    $('.homepage-hero-module').css('height',unitHeight);

}

function initBannerVideoSize(element){

    $(element).each(function(){
        $(this).data('height', $(this).height());
        $(this).data('width', $(this).width());
    });

    scaleBannerVideoSize(element);

}

function scaleBannerVideoSize(element){

    var windowWidth = $(window).width(),
        windowHeight = $(window).height() + 5,
        videoWidth,
        videoHeight;

    // console.log(windowHeight);

    $(element).each(function(){
        var videoAspectRatio = $(this).data('height')/$(this).data('width');

        $(this).width(windowWidth);

        if(windowWidth < 1000){
            videoHeight = windowHeight;
            videoWidth = videoHeight / videoAspectRatio;
            $(this).css({'margin-top' : 0, 'margin-left' : -(videoWidth - windowWidth) / 2 + 'px'});

            $(this).width(videoWidth).height(videoHeight);
        }

        $('.homepage-hero-module .video-container video').addClass('fadeIn animated');

    });
}