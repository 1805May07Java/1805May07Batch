
/*
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fib(n){
    var a = 0, b = 1, t;
    while (n-- > 0) {
    t = a;
    a = b;
    b += t;
    }
    return a;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubblesort(arr){
    var done = false;
    while(!done){
        done = true;
        for(var i = 1; i < arr.length; i++){
            if(arr[i -1] > arr[i]){
                done = false;
                var temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
    return arr;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(str) {
    var i = str.length;
    var rev = '';
    while (i--){
        rev += str[i];
    }
    return rev;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(someNum){
    var total = 1;
    var count = 1;
    while(count <= someNum){
        total *= count;
        count++;
    }
    return total;
}

/* 
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(str, length, offset){
    if(str.length < offset + length){
        alert("That is beyond the end of the string.")
        return str;
    }
    return str.substring(offset, offset + length);
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(num){ //0 is categorized as even by this function
    while(num >= 0){
        num -= 2;
    }
    if(num == -1){
        return false;
    } else if(num == -2){
        return true;
    }
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(str){
    return str === str.split("").reverse().join("");
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

function printShape(shape, height, character){
    var i, i2;
    switch(shape){
        case "Square":
                console.log("right after case square");////
                for(i = 0; i < height; i++){
                    for(i2 = 0; i2 < height; i2++){
                        console.log(character);
                    }
                    console.log("");
                }
                break;
        case "Triangle":
                console.log("Right after case triangle");////
                for(i = 0; i < height; i++){
                    for(i2 = 0; i2 < height; i2++){
                        console.log(character);
                    }
                    console.log("");
                }
                break;
        case "Diamond":
                console.log("Right after diamond");
                for(i = 0; i < height; i++){
                    for(i2 = 0; i2 < height; i2++){
                        console.log(character);
                    }
                    console.log("");
                }
                break;
        default:
                console.log("Problem");
    }
    return null;
}
