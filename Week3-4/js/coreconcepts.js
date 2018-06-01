/*
 * JavaScript is a a scripting language for client-side operations
 * 	!= Java. "JS is to Java as ham is to hamster"
 * 	C-like syntax
 * 	supports prototypal inheritance 
 * 	loosely typed - variable types are dynamically allocated
 *  JS syntax defines two types of values:
 *  		1. fixed values - literals
 *  		2. variable values - declared using var, let, or const
 * 	Variable types number, string, object, boolean, null, NaN(?), undefined
 * 			(null is considered an object in JS. can consider it a bug)
 * 	JS statements are composed of values, operators, expressions, 
 * 			keywords, and comments
 * 	JS is case sensitive (lastname != lastName)
 *  Some keywords in JS that we're familiar with - break, continue, 
 *  		do...while, for, if...else, return, switch, try...catch
 *  		There is also debugger - stops the execution of JS, and 
 *  		calls (if available) the debugging function
 *  Load-and-Go delivery
 * 			Delivered to browser and it knows how to handle it
 * 			Isn't always running
 *  Objects are special -> "generalized containers"
 *  Functions are special -> lambda closures
 */

var a = 5;
var b = "hello"
	var c = 'hello';
var d = 7/0
var e = {name: "genesis", age:30};
e["age"] = 20;
var f = e.age;
var g = [0 , 2, 4, 6, 8];
var h = null;
var i;
var j = 1, k = 'hey', l = null;
var b; //if you redeclare a JS variable, it will not lose its value
console.log(typeof(a)); //returns the type of variable or expression
var interpol = `Hi ${e.name}`;
//further reading: http://es6-features.org/#StringInterpolation
//https://codeburst.io/javascript-template-literals-tag-functions-for-beginners-758a041160e1
//https://ponyfoo.com/articles/es6-template-strings-in-depth
//https://ponyfoo.com/articles/template-literals-strictly-better-strings

//----------------------------OPERATORS--------------------------------------
//Arithmetic: + - * / %
//Bitwise & | >> >>> <<
//Comparison > < >= <= == === != !==
//Logical (includes guard and default) && || ! !!
//Further Reading: http://seanmonstar.com/post/707078771/guard-and-default-operators

/*
 * Guard Operator &&
 * - if the first operand is truthy, return the 2nd operand 
 * 		otherwise return the first operand
 * - instead of returning true or false, it returns the 
 * 		value of the appropriate operand 
 */
var isLoggedIn = true;
var username = "user";

var getUser = function(){
	return isLoggedIn && username;
}

/* Default Operator - || 
 * 	If the first operand is truthy, return the first operand
 *  otherwise, return the second operand
 */

var getsCommission = 500;
var getRegSalary = 50;
var getsPaid = function(){
	return getsCommission || getsRegSalary;
}

//-------------------------TRUTHY & FALSY--------------------------------------
/*
 * Truthy and Falsy
 * Falsy - null, 0, undefined, NaN, "", false
 * Truthy - anything else 
 * 
 * loose typing, type coersion, 
 * 
 * 
 * FurtherReading: http://www.nfriedly.com/techblog/2009/07/advanced-javascript-operators-and-truthy-falsy/
 */

if(0) console.log("falsy");
if("0") console.log("truthy");
if(undefined) console.log("falsy");



//-----------------------------STRINGS---------------------------------------
/*
 *      - 0 or more, 16-bit characters
        - 'hello' == "hello"
        - Immutable
        - == Similar strings are equal
        - UCS-2
        - String.length
        - String methods
 * charAt
 * concat
 * indexOf
 * lastIndexOf
 * replace
 * Search
                - Use regular expressions.
 * slice
 * split
 * substring
 * toUpperCase
 * toLowerCase
 */

//-----------------------------OBJECTS--------------------------------------
/* 	-can contain data and functions 
 *  -can inherit from other objects 
 *  -object literal {}
 *  -objects can contain an unordered collection of name/value pairs
 */

//------------------------------ARRAYS----------------------------------------	
/*  -inherit from object
 *  -array indexes are converted into strings & used as names 
 *  	to retrieve values
 *  -array literal []
 *  -do not specify length/type
 *  -length number - not the actual # of elements stored in the array 
 *  	but 1 larger than the last index
 * 	-very efficient for sparse arrays
 *	-not very efficient in most other cases
 * 	-one advantage: no need to provide a length or type when creating an array
 *  --> should I use objects or arrays?
 * 		use objects when names are arbitrary strings
 * 		use arrays when names are sequential integers
 */

