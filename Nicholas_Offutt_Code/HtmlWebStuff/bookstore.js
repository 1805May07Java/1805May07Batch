




function addBook()
{
	var isbn = document.getElementById().value;
	var title = document.getElementById().value;
	var price = document.getElementById().value;
	var hold = document.getElementById();
	var genre = hold.options[hold.selectedIndex].value;
	
	var row = document.createElement("row");
	
	
		var data1 = document.createElement("table data");
		var data2 = document.createElement("table data");
		var data3 = document.createElement("table data");
		var data4 = document.createElement("table data");
		
		data1.value = isbn;
		data1.textContent = isbn;
		data2.value = title;
		data2.textContent = title;
		data3.value = price;
		data3.textContent = price;
		data4.value = genre;
		data4.textContent = genre;
		
		document.getElementById(row).appendChild(data1);
		document.getElementById(row).appendChild(data2);
		document.getElementById(row).appendChild(data3);
		document.getElementById(row).appendChild(data4);
		
		document.getElementById("body").appendChild(row);
		
		
}