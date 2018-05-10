package com.rev.exercises;

import java.util.Scanner;

public class Smallest {

	public static void main(String[] args) 
	{
		double a, b, answer;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter a number.");
		a = in.nextDouble();
		
		System.out.println("Please enter another number.");
		b = in.nextDouble();
		
		if(a == b)
		{
			System.out.println("That's the same number");
		}
		else
		{
			answer = a < b ? a : b;
			System.out.println(answer + " is the smallest.");
		}
	}

}
