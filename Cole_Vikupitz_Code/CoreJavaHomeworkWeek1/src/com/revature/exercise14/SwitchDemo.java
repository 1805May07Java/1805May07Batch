/*
 * SwitchDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 14: Program that demonstrates the switch statement in
 * Java. Given a mode, switch statement will do one of the following
 * for the specified case:
 * (1) - Compute the square root for some random integer.
 * (2) - Displays the current date & time.
 * (3) - Splits the string "I am learning Core Java" into an array, then
 *       prints the strings in the array.
 */

package com.revature.exercise14;

// Imports
import java.util.Date;
import java.util.Random;

public class SwitchDemo {
	
	/**
	 * Method that demonstrates the switch statement, given a mode
	 * between 1-3.
	 * 
	 * @param mode - The case to catch; if it's not 1-3, the default
	 * case is hit.
	 */
	public static void switchFunction(int mode) {
		
		switch(mode) {
		
			// Case 1: Compute and display square root of some number
			case 1:
				// Get a random number
				int number = new Random().nextInt(200);
				// Compute square root with Math.sqt()
				float root = (float) Math.sqrt(number);
				// Display computed result
				System.out.printf("Square root of %d is %.06f\n", number, root);
				break;
			// Case 2: Display the current date & time
			case 2:
				// Creates a new Date object
				Date date = new Date();
				// Invoke toString() to display the date and time
				System.out.printf("Today's date: %s\n", date.toString());
				break;
			// Case 3: Split the string "I am learning Core Java"
			case 3:
				// Create the string, then split into array
				String testStr = "I am learning Core Java";
				String arr[] = testStr.split(" ");
				// Iterate through array, display each word
				for (String str : arr)
					System.out.printf("%s ", str);
				System.out.println();
				break;
			// Default: Print notification and mode
			default:
				// Simply print the mode, notify that default case was hit
				System.out.printf("** Hit default case at mode %d\n", mode);
		}
	}

	public static void main(String[] args) {
		
		// Test switch statement for variety of modes
		for (int i = 0; i <= 5; i++)
			switchFunction(i);
	}
}
