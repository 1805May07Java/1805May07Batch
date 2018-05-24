package com.ex.run;

import java.util.Scanner;

import com.ex.pojos.BankAccount;
import com.ex.pojos.BankUser;
import com.ex.service.AccountService;
import com.ex.service.AccountTypeService;
import com.ex.service.UserService;

public class App 
{
	static Scanner scan = new Scanner(System.in);
	static UserService us = new UserService();
	static AccountTypeService ts = new AccountTypeService();
	static AccountService as = new AccountService();

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Big Banking app!");
		
		run();

	}

	private static void run() 
	{
		System.out.println("---------Main Menu----------\n"
				+ "1. Sign up\n"
				+ "2. Log in\n" );

		int option = Integer.parseInt(scan.nextLine());
		
		if (option == 1)
		{
			signUp();
		}
		else if(option == 2)
		{
			logIn();
		}
		else
		{
			System.out.println("That was not a valid input, please try again.");
			run();
		}
		
	}
	
	static void signUp()
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your First name:\n");
		String firstName = in.nextLine();
		System.out.println("Please enter your Last name:\n");
		String lastName = in.nextLine();
		System.out.println("Please enter a username:\n");
		String username = in.nextLine();
		if(!us.unique(username))
		{
			System.out.println("That name already exists, please pick another.");
			signUp();
			return;
		}
		else
		{
			System.out.println("Please enter your password:\n");
			String password = in.nextLine();
			System.out.println("Please enter your email:");
			String email = in.nextLine();
			System.out.println("What kind of account would you like to initially create?\n" +
								"1: Checking\n" + 
								"2: Savings\n" + 
								"3: Credit");
			int at = Integer.parseInt(scan.nextLine());
			System.out.println(at);
			if((at != 1) && (at != 2) && (at != 3))
			{
				System.out.println("That was an invaild entry, creating a checking account by default.");
				at = 1;
			}
			
			System.out.println("Please enter your initial account balance:\n");
			double balance = 0;
			try{
				balance = in.nextDouble();
			}catch(NumberFormatException nfe)
			{
				System.out.println("Not a valid balance.");
			}
			BankAccount acc = new BankAccount(at, balance);
			acc = as.addAccount(acc);
			BankUser next = new BankUser(firstName, lastName, username, email, password);
			next = us.addUser(next);
			as.addUserAccount(next, acc);
			
		}
		
		logIn();
	}
	
	static void logIn()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Logging in.....\n" + "Enter your username: ");
		String username = in.nextLine();
		if(!us.exists(username))
		{
			System.out.println("Not a valid user, please try again");
			logIn();
		}
		else
		{
			//get user object
			BankUser person = us.getByUsername(username);
			System.out.println("Enter your password: ");
			String password = in.nextLine();
			//test if pw is valid
			if(person.getPassword().equals(password))
			{
				doThings(person);
			}
			else
			{
				System.out.println("Sorry, your password was incorrect.  Please try again");
				logIn();
			}
		}	
		
	}
	
	static void doThings(BankUser s)
	{
		System.out.println();
		System.out.println("What would you like to do?\n" + 
							"1: Check balance.\n" +
							"2: Withdraw\n" +
							"3: Deposit\n" +
							"4: Create a new account\n" +
							"5: Link a joint account\n" +
							"6: Log Out");
		Scanner scan = new Scanner(System.in);
		int op = 0;
		String answer;
		try {
			op = Integer.parseInt(scan.nextLine());
			
		} catch (NumberFormatException nfe) {
			System.out.println("Sorry, that's not an option. Please try again.");
			doThings(s);
			return;
		}
		
		switch(op)
		{
			case 1: as.checkBalance(s);
				doThings(s);
				break;
			case 2: as.withdraw(s);
				doThings(s);
				break;
			case 3: as.deposit(s);
				doThings(s);
				break;
			case 4: as.createAccount(s);
				doThings(s);
				break;
			case 5: as.linkAccount(s);
				doThings(s);
				break;
			case 6: logOut();
				break;
			default: System.out.println("Sorry, that's not an option.");
			doThings(s);
		}
		System.out.println();
		
		scan.close();
	}
	
	static void logOut()
	{
		System.out.println("Good bye.");
		
	}

}
