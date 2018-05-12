/*
 * BankMachine.java
 * Author: Cole Vikupitz
 *
 * FIXME - ADD DESCRIPTION
 */

package com.revature.version1;

// Imports
import java.util.Scanner;

public class BankMachine {

	private Scanner scanner;
	private User currentUser;

	public BankMachine() {

		this.scanner = new Scanner(System.in);
		this.currentUser = null;
	}

	public void run() {

		// Main menu
	}

	private void createUser() {

		// Prompt username, password, create user, then login when successful

	}

	private void login() {

		// Prompt username, password, login if authenticated
	}

	private void modifyAccount() {

		// Withdraw, deposit money, logout
	}

	private int promptNumber(int min, int max) {

		while (true) {

			try {
				System.out.print("> ");
				int number = Integer.parseInt(this.scanner.nextLine());
				if (min <= number && number <= max)
					return number;
				System.out.println("Invalid entry, please enter a valid option.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, please enter a valid option.");
			}
		}
	}

}
