document.getElementById("inner").addEventListener("click", function(){
    alert("IN INNER");}, false);

document.getElementById("middle").addEventListener("click", function(){
    alert("IN MIDDLE");
    event.stopPropagation();}, false);

document.getElementById("outer").addEventListener("click", function(){
    alert("IN OUTER");}, false);