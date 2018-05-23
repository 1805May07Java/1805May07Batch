//Comment
/* block comment*/

var a = 6;
var a;
console.log(a); //redeclare it wont loose its value

var interpol = `our variable a still keeps its value of ${a}`;

//truthy and falsy
//falsy = 0, null, undefined, NaN, "", false
//truthy - anything else
	
// === does not cast datatypes

//Guard operator &&
var userName = "gb17";
var password = "p4ssw0rd";
var pw = userName && password; // returns username if falsy password if truthy

//Default operator || oposite
var commission = 500;
var salery = 3000;
var getPaid = commission || salary;   //returns salery if commission is falsy and returns commission if it is truthy


//functions
var testing = function(){
	var x = 5;
	return x  *2;
};

testing(); //call function
function add(x, y){
	return x + y;
};
add(9,10);

var person = {
	fn: 'nathan', 
	ln: 'ashcroft',
	getFullName: function(){return `${this.fn} ${this.ln}`;}
}

person.getFullName();

//callback functions
var freinds = ["me", "myself", "I"];

//freinds.forEach( function(eachName, index){console.log(`${index + 1}: ${eachName}1);})

//scopes
//before es6 global and function scopes
//any variable without a declaration is put at top of page
//let keyword makes it block scopes
//const allows block scope too but should be used for constants


//fib function
function fib(n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fib(n-1) + fib(n-2);
};

//buble sort a num array
function bubble (arr){
	int holder;
			
			i = 0;
			
			do {
				if(arr[i] > arr[i+1]) {
					holder = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = holder;
					i = 0;
				}
				else {i++;};
				
			}while(i < arr.length -1);
			
			return array;
	}
	
//reverse String
function revStr(str){
	
	for(i = str.length - 1; i >= 0; i--) {
				console.log(str.charAt(i));	
			}
}
//Factorial
function fact(num){
	f = 1;
		
		while (num != 0) {
			f *= num;
			num--;
		}
		
		return f;
}









fsffs