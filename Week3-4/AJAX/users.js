window.onload = function () {
    console.log("window loaded");
    loadUsers();
    $('#submit').on('click', addUser);

    $('#users').on('click', 'li', function(){
        console.log(this);
    } );
}



function loadUsers() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var users = JSON.parse(xhr.responseText);
            while(users.length!=0){
                let user = users.pop();
                addToList(user);
            }
        }
    }

    xhr.open("GET", "http://localhost:8083/helloservlets/users", true);
    xhr.send();

}

function addToList(user) {
    var li = document.createElement("li");
    li.innerHTML  = user.username;
    $('#users').append(li);
}

function addUser(){
    var username = $('#username').val();
    var password = $('#password').val();
    var user = {'username' : username, 'password' : password};
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            let u = xhr.responseText;
            addToList(JSON.parse(u));
        }
    }

    xhr.open("POST","http://localhost:8083/helloservlets/users", true);
    xhr.send(JSON.stringify(user));
}