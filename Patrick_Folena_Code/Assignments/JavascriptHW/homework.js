/*
PART I
Create a single Javascript file called homework.js to answer these questions.
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fib(n){
    if(n <= 0){
        return 0;
    }
    else if (n<=2) {
        return 1;
    }
    var hold1 = 1;
    var hold2 = 1;
    var hold3;
    while(n-- > 2){
        hold3 = hold1+hold2;
        hold1 = hold2;
        hold2 = hold3;
    }
    return hold3;
};
/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray){
    for(var i = 0; i < numArray.length; i++)
    {
        for(var j = i; j < numArray.length-1; j++)
        {
            if(numArray[j] > numArray[j+1])
            {
                var hold = numArray[j+1];
                numArray[j+1] = numArray[j];
                numArray[j] = hold;
            }
        }
    }
    return numArray;
};
/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr){
    if(typeof someStr !== "string")
    {
        return undefined;
    }
    var rev = "";
    for(var i = someStr.length-1; i >= 0; i--)
    {
        rev = rev + someStr[i];
    }
    return rev;
};
/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
    if(someNum < 0){
        return NaN;
    }
    else if (someNum <= 1) {
        return 1;
    }

    var answer = 1;
    while(someNum >= 2)
    {
        answer = answer * (someNum--);
    }
    return answer;
};
/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/
function substring(someStr, length, offset){
    if(typeof someStr !== "string" || typeof length !== "number" || typeof offset !== "number"){
        alert("Invalid Parameter Types");
        return undefined;
    }
    if (isNaN(length)|| isNaN(offset)){
        if(isNaN(length))   alert("Variable 'length' is NaN");
        else                alert("Variable 'offset' is NaN");
        return undefined;
    }
    else if(length >= someStr.length || offset >= someStr.length){
        if(length > someStr.length) alert("Variable 'length' is Out Of Bounds (->)");
        else                        alert("Variable 'offset' is Out Of Bounds (->)");
        return undefined;
    }
    else if (length < 0 || offset < 0){
        if(length < 0)              alert("Variable 'length' is Out Of Bounds (<-)");
        else                        alert("Variable 'offset' is Out Of Bounds (<-)");
        return undefined;
    }
    else{
        var returnStr = "";
        if(offset > length){
            var hold = offset;
            offset = length;
            length = hold;
        }
        for(var i = offset; i <= length; i++){
            returnStr += someStr[i];
        }
        return returnStr;
    }
};
/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum){
    if(typeof somenum !== "number" || isNaN(someNum))
    {
        return undefined;
    }
    return ((someNum&1) === 0);
};
/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/
function isPalindrome(someStr){
    if(typeof someStr != "string")
    {
        return undefined;
    }

    var baseStr = someStr.toLowerCase();
    for(i = 0; i < someStr.length/2; i++)
    {
        if(baseStr[i] !== baseStr[baseStr.length-i-1])
        {
            return false;
        }
    }
    return true;
};
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
    
    if(typeof shape !== "string" || typeof height !== "number" || typeof character !== "string"){
        return undefined;
    }
    var drawShape = "";
    switch(shape) {
        case "Square":
            for(var i = 1; i <= height; i++) {
                for(var j = 1; j <= height; j++) {
                    drawShape += character;
                }
                drawShape += "\n";
            }
            break;
        case "Triangle":
            for(var i = 1; i <= height; i++){
                for(var j = 1; j <= i; j++){
                    drawShape += character;
                }
                drawShape += "\n";
            }
            break;
        case "Diamond":
            var left = (height/2)+0.5;  //left = 3
            var right = left;           //right = 3
            for(var i = 1; i <= height; i++){
                for(var j = 1; j <= height; j++){
                    if(j < left || j > right) {
                        drawShape += " ";
                    }
                    else {
                        drawShape += character;
                    }
                }

                if(i < ((height+1)/2)){
                    left--;
                    right++;
                }
                else {
                    left++;
                    right--;
                }
                drawShape += "\n";
            }
			break;
        default: return undefined;
    }
    console.log(drawShape);
};
/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/
function traverseObject(someObj){
for(var prop in someObj) {
    propVal = someObj[prop]

    console.log(prop + " : " + propVal);
}
};
/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr)
{
    console.log(someArr.length);
    delete(someArr[2]);
    console.log(someArr.length);
};
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
};
/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
    var john = new Person("John", 30);
*/
function Person(name, age){
    this.name = name;
    this.age = age;
};
/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
*/
function getPerson(name, age){
    return {type: Person, name: name, age: age};
}
/*
-----------------------------------------------------------------------------------
PART II
Part II will focus on Javascript's ability to manipulate the DOM.
Use the provided index.html
Put your Javascript in the provided <script> element at the bottom of the page.
Please put the question itself as a comment above each answer.
NOTE: Part II will be done twice: once with Javascript and once with jQuery.
      They should be done separately.
      Copy the index.html file and rename them to: indexJavascript.html and indexJQuery.html
-----------------------------------------------------------------------------------
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
  
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
  
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
  
4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
  
5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute.
6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
    <input id="num1" class="nums" type="text"/>
    <input id="num2" class="nums" type="text"/>
    <h3>Sum: <span id="sum"></span></h3>
Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element
7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
    "Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill.
8. Favorite Color Event
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
    "So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) the newly selected favoriteColor
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
    Hide the name if shown.
    Show the name if hidden.
10. Current Time
Regarding this element:
    <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
11. Delay
Regarding this element:
    <p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. Use recursion.
On each node, call func(node).
*/
