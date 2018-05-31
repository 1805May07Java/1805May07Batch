function writeFizzBuzz (){
	var toWriteCount = document.getElementById("number").value;
var theBody = document.getElementById("muhBody");
  
  for(toWrite; toWrite > 0 ; toWrite--){
  var p = document.createElement('p');
  	p.appendChild(isFizzBuzz(toWrite));
    theBody.appendChild(p);
  }
   
}

function isFizzBuzz(x){
  	if(x%3 == 0 && x%5 == 0)
    	return "fizzbuzz"
     else if(x%5 == 0)
     	return "buzz"
      else if(x%3 == 0)
      	return "fizz"
       else
       	return x;
}
