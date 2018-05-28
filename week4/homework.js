
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
    var i, j;
    switch(shape){
        case "Square":
                console.log("right after case square");////
                for(i = 1; i <= height; i++){
                    for(j = 0; j < height; j++){
                        console.log(character);
                    }
                    console.log("");
                }
                break;
        case "Triangle":
                console.log("Right after case triangle");////
                for(i = 1; i <= height; i++){
                    for(j = 0; j < i; j++){
                        console.log(character);
                    }
                    console.log("");
                }
                break;
        case "Diamond":
                console.log("Right after diamond");
                //top half of diamond
                var space = height;

                for(i = 1; i <= height; i++){
                    for(j = 1; j <= space; j++){
                        console.log(" ");
                    }
                    space--;
                    for(j = 1; j <= 2 * i -1; j++){
                        console.log(character);
                    }
                }
                space = 2;
                for(i = 1; i <= height; i++){
                    for(j = 1; j <= space; j++){
                        console.log(" ");
                    }
                    space++;
                    for(j = 1; j <= (2 * (height - i) - 1); j++){
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

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
var alphabet =
{
    a: 'value1',
    b: 'value2',
    c: 'value3',
    d: 'value4'
};

function traverseObject(someObj){
    for (var prop in someObj) {
        console.log(someObj[prop]);
    }
    return;
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

function deleteElement(someArr){
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

function spliceElement(someArr){
    console.log(someArr.length);
    someArr.splice(2,1);
    console.log(someArr.length);
}

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);
*/

function Person(name, age){
    this.name = name;
    this.age = age;
}

var john = new Person("John", 30);

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
*/

function getPerson(name, age){
    var Person = {
        name : name,
        age : age
    };
    return Person;
}

/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function getUSA(){
    var usaElement = document.getElementsByTagName('span')[1];
    console.log(usaElement.innerHTML);
}

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales(){
    var salesPeople = document.querySelectorAll("tr > td.empName");
    var sibs = getSiblings(salesPeople);
    console.log(salesPeople);
    return sibs;
}

//The following two assist getPeopleInSales()
function getSiblings(el, filter) {
    var siblings = [];
    el = el.parentNode.firstChild;
    do { if (!filter || filter(el)) siblings.push(el); } while (el = el.nextSibling);
    return siblings;
}

// example filter function
function exampleFilter(el) {
    return elem.nodeName.toLowerCase() == 'a';
}