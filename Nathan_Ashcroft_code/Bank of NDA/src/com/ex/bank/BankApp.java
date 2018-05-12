package com.ex.bank;

import java.util.Scanner;

public class BankApp {
	static BankService service = new BankService();
	static User curUser = new User();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		start();
		
		scan.close();
	}

	//Main menu
	static void start() {
		boolean loop = true;

		while(loop) {
			System.out.println("Welcome to Bank of NDA\n"
					+ "What would you like to do?\n"
					+ "1.) Sign in to an existing account\n"
					+ "2.) Sign up for a new account\n"
					+ "3.) Exit");


			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			switch(op) {
			case 1: login(); break;
			case 2: signUp(); break;
			case 3: loop = false; break;
			default: System.out.println("Sorry that is not an option"); break;
			}
		}
	}

	//Log in menu
	static void login() {
		boolean loop = true;

		while(loop) {

			System.out.println("Logging in...\nEnter your userName: ");
			String userName = scan.nextLine();

			if(!service.exists(userName)) {
				System.out.println("incorrect userName please try again");
			}
			else {
				System.out.println("Please enter your Password:");
				User u = service.getByUserName(userName);
				String pass = scan.nextLine();
				if (u.getPassword().equals(pass)) {
					curUser = u;
					loop = false;
					banking();
				}
				else {
					System.out.println("Your password is incorrect. Try again");
				}
			}
		}
	}

	//Banking menu
	static void banking() {
		boolean loop = true;

		while(loop) {

			System.out.println("Hello " + curUser.getfName() + " " + curUser.getlName() + " Welcome to your account.\n"
					+ "Your current balance is $" + curUser.getBalance() + "\n"
					+ "What do you want to do?\n"
					+ "1.) Deposit money.\n"
					+ "2.) Withdraw Money.\n"
					+ "3.) Log out\n");

			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			switch(op) {
			case 1: addMoney(); break;
			case 2: withdrawlMoney(); break;
			case 3: logOut(); loop = false; break;
			default: System.out.println("Sorry that is not an option"); break;
			}
		}
	}

	//add money to account
	static void addMoney() {
		boolean loop = true;

		while(loop) {

			System.out.println("Hello " + curUser.getfName() + " how much money would you like to deposit today?");
			double add = 0;
			try {

				add = Double.parseDouble(scan.nextLine());
			}
			catch(NumberFormatException nfe) {
				//nfe.printStackTrace();
				System.out.println("Sorry not a valid number please try again");
			}
			curUser.setBalance(curUser.getBalance() + add);
			service.updateUser(curUser);
			loop = false;
		}
	}

	//withdraw money from account
	static void withdrawlMoney() {
		boolean loop = true;

		while(loop) {

			System.out.println("Hello " + curUser.getfName() + " how much money would you like to deposit today?");
			double sub = 0;
			try {

				sub = Double.parseDouble(scan.nextLine());
			}
			catch(NumberFormatException nfe) {
				//nfe.printStackTrace();
				System.out.println("Sorry not a valid number please try again");
			}
			if(sub > curUser.getBalance()) {
				System.out.println("You do not have enough in your account.");
				loop = false;
			}
			else {
				curUser.setBalance(curUser.getBalance() - sub);
				service.updateUser(curUser);
				loop = false;
			}
		}
	}

	//Log out
	static void logOut() {
		System.out.println("Logging off....");
		curUser = null;
		curUser = new User();
	}

	//make a new account
	static void signUp() {
		boolean loop = true;

		while(loop) {

			System.out.println("Signing up...\nEnter a userName:");
			String userName = scan.nextLine();
			String password;
			String fName;
			String lName;

			if(!service.exists(userName)) {
				System.out.println("Enter a password\n(Must be between 6-15 characters: ");
				password = scan.nextLine();
				if (password.length() > 5 && password.length() < 16) {
					System.out.println("Enter your First Name:");
					fName = scan.nextLine();
					System.out.println("Enter your Last Name:");
					lName = scan.nextLine();

					curUser.setBalance(0);
					curUser.setfName(fName);
					curUser.setlName(lName);
					curUser.setPassword(password);
					curUser.setUserName(userName);
					service.addUser(fName, lName, userName, password);
					banking();
					loop = false;
				}
				else {
					System.out.println("Incorrect password size try again.");
					scan.close();
				}
			}
			else {
				System.out.println("Username Taken try a different one.");
				scan.close();
			}
		}
	}

}
