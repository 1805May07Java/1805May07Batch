// Javascript Homework
// Due Friday Morning

// -----------------------------------------------------------------------------------
// PART I

// Create a single Javascript file called homework.js to answer these questions.
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
	if(n <= 0) return; // assume the sequence starts at 1, so any n <= 0 is an invalid number input
	if(n <= 2) return 1; // assume the sequence starts at 1

	var f2 = 1, f1 = 1;

	for(let i=2; i<n; i++) {
		let temp = f2 + f1;
		f1 = f2;
		f2 = temp;
	}
	return f2;
}
console.log(fib(5));

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    for(let i=0; i<numArray.length-1; i++) {
    	for(let j=0; j<numArray.length-i-1; j++) {
    		if(numArray[j] > numArray[j+1]) {
    			let temp = numArray[j];
    			numArray[j] = numArray[j+1];
    			numArray[j+1] = temp;
    		}
    	}
    }
    return numArray;
}
console.log(bubbleSort([7,6,3,2,4,1,8,0,9,5]));

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
	someStr = someStr.split('');
	for(let i=0; i<someStr.length/2 | 0; i++) {
		let temp = someStr[i];
		someStr[i] = someStr[someStr.length-1-i];
		someStr[someStr.length-1-i] = temp;
	}
	return someStr.join('');
}
console.log(reverseStr("Hello World!"));

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
	if(someNum <= 1) return 1;
	return someNum * factorial(someNum-1);
}
console.log(factorial(6))

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
	if(!someStr || typeof someStr !== typeof "") {
		return alert("Not valid string");
	}
	if(offset < 0 || length+offset >= someStr.length || length+offset < 0) {
		return alert("invalid length or offset");
	}
	return someStr.substring(offset, length+offset+1);
}
// console.log(substring("Hello World!", 3, 40));
// console.log(substring("Hello World!", 12, 0));

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
	return someNum/2 === (someNum/2 | 0);
}
console.log(isEven(11));
console.log(isEven(4));

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
	for(let i=0; i<someStr.length/2 | 0; i++) {
		if(someStr.charAt(i) !== someStr.charAt(someStr.length-1-i)) {
			return false;
		}
	}
	return true;
}
console.log(isPalindrome("racecar"));
console.log(isPalindrome("Not a palindrome for sure"));

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *
function printShape(shape, height, character) {
	if(shape === "Square") return drawSquare(height, character);
	if(shape === "Triangle") return drawTriangle(height, character);
	if(shape === "Diamond") return drawDiamond(height, character);
}
console.log(printShape("Square", 5, "%"));
console.log(printShape("Triangle", 8, "$"));
console.log(printShape("Diamond", 9, "*"));

function drawSquare(height, character) {
	if(height <= 0) return;

	var line = "";
	for(let i=0; i<height; i++) {
		line += character;
	}
	var str = line;
	for(let i=0; i<height; i++) {
		str += '\n' + line;
	}
	return str;
}

function drawTriangle(height, character) {
	if(height <= 0) return;

	var line = character;
	var str = "";
	for(let i=0; i<height; i++) {
		str += line + '\n';
		line += character;
	}
	return str;
}

function drawDiamond(height, character) {
	if(height <= 0) return;
	var line = "";
	var str;
	for(let i=0; i<height; i++) {
		line += character;
	}
	str = line;
	for(let i=0; i<(height/2|0); i++) {
		let cut = "";
		for(let j=0; j<=i; j++) {
			cut += ' ';
		}
		cut += line.substring(i+1, line.length-1-i);
		str = cut + '\n' + str + '\n' + cut;
	}
	return str;
}
// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
	for(var key in someObj) {
		if(!someObj.hasOwnProperty(key)) continue;
		console.log(key + ":" + someObj[key]);
	}
}

