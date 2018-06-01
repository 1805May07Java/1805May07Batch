/*
 * homework.js
 * Author: Cole Vikupitz
 *
 * Solutions for section I of the JavaScript exercises in the 'Javascript_Homework.txt'
 * handout.
 *
 */


/*
 * 1. Fibonacci
 * Define function: fib(n) 
 * Return the nth number in the fibonacci sequence.
 */
function fib(n) {

    // Declare/initialize variable(s)
	var sum = 0;
    var prev = 0;
    var next = 1;
    
    // Checks: n must be > 1
    if (n <= 0)
        return prev;
    if (n == 1)
        return next;
    // Traverse from 0 to n, add the previous two terms together
    for (let i = 0; i < n; i++) {
        sum = prev + next;
        prev = next;
        next = sum;
    }

    return prev;
}


/*
 * 2. Bubble Sort
 * Define function: bubbleSort(numArray)
 * Use the bubble sort algorithm to sort the array.
 * Return the sorted array.
 */
function bubbleSort(numArray) {

    var prev;
    var next;

    // Check: length must be > 2
    if (numArray.length <= 1)
        return numArray;

    // Traverse each item in array
    for (let i = 0; i < numArray.length; i++) {
        // Inner traverse of each subsequent item
        for (let j = 0; j < numArray.length - i - 1; j++) {
            prev = numArray[j];
            next = numArray[j + 1];
            // Swap two items in place if needed
            if (next < prev) {
                var temp = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = temp;
            }
        }
    }

    return numArray;
}


/*
 * 3. Reverse String
 * Define function: reverseStr(someStr)
 * Reverse and return the String.
 */
function reverseStr(someStr) {

    reversed = [];
    // Traverse string backwards, append each char to string
    for (let i = someStr.length - 1; i >= 0; i--) {
        reversed.push(someStr[i]);
    }
    
    // Converts array to string, returns result
    return reversed.join("");
}


/*
 * 4. Factorial
 * Define function: factorial(someNum)
 * Use recursion to compute and return the factorial of someNum.
 */
function factorial(someNum) {

    // Base case: consider all N <= 1 as 1
    if (someNum <= 1)
        return 1;
    // Multiply N by N - 1 recursively
    return someNum * factorial(someNum - 1);
}


/*
 * 5. Substring
 * Define function substring(someStr, length, offset)
 * Return the substring contained between offset and (offset + length) inclusively.
 * If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */
function substring(someStr, length, offset) {
    
    var len = someStr.length;
    var subStr = [];
    
    // Check: offset must be a valid index within string
    if (offset < 0 || offset > len - 1) {
        window.alert("The offset mut be in the range [0, str_length - 1]");
        return "";
    }
    
    // Check: substring length must not extend beyond end of original string
    if ((len - offset) < length) {
        window.alert("The length must be in the range [0, str_length - offset]");
        return "";
    }
    
    // Append each character into substring char array
    for (let i = 0; i < length; i++) {
        subStr.push(someStr[offset + i]);
    }
    
    return subStr.join("");
}


/*
 * 6. Even Number
 * Define function: isEven(someNum)
 * Return true if even, false if odd.
 * Do not use % operator.
 */
function isEven(someNum) {

    // This division will truncate the decimal remainder
    var a = someNum >> 1;
    // This division will leave the decimal remainder on
    var b = someNum / 2;
    // Number is even if both results are the same
    return (a == b);
}


/*
 * 7. Palindrome
 * Define function isPalindrome(someStr)
 * Return true if someStr is a palindrome, otherwise return false
 */
function isPalindrome(someStr) {

    // Compute the midpoint of the string
    var mid = someStr.length / 2;
    // Traverse the string from both front and back
    // Check each character in respective opposite ends
    for (let i = 0, j = someStr.length - 1; i < mid; i++, j--) {
        if (someStr[i] != someStr[j]) {
            return false;
        }
    }
    
    // If we reach here, string must be a palindrome
    return true;
}


