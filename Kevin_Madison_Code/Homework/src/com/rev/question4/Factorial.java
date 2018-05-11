package com.rev.question4;
//Question 4: Write a program to compute N factorial.

import java.util.Scanner;

public class Factorial {
	int iteration = 0;
	public static void main(String[] args) {
		
		System.out.println("enter a number to find the n factorial of: ");
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		System.out.println("The factorial of "+n+ " is " +factorial(n));
		System.out.println(factorial(n));
	}
	
	public static int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n ; i++) {
			result = result*i;
		}
		return result;
	}
	
	
}
