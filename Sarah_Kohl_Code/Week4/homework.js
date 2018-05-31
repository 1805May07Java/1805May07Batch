// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n){
    if(n===0)
        return 0;
    if(n===1)
        return 1;
    return fib(n-1) + fib(n-2);
} 



// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray)
{
    for(var inv = 0; inv<numArray.length;inv++)
    {
        for(var runner = inv; runner<numArray.length;runner++)
        {
            if(numArray[runner] < numArray[inv])
            {
                swap(numArray, inv, runner);
            }
            
        }
    }

    return numArray;

	function swap(array, first, second) {
		var temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr)
{
    return someStr.split("").reverse().join("");
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum){
    if(n<=1)
        return 1;
    else
    return n * factorial(n-1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset)
{
    if(offset < 0 || offset > someStr.length-1)
    {
        alert("Offset is out of string length bounds");
    }
    else if(offset + length > someStr.length)
    {
        alert("The requested substring exceeds the length of the original string");
    }
    else{
        var temp = "";
        for(var i = offset; i<offset+length;i++)
        {   
            temp += someStr[i];
        }
        return temp;
    }
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum){
    return !((someNum & (1 << 32)) !== 0);
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr)
{
    return someStr === reverseStr(someStr) ? true : false;
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
function printShape(shape, height, character){
   
    switch(shape)
    {
        case 'Square':
            printSquare(character, height);
            break;
        case 'Triangle':
            printTriangle(character, height);
            break;
        case 'Diamond':
            printDiamond(character, height);
            break;
    }

    function printSquare(character, height){
        for(var h=0;h<height;h++)
        {
            console.log(character.repeat(height));
        }
    }


    function printTriangle(character, height){
        for(var h=1;h<=height;h++)
        {
            console.log(character.repeat(h));
        }
    }

    function printDiamond(character, height){
        for(var h=1;h<=height;h+=2)
        {
            console.log(" ".repeat(height-h/2)+character.repeat(h));
        }
        for(var h=height-2;h>=1;h-=2)
        {
            console.log(" ".repeat(height-h/2)+character.repeat(h));
        }
    }
};


// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj)
{
    var keys =Object.keys(someObj);
    keys.forEach(key => {
        console.log(`${key}:${someObj[key]}`);
    });
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr)
{
    console.log(`Previous length: ${someArr.length}`);
    delete someArr[3];
    console.log(`New length: ${someArr.length}`);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr)
{
    console.log(`Previous length: ${someArr.length}`);

    someArr.splice(3,1);

    console.log(`New length: ${someArr.length}`);
}


// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);
function Person(name, age){
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);
function getPerson(name, age)
{
    return {name: name,
            age: age
    };
}

