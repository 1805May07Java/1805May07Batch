/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.*/
function fib(n){
    if(n==0) return 0;
    if(n==1) return 1;
    return fib(n-1)+fib(n-2);
}
/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.*/
function bubbleSort(array){
    for (a = 0; a < array.length; a++){
        for (b = 1; b < (array.length - a); b++) {
            //if element at index b-1 is greater than element at index b, swap
            if (array[b-1] > array[b]) {
                temp = array[b-1];
                array[b-1] = array[b];
                array[b] = temp;
            }
        }
    }
    console.log(array);
}

/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.*/
function reverseString(somestring){
    reversed = "";
    for(index = (somestring.length)-1; index >= 0; index--)
            reversed = reversed + somestring.charAt(index); //
        return reversed;
}
/*4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.*/
function factorial(input){
    factorial=1; //factorial always starts at 1
        
        //counter
        for(count=1; count<=input; count++){
            //4! = 1*2*3*4
            factorial*=count;
        }
        return factorial;
}
/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.*/
function substring(someStr, length, offset){
    if(offset > length && offset === Number){
        someStr.substring(offset, length);
    }
    else{
        alert('Incorrect input.');
    }
}
/*6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/
function isEven(someNum){
    quotient=somenum/2;
    if(quotient*2==someNum){
        return true;
    }
    else{
        return false;
    }    
}

/*7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false*/
function isPalindrome(somestring){
    reversed = "";
    for(index = (somestring.length)-1; index >= 0; index--)
            reversed = reversed + somestring.charAt(index); //
    if(somestring==reversed){
        return true;
    }
    else{
        return false;
    }
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
  *    */
 function printShape(shape, height, character){
    if(shape==='Square'){
        for(i = 1; i <= height; i++){
            for(j=1;j<=height;j++){
                console.log(`${character}`);
            }
            console.log('\n');
        }
    }
    else if(shape==='Triangle'){
        for(i = 1; i <= height; i++){
            for(j = 1; j <= i; j+2){
                console.log(`${character}`);
            }
            console.log('\n');
        }
    }
    else if(shape==='Diamond'){
        for(i = 1; i<=height; i++){
            for(j=1;j<=i;j++){
                console.log(`${character}`);
            }
        }
        console.log('\n');
    }
 }

/*9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.*/
function traverseObject(someObj){
    for(var prop in someObj){
        propVal = someObj[prop];
        console.log(prop, propVal);
    }
}
/*10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.*/
function deleteElement(someArr){
    console.log(someArr.length);
    someArr.deleteElement(2);
    console.log(someArr.length);
    
}
/*11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length. */
function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(2,1,null);
    console.log(someArr.length);
}
/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
var john = new Person("John", 30);*/

function Person(name, age){
    this.name = name;
    this.age = age;
}

/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
var john = getPerson("John", 30);*/
var person = {
    name: 'John',
    age: 30
};
function getPerson(name, age){
    if(person.name == name && person.age == age){
        return person;
    }
}