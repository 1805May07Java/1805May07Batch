/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fib(n) {
    if (n <= 1) return 1;
    return fib(n - 1) + fib(n - 2);
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
function bubbleSort(numArray) {
    var tmp;
    do {
        tmp = false;
        for (var i = 0; i < numArray.length - 1; i++) {
            if (numArray[i] > numArray[i + 1]) {
                var temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
                swapped = true;
            }
        }
    } while (tmp);
}

/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.*/
function reverseStr(someStr) {
    var tmp = '';
    for (var i = someStr.length - 1; i >= 0; i--)
        tmp += someStr[i];
    return tmp;
}

/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(someNum) {
    if (someNum === 0) {
        return 1;
    }

    // This is it! Recursion!!
    return someNum * factorial(someNum - 1);
}


/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/
function substring(someStr, length, offset) {
    var off = someStr;
    if ((typeof someStr) !== 'string') {
        alert("not a string");
        return null;
    }
    if ((typeof length) !== 'number') {
        alert("not a number");
        return null;
    }
    if ((typeof offset) !== 'number') {
        alert("not a number");
        return null;
    }
    off = someStr.substring(offset, length);
    return off;
}


/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
function isEven(someNum) {

    if (someNum & 1) {
        var a = false
    }
    else {
        var a = true
    }
    return a
}

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(someStr) {
    var a = /[^A-Za-z0-9]/g;
    someStr = someStr.toLowerCase().replace(a, '');
    var len = someStr.length;
    for (var i = 0; i < len / 2; i++) {
        if (someStr[i] !== someStr[len - 1 - i]) {
            return false;
        }
    }
    return true;
}

/*8. Shapes
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
  * */
function printShape(shape, height, character) {
    switch (shape.toLowerCase()) {
        case 'square':
            let str = '';
            for (let i = 1; i <= height; i++) {
                for (let k = 1; k <= height; k++) {
                    str += character;
                }
                console.log(str);
                str = "";
            }
            break;

        case 'triangle':
            let str = '';
            for (let i = 1; i <= height; i++) {
                for (let k = 1; k <= height - i; k++) {
                    str += "\t";
                }
                for (var j = 1; j <= i; j++) {
                    str += character + "\t\t";
                }
                console.log(str);
                str = "";
            }
            break;
        case 'diamond':
            let w, str = '';

            for (let y = 0; y < height * 2 - 1; y++) {
                w = y < height ? y : height * 2 - y - 2;
                str += Array(height - w).join(' ') + Array(w + 1).join(character + ' ') + character + '\n';
            } 
            console.log(str);
    }
}

/*  9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObject(someObj) {

    var p = Object.entries(someObj);
    for (let i = 0; i < p.length; i++) {
        console.log(p[i][0] + " - " + p[i][1]);
    }
}

/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.*/
function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(2, 1);
    console.log(someArr.length);
}

/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);*/
    function Person(name, age) {
        this.name = name;
        this.age = age;
    }


/*    13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);*/
    function getPerson(name, age) {
        var person = {
            "name" : name,
            "age" : age
        };
        return person;
    }