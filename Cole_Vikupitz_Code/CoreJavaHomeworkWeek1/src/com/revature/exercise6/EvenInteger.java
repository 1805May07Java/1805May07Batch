/*
 * EvenInteger.java
 * Author: Cole Vikupitz
 * 
 * Exercise 6: Program that checks whether an integer is even/odd
 * without using the modulus operator.
 */

package com.revature.exercise6;

public class EvenInteger {
	
	/**
	 * Returns true/false depending on if the given integer 'number'
	 * is even.
	 * 
	 * @param number - The number to check.
	 * @return True if 'number' is even, false otherwise.
	 */
	public static boolean isEven(int number) {
		
		float a;
		int b;

		/*
		 * To check if N is even without using the % operator, we can
		 * divide the number in half twice; one using an integer and
		 * another using a float. For integers, Java truncates the remainder
		 * off (the decimal portion). An even integer will have no remainder
		 * when divided by 2, therefore if the integer and float results are
		 * the same, we can conclude that the number is even.
		 * 
		 * EXAMPLE:
		 * 5 / 2 = 2
		 * 5 / 2.0 = 2.5
		 * 5 is odd since 2 != 2.5
		 * 
		 * EXAMPLE:
		 * 10 / 2 = 5
		 * 10 / 2 = 5.0
		 * 10 is even since 5 == 5.0
		 */
		a = number / 2.0F;
		b = number / 2;
		return (a == b);
	}

	public static void main(String[] args) {
		
		// Test a variety of numbers
		for (int i = 0; i <= 20; i++) {
			// Prints out the number, and whether it's even or not
			System.out.printf("%d is even: ", i);
			if (isEven(i))
				System.out.println("TRUE"); // Number is even
			else
				System.out.println("FALSE"); // Number is odd
		}
	}
}
