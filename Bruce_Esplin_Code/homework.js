//1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fibonacci(num){
    var a = 1, b = 0, temp;

    while (num >= 0){
        temp = a;
        a = a + b;
        b = temp;
        num--;
    }

    return b;
    }
// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubble_Sort(numArray)
{
    var swap;
    var n = numArray.length-1;
    var x=numArray;
    do {
        swap = false;
        for (var i=0; i < n; i++)
        {
            if (x[i] < x[i+1])
            {
               var temp = x[i];
               x[i] = x[i+1];
               x[i+1] = temp;
               swap = true;
            }
        }
        n--;
    } while (swap);
 return x; 
}
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
    var someStr = ["Pizza", "Wings", "Beer"];
    someStr.reverse;

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
    function factorial(x) 
    { 

    if (x === 0)
    {
        return 1;
    }
    return x * factorial(x-1);
            
    }
// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
    function isEven(someNum) {
        if((num & 1) == 0){
        return true
        }
        return false;
    }

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
isPalindrome = function(i) {
    return i === reverseStr(i);
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
    function diamond(val){
        var y, w, shape = '';
      
        for(y = 0; y < val * 2 - 1; y++) {
          w = y < val ? y : val * 2 - y - 2;
          shape += Array(val - w).join(' ') + Array(w + 1).join('* ') + '*\n';
        }
        document.write('<pre>' + shape + '</pre>');
      }

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
deleteElement = function(i) {
    console.log(i.length);
    delete i[3];
    console.log(i.length);
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
    for (var i = 2; i <= TheArray.length; i += 2)
    TheArray.splice(i, 1);