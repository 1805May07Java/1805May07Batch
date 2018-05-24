<<<<<<< HEAD
window.onload= function(){
    loadGenres();



}
//This functionwill load in our genres from our API
// to populate the drop down
    function loadGenres(){
            var xhr = new XMLHttpRequest();
             xhr.onreadystatechange = function(){
                    if(xhr.readyState == 4 && xhr.status == 200){
                        var genres = JSON.parse(xhr.responseText);
                        for(let i = 0; i < genres.length; i++){
                                var elem = document.createElement("option");
                                elem.value = genres[i].id;
                                elem.value = genres[i].name;
                                elem.innerHTML = genres[i].name;
                                $('#genres').append(elem);
                        }

                    }

            }
            xhr.open("GET", "http://localhost:3000/genres/", true);
            xhr.send();
    }
=======
window.onload = () => {
    getBooks();
}

function getBooks(){
    //STEP 1: CREATE YOUR XHR
    var xhr = new XMLHttpRequest();
    //STEP 2: FUNCTION TO CARRY OUT WHEN RESPONSE IS READY
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.statusText);
            var data = xhr.responseText;
            books = JSON.parse(data);
        }
    }
    //STEP 3: OPEN REQUEST
   // xhr.open("GET", "https://api.myjson.com/bins/tq5ma", true);
    xhr.open("GET", "http://localhost:3000/books", true);

    //STEP 4: SEND
    xhr.send();
}
>>>>>>> master