/*
 * 8. Shapes
 * Define function: printShape(shape, height, character)
 * shape is a String and is either "Square", "Triangle", "Diamond".
 * height is a Number and is the height of the shape. Assume the number is odd.
 * character is a String that represents the contents of the shape. Assume this String contains just one character.
 * Use a switch statement to determine which shape was passed in.
 * Use the console.log function to print the desired shape.
 * Example for printShape("Square", 3, "%");
 * %%%
 * %%%
 * %%%
 * Example for printShape("Triangle", 3, "$");
 * $
 * $$
 * $$$
 * Example for printShape("Diamond", 5, "*");
 *   *
 *  ***
 * *****
 *  ***
 *   *
 */
function printShape(shape, height, character) {

    // String that will hold the shape
    var res = "";
    
    // Caller specified a square
    if (shape === "Square") {
        // Does an inner loop to append character
        for (let i = 1; i <= height; i++) {
            for (let j = 1; j <= height; j++) {
                res += character;
            }
            res += "\n";
        }
    }
    // Caller specified a triangle
    else if (shape === "Triangle") {
        // Another inner loop, print an additional char for each line
        for (let i = 1; i <= height; i++) {
            for (let j = 1; j <= i; j++) {
                res += character;
            }
            res += "\n";
        }
    }
    // Caller specified a diamond
    else if (shape === "Diamond") {
        // Compute the midpoint of the diamond
        var half = Math.floor(height / 2);
        // Prints the top half of the diamond
        for (let i = 1; i <= half; i++) {
            for (let j = 0; j <= half-i; j++) { res += " "; }
            for (let k = half-i; k < half+i-1; k++) { res += character; }
            for (let l = 0; l <= half-i; l++) { res += " "; }
            // Must end rows with a newline
            res += "\n";
        }
        // Print the midle section; only if height is div. by 2
        if (height % 2 != 0) {
            for (let i = 1; i <= height; i++) { res += character; }
            // Must end rows with a newline
            res += "\n";
        }
        // Prints the bottom half of the diamond
        for (let i = half; i > 0; i--) {
            for (let j = half; j > i-1; j--) { res += " "; }
            for (let k = i*2-1; k > 0; k--) { res += character; }
            for (let l = half; l > i-1; l--) { res += " "; }
            // Must end rows with a newline
            res += "\n";
        }
    }
    
    // Prints shape out to console
    console.log(res);
}


/*
 * 9. Object literal
 * Define function traverseObject(someObj)
 * Print every property and it's value.
 */
function traverseObject(someObj) {

    // Get array of object properties and their respective values
    var props = Object.entries(someObj);
    // Traverses each entry, prints the value
    for (let i = 0; i < props.length; i++) {
        console.log(props[i][0] + " : " + props[i][1]);
    }
}


/*
 * 10. Delete Element
 * Define function deleteElement(someArr)
 * Print length
 * Delete the third element in the array.
 * Print length
 * The lengths should be the same.
 */
function deleteElement(someArr) {

    // Print length
    console.log("Before: " + someArr.length);
    // Delete the third element in the array.
    delete someArr[2];
    // Print length
    // The lengths should be the same.
    console.log("After: " + someArr.length);
}


/*
 * 11. Splice Element
 * Define function spliceElement(someArr)
 * Print length
 * Splice the third element in the array.
 * Print length
 * The lengths should be one less than the original length.
 */
function spliceElement(someArr) {

    // Print length
    console.log("Before: " + someArr.length);
    // Splice the third element in the array.
    someArr.splice(2, 1);
    // Print length
    // The lengths should be one less than the original length.
    console.log("After: " + someArr.length);
}


/*
 * 12. Defining an object using a constructor
 * Define a function Person(name, age)
 * The following line should set a Person object to the variable john:
 *      var john = new Person("John", 30);
 */
function Person(name, age) {

    // Same as a constructor
    this.name = name;
    this.age = age;
}


/*
 * 13. Defining an object using an object literal
 * Define function getPerson(name, age)
 * The following line should set a Person object to the variable john:
 *      var john = getPerson("John", 30);
 */
function getPerson(name, age) {

    // Create object literal with properties and values
    var person = {
        "name" : name,
        "age" : age
    };
    // Returns the object
    return person;
}