var arr = [];
arr[100] = 10;
arr.length; // 101

var arr2 =  [1, 5, 7, 8];
var one = arr2.shift();
arr2.unshift(5); 
var eight = arr2.pop();
arr.push(0);


//-----------------------------FUNCTIONS------------------------------------------
/* Functions are objects in javascript. They can be stored in variables, passed as 
 * arguments to other functions, created within functions, and returned from functions
 * 

 * 
 */
function add(a, b){
	return a + b;
}
/*
 * Arrow notation
 * - Arrow functions make JS code more concise, and simplify function scoping and the this keyword
 */
//ES5:
var multiply = function(x, y){ return x * y;};
//ES6:
var multiply = (x,y)=>{return x*y} ;

/*
 * the this keyword
 * Functions have properties, like objects have properties. When a
 * function executes, it gets the this property - a variable with the
 * value of the object that invokes the function where this is used
 * 
 * this is not assigned a value until an object invokes the function 
 * where this is defined. 
 * Further Reading: http://javascriptissexy.com/understand-javascripts-this-with-clarity-and-master-it/
 */

var person = {
		firstname: "Genesis",
		lastname: "Bonds",
		getName: function(){
			return this.firstname + " " + this.lastname;
		}
}

/* A callback function, also known as a higher-order function, is a function passed to
 * another function as a parameter. The callback function is called/executed inside the 
 * other function. A callback function is essentially a design pattern
 */
var friends = ["me", "myself", "i"];
friends.forEach( function(eachName, index){
	console.log(`${index + 1}: ${eachName}`);
});
// here, we pass an anonymous function(a function without a name) to the forEach method as a param
// callback functions are closures

/*
 * Closures allow JS programmers to write better code. A closure is an inner function that has
 * access to the outer  (enclosing) function's variables. The inner function has access to not
 * only the outer function's variables, but also to the outer function's parameters.
 * Further Reading: http://javascriptissexy.com/understand-javascript-closures-with-ease/
 * Basic example: 
 */
function showName(fn, ln){
	var welcome = "Hey ";
	function fullName(){
		return welcome + fn + " " + ln;
	}
	return fullName();
}
showName('Genesis', 'Bonds');


//---------------------HOISTING & VARIBALE SCOPES------------------------------------------
/*  Variable declarations using var are treated as
 *  if they are at the top of the function (or 
 *  global scope, if declared outside of a function)
 *  regardless of where the actual declaration occurs;
 *  this is called hoisting. 
 *  Further Reading: http://javascriptissexy.com/javascript-variable-scope-and-hoisting-explained/
 */

function getValue(condition){
	if(condition){
		var value ="blue";
		return value;
	} else{
		// value exists here with a value of undefined
		return null;
	}
	//value exists with a value of undefined 
}
/* Looking at the above code, you might expect value to
 * only be created if condition evaluates to true. In fact, 
 * value is created regardless. Behind the scene, the JS
 * engine changes the getValue function to look like: */

function getValue(condition){
	var value;
	if(condition){
		value="blue";
		return value;
	}else{
		return null;
	}
}
/*
 * The declaration of value is hoisted to the top 
 * while the initialization remains in the same spot. That
 * means that the variable value is still accessible elsewhere
 * in the function; it just has a value of undefined.
 */

//Understanding the LET keyword
/* limits the variable to block scope
 */
function getValue(condition){
	if(condition){
		let value="blue";
		return value;
	} else{
		//value doesnt exist here
		return null;
	}
	//value doesnt exist here
}
//---------------------------OOP IN JS------------------------------------
/* Inheritance and classes
 * Prior to ES6, JS did not support OO design. Inheritance was
 * prototypal, but now classes and constructors exist 
 * Prototypal inheritance meant that objects inherit directly from
 * 		 other objects. The parent object is called the "prototype"
 * Every object has a property called "__proto__" that points to
 *  	 its prototype
 */

var str = "dog";
console.log(str.__proto__);

//First, what this looked like in ES6:
function vehicle(name, type){
	this.name = name;
	this.type = type;
}
vehicle.prototype.getName = function getName(){
	return this.name;
}
vehicle.prototype.getType = function getType(){
	return this.type;
}
var car = new vehicle('Tesla', 'car');
console.log(car.getName()); // prints Tesla
console.log(car.getType()); // prints car

//Now, in ES6:
class Vehicle{
	constructor(name, type){
		this.name = name;
		this.type = type;
	}
	getName(){return this.name;}
	getType(){return this.type;}
}

let car = new Vehicle('BMW', 'car');
console.log()