package com.rev.ui;

import java.io.Closeable;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.rev.service.User;

public class ConsoleUI implements Closeable {

	private Scanner in;
	private PrintStream out;
	private User user;
	
	public ConsoleUI(InputStream source, PrintStream out) {
		this.in = new Scanner(source);
		this.out = out;
		this.user = null;
	}
	
	public void start() {
		
		login();

		options();
		
	}

	private void login() {
		
		while (user == null) {
			out.print("Please enter your email: ");
			String email = in.nextLine();
			
			if (User.exists(email)) {
				out.print("Enter your password: ");
				String password = in.nextLine();
				user = User.getUser(email, password);
				
				if (user == null) {
					out.println("Username or Password was wrong. Please try again.");
					continue;
				}
			} else {
				out.print("Email not found, would you like to create a new account(Y/N): ");
				String ans = in.nextLine();
				
				if (Character.toUpperCase(ans.charAt(0)) != 'Y') {
					continue;
				}
				
				out.print("Enter a password: ");
				String p1 = in.nextLine();
				out.print("Re-enter the password: ");
				String p2 = in.nextLine();
				
				if (!p1.equals(p2)) {
					out.println("Error, passwords do not match.");
					continue;
				}
				
				out.print("Enter your first name: ");
				String firstName = in.nextLine();
				
				out.print("Enter your last name: ");
				String lastName = in.nextLine();
				
				user = User.createUser(email, firstName, lastName, p1);
			}
		}
	}
	
	private void options() {
		
		boolean shouldContinue = true;
		
		out.println();
		out.println("Welcome " + user.getFirstName());
		
		while (shouldContinue) {

			long balance = user.getBalance();

			out.printf("Your balance is $%d.%02d\n", balance / 100, balance % 100);
			out.println("What would you like to do?");
			out.println("1) deposit");
			out.println("2) withdraw");
			out.println("0) exit");
			out.print("Enter your choice: ");
			
			String choice = in.nextLine();
			out.println();
			
			switch(choice) {
			case "0":
				shouldContinue = false;
				break;
				
			case "1":
				deposit();
				break;
				
			case "2":
				withdraw();
				break;
				
			default:
				out.println("That wasn't a valid choice.");
			}
		}
		
	}

	private void deposit() {
		out.print("Enter an amount to deposit: ");
		
		long value;
		
		try {
			value = asMoney(in.nextLine());
		} catch (NumberFormatException e) {
			out.println("Error, invalid value.\n");
			return;
		}
		
		try {
			user.deposit(value);
			System.out.printf("Deposited $%d.%02d\n\n", value / 100, value % 100);
		} catch (IllegalArgumentException e) {

			if (value < 0) {
				out.println("Error, cannot deposit negative values.\n");
			} else {
				out.println("Error, unkown error.");
			}
		}
		
	}

	private void withdraw() {

		out.print("Enter an amount to withdraw: ");
		
		long value;
		
		try {
			value = asMoney(in.nextLine());
		} catch (NumberFormatException e) {
			out.println("Error, invalid value.\n");
			return;
		}
		
		try {
			user.withdraw(value);
			System.out.printf("Withdrew $%d.%02d\n\n", value / 100, value % 100);
		} catch (IllegalArgumentException e) {
			if (value < 0) {
				out.println("Error, cannot withdraw negative values.\n");
			} else if (value > user.getBalance()) {
				out.println("Error, you cannot withdraw that much.\n");
			} else {
				out.println("Error, unkown error.");
			}
		}
	}

	private long asMoney(String value) {
		
		String[] values = value.split("\\.");
		
		long result;
		
		if (values.length == 1) {
			result = Integer.parseInt(values[0]) * 100;
		} else if (values.length == 2) {
			
			if (values[0].length() == 0) {
				values[0] = "0";
			}
			
			if (values[1].length() == 1) {
				values[1] = values[1] + "0";
			} else if (values[1].length() == 0) {
				values[1] = "00";
			} else if (values[1].length() != 2) {
				throw new NumberFormatException();
			}
			
			result = Long.parseLong(values[0]) * 100;
			
			if (values[0].charAt(0) == '-' ) {
				result -= Long.parseLong(values[1]);
			} else {
				result += Long.parseLong(values[1]);
			}
		} else {
			throw new NumberFormatException();
		}
		
		return result;
	}
	
	@Override
	public void close() {
		in.close();
	}
	
}
