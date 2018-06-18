package com.banking.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountServices {
	
//	This is were all the action happens for our banking services. 

	private IODAO dao = new IODAO();
	private ArrayList<Account> accounts;
	NumberFormat formatter = new DecimalFormat("#0.00"); 
	
	public AccountServices() {
		//load our accounts into our local arraylist
		accounts = dao.readAccounts();
		
		
	}
	
	 void logIn() {
		Scanner last = new Scanner(System.in);
		String username = "";
		String password = "";
		System.out.print(  "----------------------------------------------------" +"\n"
							+"Great lets get you logged in!" +"\n"
							+"Enter username: \t");
	
	
		//Accept the username. Check to see if it exists, if it doesn't we retry login
		username = last.nextLine();
		System.out.println();
		
		
		if(username.equals("")) {
			System.out.println("You didn't enter anything!");
			logIn();
		}else if(!exists(username)){
			System.out.println("Couldn't find it. Try Again");
			logIn();
		}else if(exists(username)){
			
			//Now we accept the password
			System.out.print("Enter password: \t");
			password = last.nextLine();
			while(!match(username, password)){
				
				System.out.println("password didn't match! Try Again");
				System.out.print("Enter password: \t");
				password = last.nextLine();
			}
			
			System.out.println("Account Accessed!");
			System.out.println();
			modifyBank(getByUsername(username));
			
		}
		
		
		
		
	}
	 
	 boolean match(String username, String input) {
		 Account temp = getByUsername(username);
		 if(temp.getPassword().equals(input)) {
			 return true;
		 }else {
			 return false;
		 }
	 }

	 Account getByUsername(String username) {
		 return accounts.stream().
					filter(s -> s.getUsername().equalsIgnoreCase(username)).
						findFirst().get();
	 }
	
	boolean exists(String input) {
		//we look through our arraylist for matching username
		return  accounts.stream().anyMatch(
				s -> s.getUsername().equalsIgnoreCase(input));
	}
	
	 void signUp() {
		 //Create user in the arraylist and IODAO
		 Scanner user = new Scanner(System.in);
		 System.out.print(   "------------------------------------------------" +"\n"
							+"Great lets get you Signed Up!" +"\n"
							+"Enter desired username: \t");
		 String username = user.nextLine();
		 if(exists(username)) {
			 System.out.println("Username already exists! Try Again");
			 signUp();
		 } else {
			 System.out.print("Enter desired password: \t");
			 String password = user.nextLine();
			 System.out.println();
			 
			 //gives password. Check to see if input is given.
			 while(password.equals("")) {
				 System.out.println("You didn't enter anything! TryAgain");
				 System.out.print("Enter desired password: \t");
				 password = user.nextLine();
				 System.out.println();
			 }
			 
			 //Add this account to our arrayList as well as our IODAO
			 Account temp = new Account(username, password);
			 dao.addAccount(temp);
			 accounts.add(temp);
			 
			 //Signed Up!
			 System.out.println("Accounts made!");
			 modifyBank(temp);
		 }
		
	}
	 
	 void logOff(Account user) {
		 System.out.println( "Thanks for banking with us! \n"
				 			+"Would you like to: \n"
				 			+"----------------------------\n"
				 			+"1: Log Off \n"
				 			+"2: Make a transaction \n"
				 			+"----------------------------\n");
		 Scanner s = new Scanner(System.in);
		 int option = 0;
			try {
				
				option = Integer.parseInt(s.nextLine());
				
				}catch(NumberFormatException nfe) {
					System.out.println("!!INVALID INPUT!! Try Again! ");
					logOff(user);
				}
			
			//Checks if Integer is a valid option if not run through again
			
			switch(option) {
			case 1: System.out.println("Have a nice day!!");
			dao.editAccount(user); //edit the changes
			//dao.serializeRoster(); //Send to back up
			break; //Log Off
			case 2: modifyBank(user); 
			break; //back to modifyBank for another transaction
			default: System.out.println("Sorry, that's not an option. Please try again");
			logOff(user);
			}
			
			
			
	 }
	
	private void modifyBank(Account user) {
		//Allows for withdraw or deposit
		//CHANGE: ONLY ALLOW 2 DECIMAL PLACES WITHOUT ROUNDING
		Scanner reader = new Scanner(System.in);
		 System.out.print(   "------------------------------------------------" +"\n"
				 			+"Your current balance is: $" +formatter.format(user.getBalance()) +"\n" 
							+"Let's Edit your account!" +"\n"
							+"Select the desired option: \n"
							+"------------------------------------------------" +"\n"
							+"1: Withdraw \n"
							+"2: Deposit \n"
							+"------------------------------------------------" +"\n");
		
		 int option = 0;

		 try {
			 	
				option = Integer.parseInt(reader.nextLine());
				
				}catch(NumberFormatException nfe) {
					System.out.println("!!INVALID INPUT!! Try Again!");
					modifyBank(user);
				}
		 
		 
		 switch(option) {
			case 1:  
				withdraw(user);
				break; //Withdraw
			
			
			case 2:  
				deposit(user);
				break; //Deposit
			
			
			default: System.out.println("Sorry, that's not an option. Please try again");
			modifyBank(user);
			}
		 
		 
		 
	}
	private void withdraw (Account user) {
		System.out.println("How much would you like to withdraw?"); 
		Scanner input = new Scanner(System.in);
		double amount = 0;
		
		//make sure the input is an integer
		try {
			amount = Double.parseDouble(input.nextLine());
			}catch(NumberFormatException nfe) {
				System.out.println("!!INVALID INPUT!! Try Again! ");
				withdraw(user);
			}
		//Check if the amount is sufficient
		if(amount > user.getBalance()) {
			System.out.println("You don't have enough money! Withdraw Less!");
			withdraw(user);
		}else if(amount < 0) {
			System.out.println("Enter a positive amount!");
			withdraw(user);
		}else {
			user.setBalance(user.getBalance() - amount);
			System.out.println("Your new balance is: $" +formatter.format(user.getBalance()));
			System.out.println();
			logOff(user);
		}
		
		
		}
	private void deposit(Account user) {
		System.out.println("How much would you like to deposit?");
		Scanner input = new Scanner(System.in);
		double amount = 0;
		
		//make sure the input is an integer
		try {
			amount = Double.parseDouble(input.nextLine());
			}catch(NumberFormatException nfe) {
				System.out.println("!!INVALID INPUT!! Try Again! ");
				deposit(user);
			}
		//Check if the amount is sufficient
		if(amount < 0) {
			System.out.println("Enter a positive amount!");
			deposit(user);
		}else {
			user.setBalance(user.getBalance() + amount);
			System.out.println("Your new balance is: $" +formatter.format(user.getBalance()));
			System.out.println();
			logOff(user);
		}
		
	}
}









