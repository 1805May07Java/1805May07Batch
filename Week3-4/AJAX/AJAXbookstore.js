window.onload = function(){
    loadGenres();
    loadAuthors();
    $('#add').on('click', addNewBook);
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
                addBookRow(books[i], genres[books[i].genre-1].name);
            }
        }
    }

    xhr.open("GET", "http://localhost:3000/books", true);
    xhr.send();
}

function addNewBook(){
    var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var e = document.getElementById("genres");
    var genre = e.options[e.selectedIndex].value;
    var newBook = {
        "isbn": isbn, 
        "title": title, 
        "price" : price,
        "genre" : genre
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status >= 200 && xhr.status <=299){
            
            newBook = JSON.parse(xhr.responseText);
            addBookRow(newBook,e.options[e.selectedIndex].innerHTML);
        }
    }

    xhr.open("POST", "http://localhost:3000/books", true );
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(JSON.stringify(newBook));
}



function addBookRow(book, genre){
    //getting our input values 
    var id = book.id;
    var isbn = book.isbn;
    var title = book.title;
    var price = book.price;


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

function loadAuthors(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log(`in load authors at ready state ${xhr.readyState}`);
        if(xhr.readyState==4 && xhr.status == 200){
            var authors = JSON.parse(xhr.responseText);
            
            for(let i = 0; i < authors[i].length; i++){
                let a = authors[i];
                let elem = document.createElement("option");
                elem.value = a.id;
                elem.innerHTML = `${a.firstname} ${a.lastname}`;
                $('#authors').append(elem);
            }
        }
    }

    xhr.open("GET", "http://localhost:3000/authors", true);
    xhr.send();
}

// get authors by book method 

//