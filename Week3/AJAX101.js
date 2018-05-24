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