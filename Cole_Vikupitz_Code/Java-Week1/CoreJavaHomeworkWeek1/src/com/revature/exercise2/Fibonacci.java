/*
 * Fibonacci.java
 * Author: Cole Vikupitz
 * 
 * Exercise 2: Program that computes and returns the Fibonacci sequence
 * for some given number.
 */

package com.revature.exercise2;

public class Fibonacci {

	/**
	 * Returns the fibonacci sequence sum for the given number
	 * 'steps'.
	 * 
	 * @param steps - The number to compute the fibonacci sequence for.
	 */
	public static long fibonacciSequence(int steps) {
		
		// Declare & initialize variables
		long sum, prev = 0L, next = 1L;
		
		// Fib(0) is 0, return 0
		if (steps <= 0)
			return prev;
		// Fib(1) is 1, return 1
		if (steps == 1)
			return next;
		
		// Iterate through the fibonacci sequence up to N
		for (int i = 0; i < steps; i++) {
			// Adds the previous two terms, reassigns the appropriate variables
			sum = prev + next;
			prev = next;
			next = sum;
		}

		// Returns the result
		return prev;
	}
	
	public static void main(String[] args) {
		
		// Print the fibonacci sequence for the given number
		final int NSTEPS = 25;
		long result = fibonacciSequence(NSTEPS);
		System.out.printf("Fibonacci(%d) = %d\n", NSTEPS, result);
	}

}
