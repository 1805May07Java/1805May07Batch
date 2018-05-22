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
 *  Functions are special -> lambda closures, IIFE, callback functions
 */

 // this is a single line comment

 var a = 6;
 var a;
 console.log(a); // if we redeclare a variable, it will not lose its value

 var interpol = `our variable a still keeps its value of ${a}`; 



 // OPERATORS
//Arithmetic: + - * / %
//Bitwise & | >> >>> <<
//Comparison > < >= <= == === != !==
//Logical (includes guard and default) && || ! !!

//TRUTHY AND FALSY
//FALSY - 0, null, undefined, NaN, ""(empty string), false
//TRUTHY - anything else

/*
 * Guard Operator &&
 * - if the first operand is truthy, return the 2nd operand 
 * 		otherwise return the first operand
 * - instead of returning true or false, it returns the 
 * 		value of the appropriate operand 
 */


 
/* Default Operator - || 
 * 	If the first operand is truthy, return the first operand
 *  otherwise, return the second operand
 */


function getValue(condition){
    // var value;
	if(condition){
		value ="blue";
		return value;
	} else{
		let value = "red";
		// value exists here with a value of undefined
		return null;
	}
	//value exists with a value of undefined 
}


function getValue(cond){
    // var value;
    console.log(test);
    console.log(value);
    if(cond){
        value = "blue";
        return value;
    }
    else{
        var test = 5;
        return null;
    }
    console.log(test);
}