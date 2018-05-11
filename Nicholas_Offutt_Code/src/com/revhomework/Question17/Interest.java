package com.revhomework.Question17;

import java.util.Scanner;

public class Interest 
{

	public static void main(String[] args) 
	{
			
		//Scanner object allows user input
		Scanner input = new Scanner(System.in);
		//the doubles
		double principal = 0;
		double rate = 0;
		double years = 0;
		
		System.out.println("Welcome let's calculate your simple interest. Be advised you must enter a non zero answer for each question.");
		
		//while loop to fin our answers
		while(principal == 0 || rate ==0 || years ==0) 
		{
			System.out.println("Please enter the Principal.");
			
			//input validation on scanner
			if(input.hasNextDouble()) 
			{
				principal = input.nextDouble();
			}
			else 
			{
				//error message and dumps out bad data
				System.out.println("That is not a number.");
				input.nextLine();
			}
			
			
			
			System.out.println("Please enter the Rate.");
			
			//input validation on scanner
			if(input.hasNextDouble()) 
			{
				rate = input.nextDouble();
			}
			else 
			{
				//error message and dumps out bad data
				System.out.println("That is not a number.");
				input.nextLine();
			}
			
			System.out.println("Please enter the time in Years.");
			
			//input validation on scanner
			if(input.hasNextDouble()) 
			{
				years = input.nextDouble();
			}
			else 
			{
				//error message and dumps out bad data
				System.out.println("That is not a number.");
				input.nextLine();
			}
		
		}
		
		//call the interest function in a print out
		System.out.println("Your Interest Totals:");
		System.out.println(simpleInterest(principal, rate, years));
		
		
		//close the scanner
		input.close();
	}
	
	
	
	public static double simpleInterest(double amount, double rate, double years) 
	{
		return amount*rate*years;
	}
	
	
}
