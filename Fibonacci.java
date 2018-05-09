package com.rev.exercises;

public class Fibonacci 
{
	public static void main(String args[])
	{
		int a = 0, b = 1, c;
		
		System.out.print(a + " ");
		System.out.print(b + " ");
		
		//for loop to get the other 23 numbers
		for(int i = 2; i < 25; i++)
		{
			//finds the next number and then shifts the last 2 forward by 1
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + " ");
		}
			
		
	}
	
}
