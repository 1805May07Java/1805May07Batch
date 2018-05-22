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

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.AccountDao;
import com.revature.dao.UserProfileDao;
import com.revature.pojos.Account;
import com.revature.pojos.UserProfile;

public class BankMachine {

	// Scanner allowing users to interact with machine
	private Scanner scanner;
	// The currently logged in user
	private UserProfile currentUser;
	// The current account being modified
	private Account currentAccount;
	// List of all logged in user's accounts
	private ArrayList<Account> accounts;

	public BankMachine() {

		this.scanner = new Scanner(System.in);
		this.currentUser = null;
		this.currentAccount = null;
		this.accounts = null;
	}

	// Run the bank machine
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
	}

	// Display the banking system's main menu
	private void displayMainMenu() {

		System.out.println("\n----- Revature Banking System -----");
		System.out.println("1: Login");
		System.out.println("2: Create Account");
		System.out.println("0: Exit");
	}

	private void fetchAccounts() {

		this.accounts = AccountDao.getUserAccounts(this.currentUser.getId());
	}

	// Display the currently signed on user's info and a menu
	private void displayAccountMenu() {

		int count = 2;

		System.out.printf("\nWelcome %s %s\n",
				this.currentUser.getFirstName(), this.currentUser.getLastName());
		System.out.printf("Logged in as %s\n", this.currentUser.getUsername());
		System.out.println("1: Create Account");
		for (Account temp : this.accounts)
			System.out.printf("%d: %s\n", count++, temp.toString());
		System.out.println("0: Logout");
	}

	// Prompts user for their full name, username, and password
	private void createUser() {

		String firstName, lastName, username, password;

		// Prompt user for their first name
		System.out.println("Enter new account information ('-' to cancel).");
		while (true) {
			System.out.print("First Name: ");
			firstName = this.scanner.nextLine();
			// User cancels the prompt
			if (firstName.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// Check for validity
			if (this.entryIsValid(firstName))
				break;
			System.out.println("First name is not valid.");
			System.out.println("Must be 2-24 characters and only letters and numbers.");
		}

		// Prompt the user for their last name
		while (true) {
			System.out.print("Last Name: ");
			lastName = this.scanner.nextLine();
			// User cancels the prompt
			if (lastName.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// Check for validity
			if (this.entryIsValid(lastName))
				break;
			System.out.println("Last name is not valid.");
			System.out.println("Must be 2-24 characters and only letters and numbers.");
		}

		// Prompt the user for their username
		while (true) {
			System.out.print("Username: ");
			username = this.scanner.nextLine();
			// User cancels the prompt
			if (username.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// Check for validity
			if (!this.entryIsValid(username)) {
				System.out.println("Username is not valid.");
				System.out.println("Must be 2-24 characters and only letters and numbers.");
				continue;
			}
			// Check if username is unique
			if (UserProfileDao.usernameUnique(username))
				break;
			System.out.println("That username already exists, please try a different one.");
		}

		// Prompt the user for their password
		while (true) {
			System.out.print("Password: ");
			password = this.scanner.nextLine();
			if (password.equals("-")) {
				this.displayMainMenu();
				return;
			}
			// User cancels the prompt
			if (this.entryIsValid(password))
				break;
			System.out.println("Password is not valid.");
			System.out.println("Must be 2-24 characters and only letters and numbers.");
		}

		// Create the new user, upload to database
		UserProfileDao.addUserRecord(new UserProfile(0, firstName, lastName, username, password));
		this.currentUser = UserProfileDao.authenticate(username, password);
		this.modifyAccount();
	}

	// Prompts the user for their username and password
	// Authenticates the user's entered credentials
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

			// Authenticate the user credentials
			if ((this.currentUser = UserProfileDao.authenticate(username, password)) != null)
				notValid = false;
			// USername/password incorrect, print error and retry
			else
				System.out.println("Invalid username and password. Please try again.");
		}

		this.modifyAccount();
	}

	private void createAccount() {

		System.out.println("Select which account type you want.");
		System.out.println("1: Credit");
		System.out.println("2: Savings");
		System.out.println("3: Checking");
		System.out.println("0: Cancel");

		int type = this.promptNumber(0, 3);
		if (type == 0) {
			this.displayAccountMenu();
			return;
		}

		AccountDao.addAccountRecord(this.currentUser.getId(), type);
		this.fetchAccounts();
		this.displayAccountMenu();
	}

	// FIXME
	private void modifyAccount() {

		boolean loggedIn = true;

		this.fetchAccounts();
		this.displayAccountMenu();

		while (loggedIn) {
			int choice = this.promptNumber(0, this.accounts.size() + 1);
			if (choice == 0) {
				loggedIn = false;
			} else if (choice == 1) {
				this.createAccount();
			} else {
				this.currentAccount = this.accounts.get(choice - 2);
				this.configureAccount();
			}
		}

		this.currentUser = null;
		this.accounts = null;
		this.displayMainMenu();
	}

	private void displayConfMenu() {

		System.out.println("What would you like to do?");
		System.out.println("1: Deposit");
		System.out.println("2: Withdraw");
		System.out.println("3: View Balance");
		System.out.println("0: Return to Account");
	}

	private void configureAccount() {

		boolean flag = true;
		this.displayConfMenu();

		while (flag) {

			switch (this.promptNumber(0, 3)) {
				case 0:
					flag = false;
					break;
				case 1:
					this.deposit();
					break;
				case 2:
					this.withdraw();
					break;
				case 3:
					System.out.printf("Current Balance: $%.2f\n", this.currentAccount.getBalance());
					break;
			}
		}

		this.displayAccountMenu();
	}

	private void deposit() {

		boolean notValid = true;
		String line;
		double amount = 0.0;

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
				if (amount > 0.0) {
					// Deposit the money into the account
					this.currentAccount.deposit(amount);
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
		System.out.printf("Successfully deposited $%.2f\n\n", amount);
		AccountDao.updateAccount(this.currentAccount);
		this.displayConfMenu();
	}

	private void withdraw() {

		boolean notValid = true;
		String line;
		double amount = 0.0;

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
				if (amount > 0.0) {
					// Attempt to withdraw amount from account
					// Print error if insufficient funds
					if (!this.currentAccount.withdraw(amount)) {
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
		System.out.printf("Sucessfully withdrew $%.2f\n\n", amount);
		AccountDao.updateAccount(this.currentAccount);
		this.displayAccountMenu();
	}

	// Prompts the user for an integer within the range [min, max]
	// Continues to prompt the user until a valid integer is entered
	// The specified integer is then returned
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

	// Returns true/false if 'entry' is valid
	// Valid if 2-24 characters long, and contains only letters and numbers
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