var obj = {
	name: "Alex",
	cool: "Not cool",
	nice: () => {return "nice"}
}
traverseObject(obj);

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
	if(someArr.length <= 2) return someArr.length;
	someArr[2] = undefined;
	return someArr.length;
}
console.log(deleteElement([1,2]));
console.log(deleteElement([1,2,3,4,5,6]));

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
	if(someArr.length <= 2) return someArr.length;
	var answer = [].concat(someArr.slice(0, 2), someArr.slice(3));
	console.log(answer);
	return answer.length;
}
console.log(spliceElement([1,2,3,4,5,6,7]))

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age) {
	this.name = name;
	this.age = age;
}
var john = new Person("John", 30);
console.log(john)

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age) {
	return {name: name, age: age};
}
john = getPerson("John", 30);
console.log(john);
 
 
 
 
// -----------------------------------------------------------------------------------
// PART II

// Part II will focus on Javascript's ability to manipulate the DOM.
// Use the provided index.html
// Put your Javascript in the provided <script> element at the bottom of the page.
// Please put the question itself as a comment above each answer.

// NOTE: Part II will be done twice: once with Javascript and once with jQuery.
// 	  They should be done separately.
// 	  Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
// -----------------------------------------------------------------------------------

// 1. USA
// Define function getUSA()
// Find the html element that contains "USA".
// Print that element's contents.
function getUSA() {
	console.log(document.querySelector("h1 span:nth-child(2)").innerHTML);
	console.log($("h1 span:nth-child(2)").html());
}
getUSA();

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales() {
	var arr = [];
	var ppl = document.getElementsByClassName("empName");
	var dep = document.querySelectorAll(".empName + td");
	for(let i=0; i<ppl.length; i++) {
		if(dep[i].innerHTML === "Sales") {
			arr.push(ppl[i].innerHTML);
		}
	}
	console.log(arr.join(", "));

	var arr2 = [];
	$('.empName').each((index, item) => {
		if($(item).next().html() === "Sales") {
			arr2.push($(item).html());
		}
	});
	console.log(arr2.join(", "));
}
getPeopleInSales();

// 3. Click Here
// Define function getAnchorChildren()
// Find all anchor elements with a <span> child.
// Print the contents of <span>
function getAnchorChildren() {
	var nice = document.querySelectorAll("a span");
	nice.forEach((val) => {
		console.log(val.innerHTML);
	});

	$('a span').each((index, item) => {
		console.log(item.innerHTML);
	});
}
// console.log9
getAnchorChildren();

// 4. Hobbies
// Define function getHobbies()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.
function getHobbies() {
	var sel = document.getElementsByName("skills")[0];
	sel = sel.options[sel.selectedIndex];
	console.log(sel.value + ", " + sel.text);

	console.log($('select[name="skills"] option:selected').val() + ", " + $('select[name="skills"] option:selected').text() );
}
getHobbies();
  
// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.


// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// 	<input id="num1" class="nums" type="text"/>
// 	<input id="num2" class="nums" type="text"/>
// 	<h3>Sum: <span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:
// 	"Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// 	"So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:
// 	Hide the name if shown.
// 	Show the name if hidden.

// 10. Current Time
// Regarding this element:
// 	<h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

// 11. Delay
// Regarding this element:
// 	<p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.
document.getElementById("helloWorld").addEventListener('click', changeColor);
$('#helloWorld').on('click', changeColor);

function changeColor() {
	setTimeout(() => {
		var r = (Math.random()*255+1) | 0;
		var g = (Math.random()*255+1) | 0;
		var b = (Math.random()*255+1) | 0;
		document.getElementById("helloWorld").style.color = `rgb(${r},${g},${b})`;
	}, 3000);
}


// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. Use recursion.
// On each node, call func(node).
function walkTheDom(node, func) {
	func(node);
}


function func(node) {
	if(!node) return;

	for(let i=0; i<node.children.length; i++) {
		console.log(node.children[i]);
		func(node.children[i]);
	}

	$(node).children().each((index, item) => {
		console.log($(item)[0]);
		func(item);
	})

}
// walkTheDom(document, func);