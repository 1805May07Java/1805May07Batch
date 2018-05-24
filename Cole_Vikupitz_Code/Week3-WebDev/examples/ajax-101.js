
window.onload = () => {
	getBooks()
};

function getBooks() {

	// How to make JSON request
	
	// Step 1 : Create your XHR
	var xhr = new XMLHttpRequest();

	// Step 2 : Function to carry out when response is ready
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status = 200) {
			var data = xhr.responseText;
			books = JSON.parseData(data);
		}
	}

	// Step 3 : Open our request
	xhr.open("GET", "https://api.myjson.com/bins/tq5ma", true);

	// Step 4 : Send it
	xhr.send();
}