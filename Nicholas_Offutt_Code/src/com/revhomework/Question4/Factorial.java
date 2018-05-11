package com.revhomework.Question4;

public class Factorial 
{
	
	//Void function for taking in the number and then factorializing it, printing result to screen.
	
	public void factor(int input) 
	{
		
		//set up an integer at one so that we can freely multiply against it, without accidentally having zero.
		int factor = 1;
		
		//checks for zero or negative input to avoid weirdness
		if(input > 0) 
		{
			
			//Straight forward decrementing for loop
			for(int i = input; i > 0; i--)
			{
				
				
				factor = factor * i; 
				
			}
			
		}
		else 
		{
			//print outs to declare what 
			System.out.println("A Zero or negative number was entered. If zero, 1 is the result.");
			System.out.println("If negative, I am sorry I cannot do that User.");
		}
		
		
		//Prints the result to output
		System.out.println("The factorial of: " + input + " is "+ factor);
	}
}
