package com.revhomework.Question2;

public class Fibonacci 
{
	//returns the number at the nth position, assuming the sequence starts at 1!
	public int fib (int in)
	{
		
		int previous = 0;
		int current = 1;
		int holder = 0;
		for(int i = 1; i <= in; i++)
		{
			System.out.print(current + " ");
			holder = current;
			current = current + previous;
			previous = holder;
		}
		System.out.println();
		return current;
		
	}
	
	
	
	
}
