/*
*JS scripting language for 
*c like syntax
*
fixed values literals
variabble values- declared variables
objects are generalized containers
funstions exist and arre special 
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/


var a = 6;
var a;
console.log(a); // if you redeclare a variable it will not lose value 

var interpol = `our variable a still keeps its value of ${a}`;


//OPERATORS
// arithmetic + - * /
// bitwise & | >> >>> << 
//comparison > < >= <= == === != !==
//logical include guard and default && || ! !!


/*Truthy and Falsy 
// Falsy - 0, null, undefined, NaN, ""(empty String), false
// Truthy - everything else 
// every thing has an inherent true/ false comparitor even thigs that don't really make sense.
JS involves type coercion where it forces a type coversion when you use ==,
=== for a traditional direct comparison.  

Guard Operator &&
if the first operand is truthy then get the second operand
otherwise give the first operand

default operator - || 
the opposite of guard 

Functions 
Anonymous - set a function equal to a variable

var testing = function(){
	var x = 5;
	return x*2;
};

function add(x,y)
{
	return x + y;
};


--functions inside objects


var person = {fn: 'Me', ln: 'Here', getFullName(){return `${this.fn} ${this.ln}`;}};
person.getFullName();

callback functions functions passed to other functions
var friends = ['me','myself, 'I'];

friends.forEach( function(eachName, index){console.log(`${index + 1}: ${eachName}`);})

nested functions called closeures, used to create make shift block scope
with var you only have global and function scope, let allows for block scoped variables 

if you don't tyoe a variable with var, let or const it automatically is hoisted to being a global variable
regardless of where it is initialized from.  

functon getValue(condition)
{
	console.log(value);
	if(condition)
	{
		 let value = "blue";
		return value;
	}
	else
	{
		let value = "red";
		return null;
	}
}	

*/


