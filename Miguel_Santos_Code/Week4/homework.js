// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function fib(n){
	if (n == 0) return 0;
	if (n == 1) return 1;
	return fib(n-1) + fib(n-2);
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(arr){
	var temp;
	var i, j;
	for(i=0; i<arr.length; ++i){
		for(j=0; j<arr.length-i; ++j){
			if(arr[j] > arr[j+1]){
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
			}
		}
	}
	return arr;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

function reverseStr(str){
	var temp = [];
	var i;
	for(i=0; i<str.length; i++){
		temp += str[str.length - (i+1)];
	}
	return temp;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function factorial(someNum){
    if(someNum == 1){
        return 1;
    }
    else{
        return someNum*factorial(someNum-1);
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(someStr, length, offset){
    if(offset < 0 || offset >= someStr.length){
        alert("Offset parameter must be within 0 and " + (someStr.length - 1));
    }
    else if(length < 0 || (offset+length) > someStr.length){
        alert("Length parameter is out of bounds");
    }
    else{
        var str = new String();
        for (let i = offset; i < (offset+length); i++){
            str += someStr[i];
        }
        return str;
    }
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum){
    if(someNum & 1 == 1){
        return false;
    }
    else{
        return true;
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(someStr){
    if (someStr.split("").reverse().join("") == someStr){
        return true;
    }
    else{
        return false;
    }
}

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
    var out = "";
    switch (shape) {
        case "square":
            for (let i = 0; i < height; i++) {
                for (let j = 0; j < height; j++) {
                    out += character;
                }
                if (i == height - 1) {
                    break;
                }
                else {
                    out += '\n';
                }
            }
            console.log(out);
            break;
        case "triangle":
            for (let i = 0; i < height; i++) {
                for (let j = 0; j < (i + 1); j++) {
                    out += character;
                }
                if (i == height - 1) {
                    break;
                }
                else {
                    out += '\n';
                }
            }
            console.log(out);
            break;
        case "diamond":
            for (let i = 0; i < height; i++) {
                var arr = [];
                for (let k = 0; k < height; k++) {
                    arr[k] = " ";
                }
                if (i <= Math.floor(height / 2)) {
                    out += doThis(i, height, arr, character);
                }
                else {
                    out += doThis(Math.abs(i + 1 - height), height, arr, character);
                }
                if (i == height - 1) {
                    break;
                }
                else {
                    out += '\n';
                }
            }
            console.log(out);

    }
}
function doThis(pos, length, arr, char){
    if(pos < 0){
        return;
    }
    else{
        arr[Math.floor(length/2)+pos] = char;
        arr[Math.floor(length/2)-pos] = char;
        doThis(pos-1, length, arr, char);
    }
    return arr.join("");
}


// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj){
    for(let props in someObj){
        console.log(props + ": " + someObj[props]);
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(2,1);
    console.log(someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// var john = new Person("John", 30);

function Person(name, age){
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
 
 function getPerson(name, age){

 }
 
 