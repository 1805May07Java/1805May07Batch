
window.onload = function() {
	console.log("Testing -- page has loaded");
	loadGenres();
}

function loadGenres() {

	var genres = [];

	for (let i = 0; i < genres.length; i++) {
		var elem = document.createElement("option");
		elem.value = genres[i].toLowerCase();
		elem.textContent = genres[i];
		document.getElementById("genres").appendChild(elem);
	}
}

function validateISBN() {

	var input = document.getElementById("isbn").value;
	var numRegEx = /^[0-9]+$/;
	if (! (numregEx.text(input) & input.length == 10)){
		document.getElementById("isbnwarning").hidden = false;
		document.getElementById("isbnwarning").innerHTML = "Not valid input";
	} else {
		document.getElementById("isbnwarning").hidden = true;
	}
}

function addBook() {

	var isbn = document.getElementById("isbn").value;
	var title = document.getElementById("title").value;
	var price = document.getElementById("price").value;
	var e = document.getElementById("genres");
	var genre = e.options[e.selectedIndex].value
	console.log(genre);
}

