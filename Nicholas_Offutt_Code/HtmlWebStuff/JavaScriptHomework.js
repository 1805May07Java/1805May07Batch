
document.getElementById('button').addEventListener('click', run);



function run()
{
	var input = document.getElementById('input').value;
	var arg = rnaTranscription(input);
	var text = "";
    for(let i = 0; i< arg.length; i++)
    {
        console.log(arg[i]);
        text = text + ' ' +arg[i];
    }
    document.getElementById('landing zone').innerHTML = text;
}

//stuff from exercism

//example 1 

function helloWorld()
{
	return "Hello World";
}



function twoFer(input)
{
	if(input == null)
	{
		return "One for you, one for me.";
	}
	else{
		return `One for ${input}, one for me.`;
	}
}

function leap(year)
{
	if(year % 4 === 0)
	{
		if(year % 100 != 0)
		{
			return true;	
		}
		else if(year % 400 === 0)
		{
			return true;
		}
		else {return false;}
	}
	else
	{
		return false;
	}

}

function reverse(string)
{
	for(let i = (string.length -1); i >=0; i--)
	{
		console.log(string.charAt(i));
	}
}

function rnaTranscription(input)
{

	output = [];
	for(let i = 0; i<=input.length; i++)
	{
		output[i] = input.charAt(i);
	}
	
	for(let i = 0; i<output.length; i++)
	{
		if(output[i] === 'G')
		{
			output[i] = 'C';
		}
		else if(output[i] === 'C')
		{
			output[i] = 'G';
		}
		
		if (output[i] === 'A')
		{
			output[i] = 'U';
		}
		else if(output[i] === 'T')
		{
			output[i] = 'A';
		}
	}
	
	return output;
}
























//JS Homework

function fib(n)
{
	if (n==0) return 0;
	if (n==1) return 1;
	return fib(n-1) + fib(n-2);
}

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


function reverse(string)
{
	for(let i = (string.length -1); i >=0; i--)
	{
		console.log(string.charAt(i));
	}
}



function factorial(x)
{
	let z = 1;
	for(let i = 1; i<=x; i++)
	{
		z = z * i;
	}
	
	return z;
}

