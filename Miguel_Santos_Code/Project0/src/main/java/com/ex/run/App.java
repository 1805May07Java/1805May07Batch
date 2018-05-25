package com.ex.run;

import java.util.Scanner;

import com.ex.services.AcctServices;
import com.ex.services.UserServices;

public class App {

	static Scanner input = new Scanner(System.in);
	static UserServices us = new UserServices();
	static AcctServices as = new AcctServices();
	
	public static void main(String[] args) {
		System.out.println("Welcome to MCS Banking!");
		start();
	}

	private static void start() {
		String ans;
		System.out.println("Are you new with us?");
		ans = input.nextLine().toLowerCase();
		if(ans.charAt(0) == 'y')
			createUser();
		else if(ans.charAt(0) == 'n') {
			System.out.println("You must be an existing user");
			login();
		}
		else {
			System.out.println("I'm sorry, I didn't quite understand that.");
			start();
		}
	}

	private static void createUser() {
		String un, pw, fn, ln;
		boolean temp;
		System.out.println("Ok. Let's start with some basic information.");
		do {
			System.out.println("What is your first name?");
			fn = input.nextLine();
			if (temp = (fn.length() > 15))
				System.out.println("Sorry, must be 15 characters or less. Try again.");
		} while(temp);
		do {
			System.out.println("And your last name?");
			ln = input.nextLine();
			if(temp = (ln.length() > 16))
				System.out.println("Sorry, must be 16 characters or less. Try again.");
		}while(temp);
		do {
			System.out.println("Please enter your desired username");
			un = input.nextLine();
			if(temp = us.isTaken(un))
				System.out.println("Sorry, that username is taken. Try again.");
		}while(temp);
		pw = newPassword();
		us.addUser(fn, ln, un, pw);
		System.out.println("You have successfully created an account.");
		login();
	}

