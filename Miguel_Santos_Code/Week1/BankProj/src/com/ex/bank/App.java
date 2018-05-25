package com.ex.bank;

import java.util.Scanner;


public class App {
	
	static Scanner input = new Scanner(System.in);
	static BankServices bs = new BankServices();

	public static void main(String[] args) {
		
		System.out.println("Welcom to MCS Banking!");
		start();
		//doThings();
		//logout();
		
	}

	private static void doThings(User u) {
		int select = 0;
		double amt = 0;
		String to;
		Scanner inp = new Scanner(System.in);
		
		System.out.println("What would you like to do?"
							+ "\n1: Check Balance"
							+ "\n2: Withdraw"
							+ "\n3: Deposit"
							+ "\n4: Transfer Balance"
							+ "\n5: Logout");
		try {
			select = Integer.parseInt(inp.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option. Please try again. outside switch");
			doThings(u);
		}
		
		switch(select) {
		case 1: System.out.println("You have a balance of: $" + String.format("%.2f", u.getBalance())); 
				break;
		case 2: System.out.println("What is the amount you would like to withdraw?");
				amt = input.nextDouble();
				if (amt > u.getBalance()) {
					System.out.println("Insufficient funds...");
					break;
				}
				bs.withdraw(u, amt); 
				break;
		case 3: System.out.println("What is the amount you would like to deposit?");
				amt = input.nextDouble();
				bs.deposit(u, amt);
				break;
		case 4: System.out.println("Enter the username of the user you want to transfer to:");
				to = inp.nextLine();
				if (!bs.validUsername(to) || to.equalsIgnoreCase(u.getUsername())) {
					System.out.println("Sorry, that user does not exist.");
					break;
				}
				System.out.println("What is the amount you would like to transfer?");
				amt = input.nextDouble();
				if (amt > u.getBalance()) {
					System.out.println("Insufficient funds...");
					break;
				}
				bs.withdraw(u, amt);
				bs.deposit(bs.findByUsername(to), amt);
				break;
		case 5: logout();
		default: System.out.println("Sorry, that is not an option. Please try again. in switch"); 
		}
		doThings(u);
	}

	private static void start() {
		
		String ans;
		System.out.println("Would you like to create a new account with us?");
		ans = input.nextLine().toLowerCase();
		if( ans.charAt(0) == 'y') {
			createAccount();
		}
		else if (ans.charAt(0) == 'n') {
			System.out.println("You must be an existing user");
			login();
		}
		else {
			System.out.println("I'm sorry, I didn't quite understand that.");
			start();
		}
		
	}

	private static void login() {
		
		String un, pw;
		User user;
		boolean temp;
		System.out.println("Please Log in.");
		do {
			System.out.println("Enter your username:");
			un = input.nextLine();
			if(temp = !bs.validUsername(un)) {
				System.out.println("I'm sorry, '" + un +"' was not found. Please try again.");
			}
		}while(temp);
		do {
			System.out.println("Enter your password:");
			pw = input.nextLine();
			if(temp = !bs.validUnPw(un,pw)) {
				System.out.println("I'm sorry, that password is incorrect. Please try again.");
			}
		}while(temp);
		user = bs.findByUsername(un);
		System.out.println("Successfully Logged in."
							+ "\nWelcome " + user.getFn() + " " + user.getLn() + ".");
		doThings(user);
		
	}

	private static void createAccount() {		

		String un, pw, fn, ln;
		boolean temp;
		System.out.println("Ok. Let's start with some basic information."
							+ "What is your first name?");
		fn = input.nextLine();
		System.out.println("And your last name?");
		ln = input.nextLine();
		System.out.println("Hello " + fn + " " + ln + "." );
		do {
			System.out.println("Please enter your desired username");
			un = input.nextLine();
			if(temp = bs.validUsername(un)) {
				System.out.println("I'm sorry, that username has already been taken. Please choose a different username.");
			}
		}while(temp);
		System.out.println("Great! Please provide a password for your account.");
		pw = input.nextLine();
		bs.addStudent(fn, ln, un, pw);
		System.out.println("You have successfully created an account.");
		login();

	}
	
	private static void logout() {
		System.out.println("Logging Out.");
		input.close();
		bs.close();
	}

}
