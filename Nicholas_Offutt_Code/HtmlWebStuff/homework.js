

/*1. Fibonacci
Define function: fib(n) 
Return the nth number in the fibonacci sequence. */
function fib(n)
{
	if (n==0) return 0;
	if (n==1) return 1;
	return fib(n-1) + fib(n-2);
}

/*2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array. */

function bubSort(arr)
{
	let holder = 0;
	let x = 0;
	for(let i =0; i< (arr.length -1); i++)
	{
		if(arr[i] > arr[i + 1])
		{
			holder = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = holder;
			x = x + 1;  	
		}
		
	}
	if(x > 0)
		{
			return bubSort(arr);
		}
		else
		{
			return arr;
		}	
}



/*3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String. */
function reverse(string)
{
    var arr = [];
    var out = "";
    for(let i = (string.length -1); i >=0; i--)
	{
        
        arr[i] = string.charAt(i)

    }
    
    for(let i = 0; i<arr.length; i++)
    {
        out = out + arr[i];
    }

    return out;
}



/**4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum. */

function factorial(x)
{
	let z = 1;
	for(let i = 1; i<=x; i++)
	{
		z = z * i;
	}
	
	return z;
}

/**5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect. */


function subString(someStr, subLength, offSet)
{
    let output = ""
    if(subLength >= someStr.length || offSet >= someStr.length || subLength <= 0 || offSet < 0)
    {
		window.alert("Sorry that doesn't work for this function.");
		return null;
    }
    else
    {
        for(let i = offSet; i<= subLength; i++)
        {
            output = output + someStr.charAt(i);
        }
        return output;
    }
}
/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.*/

function isEven(input)
{
	return (Math.floor(input/2)*2) === input;
}

/*
 * 7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */

function isPalindrome(string)
{
	if(string === reverse(string))
	{
		return true;
	}
	else
	{
		return false;
	}
}

/**9. Object literal
Define function traverseObject(someObj)
Print every property and it's value. */

function objectTraverse(someObj)
{
	for(x in someObj)
	{
		console.log(someObj[x]);
	}
}

/*
 * 10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
 * 
 */

function deleteElement(array, index)
{
	console.log(array.length);
	array[index] = null;
	console.log(array.length);
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
 */

function splice(array, index)
{
	let holder = [];

	console.log(array.length);
	for(let i = 0; i < array.length; i++)
	{
		if(i != index)
		{
			holder.push(array.shift()); 
		}
	}
	array = holder;
	console.log(array.length);
}
/*12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
 var john = new Person("John", 30);
 */
function Person(inName, inAge)
{
	this.name = inName;
	this.age = inAge;
}
/*13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
*/
function getPerson(inName, inAge)
{
	let person = {name: inName, age: inAge};
	return person;
}



/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
 */

function getUSA()
{
	 var arr = document.getElementsByTagName('*');
	 for(let i = 0; i < arr.length; i++)
	 {
		 if(arr[i].innerHTML === 'USA')
		 {
			console.log(arr[i].nodeName);
			console.log(arr[i].innerHTML);
		 }
	 }
} 

/**2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
 */

 function getPeopleInSales()
 {
	 var arr = document.getElementsByClassName('empName');
	 var sibling = '';
	 for(let i = 0; i < arr.length; i++)
	 {
		 sibling = arr[i].nextElementSibling.innerHTML;
		 if(sibling === 'Sales')
		 {
			console.log(`On the Sales Team ${arr[i].innerHTML}`);
		 }
	 }
 }

 /**3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
 */
function getAnchorChildren()
{
	var arr = document.getElementsByTagName('a');
	var children = [];
	for(let i = 0; i < arr.length; i++)
	{
		children = document.arr[i].childNodes;
		for(let x = 0; x < children.length; x++)
		{

			if(children[i].tagName === 'span')
			{
				console.log(children[i].innerHTML);
			}
		}
	}
}

/**4. Hobbies
Define function getHobbies()
Find all checked options in the 'skills' select element.
Print the value and the contents.
 */

 function getHobbies()
 {
	 var elem = document.getElementById('skills');
	 var arr = elem.childNodes;
	 for(let i =0; i < arr.length; i++)
	 {
		 if(arr[i].selected === true)
		 {
			 console.log(arr[i].value);
			 console.log(arr[i].innerHTML);
		 }
	 }
 }

/**9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
    Hide the name if shown.
	Show the name if hidden.
*/



/*10. Current Time
Regarding this element:
    <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page. 
*/

setInterval(function time()
{
	var elem = new Date();
	document.getElementById('currentTime').innerHTML = elem.toLocaleTimeString();
}, 1000)

/**11. Delay
Regarding this element:
    <p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
 */

document.getElementById('helloWorld').addEventListener('click', randomColor);

function randomColor()
{
	var x = document.getElementById('helloWorld');
	newCol = getRandomColor();
	setTimeout(function(){x.style.color = `${newCol}`},3000)
};

function getRandomColor() {
	var letters = '0123456789ABCDEF';
	var color = '#';
	for (var i = 0; i < 6; i++) {
	  color += letters[Math.floor(Math.random() * 16)];
	}
	return color;
  }


