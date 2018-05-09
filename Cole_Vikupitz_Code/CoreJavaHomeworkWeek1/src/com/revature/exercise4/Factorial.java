/*
 * Factorial.java
 * Author: Cole Vikupitz
 * 
 * Exercise 4: Program that computes the factorial of a specified
 * number.
 */

package com.revature.exercise4;

public class Factorial {

	/**
	 * Computes and returns the factorial of 'number'.
	 * 
	 * @param number - The number to compute the factorial of.
	 * @return The computed factorial.
	 */
	public static long factorial(int number) {
		
		// 0! is regarded as 1, return 1
		if (number == 0)
			return 1L;
		// Start from N-1
		long result = (long) number;
		// Multiply from N-1 down to 2; multiplying 1 is unnecessary
		for (int i = (number - 1); i > 1; i--)
			result *= i;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		final int DEFAULT = 10;
		int number = DEFAULT;
		
		// User may pass in an optional argument
		// This is the number to compute the factorial of
		if (args.length > 0) {
			try {
				// Parses the given argument into an integer
				number = Integer.parseInt(args[0]);
			} catch(Exception e) {
				// Error occurred parsing the argument
				// Print the usage and exit
				System.err.println("Error parsing the given number.");
				System.err.println("Usage: java Factorial [N]");
				System.exit(1);
			}
		}
		
		// Computes the factorial, displays the result
		long result = factorial(number);
		System.out.printf("%d! = %d\n", number, result);
	}

}
