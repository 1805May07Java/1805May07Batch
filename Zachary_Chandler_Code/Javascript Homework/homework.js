
/*
    1. Fibonacci
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence.
*/
fib = function(n) {
    if (n <= 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return fib(n-1) + fib(n-2);
    }
}

/*
    2. Bubble Sort
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array.
*/
bubbleSort = function(arr) {

    let lastAltered = 0;

    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length - i; j++) {
            if (arr[j+1] < arr[j]) {
                let temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                lastAltered = j;
            }
        }

        i = arr.length - lastAltered - 1;
    }

    return arr;
}

/*
    3. Reverse String
    Define function: reverseStr(someStr)
    Reverse and return the String.
*/
reverseStr = function(n) {
    let result = "";

    for (let i = 0; i < n.length; i++) {
        result = n[i] + result;
    }

    return result;
}

/*  
    4. Factorial
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum.
*/
factorial = function(n) {

    if (n <= 0) {
        return 1;
    } else {
        return  factorial(n-1) * n;
    }
}

/*
    5. Substring
    Define function substring(someStr, length, offset)
    Return the substring contained between offset and (offset + length) inclusively.
    If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
substring = function(n, i, j) {

    if (j < 0) {
        alert("cannot use negative length");
    } else if (i < 0) {
        alert("cannot use negative index");
    } else if (i > n.length) {
        alert("index cannot exceede the end of the string")
    } else if (i + j > n.length) {
        alert("length exceedes the end of string")
    }

    return n.substring(i, i+j);
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
isEven = function(n) {
    return n & 1 ? false : true;
}


// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
isPalindrome = function(n) {
    return n === reverseStr(n);
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
printShape = function(shape, w, c) {

    var h = w;

    if (shape == "Square") {
        var filter = () => true;
    } else if (shape == "Triangle") {
        var filter = (n, m) => n <= m;
    } else if (shape == "Diamond") {
        if (isEven(w)) {
            h = ++w;
        }

        let mid = Math.floor(w/2);
        var filter = (n, m) => !(             // check for a space and negate it
            n < Math.abs(mid - m) ||          // left side spaces
            n > (mid + m) ||                  // right side upper spaces
            (m > mid && n >= w - (m - mid))); // right side lower spaces
    } else {
        return;
    }

    for (let i = 0; i < h; i++) {
        let line = `${i}: `;

        for (let j = 0; j < w; j++) {
            if (filter(j, i)) {
                line += c;
            } else {
                line += ' '
            }
        }
        console.log(line);
    }
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
traverseObject = function(n) {
    for (let key in n) {
        console.log(`${key}: ${n[key]}`);
    }
}


// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
deleteElement = function(n) {
    console.log(n.length);
    delete n[3];
    console.log(n.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.1
spliceElement = function(n) {
    console.log(n.length);
    n.splice(2, 1);
    console.log(n.length);
}


// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
Person = function(name, age) {
    this.name = name;
    this.age = age;
}


// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
getPerson = function(name, age) {
    return new Person(name, age);
}

