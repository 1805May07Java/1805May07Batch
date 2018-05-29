package com.hw.q4;

public class Factorial {
	
	static double nFactorial(int n)
	{
		if(n==1)
		{
			return n;
		}
		else
			return n * nFactorial(n-1);
	}
}
