/*
 * InterestDemo.java
 * Author: Cole Vikupitz
 * 
 * Exercise 17: Program that computes a simple interest, given the principal amount,
 * the interest rate, and the time in years. User must input these amounts manually.
 */

package com.revature.exercise17;

// Imports
import java.util.Scanner;

public class InterestDemo {

	public static void main(String[] args) {
		
		// Create new Scanner for user input
		Scanner scanner = new Scanner(System.in);
		// Declare & initialize other variables
		String input;
		float principal = 0.0F, rate = 0.0F;
		int time = 0, mode = 1;
		
		while (true) {
			try {
				if (mode == 1) { // Prompt user for principal amount
					System.out.print("Enter the principal amount: ");
					input = scanner.nextLine();
					// Convert user input into a floating point number
					principal = Float.parseFloat(input);
					mode++;
				} else if (mode == 2) { // Prompt user for the interest rate
					System.out.print("Enter the interest rate (0.0 - 1.0): ");
					input = scanner.nextLine();
					// Convert user input into a floating point
					rate = Float.parseFloat(input);
					mode++;
				} else { // Prompt user for the time (in years)
					System.out.print("Enter the time (years): ");
					input = scanner.nextLine();
					// Convert user input into an integer
					time = Integer.parseInt(input);
					break;
				}
			} catch (Exception e) {
				// Display error message when user enters invalid content
				System.out.println("Invalid input, please enter the appropriate data.");
			}
		}
		
		// Compute and display the interest
		float interest = (principal * rate * time);
		System.out.printf("The interest is: %.02f\n", interest);
		// Close the scanner connection
		scanner.close();
	}

}
