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

	// Scanner object used for user input
	private Scanner scanner;
	// Instance (connection) of the banking database containing all users
	private BankDatabase database;
	// Keeps track of the currently logged in user
	private User currentUser;

	// Constructor
	public BankMachine() {

		// Create scanner for user input
		this.scanner = new Scanner(System.in);
		// Connect to the banking database
		this.database = BankDatabase.getInstance();
		// Load all user records into database
		this.database.loadDBfromFile(FileUtility.FILE);
		// Keeps track of currently logged in user
		this.currentUser = null;
	}

	private void displayMainMenu() {

		System.out.println("\n----- Revature Banking System -----");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("0: Exit");
	}

	private void displayAccountMenu() {

		System.out.printf("Logged in as %s\n", this.currentUser.getUsername());
		System.out.printf("Account Balance: $%.2f\n", this.currentUser.getBalance());
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("0: Logout");
	}

	public void run() {

		boolean running = true;
		this.displayMainMenu();

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

		// Save all database records to file
		this.database.saveDBtoFile(FileUtility.FILE);
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

		notValid = true;
		System.out.println("Enter your desired password.");
		while (notValid) {
			System.out.print("> ");
			password = this.scanner.nextLine();
			if (!this.isValid(password)) {
				System.out.println("Password is not valid.");
				System.out.println("Must contain at least 2 characters and only letters and numbers.");
			} else {
				notValid = false;
			}
		}

		this.currentUser = new User(username, password, 0.0F);
		this.database.addUser(this.currentUser);
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
		this.displayAccountMenu();

		while (loggedIn) {

			switch (this.promptNumber(0, 2)) {
				case 1:
					this.deposit();
					break;
				case 2:
					this.withdraw();
					break;
				case 0:
					this.currentUser = null;
					this.displayMainMenu();
					return;
				default:
					break;
					// FIXME - Should anything happen here?
			}
		}
	}

	private void deposit() {

		boolean notValid = true;
		double amount;

		System.out.println("Enter the deposit amount.");
		while (notValid) {

			System.out.print("> ");
			try {
				amount = Double.parseDouble(this.scanner.nextLine());
				if (amount > 0.0F) {
					this.currentUser.deposit(amount);
					notValid = false;
				} else {
					System.out.println("Invalid entry, please enter a valid amount.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, please enter a valid amount.");
			}
		}

		this.displayAccountMenu();
	}

	private void withdraw() {

		boolean notValid = true;
		double amount;

		System.out.println("Enter the withdraw amount.");
		while (notValid) {

			System.out.print("> ");
			try {
				amount = Double.parseDouble(this.scanner.nextLine());
				if (amount > 0.0F) {
					if (!this.currentUser.withDraw(amount)) {
						System.out.println("Not enough money in account to satisfy amount.");
					} else {
						notValid = false;
					}
				} else {
					System.out.println("Invalid entry, please enter a valid amount.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry, please enter a valid amount.");
			}
		}

		this.displayAccountMenu();
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


	private boolean isValid(String entry) {

		// String must be at least 2 characters long
		if (entry.length() < 2)
			return false;
		// String must contain only letters and numbers
		for (char ch : entry.toCharArray())
			if (!Character.isLetter(ch) && !Character.isDigit(ch))
				return false;
		return true;
	}

}
