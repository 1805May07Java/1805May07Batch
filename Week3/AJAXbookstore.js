window.onload = function(){
    loadGenres();
    testing = getGenreById(1);
    console.log(testing);
}

/*
This function will load in our genres from our API to 
populate the drop down
*/
function loadGenres(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
            var genres = JSON.parse(xhr.responseText);
            for(let i = 0; i < genres.length; i++){
                var elem = document.createElement("option");
                elem.value = genres[i].id;
                elem.innerHTML = genres[i].name;
                $('#genres').append(elem);
            }

            loadBooks(genres);
        }
    }

    xhr.open("GET", "http://localhost:3000/genres", true);
    xhr.send();
}

function getGenreById(id){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
            var genre = JSON.parse(xhr.responseText);
            return genre;
        }
    }

    xhr.open("GET", `http://localhost:3000/genres/${id}`, false);
    xhr.send();
}

function loadBooks(genres){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState==4 && xhr.status == 200){
            var books = JSON.parse(xhr.responseText);
            for(let i = 0; i < books.length; i++){
                addBookRow(books[i], genres);
            
            }
        }
    }

    xhr.open("GET", "http://localhost:3000/books", true);
    xhr.send();
}


function addBookRow(book, genres){
    console.log(genres);
    //getting our input values 
    var id = book.id;
    var isbn = book.isbn;
    var title = book.title;
    var price = book.price;
    var genre = genres[book.genre-1].name;

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