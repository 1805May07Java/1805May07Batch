window.onload = function(){
    console.log("testing -- page has loaded");
    loadGenres();
    document.getElementById("isbn").addEventListener("blur", validateISBN);
    document.getElementById("add").addEventListener("click", addBook);
}

function loadGenres(){

    var genres = ["Buisness", "Comedy", "cooking", "drama", "Engineering", "Fiction", "History", "Horror", "non-fiction", "Romance", "Science"];

    for(let i = 0; i < genres.length; i++){
        var elem = document.createElement("option");
        elem.value = genres[i];
        elem.textContent = genres[i];
        document.getElementById("genres").appendChild(elem);
    }
}

function validateISBN(){
    var input = document.getElementById("isbn").value;
    var numsRegEx = /^[0-9]+$/;
    if(! (numsRegEx.test(input) & input.length == 10)){
       document.getElementById("isbnwarning").innerHTML = "not valid input please enter 10 digit";
       //document.getElementById("add").setAttribute("disabled", true);
       document.getElementById("add").setAttribute("disabled", true);
        console.log("not valid input");
    }
    else{
        document.getElementById("isbnwarning").hidden = true;
        //document.getElementById("add").removeAttribute("disabled", false);
        document.getElementById("add").removeAttribute("disabled");        
    }
}

var count = 100;
 //function takes input from user and formats it in a table by apending a row to the pre existing table
function addBook(){
   //values
    var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var e = document.getElementById("genres");
    var genre = e.options[e.selectedIndex].value;
    console.log(genre);
    var id = count++;

    var tr = document.createElement("tr");
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");
    var td5 = document.createElement("td");

    td1.innerHTML = id;
    td2.innerHTML = isbn;
    td3.innerHTML = title;
    td4.innerHTML = price;
    td5.innerHTML = genre;

    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    
    document.getElementById("tbody").appendChild(tr);
}