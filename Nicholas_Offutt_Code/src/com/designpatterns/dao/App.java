package com.designpatterns.dao;

import java.util.Scanner;



public class App {

	public static void main(String[] args) 
	{
		

	}

	
	
	static void start() 
	{
		//Scanner object allows user input
		Scanner input = new Scanner(System.in);
		int op = 0;
		
		
		
		System.out.println("Welcome to our Student App!" + 
						 "\nWhat would you like to do?" +
						 "\n1: Log In" +
						 "\n2: Sign up");
		try 
		{
			 op = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) 
		{
			nfe.printStackTrace();
			System.out.println("");
		}
		
		
		
		
		
		
		input.close();


	}
	
	
	
	
}
