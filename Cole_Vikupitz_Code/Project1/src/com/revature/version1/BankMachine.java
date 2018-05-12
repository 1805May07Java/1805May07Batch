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
	private BankDatabase database;
	private User currentUser;

	public BankMachine() {

		this.scanner = new Scanner(System.in);
		this.database = BankDatabase.getInstance();
		this.currentUser = null;
	}

	public void run() {

		boolean running = true;
		System.out.println("----- Revature Banking System -----\n");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("0: Exit");

		while (running) {
			switch (this.promptNumber(0, 2)) {
				case 1:
					this.login();
					this.modifyAccount();
					break;
				case 2:
					this.createUser();
					this.modifyAccount();
					break;
				case 0:
					running = false;
					break;
				default:
					break;
					// FIXME - should anything happen here?
			}
		}
	}

	private void createUser() {

		String username = "", password = "";
		boolean notValid = true;

		System.out.println("Enter your desired username.");
		while (notValid) {
			System.out.print("> ");
			username = this.scanner.nextLine();
			if (!this.isValid(username)) {
				System.out.println("Username is not valid.");
				System.out.println("Must contain at least 2 characters and only letters and numbers.");
			} else if (this.database.userNameExists(username)) {
				System.out.println("That username already exists, please try a different one.");
			} else {
				notValid = false;
			}
		}

		System.out.println("Enter your desired password.");
		System.out.println("> ");
		password = this.scanner.nextLine();
		this.currentUser = new User(username, password, 0.0F);
	}

	private void login() {

		String username, password;
		boolean notValid = true;

		while (notValid) {

			System.out.print("Username: ");
			username = this.scanner.nextLine();
			System.out.print("Password: ");
			password = this.scanner.nextLine();

			if ((this.currentUser = this.database.authenticate(username, password)) != null)
				notValid = false;
			else
				System.out.println("Authentication failed, incorrect username and/or password.");
		}
	}

	private void modifyAccount() {

		boolean loggedIn = true;
		System.out.printf("Welcome %s\n", this.currentUser.getUsername());
		System.out.printf("Account Balance: %0.2f\n", this.currentUser.getBalance());
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("3: ");
		System.out.println("0: Logout");

		while (loggedIn) {

			switch (this.promptNumber(0, 3)) {

			}
		}
	}

	private void deposit() {}
	private void withdraw() {}


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


	private boolean isValid(String entry) {

		if (entry.length() < 2)
			return false;
		for (char ch : entry.toCharArray())
			if (!Character.isLetter(ch) && !Character.isDigit(ch))
				return false;
		return true;
	}

}
