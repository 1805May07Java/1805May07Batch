package com.revhomework.Question9;

import java.util.ArrayList;


public class PrimeFind {

	public static void main(String[] args) 
	{
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for(int i =0; i<100; i++) 
		{
			num.add(i+1);
		}
		
		System.out.println("Here are the prime between 1 and 100.");
		
		for(int i : num) 
		{
			if(isPrime(i)) 
			{
				System.out.print(i + " ");
			}
		}
		
		
	}

	public static boolean isPrime(int input) 
	{
		//check the obvious outs
		if(input <= 1) 
		{
			return false;
		}
		//take care of the two exception
		if(input == 2) 
		{
			return true;
		}
		//eliminate all even numbers
		if(input%2==0) 
		{
			return false;
		}
		
		//the actual for loop, start at three look only at the odd numbers, look until we hit the input
		for(int i = 3; i < input; i+=2)
		{
			//knock us out if we find it 
			if(input % i == 0) 
			{ 
				return false;
			}
			
		}
		
		//if we got here it is prime
		return true;
	}
	
	
}
