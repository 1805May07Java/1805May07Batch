/* 
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fib(n) {
	if (n == 1 || n == 0) {
		return 1;
	}
	return fib(n - 1) + fib(n - 2);
}

/* 
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray) {
	let swap = false;
	for (let i = 0; i < numArray.length - 1; i++) {
		for (let j = 0; j < numArray.length - 1; j++) {
			if (numArray[j] > numArray[j + 1]) {
				let temp = numArray[j];   //swap
				numArray[j] = numArray[j + 1];
				numArray[j + 1] = temp;
				swap = true;
			}
		}
		if (!swap) {
			break;
		}
	}
	return numArray;
}

/* 
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr) {
	let reversed = "";

	for (let i = 0; i < someStr.length; i++) {
		reversed = reversed + someStr[someStr.length - i - 1];
	}
	return reversed;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
	if (someNum == 1) {
		return 1;
	}
	return someNum * factorial(someNum - 1);
}

/* 
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset) {
	let valid = true;
	let lengthOfSomeStr = someStr.length;
	if (length < 0 || offset < 0) {
		alert('Negative values not allowed!');
		valid = false;
	}
	if (offset + length > lengthOfSomeStr) {
		alert('offset + length is greater than the length of someStr!');
		valid = false;
	}
	if (typeof someStr != 'string') {
		alert('First argument must be of type string!');
		valid = false;
	}
	if (typeof length != 'number' || typeof offset != 'number') {
		alert('Second and third arguments must be of type number!');
		valid = false;
	}
	if (valid) return someStr.substring(offset, offset + length);
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum) {
	let someNumString = someNum.toString();
	let lastDigit = someNumString[someNumString.length - 1];
	switch (lastDigit) {
		case '0':
		case '2':
		case '4':
		case '6':
		case '8': return true;
		default: return false;
	}
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr) {
	let length = someStr.length;
	for (let i = 0; i < length / 2; i++) {
		if (someStr[i] != someStr[length - i - 1]) {
			return false;
		}
	}
	return true;
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/
function printShape(shape, height, character) {
	let buffer = '';
	switch (shape) {
		case 'Square':
			for (let i = 0; i < height; i++) {
				for (let j = 0; j < height; j++) {
					buffer += character;
				}
				buffer += '\n';
			}
			console.log(buffer);
			break;
		case 'Triangle':
			for (let i = 0; i < height; i++) {
				let k = 0;
				while (k < i + 1) {
					buffer += character;
					k++;
				}
				buffer += '\n';
			}
			console.log(buffer);
			break;
		case 'Diamond':
			let halfHeight = Math.floor(height / 2);
			for (let i = 0; i < height; i++) {  //rows
				for (let j = 0; j < height; j++) {  //columns
					if (i < height / 2) { //top half of diamond
						let lowerBound = halfHeight - i;
						let upperBound = halfHeight + i;
						if (j <= upperBound && j >= lowerBound) { //print character
							buffer += character;
						} else { //otherwise, print empty space
							buffer += ' ';
						}
					} else { //bottom half of diamond
						let delta = i - halfHeight;
						let lowerBound = delta;
						let upperBound = height - delta;
						if (j < upperBound && j >= lowerBound) { //print character
							buffer += character;
						} else { //otherwise, print empty space
							buffer += ' ';
						}
					}
				}
				buffer += '\n';
			}
			console.log(buffer);
	}
}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj) {
	for (var prop in someObj) {
		console.log(`someObj[${prop}] = ${someObj[prop]}`);
	}
}

/* 
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr) {
	console.log(`Current length is ${someArr.length}. The contents are ${someArr}`);
	someArr[2] = null;;
	console.log(`Third element deleted. Current length is ${someArr.length}. The contents are
	${someArr} `);
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr) {
	console.log(`Current length is ${someArr.length}. The contents are ${someArr}`);
	someArr.splice(2, 1);
	console.log(`Current length is ${someArr.length}. The contents are ${someArr}`);
}

/* 
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/
function Person(name, age) {
	this.name = name;
	this.age = age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/
function getPerson(name, age) {
	let o = {};
	o.name = name;
	o.age = age;
	return o;
}

/*
-----------------------------------------------------------------------------------
| PART II                                                                         |
-----------------------------------------------------------------------------------


/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/
function getUSA() {
	let elements = document.getElementsByTagName('span')
	for (let element of elements) {
		if (element.textContent == 'USA') {
			console.log(element.textContent);
		}
	}
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/
function getPeopleInSales() {
	String = "";
	var people = document.getElementsByClassName('empName');
	for (let person of people) {
		console.log(person.innerHTML);
	}
}

/*
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/
function getAnchorChildren() {
	var anchors = document.getElementsByTagName('a');
	for (anchor of anchors) {
		anchor.childNodes.forEach(
			function (node) {
				if (node.nodeName == 'SPAN') {
					console.log(node.innerText);
				}
			}
		)
	}
}

/*
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/
function getHobbies() {
	let skills = document.getElementsByName('skills')[0];
	console.log(`${skills.options[skills.selectedIndex].text} : ${skills.options[skills.selectedIndex].value}`);
}

/*
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
*/
function getCustomAttribute() {
	let customAttrList = document.querySelectorAll('[data-customAttr]');
	for (node of customAttrList) {
		console.log(`Value: ${node.getAttribute('data-customAttr')}
		Node: ${node}`);
	}
}

/*
10. Current Time
Regarding this element:
	<h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
let time = document.getElementById('currentTime');
window.onload = setInterval(function(){
	time.innerHTML = `${new Date().toLocaleTimeString()}`;
}, 1000);

/* 
11. Delay
Regarding this element:
	<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
let e = document.getElementById('helloWorld');
e.addEventListener('click',
	function () {
		setTimeout(function () {
			e.style.color = randomColor();
		}, 3000)
	})

function randomColor() {
	let color = '#';
	for (let i = 0; i < 6; i++) {
		let rgbComponent = Math.floor(Math.random() * 16);
		let hexVal = rgbComponent.toString(16);
		color += hexVal;
	}
	return color;
}