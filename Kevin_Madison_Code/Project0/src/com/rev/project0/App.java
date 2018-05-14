package com.rev.project0;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	// intialize service object
	static AccountService service = new AccountService();

	// main class to run Account app
	public static void main(String[] args) {

		// get info from console to create new Account object. and allow them to log in

		start();

	}

	static void start() {
		System.out.println("|| Welcome to 'Simple Bank'!" + "\n|| What would you like to do?" + "\n|| 1: Log In"
				+ "\n|| 2: Sign up");

		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
			scan.close();
			return;
		}

		switch (op) {
		case 1:
			logIn();
			break;
		case 2:
			signUp();
			break;
		default:
			System.out.println("Sorry, that's not an option. Please try again");
			start();
			scan.close();
			return;
		}
		scan.close();
	}

	static void logIn() {
		Scanner in = new Scanner(System.in);
		System.out.print("Logging in....\n" + "Enter your username:");
		String username = in.nextLine();
		if (!service.exists(username)) {
			System.out.println("You arent a user. please try again");
			logIn();
		} else {
			Account stud = service.getByUsername(username);

			// printing the current user
			// System.out.println(stud.toString());

			System.out.print("Enter your password: ");
			String password = in.nextLine();
			// test if password is valid
			if (stud.getPassword().equals(password)) {
				loggedIn(stud);
			} else {
				System.out.println("Sorry, your password was incorrect. try again");
				logIn();
			}
		}

	}

	/*
	 * SignUp()
	 * 
	 */
	static void signUp() {
		// instantiate scanner
		Scanner scan = new Scanner(System.in);

		// get user's first name
		System.out.print("First Name: ");
		String fn = scan.nextLine();

		// get user's last name
		System.out.print("Last Name: ");
		String ln = scan.nextLine();

		// get user's preffered username and check to see if it's unique
		System.out.print("Enter your username: ");
		String username = scan.nextLine();
		if (service.exists(username)) {
			System.out.println("sorry, that username is taken,");
			signUp();
		} else {
			// username is unqiue, so get the user's password.
			System.out.println("Thanks, " + username + ". What's your password?");
			String password = scan.nextLine();
			System.out.print("How much money would you like to open your account with? ($5.00 min)");
			String initialBalance = scan.nextLine();
			double balance = 0;
			try {
				balance = Double.parseDouble(initialBalance); // do input validation
				if (balance < 5.0) {
					System.out.println("Please enter an amount greater than $5.00."
							+ "\nPlease try to sign up again with enough money.");
					signUp();
				} else if (balance > 250000.00) {
					System.out.println("That is too much money for one account."
							+ "\nPlease tyry to sign up again with less than $250,000.");
				}
			} catch (NumberFormatException nfe) {
				// nfe.printStackTrace();
				System.out.println(
						"That was not a valid amount of money. Please sign up again with enough money next time.");
				signUp();
			}
			Account Account = service.addAccount(fn, ln, username, password, balance);
			loggedIn(Account);
		}
		// login or dothings

	}

	static void loggedIn(Account s) {
		// retrieve account information
		String fn = s.getFn();
		String ln = s.getLn();
		Double balance = s.getBalance();

		// change user info or whatever
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		System.out.println("-----------------------------------------------------------");
		System.out.println("||Welcome " + fn + "_" + ln + " to your personal bank account.");
		System.out.println("||You currently have: $" + decimalFormat.format(balance));
		System.out.println("-----------------------------------------------------------");

		System.out.print("||--------------------------||" + "\n||What would you like to do?||"
				+ "\n|| 1: Withdrawl             ||" + "\n|| 2: Deposit               ||"
				+ "\n|| 3: Log Out               ||" + "\n||--------------------------||\n" + "Option: ");

		Scanner keyboard = new Scanner(System.in);
		int response = 0;
		response = keyboard.nextInt();
		// keyboard.close();

		switch (response) {
		case 1:
			withdrawl(s);
			break;
		case 2:
			deposit(s);
			break;
		case 3:
			logOut(s);
			return;
		default:
			System.out.println("Enter a valid response.");
			break;
		}
		loggedIn(s);

	}

	private static void withdrawl(Account s) {
		System.out.println("You currently have: " + s.getBalance());
		System.out.print("\nHow much would you like to withdrawl?" + "\n$");

		Scanner keyboard = new Scanner(System.in);

		double withdrawlAmount = keyboard.nextDouble();
		double newBalance = s.getBalance() - withdrawlAmount;
		if (newBalance < 0) {
			System.out.println("You cannout withdrawl money that you don't have.");
		} else if (newBalance < 5) {
			System.out.println("!!! You must leave at least $5 in your account to maintain an open account.");
		} else {
			s.setBalance(newBalance);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			System.out.println("\n-----------------------------------------" + "\n||You successfully withdrew $"
					+ withdrawlAmount + "." + "\n||Your new balance is now: $" + decimalFormat.format(s.getBalance())
					+ "." + "\n-----------------------------------------\n");
			service.updateBalance(s);
		}

	}

	private static void deposit(Account s) {
		System.out.println("You currently have: " + s.getBalance());
		System.out.print("\nHow much would you like to deposit?" + "\n$");

		Scanner keyboard = new Scanner(System.in);
		double deposit = keyboard.nextDouble();
		double newBalance = s.getBalance() + deposit;
		if (newBalance > 250000.0) {
			System.out.println("The amount you entered will exceed your $250,000 limit.");
		} else if (newBalance < s.getBalance()) {
			System.out.println("You cannot deposit negative amounts of money.");
		} else {
			s.setBalance(newBalance);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			System.out.println("\n-----------------------------------------" + "\n||You successfully deposited $"
					+ deposit + "." + "\n||Your new balance is now: $" + decimalFormat.format(s.getBalance()) + "."
					+ "\n-----------------------------------------\n");
			service.updateBalance(s);

		}

		return;

	}

	static void logOut(Account s) {
		System.out.println("You have successfully logged out. \nThank you!");
		service.updateBalance(s);

		return;
		// serialize Account roster
	}

}
