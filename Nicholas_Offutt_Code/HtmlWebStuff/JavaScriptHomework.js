//JS Homework

function fib(n)
{
	if (n==0) return 0;
	if (n==1) return 1;
	return fib(n-1) + fib(n-2);
}

function bubSort(arr[])
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
	for(let i = (string.length -1); i >=0; i--;)
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