package com.revature.dao;

import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		scanner.close();
	}

	static void start() {

		System.out.println("Welcome to our student app!");
		System.out.println("What would you like to do?");
		System.out.println("1: Log In");
		System.out.println("2: Sign Up");

		int op = 0;
		try {
			op = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Sorry, that's not a valid option.");
			start();
		}

		switch (op) {

		case 1:
			login();
			break;
		case 2:
			signUp();
			break;
		default:
			System.out.println("Sorry, that's not a valid option.");
			start();
		}
	}

	static void login() {

		System.out.println("Logging in...");
		String username = scanner.nextLine();
		// Check fr existing...


	}

	static void signUp() {}
}