	private static String newPassword() {
		boolean temp;
		String pw = new String();
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=^~`_])(?=\\S+$).{8,}";
		do {
			System.out.println("Please provide a new password.\n"
							+ "*Must contain no whitespaces and at least:\n"
							+ "- 8 characters\n"
							+ "- 1 capital and lowercase letter\n"
							+ "- 1 special character (!@#$%^&+=^~`_)");
			pw = input.nextLine();
			if(temp = !pw.matches(pattern))
				System.out.println("Password does not meet requirements. Try again.");
		}while(temp);
		return pw;
	}

	private static void login() {
		String un, pw;
		int userid;
		boolean temp;
		System.out.println("Please Log in.");
		do {
			System.out.println("Enter your username:");
			un = input.nextLine();
			if(temp = !us.isTaken(un))
				System.out.println("Sorry, '" + un + "' was not found. Try again.");
		}while(temp);
		do {
			System.out.println("Enter your password:");
			pw = input.nextLine();
			if(temp = !us.validUnPw(un, pw))
				System.out.println("Sorry, password is incorrect. Try again.");
		}while(temp);
		System.out.println("Successfully logged in.");
		userid = us.findIdByUsername(un);
		while(true)
			menu(userid);
	}

	private static void menu(int id) {
		int select = 0;
		
		if(as.numOfAccts(id) == 0) {    		// check for new users w/ no accounts
			System.out.println("Let's start by making you a new account.");
			while(true) {
				try {
					createAccount(id);
					break;
				}
				catch(NumberFormatException nfe){
					System.out.println("Sorry, that is not an option. Try again.");
					continue;
				}
			}
		}
			
		System.out.println("MENU");
		System.out.println("What would you like to do?"
							+ "\n1: Check Balance(s)"
							+ "\n2: Withdraw"
							+ "\n3: Deposit"
							+ "\n4: Transfer Balance"
							+ "\n5: Create Account"
							+ "\n6: Change Password"
							+ "\n7: Logout");
		try { 
			select = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option. Try again.");
			return;
		}
		
		switch(select) {
		case 1:
			as.getAcctBal(id);
			break;
		case 2:
			withdraw(id);
			break;
		case 3:
			deposit(id);
			break;
		case 4:
			transfer(id);
			break;
		case 5:
			try {
				createAccount(id);
				break;
			}
			catch(NumberFormatException nfe) {
				System.out.println("Sorry, that is not an option. Try again.");
				break;
			}
		case 6:
			us.updatePw(id, newPassword());
			break;
		case 7:
			logout();
		default:
			System.out.println("Sorry, that is not an option. Try again.");
		}
	}

	private static void createAccount(int id) throws NumberFormatException {
		int select = 0;
		System.out.println("What type of account would you like to create?"
							+ "\n1: Savings"
							+ "\n2: Checking"
							+ "\n3: Credit");
		select = Integer.parseInt(input.nextLine());
		switch(select) {
		case 1: 
			if(as.hasAccount(id, select)) {
				System.out.println("Sorry, you already have an account of that type. Try again.");
				return;
			}
			else break;
		case 2: 
			if(as.hasAccount(id, select)) {
				System.out.println("Sorry, you already have an account of that type. Try again.");
				return;
			}
			else break;
		case 3: 
			if(as.hasAccount(id, select)) {
				System.out.println("Sorry, you already have an account of that type. Try again.");
				return;
			}
			else break;
		default: throw new NumberFormatException();
		}
		as.addAccount(id, select);
		System.out.println("Your account was successfully created.");
		return;
	}

	private static void logout() {
		System.out.println("Logging out.");
		input.close();
		System.exit(0);
	}

	private static void transfer(int id) {
		int sel1 =0, sel2 = 0;
		double amt = 0;
		System.out.println("From which account would like to transfer?"
				+ "\n1: Savings"
				+ "\n2: Checking"
				+ "\n3: Credit");
		try {
			sel1 = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option.");
			return;
		}
		if(invalidAcctSelect(id, sel1))
			return;
		System.out.println("To which account would like to transfer?"
				+ "\n1: Savings"
				+ "\n2: Checking"
				+ "\n3: Credit");
		try {
			sel2 = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option.");
			return;
		}
		if(sel1 == sel2) {
			System.out.println("You can't transfer to the same account. Try again.");
			return;
		}
		if(invalidAcctSelect(id, sel2))
			return;
		System.out.println("Enter the amount you would like to transfer:");
		try {
			amt = Double.parseDouble(input.nextLine());
		} 
		catch(NumberFormatException nfe) {
			System.out.println("Error: Invalid input");
			return;
		}
		if (amt > as.getBalance(id, sel1)) {
			System.out.println("Insufficient funds.");
			return;
		}
		else
			as.transfer(amt, id, sel1, sel2);
		return;
	}
	
	private static void deposit(int id) {
		int select = 0;
		double amt = 0;
		System.out.println("To which account would like to deposit?"
							+ "\n1: Savings"
							+ "\n2: Checking"
							+ "\n3: Credit");
		try {
			select = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option.");
			return;
		}
		if(invalidAcctSelect(id, select))
			return;
		System.out.println("Enter the amount you would like to deposit:");
		try {
			amt = Double.parseDouble(input.nextLine());
		} 
		catch(NumberFormatException nfe) {
			System.out.println("Error: Invalid input");
			return;
		}
		as.deposit(amt, id, select);
		return;
	}

	private static void withdraw(int id) {
		int select = 0;
		double amt = 0;
		System.out.println("From which account would like to withdraw?"
							+ "\n1: Savings"
							+ "\n2: Checking"
							+ "\n3: Credit");
		try {
			select = Integer.parseInt(input.nextLine());
		}
		catch(NumberFormatException nfe) {
			System.out.println("Sorry, that is not an option.");
			return;
		}
		if(invalidAcctSelect(id, select))
			return;
		System.out.println("Enter the amount you would like to withdraw:");
		try {
			amt = Double.parseDouble(input.nextLine());
		} 
		catch(NumberFormatException nfe) {
			System.out.println("Error: Invalid input");
			return;
		}
		if (amt > as.getBalance(id, select)) {
			System.out.println("Insufficient funds.");
			return;
		}
		else
			as.withdraw(amt, id, select);
		return;
	}
	
	private static boolean invalidAcctSelect(int id, int select) {
		switch(select) {
		case 1: 
			if(!as.hasAccount(id, select)) {
				System.out.println("Sorry, you don't have an account of that type. Try again.");
				return true;
			}
			else return false;
		case 2: 
			if(!as.hasAccount(id, select)) {
				System.out.println("Sorry, you don't have an account of that type. Try again.");
				return true;
			}
			else return false;
		case 3: 
			if(!as.hasAccount(id, select)) {
				System.out.println("Sorry, you don't have an account of that type. Try again.");
				return true;
			}
			else return false;
		default: 
			System.out.println("Sorry, that is not an option.");
			return true;
		}
	}
}
