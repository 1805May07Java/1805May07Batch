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
        elem.textContent = genres[i];
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

function addBook(){
    var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var e = document.getElementById("genres");
    var genre = e.options[e.selectedIndex].value;
    
    



}