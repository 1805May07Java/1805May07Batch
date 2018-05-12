/*
 * BankMachine.java
 * Author: Cole Vikupitz
 *
 * Class that represents an ATM machine connected to the banking
 * database that allows users to create and login to accounts and
 * deposit/withdraw money.
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

	// Display the banking system's main menu
	private void displayMainMenu() {

		System.out.println("\n----- Revature Banking System -----");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("0: Exit");
	}

	// Display the currently signed on user's info and a menu
	private void displayAccountMenu() {

		System.out.printf("\nLogged in as %s\n", this.currentUser.getUsername());
		System.out.printf("Account Balance: $%.2f\n", this.currentUser.getBalance());
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("0: Logout");
	}

	/**
	 * Runs the banking machine, allowing user interaction.
	 */
	public void run() {

		boolean running = true;
		this.displayMainMenu();

		while (running) {
			// Prompt user for desired option
			switch (this.promptNumber(0, 2)) {
				// Login the user
				case 1:
					this.login();
					break;
				// Create a new user
				case 2:
					this.createUser();
					break;
				// Shut down the machine
				case 0:
					running = false;
					break;
				// Invalid option, do nothing
				default:
					break;
			}
		}

		// Save all database records to file before shutdown
		this.database.saveDBtoFile(FileUtility.FILE);
	}

	/*
	 * Prompts the user for a new username and password and creates a
	 * new account for the user on success.
	 */
	private void createUser() {

		String username = "", password = "";
		boolean notValid = true;

		// Prompt the user to enter a new username
		System.out.println("Enter new account information ('-' to cancel).");
		while (notValid) {
			// Get desired username
			System.out.print("New Username: ");
			username = this.scanner.nextLine();
			// Cancels the request
			if (username.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// Check for validity - minimum length, no illegal characters, etc.
			if (!this.isValid(username)) {
				System.out.println("Username is not valid.");
				System.out.println("Must contain at least 2 characters and only letters and numbers.");
			} else if (this.database.userNameExists(username)) {
			// Username already exists
				System.out.println("That username already exists, please try a different one.");
			} else {
				notValid = false;
			}
		}

		notValid = true;
		while (notValid) {
			// Get desired password
			System.out.print("New Password: ");
			password = this.scanner.nextLine();
			// Cancels the request
			if (password.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// Check for validity - minimum length, no illegal characters, etc.
			if (!this.isValid(password)) {
				System.out.println("Password is not valid.");
				System.out.println("Must contain at least 2 characters and only letters and numbers.");
			} else {
				notValid = false;
			}
		}

		// Creates the new account, updates database, logs user in
		this.currentUser = new User(username, password, 0.0F);
		this.database.addUser(this.currentUser);
		this.modifyAccount();
	}

	/*
	 * Prompts the user for their username, password, then authenticates the
	 * given user information.
	 */
	private void login() {

		String username, password;
		boolean notValid = true;

		System.out.println("Authenticate user (type '-' to cancel).");
		while (notValid) {

			// Prompt user for their username
			System.out.print("Username: ");
			username = this.scanner.nextLine();
			// Cancels the request
			if (username.equals("-")) {
				this.displayMainMenu();
				return;
			}

			// Prompts the user for their password
			System.out.print("Password: ");
			password = this.scanner.nextLine();
			// Cancels the request
			if (password.equals("-")) {
				this.displayMainMenu();
				return;
			}

			// Authenticate user info
			// Sign user on if successful, print error if failed
			if ((this.currentUser = this.database.authenticate(username, password)) != null)
				notValid = false;
			else
				System.out.println("Authentication failed, incorrect username and/or password.");
		}

		this.modifyAccount();
	}

	/*
	 * Prompt menu that allows a logged in user to make deposits and withdraws
	 * on their account.
	 */
	private void modifyAccount() {

		boolean loggedIn = true;
		this.displayAccountMenu();

		while (loggedIn) {

			switch (this.promptNumber(0, 2)) {
				// User requests to make a deposit
				case 1:
					this.deposit();
					break;
				// User requests to withdraw money
				case 2:
					this.withdraw();
					break;
				// User signs off
				case 0:
					this.currentUser = null;
					this.displayMainMenu();
					return;
				// Invalid option, do nothing
				default:
					break;
			}
		}
	}

	/*
	 * Prompts the user for a deposit amount, and updates their account
	 * accordingly.
	 */
	private void deposit() {

		boolean notValid = true;
		String line;
		double amount = 0.0F;

		System.out.println("Enter the deposit amount ('-' to cancel).");
		while (notValid) {

			System.out.print("> ");
			try {
				// Prompt the user for a deposit amount
				line = this.scanner.nextLine();
				// Cancels the request
				if (line.equals("-")) {
					this.displayAccountMenu();
					return;
				}
				// Parse the amount from the input
				amount = Double.parseDouble(line);
				if (amount > 0.0F) {
					// Deposit the money into the account
					this.currentUser.deposit(amount);
					notValid = false;
				} else {
					// Deposit amount invalid - display error
					System.out.println("Invalid entry, please enter a valid amount.");
				}
			} catch (NumberFormatException e) {
				// Failed to parse amount - display error
				System.out.println("Invalid entry, please enter a valid amount.");
			}
		}

		// Display success message, return to account menu
		System.out.printf("Successfully deposited $%.2f\n", amount);
		this.displayAccountMenu();
	}

	/*
	 * Prompts the user for an amount to withdraw, and updates their account
	 * accordingly.
	 */
	private void withdraw() {

		boolean notValid = true;
		String line;
		double amount = 0.0F;

		System.out.println("Enter the withdraw amount ('-' to cancel).");
		while (notValid) {

			System.out.print("> ");
			try {
				// Prompt the user for the desired amount
				line = this.scanner.nextLine();
				// Cancels the request
				if (line.equals("-")) {
					this.displayAccountMenu();
					return;
				}
				// Parse the entered amount
				amount = Double.parseDouble(line);
				if (amount > 0.0F) {
					// Attempt to withdraw amount from account
					// Print error if insufficient funds
					if (!this.currentUser.withDraw(amount)) {
						System.out.println("Sorry, your account has insufficient funds.");
					} else {
						notValid = false;
					}
				} else {
					// Amount specified invalid - print error
					System.out.println("Invalid entry, please enter a valid amount.");
				}
			} catch (NumberFormatException e) {
				// Failed to parse amount - print error
				System.out.println("Invalid entry, please enter a valid amount.");
			}
		}

		// Display success message, return to account menu
		System.out.printf("Sucessfully withdrew $%.2f\n", amount);
		this.displayAccountMenu();
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
	 * Returns true/false depending on whether 'entry' is a valid username
	 * or password. Is considered valid if it contains at least 2 characters,
	 * and contains only letters and numbers.
	 */
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
