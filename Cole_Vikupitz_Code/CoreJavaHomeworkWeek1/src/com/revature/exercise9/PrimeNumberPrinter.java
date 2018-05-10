/*
 * PrimeNumberPrinter.java
 * Author: Cole Vikupitz
 * 
 * Exercise 9: Program that prints out all the prime numbers between
 * 1 and 100.
 */

package com.revature.exercise9;

// Imports
import java.util.ArrayList;

public class PrimeNumberPrinter {
	
	/**
	 * Returns true/false depending on if the given integer 'number' is a prime
	 * number.
	 * 
	 * @param number - The number to check.
	 * @return True if the number is prime, false otherwise.
	 */
	public static boolean isPrime(int number) {
		
		// One conventionally not considered prime
		if (number <= 1)
			return false;
		// Two is prime, return true
		if (number == 2)
			return true;
		/*
		 * When checking a number for primality, we only need to check
		 * then numbers from 2 up to the square root. We only need to
		 * check one number from each of the factor pairs of the numbers.
		 */
		int sqrt = (int) Math.ceil(Math.sqrt(number));
		for (int i = 2; i <= sqrt; i++)
			if (number % i == 0)
				return false;
		
		// At this point, number isn't divisible by any
		// Therefore, number must be prime
		return true;
	}

	public static void main(String[] args) {
		
		// Create & populate the array list with numbers 1-100
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++)
			numberList.add(i);
		
		// Iterate through all numbers in array list
		System.out.println("All primes within 1 - 100:");
		for (int i : numberList)
			// Only print the number if it's prime
			if (isPrime(i))
				System.out.printf("%d ", i);
		System.out.println();
	}
}
