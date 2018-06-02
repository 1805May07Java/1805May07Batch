
/* 
1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence.

*/

function fib(n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    
    return fib(n-1) + fib(n-2);
    
    
    }

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(list){
	var temp;
	for (var j = 0; j < list.length; j++){
	for(var i = 0; i < list.length; i++){
		if(list[j] < list[i]) {
			temp = list[j];
			list[j] = list[i];
			list[i] = temp;
		}
	}
}
	return list;
}

/*
 3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(someStr){
var rev= '';

    for(let i = someStr.length-1; i >= 0; i--){
            rev = rev + someStr.charAt(i);
    }
return rev;
}

/* 
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum){
    var fact = 1;
    for(let i = 1; i <= someNum; i++){
        fact *= i;
    }
    return fact;
}

/*5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
 */

 function substring(someStr, length, offset){
    var sub='';
    if(someStr.length < offset){
        return alert('The offset is past the end of the String!');
    }else if(someStr.length < offset + length){
        return alert('Length runs off the end of the String!');
    }else if(offset < 0){
        return alert('Offset cannot be less than 0!');
    }else if(length < 0){
        return alert('Length cannot be less than zero!')
    } 

    for(let i =  offset; i <= length + offset; i++ ){
        sub = sub + someStr.charAt(i);
    }

    return sub;
 }
 /* 6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/
function isEven(someNum){
     var temp = someNum & 00001;
    if(temp == 0) return true;
    
    return false;
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalidrome(someStr){

    for(let i= 0; i < someStr.length/2; i++){
        console.log(someStr.charAt(i) +": " +someStr.charAt((someStr.length-1) - i));
        if(someStr.charAt(i) != someStr.charAt((someStr.length-1) - i)){
            return false;
        }
    }
    return true;
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
switch(shape){
    case 'Square': Square(height, character); break;
    case 'Triangle': Triangle(height, character); break;
    case 'Diamond': Diamond(height, character); break;

    default: 'invalid shape!'; break;
}
}

function Square(height, character){

    for(let i =0; i < height; i++){
        var temp = '';
        for(let j= 0; j < height; j++){
            temp = temp + character;
        }
        console.log(temp);
    }
}
function Triangle(height, character){
    for(let i=0; i < height; i++){
        var temp ='';
        for(let j= 1; j <= i+1; j++){
            temp = temp + character;
        }
        console.log(temp);
    }
}
function Diamond(height, character){
    console.log(character);
    for(let i=1; i < (height+1)/2; i++){
        var temp ='';
        for(let j= 0; j < (2*i)+1; j++){
            temp = temp + character;
        }
        console.log(temp);
    }
    
    for(let i=(height+1)/2; i < height-1; i++){
        var temp2='';
        for(let j=0; j < (2*(height-(i+1)))+1; j++){
            temp2 = temp2 + character;
        }
        console.log(temp2);
    }
    
    
   
    console.log(character);

}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

function traverseObject(someObj){
    var propValue;
    for(var propName in someObj){
        propValue= someObj[propName];

        console.log(propName +": " +propValue);
    }
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
    console.log('Before: ' +someArr.length);
    delete someArr[2];
    console.log(someArr);
    console.log('After: ' +someArr.length);
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
    console.log('Before: ' +someArr.length);
    someArr.splice(2,1);
    console.log(someArr);
    console.log('After: ' +someArr.length);
}

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

function Person(name, age){
    this.perName = name;
    this.perAge = age;

}

/* 
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
    var john = getPerson("John", 30);
*/

function getPerson(name, age){
    return new Person(name, age);
}
