package com.rev.bank;
import com.rev.pojos.Account;
import com.rev.pojos.Customer;
import com.rev.pojos.JointAccount;
import java.util.Scanner;

import com.rev.service.AccountService;
import com.rev.service.CustomerService;

public class App {
	static Scanner scan = new Scanner(System.in);
	private static final String String = null;
	static AccountService as = new AccountService();
	static CustomerService cs = new CustomerService();
	
	public static void main(String[] args) {

		start();
		
	}

	static void start(){
		System.out.println("Welcome to Acme Bank!"
				+ "\n"
				+ "\nPlease login or create an account:"
				+ "\n1: Log In"
				+ "\n2: Create Account");

		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
		}

		switch(op) {
		case 1: logIn(); break;
		case 2: createAccount(); break;
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		scan.close();
	}

	static void logIn() {
		//Scanner in = new Scanner(System.in);
		System.out.println("Logging in....\n"
				+ "Enter your username:");
//		String username = in.nextLine();
//		if(as.exists(username)) {
//			System.out.println("That username is not recognized. Please try again.");
//			logIn(); 
//		}
//		else {
//			Account acct = as.getByUsername(username);
//			//System.out.println(acct.toString());
//			System.out.println("Enter your password");
//			String password = in.nextLine();
			// test if password is valid
		
//			if(acct.getPassword().equals(password)) {
//				doThings();
//			}
//			else {
//				System.out.println("Sorry, your password was incorrect. try again");
				//logIn();
			}
		//}

	//}
	
	static void createAccount() {

		//Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String username = scan.nextLine();
		
			System.out.println("Thanks, " + username + ". What type of account would you like to setup?");
				
			System.out.println("Please choose an option below:"
					+ "\n"
					+ "\n1. Joint Account"
					+ "\n2. Checking Account"
					+ "\n3. Savings Account"
					+ "\n4. Credit Account");
							
				int ap = 0;
				try {
					ap = Integer.parseInt(scan.nextLine());
				}
				catch(NumberFormatException nfe) {
					//nfe.printStackTrace();
					System.out.println("Sorry, that's not an option. Please try again");
					start();
				}
				switch(ap) {
				case 1: AccountService.jointAccount(ap); break;
				case 2: AccountService.checkingAccount(ap); break;
				case 3: AccountService.savingsAccount(ap); break;
				case 4: AccountService.creditAccount(ap); break;
				default: System.out.println("Sorry, that's not an option. Please try again");
				
				}
				
			double balance;
			//int type = scan.nextInt();
			System.out.println("Thanks, " + username + ". Please enter a password.");
			String password =  scan.nextLine();
			System.out.println("Please enter an initial deposit ammount.");
			String gp = scan.nextLine();
			
			try{
				balance = Double.parseDouble(gp); // do input validation
			}
			catch(NumberFormatException nfe) {
				nfe.printStackTrace();
				System.out.println("that wasn't a valid amount");
				balance = 200;
			}
			//add account type
			Account account = AccountService.addAccount(username, password, ap, balance);
			
			doThings(account);
		}
		
	
	
	static void doThings(Account s) {
		// change user info or whatever
		System.out.println("Please choose an option below"
				+ "\n"
				+ "\n1. Check Balance"
				+ "\n2. Deposit Funds"
				+ "\n3. Withdraw Funds"
				+ "\n4. Logout");
		
		//Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException nfe) {
			//nfe.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
		}
		
		switch(op) {
		case 1: getBalance(s); break;
		case 2: depositFunds(s); break;
		case 3: withdrawFunds(s); break;
		case 4: logOut(); break;
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		scan.close();
		}
	
public static double getBalance(Account s) {
	System.out.println("Account current balance: " + s.getBalance());
	return s.getBalance();
	
}

public static void depositFunds(Account s) {
    double balance = getBalance(s);
    //Scanner scan = new Scanner(System.in);
    System.out.println("Current balance: " + balance);
    System.out.println("Please enter the sum of money you wish to deposit in your account: ");

    s.balance = s.balance + Double.parseDouble(scan.nextLine());

   //s.getBalance(balance);

    System.out.println("New account balance: " + getBalance(s));
    scan.close();
}

public static void withdrawFunds(Account s) {
	System.out.println("Please enter the sum of money you wish to withdraw: ");
	double balance = getBalance(s);
   // Scanner scan = new Scanner(System.in);
    double amount = Double.parseDouble(scan.nextLine());
    System.out.println("Current balance: " + balance);
    

    	if(amount < balance) {
    	balance = s.balance - amount ;
    	
    	} else {
    		System.out.println("Sorry, that amount is larger than your current balance.");
    		
    	}

    //s.getBalance(balance);

    //System.out.println("New account balance: " + Account.getBalance(balance));
    //scan.close();
   
 }	
	
	static void logOut() {
		System.out.println("Thank you!");
		//serialize student roster
	}
	
}
