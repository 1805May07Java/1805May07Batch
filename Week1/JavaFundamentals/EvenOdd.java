package com.rev.exercises;

import java.util.Scanner;

public class EvenOdd 
{
	
	
	public static void main(String[] args) 
	{
		int n, answer;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integer.");
		n = in.nextInt();
		
		answer = n/2;
		
		if(answer * 2 == n)
		{
			System.out.println("Then number is even");
		}
		else
		{
			System.out.println("Then number is odd.");
		}
		
	}
	
	
	
}
