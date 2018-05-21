/*
 * BankMachine.java
 * Author: Cole Vikupitz
 *
 * Class that represents a bank ATM machine connecting to
 * the banking database. Allows users to create or login to
 * accounts, create new banking accounts, deposit and withdraw
 * money, and view their balances.
 */

package com.revature.main;

import java.util.Scanner;

public class BankMachine {

	private Scanner scanner;

	public BankMachine() {

		this.scanner = new Scanner(System.in);
	}

	public void run() {


	}

	/*
	 * Prompts the user for an integer within the specified range (must be
	 * greater than or equal to 'min', and less than or equal to 'max').
	 * Continues to prompt the user if number failed to parse or the number
	 * given is out of range. Returns the number when successfully entered.
	 */
	private int promptNumber(int min, int max) {

		// Continue to prompt user until success
		while (true) {

			try {
				System.out.print("> ");
				// Parse the input
				int number = Integer.parseInt(this.scanner.nextLine());
				// Return number if parsed integer is in specified range
				if (min <= number && number <= max)
					return number;
				// Otherwise, print message and try again
				System.out.println("Invalid entry, please enter a valid option.");
			} catch (NumberFormatException e) {
				// Failed to parse number - re-prompt the user
				System.out.println("Invalid entry, please enter a valid option.");
			}
		}
	}

	/*
	 * Verifies whether 'entry' is valid or not. Used to validate
	 * entries for names, usernames, and passwords. Returns true
	 * if valid, or false otherwise.
	 *
	 * Entry is valid if it's 2-24 characters long, and contains
	 * only letters and digits.
	 */
	private boolean entryIsValid(String entry) {

		// String must be 2-24 characters long
		if (entry.length() < 2 || entry.length() > 24)
			return false;
		// String must contain only letters and numbers
		for (char ch : entry.toCharArray())
			if (!Character.isLetter(ch) && !Character.isDigit(ch))
				return false;
		return true;
	}

}