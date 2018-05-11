package com.revhomework.Question12;

public class Q12PrintEven {

	public static void main(String[] args) 
	{
		//create an new int array
		int[] hundred = new int[100];
		
		//load it up with 1 - 100
		for(int i = 0; i < 100; i++) 
		{
			hundred[i] = (i + 1);
		}
		
		//call the method
		printEven(hundred);
	}
	
	
	//method for printing all of the even numbers in an int array
	public static void printEven(int[] input) 
	{
		for(int i : input) 
		{
			//check if it is even
			if(i % 2 == 0) 
			{
				System.out.print(i + " ");
			}
		}
	}

}
