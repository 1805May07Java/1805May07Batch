package com.ex.run;

import java.util.Scanner;
import java.util.UUID;

import com.ex.pojo.Account;
import com.ex.service.AccountService;
import com.ex.service.Account_UserService;
import com.ex.service.UserService;

public class App {
	static Scanner scan = new Scanner(System.in);
	static UUID activeAccount = null;

	public static void main(String[] args) {
		int choice;
		boolean userHasChosenValidOption = false;
		
		while(!userHasChosenValidOption) {
			System.out.println("Bank of Java");
			System.out.println("1: Login\n2: New Account");
			choice = scan.nextInt();
			switch(choice) {
			case 1: login(); userHasChosenValidOption = true; break;
			case 2: processNewAccount(); userHasChosenValidOption=true; break;
			default: userHasChosenValidOption=false;
			}
		}
		
	}
	
	public static void login() {
		Scanner scan = new Scanner(System.in);
		String uname;
		String pwd;
		System.out.println("Enter Username:");
		uname = scan.nextLine();
		System.out.println("Enter password");
		pwd = scan.nextLine();
		boolean loggedon = UserService.confirmLogin(uname, pwd);
		if(loggedon) {
			//get userid related to the uname and pwd entered
			UUID userid = UserService.getUserId(uname, pwd);
			System.out.println("userid:"+ userid);
			//get the account related to the userid from the accounts_users table
			UUID accountid = Account_UserService.getAccountId(userid);
			
			System.out.println("accountid" + accountid);
			
			activeAccount = accountid;
			
			printLoginMenu();
			int op = scan.nextInt();
			switch(op) {
				case 1: checkBalance(); break;
				case 2: deposit(); break;
				case 3: withdraw(); break;
				case 4: logout(); break;
				default: 
			}
						
		} else {
			System.out.println("Please try again");
			//put menu here
		}
		
	}
	
	public static void checkBalance() {
		System.out.println(AccountService.getBalance(activeAccount));
		
		printLoginMenu();
		int op = scan.nextInt();
		switch(op) {
			case 1: checkBalance(); break;
			case 2: deposit(); break;
			case 3: withdraw(); break;
			case 4: logout(); break;
			default: 
		}
		
		
	}
	
	public static void deposit() {
		double amount;
		System.out.println("How much: ");
		amount = scan.nextDouble();
		AccountService.deposit(activeAccount, amount);
		
		printLoginMenu();
		int op = scan.nextInt();
		switch(op) {
			case 1: checkBalance(); break;
			case 2: deposit(); break;
			case 3: withdraw(); break;
			case 4: logout(); break;
			default: 
		}
	}
	
	
	public static void withdraw() {
		double amount;
		System.out.println("How much: ");
		amount = scan.nextDouble();
		amount = amount - amount - amount;
		AccountService.deposit(activeAccount, amount);
		
		printLoginMenu();
		int op = scan.nextInt();
		switch(op) {
			case 1: checkBalance(); break;
			case 2: deposit(); break;
			case 3: withdraw(); break;
			case 4: logout(); break;
			default: 
		}

	}
		
	public static void logout() {
		activeAccount = null;
		
		int choice;
		boolean userHasChosenValidOption = false;
		
		while(!userHasChosenValidOption) {
			System.out.println("Bank of Java");
			System.out.println("1: Login\n2: New Account");
			choice = scan.nextInt();
			switch(choice) {
			case 1: login(); userHasChosenValidOption = true; break;
			case 2: processNewAccount(); userHasChosenValidOption=true; break;
			default: userHasChosenValidOption=false;
			}
		}

		
	}
	
	public static void printLoginMenu() {
		System.out.println("1: Check Balance");
		System.out.println("2: Deposit");
		System.out.println("3: Withdraw");
		System.out.println("4: Logout");
	}
	
	public static void processNewAccount() {
		Scanner scan = new Scanner(System.in);
		String accounttype;
		UUID userid = UUID.randomUUID();
		String fname;
		String lname;
		String uname;
		String pwd;
		UUID accountid = UUID.randomUUID();
		
		System.out.println("Enter account type: ");
		accounttype = scan.nextLine();
		System.out.println("First name: ");
		fname = scan.nextLine();
		System.out.println("Last Name: ");
		lname = scan.nextLine();
		System.out.println("Username(email): ");
		uname = scan.nextLine();
		System.out.println("Password: ");
		pwd = scan.nextLine();
		//create record in accounts table
		//create record in users table
		//create record in the Users_Accounts table
		AccountService.makeNewAccount(accountid,accounttype);
		UserService.makeNewUser(userid, uname, pwd, fname, lname);
		Account_UserService.makeNewAccount_User(accountid, userid);
		
		System.out.println("Any other owners of account?");
		String reply = scan.nextLine();
		if(reply.equalsIgnoreCase("yes")) {
			System.out.println("First name: ");
			fname = scan.nextLine();
			System.out.println("Last name: ");
			lname = scan.nextLine();
			System.out.println("User name(email): ");
			uname = scan.nextLine();
			System.out.println("Password: ");
			pwd = scan.nextLine();
		//use the previously generated account id
		 //make a new user and new account_user, but do not make a new account
			UUID userid2 = UUID.randomUUID();
			UserService.makeNewUser(userid2, uname, pwd, fname, lname);
			Account_UserService.makeNewAccount_User(accountid, userid2);
		} else {
			System.out.println("Thank you for making an account today.");
		}
		
		int choice;
		boolean userHasChosenValidOption = false;
		
		while(!userHasChosenValidOption) {
			System.out.println("Bank of Java");
			System.out.println("1: Login\n2: New Account");
			choice = scan.nextInt();
			switch(choice) {
			case 1: login(); userHasChosenValidOption = true; break;
			case 2: processNewAccount(); userHasChosenValidOption=true; break;
			default: userHasChosenValidOption=false;
			}
		}
				
	}

}
