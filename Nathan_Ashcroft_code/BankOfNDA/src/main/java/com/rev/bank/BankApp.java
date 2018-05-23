package com.rev.bank;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.rev.pojos.Account;
import com.rev.pojos.User;

public class BankApp {
	private static bankService service = new bankService();
	private static User curUser = new User();
	private static ArrayList<Account> curAcc = new ArrayList<Account>();
	private static Scanner scan = new Scanner(System.in);
	private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
	
	/*static {
		formatter.setMinimumFractionDigits(2);
		formatter.setMaximumFractionDigits(2);
	}*/

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
					+ "3.) List of famous users\n"
					+ "4.) Exit");


			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			switch(op) {
			case 1: login(); break;
			case 2: signUp(); break;
			case 3: userList(); break;
			case 4: loop = false; break;
			default: System.out.println("Sorry that is not an option"); break;
			}
		}
	}

	private static void userList() {
		ArrayList<User> u = service.getUsers();
		System.out.println("This is the famous users of this bank you may recognize some names!");
		for(int i = 0; i < u.size(); i++) {
			System.out.println(u.get(i).getfName() + " " + u.get(i).getlName());
		}
		System.out.println("You too can add yoru name to the list!!!\n\n\n");
		
	}

	//Log in menu
	static void login() {
		boolean loop = true;

		while(loop) {

			System.out.println("Logging in...\nEnter your userName: ");
			String userName = scan.nextLine();

			if(!service.exists(userName)) {
				System.out.println("Invalid userName please try again");
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
					loop = false;
				}
			}
		}
	}

	private static void banking() {
		boolean loop = true;

		while(loop) {
			curAcc = service.getaccounts(curUser);
			if (curAcc.isEmpty()) {
				System.out.println("Hello " + curUser.getfName() + " " + curUser.getlName() + " You have no accounts you need to make a new account.");
				newAccount();
			}
			System.out.println("Hello " + curUser.getfName() + " " + curUser.getlName() + " Welcome to your account.\n");
			System.out.println("Account number\t\tBalance\t\t\tType");
			for (int i = 0; i < curAcc.size(); i++) {
				System.out.println(curAcc.get(i).getAccID() + "\t\t\t" 
						+ formatter.format(curAcc.get(i).getBalance()) + "\t\t\t" 
						+ service.getAccountType(curAcc.get(i).getAccType()));
			}
			System.out.println("What do you want to do?\n"
					+ "1.) Deposit money.\n"
					+ "2.) Withdraw Money.\n"
					+ "3.) Add An Account. \n"
					+ "4.) Log out\n");

			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			switch(op) {
			case 1: addMoney(); break;
			case 2: withdrawlMoney(); break;
			case 3: newAccount(); break;
			case 4: logOut(); loop = false; break;
			default: System.out.println("Sorry that is not an option"); break;
			}
		}

	}

	private static void logOut() {
		System.out.println("Logging off....");
		curUser = null;
		curUser = new User();
		curAcc.clear();

	}

	private static void signUp() {
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

					/*curUser.setfName(fName);
					curUser.setlName(lName);
					curUser.setPassword(password);
					curUser.setUserName(userName);*/
					service.addUser(fName, lName, userName, password);
					curUser = service.getByUserName(userName);

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

	private static void withdrawlMoney() {
		boolean loop = true;
		while(loop) {
			System.out.println("Which account would you like to withdrawl from (1 to go back)");
			System.out.println("Account number\t\tBalance\t\t\tType");
			for (int i = 0; i < curAcc.size(); i++) {
				System.out.println(curAcc.get(i).getAccID() + "\t\t\t" 
						+ formatter.format(curAcc.get(i).getBalance()) + "\t\t\t" 
						+ service.getAccountType(curAcc.get(i).getAccType()));
			}

			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			for (int i = 0; i < curAcc.size(); i++) {
				if (op == 1) {break;}
				if (curAcc.get(i).getAccID() == op)
				{
					System.out.println("How much would you like to withdraw?");
					double withdraw = 0;
					try {
						withdraw = Double.parseDouble(scan.nextLine());
					} catch(NumberFormatException nfe) {
						System.out.println("Sorry not an option please try again");
						break;
					}
					double newbal = 0;
					newbal = curAcc.get(i).getBalance() - withdraw;

					if (newbal < 0) {
						System.out.println("You cannot withdraw that much");
						break;
					}
					else {
						curAcc.get(i).setBalance(newbal);
						service.withMoney(curAcc.get(i));
						loop = false;
						break;
					}
				}
				else {
					if (i == (curAcc.size() -1)) {
						System.out.println("that account does not belong to you.");
					}
				}
			}
		}
	}

	private static void addMoney() {
		boolean loop = true;
		while(loop) {
			System.out.println("Which account would you like to Deposit money into (1 to go back)");
			System.out.println("Account number\t\tBalance\t\t\tType");
			for (int i = 0; i < curAcc.size(); i++) {
				System.out.println(curAcc.get(i).getAccID() + "\t\t\t" 
						+ formatter.format(curAcc.get(i).getBalance()) + "\t\t\t" 
						+ service.getAccountType(curAcc.get(i).getAccType()));
			}

			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}

			for (int i = 0; i < curAcc.size(); i++) {
				if (op == 1) {break;}
				if (curAcc.get(i).getAccID() == op)
				{
					System.out.println("How much would you like to Deposit?");
					double deposit = 0;
					try {
						deposit = Double.parseDouble(scan.nextLine());
					} catch(NumberFormatException nfe) {
						System.out.println("Sorry not an option please try again");
						break;
					}
					double newBal = 0;
					newBal = curAcc.get(i).getBalance() + deposit;

					curAcc.get(i).setBalance(newBal);
					service.addMoney(curAcc.get(i));
					
					loop = false;
					break;

				}
				else {
					if (i == (curAcc.size() -1)) {
						System.out.println("that account does not belong to you.");
					}
				}
			}
		}

	}

	private static void newAccount() {
		boolean loop = true;
		while (loop) {
			System.out.println("Welcome " + curUser.getfName() + " " + curUser.getlName() + " "
					+ "Welcome to the Bank of NDA\nWhat type of account do you want to create?\n"
					+ "1. Credit.\n"
					+ "2. Savings (Bonus $10).\n"
					+ "3. Checking (Bonus $5).");
			
			int op = 0;

			try {
				op = Integer.parseInt(scan.nextLine());
			} catch(NumberFormatException nfe) {
				System.out.println("Sorry not an option please try again");
			}
			Account a;
			
			switch(op) {
			case 1: a = new Account(1, curUser.getUserID(), 0);
					service.addAccount(a);
					curAcc.add(a); 
					loop = false;
					break;
			case 2: a = new Account(2, curUser.getUserID(), 10);
					service.addAccount(a);
					curAcc.add(a); 
					loop = false;
					break;
			case 3: a = new Account(3, curUser.getUserID(), 5); 
					service.addAccount(a);
					curAcc.add(a); 
					loop = false;
					break;
			default: System.out.println("Sorry that is not an option"); break;
			}
		}

	}

}
