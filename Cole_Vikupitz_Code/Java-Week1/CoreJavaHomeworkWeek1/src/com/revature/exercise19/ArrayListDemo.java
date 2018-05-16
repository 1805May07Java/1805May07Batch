/*
 * ArrayListDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 19: Program that stores the numbers 1-10 into an array list.
 * Displays the sum of all the even numbers, odd numbers, then removes all
 * primes and then displays the sum of all the remaining numbers.
 */

package com.revature.exercise19;

// Imports
import java.util.ArrayList;

public class ArrayListDemo {
	
	/**
	 * Returns the sum of all the even numbers in the array list 'list'.
	 * 
	 * @param list - An array list of integers.
	 * @return Sum of all even numbers in 'list'.
	 */
	public static int displayEvenSum(ArrayList<Integer> list) {
		
		// Keep track of the sum
		int sum = 0;
		for (int i : list)
			// Only count if even (divisible by 2)
			if (i % 2 == 0)
				sum += i;
		
		return sum;
	}
	
	/**
	 * Returns the sum of all the odd numbers in the array list 'list'.
	 * 
	 * @param list - An array list of integers.
	 * @return Sum of all odd numbers in 'list'.
	 */
	public static int displayOddSum(ArrayList<Integer> list) {
		
		// Keep track of the sum
		int sum = 0;
		for (int i : list)
			// Only count if odd (not divisible by 2)
			if (i % 2 == 1)
				sum += i;

		return sum;
	}

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
		
		// Create array list, populate with numbers 1-10
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			list.add(i);
		
		// Display the array list's original contents
		System.out.println("The original array list:");
		for (int i : list)
			System.out.printf("%d ", i);
		System.out.println();
		
		// Add up all even numbers and display result
		int sum = displayEvenSum(list);
		System.out.printf("Sum of all even numbers: %d\n", sum);
		// Add up all odd numbers and display result
		sum = displayOddSum(list);
		System.out.printf("Sum of all odd numbers: %d\n", sum);

		// Remove all prime numbers from the array list
		for (int i = 0; i < list.size(); i++)
			if (isPrime(list.get(i)))
				list.remove(i);

		// Display the array list after all primes have been removed
		System.out.println("The array list after all primes removed:");
		for (int i : list)
			System.out.printf("%d ", i);
		System.out.println();
		
		// Display sum of all remaining numbers in the array list
		sum = 0;
		for (int i : list)
			sum += i;
		System.out.printf("Sum of all composite numbers: %d\n", sum);
	}
}

