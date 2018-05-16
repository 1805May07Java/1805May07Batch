/*
 * Minimum.java
 * Author: Cole Vikupitz
 * 
 * Exercise 10: Program that finds the minimum of two given numbers using only
 * ternary operators.
 */

package com.revature.exercise10;

public class Minimum {

	public static void main(String[] args) {
		
		// Initialize the two numbers to compare
		int x = 0, y = 0;
		
		// Improper usage, print usage and exit
		if (args.length < 2) {
			System.out.println("Usage: java Minimum number1 number2");
			System.exit(0);
		}
		
		try {
			// Retrieve and parse the two numbers passed as arguments
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		} catch (Exception e) {
			// Failed to parse integers, print error and exit
			System.err.println("Error processing one of the numbers.");
			System.exit(1);
		}
		
		// Find the minimum of the two numbers using ternary operator(s)
		String result = (x == y) ? "No minimum, numbers are equal." :
			((x < y) ? String.format("Minimum is %s", x) : String.format("Minimum is %s", y));
		// Print the minimum number
		System.out.println(result);
	}
}
