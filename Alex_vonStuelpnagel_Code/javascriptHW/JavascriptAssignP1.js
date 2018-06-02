// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

var fib = function(n) {
   if (n <= 1){
      return n;
   }
   return fib(n-1) + fib(n-2);
}

console.log(fib(7));

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

var bubbleSort = function( A ){
    A : [];
    n = A.length;
    do {
        swapped = false;
        for (i = 0 ; i != n-1; i++){
            if (A[i-1] > A[i]) {
                temp = A[i];
                A[i] = A[i-1];
                A[i-1] = temp;
                swapped = true;
            }
        }
    } while (swapped == true);
    return A;
}

console.log(bubbleSort([1,3,4,5,6,2,7,9]));

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.

var reverseStr = function(str){
    if ((str == null) || (str.length < 1)){
        return str;
    } else {
    n = str.length;
    rvrs = rvrs.concat(str.charAt(n-1));
    str = reverseStr(str.substring(0,n-1));
    }
    return rvrs;
}

console.log(reverseStr("hippopotamus"));

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

var fact = function(someNum){
    if(someNum==1){ return 1;}
    result = fact(someNum-1) * someNum;
    return result;
}

console.log(fact(12));

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

var substring = function(someStr, length, offset){
    substring = "";
    for (i=offset;i<length;i++){
        temp = someStr.charAt(i);
        substring = substring.concat(temp);
    }
    return substring;
}

console.log(substring("Bobcat", 3, 0));

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

var isEven = function(n){
    quo = n/2;
    if(Math.round(quo)*2 == n){
        return true;
    }
    return false;
}

console.log(isEven(2));
console.log(isEven(11));

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false


var reverseStr = function(str){
    if ((str == null) || (str.length < 1)){
        return str;
    } else {
    n = str.length;
    rvrs = rvrs.concat(str.charAt(n-1));
    str = reverseStr(str.substring(0,n-1));
    }
    return rvrs;
}

var isPalindrome = function(someStr){
    if (reverseStr(someStr) == someStr){
        
        return true;
    }
    return false;
}

rvrs = "";
console.log(isPalindrome("Hippopotamus"));
rvrs = "";
console.log(isPalindrome("tattarrattat"));

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

var printShape = function(shape, height, character){
    rowText = "";
    switch(shape) {
        case "Square":
        var row;
            for (row=0;row< height; row++){
                var col;
                for (col=0;col< height; col++){
                    rowText = rowText.concat(character);
                }
                console.log(rowText);
                rowText = "";
            }
            break;
        case "Triangle":
            edge = 1;
            var row;
            for (row=0;row< height; row++){
                var col;
                for (col=0;col< height; col++){
                    if (col < edge){
                    rowText = rowText.concat(character);
                    }
                }
                edge++;
                console.log(rowText);
                rowText = "";
            }
            break;
        case "Diamond":
            if (height%2 != 0){
                side = Math.round(height/2) - 1;
            } else {
                side = (height/2) - 1;
            }
            middle = side+1;
            var row;
            for (row=0;row< height; row++){
                var col;
                for (col=0;col< height; col++){
                    if (col+1 > side && col+1 <= height-side){
                        rowText = rowText.concat(character);
                    } else {
                        rowText = rowText.concat(" ");
                    }
                }
                if (row+1 < middle) {
                    side--;
                } else {
                    side++;
                }
                
                console.log(rowText);
                rowText = "";
            }
            break;
        default:
            console.log("invalid shape");
    }
}

printShape("Square", 5, "?");
printShape("Triangle", 5, "@");
printShape("Diamond", 5, "#");

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

var traverseObject = function (someObj){
    console.log(someObj);
}

var car = {type:"Fiat", model:"500", color:"white"};
traverseObject(car);

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

var deleteElement = function(someArr){
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

console.log(deleteElement([1,3,4,5,6,2,7,9]));

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

var spliceElement = function(someArr){
    console.log(someArr.length);
    someArr.splice(2,1);
    console.log(someArr.length);
}

console.log(spliceElement([1,3,4,5,6,2,7,9]));

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

var Person = function(name, age){
    person = {fname: name, age: age};
    return person;
}

var John = new Person("John",30);
console.log(John);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);

var getPerson = function(name, age){
    person = {fname: name, age: age};
    return person;
}

var John = getPerson("John",30);
console.log(John);
