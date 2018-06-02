// Javascript Homework
// Due Friday Morning
// Put all homework in:
// -----------------------------------------------------------------------------------
// PART I
// Create a single Javascript file called homework.js to answer these questions.
// Please put the question itself as a comment above each answer.
// -----------------------------------------------------------------------------------

// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n) {
    if (n == 1 || n == 2) {
        return 1;
    } else {
        return (n + (n - 1));
    }
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    for (let i = 0; i < numArray.length; i++) {
        for (let j = 0; j < numArray.length; j++) {
            if (numArray[j] > numArray[j - 1]) {
                var temp = numArray[j];
                numArray[j] = numArray[j - 1];
                numArray[j - 1] = temp;
            }
        }
    }
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
    return str.split("").reverse().join("");
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum < 0) {
        return -1;
    } else if (someNum == 0) {
        return 1;
    } else {
        return someNum * factorial(someNum - 1);
    }
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
    var newStr = someStr;
    if (typeof someStr === 'number') {
        alert("This is a number.")
    }

    if (typeof someStr !== 'string') {
        alert("This is not a string");
    }

    var newStr = someStr.subString(offset, length);
    return newStr;
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
    if (someNum & 1) {
        return false;
    } else {
        return true;
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrom(someStr) {
    var re = /[^A-Za-z0-9]/g;
    someStr = someStr.toLowerCase().replace(re, '');
    var len = someStr.length;
    for (var i = 0; i < len / 2; i++) {
        if (someStr[i] !== someStr[len - 1 - i]) {
            return false;
        }
    }
    return true;
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
    if(shape === 'Square'){
        for(let i = 0; i<height ; i++){
            var printable = "";
            for(let j = 0 ; j < height ; j++){
                printable = printable + character;
            }
            console.log(printable);
        }
    }

    if(shape === 'Triangle'){
        let width = 1;
        for(let i = 0; i < height; i++){
            var printable = "";
            for(let j = 0; j<width; j++){
                printable = printable + character;
            
            }
            console.log(printable);
            width++;
        }
    }

    if(shape === 'Diamond'){
        let width = 1;
        let narrowing = (height+1)/2;

        // print widening part of diamond
        for(let i = 0; i < narrowing ; i++){
            let printable = "";
            for(let j = 0; j < width; j++){
                printable = printable + character;
            }
            console.log(printable)
            width++;
        }
        
        //narrow the width again
        width--;

        // print narrowing part of diamond
        for(let i = narrowing; i > 0; i--){
            var printable = "";
            for(let j = 0; j < width; j++){
                printable = printable + character;
            }
            console.log(printable);
            width--;
        } 
    }

}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
    var property = Obect.entries(someObj);
    for(let o = 0; i < property.length; i++){
        console.log(property[i][0] + " = " + property[i][1]);
    }
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
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
function spliceElement(someArr) {
        console.log("Previous length: " + someArr.length);
        someArr.splce(2,1);
        console.log("New Length: "+ someArr.length);

}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
//     var john = new Person("John", 30);
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
//     var john = getPerson("John", 30);
function getPerson(name, age) {
    var person = {
        "name" : name,
        "age" : age
    };
    return person;
}