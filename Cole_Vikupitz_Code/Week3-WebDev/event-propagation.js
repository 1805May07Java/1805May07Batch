document.getElementById("inner").addEventListener("click", function(){
	alert("IN INNER")
	}, false);

document.getElementById("middle").addEventListener("click", function(){
	alert("IN MIDDLE")
	}, true);

document.getElementById("outer").addEventListener("click", function(){
	alert("IN OUTER")
	}, false);


// use eventStopPropagation() to halt the propagation(s)
/*
document.getElementById("inner").addEventListener("click", function(){
	alert("IN INNER");
	event.stopPropagation();
	}, false);
*/
