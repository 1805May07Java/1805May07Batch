window.onload = function(){
    console.log("testing -- page has loaded");
    loadGenres();
    document.getElementById("isbn").addEventListener("blur", validateISBN);
    document.getElementById("add").addEventListener("click", addBook);
}

function loadGenres(){
    var genres = ["Business", "Comedy", "Cooking", "Drama", "Engineering", "Fiction", "History",
            "Horror", "Non-Fiction", "Romance", "Science"];
    for(let i = 0; i < genres.length; i++){
        var elem = document.createElement("option");
        elem.value = genres[i];
        elem.innerHTML = genres[i];
        document.getElementById("genres").appendChild(elem);
    }
}

function validateISBN(){
    var input = document.getElementById("isbn").value;
    var numRegEx = /^[0-9]+$/;
    if(! (numRegEx.test(input) & input.length == 10)){
        document.getElementById("isbnwarning").hidden = false;
        document.getElementById("add").setAttribute("disabled", true);
        document.getElementById("isbnwarning").innerHTML = "Not valid input. Please enter a 10 digit number";
    }
    else{
        document.getElementById("isbnwarning").hidden = true;
        document.getElementById("add").removeAttribute("disabled");
    }

}

var count = 100;

/*
This function takes input from the user, and formats it in 
a table by appending a row to the preexisting students table
*/
function addBook(){
    //getting our input values 
    var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var e = document.getElementById("genres");
    var genre = e.options[e.selectedIndex].value;
    var id = count++;

    //generate new elements
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");

    //assign our cells appropriate data
    cell1.innerHTML = id; // <td> </td>
    cell2.innerHTML = isbn;
    cell3.innerHTML = title;
    cell4.innerHTML = price;
    cell5.innerHTML = genre;

    // append each element to its parent

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);

    document.getElementById("tablebody").appendChild(row);




}