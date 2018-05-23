package com.Banking.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import com.Banking.pojos.Account;
import com.Banking.pojos.Checking;
import com.Banking.pojos.Credit;
import com.Banking.pojos.Savings;
import com.Banking.service.AccountService;
import com.Banking.service.CheckingService;
import com.Banking.service.CreditService;
import com.Banking.service.SavingsService;

public class Controller {
	
		static Scanner scan = new Scanner(System.in);
		static AccountService account= new AccountService();
		static CheckingService checking= new CheckingService();
		static SavingsService savings = new SavingsService();
		static CreditService credit = new CreditService();
		static NumberFormat formatter = new DecimalFormat("#0.00"); 
	
	public void start() {
		//Prompt user to see begin log in or sign up
		System.out.println(  "Let's Begin by creating or accessing your account."   +"\n"
							+"Please give the number input for the desired option:" +"\n"
							+"----------------------------------------------------" +"\n"
							+"1: Log In (Must have existing account)" +"\n"
							+"2: Sign Up" +"\n"
							+"----------------------------------------------------" );
		
		//Take the user input to see what should be done
		int input = 0;
		//Checks if input is an Integer
		try {
			
			input = Integer.parseInt(scan.nextLine());
			
			}catch(NumberFormatException nfe) {
				System.out.println("!!INVALID INPUT!! Try Again! ");
				start();
			}
		
		//Checks if Integer is a valid option if not run through again
		
		switch(input) {
		case 1: logIn(); break; //Log In
		case 2:	signUp(); break; //Sign Up
		default: System.out.println("Sorry, that's not an option. Please try again");
		start();
		}
		
		
		
		
	}
	
	public void logIn() {
		
		String username = "";
		String password = "";
		System.out.println();
		System.out.print(  "----------------------------------------------------" +"\n"
							+"Great lets get you logged in!" +"\n"
							+"Enter username: \t");
	
	
		//Accept the username. Check to see if it exists, if it doesn't we retry login
		username = scan.nextLine();
		System.out.println();
		
		
		if(username.equals("")) {
			System.out.println("You didn't enter anything!");
			logIn();
		}else if(!account.exists(username)){
			System.out.println("Couldn't find it. Try Again");
			logIn();
		}else if(account.exists(username)){
			
			//Now we accept the password
			System.out.print("Enter password: \t");
			password = scan.nextLine();
			while(!account.match(username, password)){
				
				System.out.println("password didn't match! Try Again");
				System.out.print("Enter password: \t");
				password = scan.nextLine();
			}
			
			System.out.println("Account Accessed!");
			System.out.println();
			
			accountManage(account.getByUsername(username));
		}
	
		
		
		
	}

	public void signUp() {
		 //Create user in the arraylist
		 System.out.print(   "------------------------------------------------" +"\n"
							+"Great lets get you Signed Up!" +"\n"
							+"Enter desired username: \t");
		 String username = scan.nextLine();
		 if(account.exists(username)) {
			 System.out.println("Username already exists! Try Again");
			 signUp();
		 } else {
			 System.out.print("Enter desired password: \t");
			 String password = scan.nextLine();
			 System.out.println();
			 
			 //gives password. Check to see if input is given.
			 while(password.equals("")) {
				 System.out.println("You didn't enter anything! Try Again");
				 System.out.print("Enter desired password: \t");
				 password = scan.nextLine();
				 System.out.println();
			 }
			 
			 //get email. Check if input is given
			 System.out.print("Alright let's add an email to the account: \t");
			 String email = scan.nextLine();
			 while(email.equals("")) {
			 System.out.println("You didn't enter anything! Try Again");
			 System.out.print("Alright let's add an email to the account: \t");
			 email = scan.nextLine();
			 System.out.println();
			 }
			 
			 //Add this account to our arrayList as well as our IODAO
			 Account temp = new Account(username, password, email);
			 temp = account.addAccount(temp);
			 //Signed Up!
			 System.out.println("Accounts made!");
			 System.out.println(temp.getAccountid());
			 accountManage(temp);
		 }
		
	}

	public void accountManage(Account temp) {
			
		 System.out.print(   "------------------------------------------------" +"\n"
					+"Let's Edit your account!" +"\n"
					+"Select the desired option: \n"
					+"------------------------------------------------" +"\n"
					+"1: Checking \n"
					+"2: Savings \n"
					+"3: Credit \n"
					+"4: Log Off \n"
					+"------------------------------------------------" +"\n");

int option = 0;
try {
	 	
		option = Integer.parseInt(scan.nextLine());	
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again!");
			accountManage(temp);
		}

switch(option) {
	case 1:  
		if(!checking.exists(temp.getAccountid())) {
			System.out.println("You don't have a Checking Account with us!");
			addChecking(temp);
		}else {
		checking(checking.getById(temp.getAccountid()));
		}
		break; //checking
	
	
	case 2:  
		if(!savings.exists(temp.getAccountid())) {
			System.out.println("You don't have a Savings Account with us!");
			addSavings(temp);
		}else {
		savings(savings.getById(temp.getAccountid()));
		}
		break; //savings
		
	case 3:
		if(!credit.exists(temp.getAccountid())) {
			System.out.println("You don't have a Credit Account with us!");
			addCredit(temp);
		}else {
		credit(credit.getById(temp.getAccountid()));
		}
		break; //credit
		
	case 4:
		System.out.println("Good Bye!");
		break;
	
	default: System.out.println("Sorry, that's not an option. Please try again");
	accountManage(temp);
	}

	}

	private void addCredit(Account a) {
		String input = "";
		System.out.println(  "Make a Credit Account? :" +"\n"
				+" 1: Yes" +"\n"
				+" 2: No" +"\n");	
		
			input = scan.nextLine();
			switch(Integer.parseInt(input)) {
			case 1:  
				Credit temp = new Credit(a.getAccountid(), 0);
				temp = credit.addCredit(temp);
				credit(temp);
				break; //add
			case 2:  
				accountManage(a);
				break; //don't add
				
			default: System.out.println("Sorry, that's not an option. Please try again");
			addCredit(a);
			}
		
	}

	private void addSavings(Account a) {
		String input = "";
		System.out.println(  "Make a Savings Account? :" +"\n"
				+" 1: Yes" +"\n"
				+" 2: No" +"\n");	
		
			input = scan.nextLine();
			switch(Integer.parseInt(input)) {
			case 1:  
				Savings temp = new Savings(a.getAccountid(), 0);
				temp = savings.addSavings(temp);
				savings(temp);
				break; //add
			case 2:  
				accountManage(a);
				break; //don't add
				
			default: System.out.println("Sorry, that's not an option. Please try again");
			addSavings(a);
			}
		
	}

	private void addChecking(Account a) {
		String input = "";
		System.out.println(  "Make a Checking Account? :" +"\n"
				+" 1: Yes" +"\n"
				+" 2: No" +"\n");	
		
			input = scan.nextLine();
			switch(Integer.parseInt(input)) {
			case 1:  
				Checking temp = new Checking(a.getAccountid(), 0);
				temp = checking.addChecking(temp);
				checking(temp);
				break; //add
			case 2:  
				accountManage(a);
				break; //don't add
				
			default: System.out.println("Sorry, that's not an option. Please try again");
			addChecking(a);
			}
		
	}

	private void credit(Credit c) {
		 System.out.print(   "------------------------------------------------" +"\n"
		 			+"Your current balance is: $" +formatter.format(c.getBalance()) +"\n" 
					+"Let's Edit your credit!" +"\n"
					+"Select the desired option: \n"
					+"------------------------------------------------" +"\n"
					+"1: Withdraw \n"
					+"2: Deposit \n"
					+"------------------------------------------------" +"\n");

int option = 0;

try {	
		option = Integer.parseInt(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again!");
			credit(c);
		}

switch(option) {
	case 1:  
		withdraw(c);
		break; //Withdraw
	case 2:  
		deposit(c);
		break; //Deposit
	default: System.out.println("Sorry, that's not an option. Please try again");
	credit(c);
	}
	
		
	}

	private void savings(Savings s) {
		 System.out.print(   "------------------------------------------------" +"\n"
		 			+"Your current balance is: $" +formatter.format(s.getBalance()) +"\n" 
					+"Let's Edit your Savings!" +"\n"
					+"Select the desired option: \n"
					+"------------------------------------------------" +"\n"
					+"1: Withdraw \n"
					+"2: Deposit \n"
					+"------------------------------------------------" +"\n");

int option = 0;

try {	
		option = Integer.parseInt(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again!");
			savings(s);
		}

switch(option) {
	case 1:  
		withdraw(s);
		break; //Withdraw
	case 2:  
		deposit(s);
		break; //Deposit
	default: System.out.println("Sorry, that's not an option. Please try again");
	savings(s);
	}
	
		
	}

	private void checking(Checking c) {
		 System.out.print(   "------------------------------------------------" +"\n"
		 			+"Your current balance is: $" +formatter.format(c.getBalance()) +"\n" 
					+"Let's Edit your checking!" +"\n"
					+"Select the desired option: \n"
					+"------------------------------------------------" +"\n"
					+"1: Withdraw \n"
					+"2: Deposit \n"
					+"------------------------------------------------" +"\n");

int option = 0;

try {	
		option = Integer.parseInt(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again!");
			checking(c);
		}

switch(option) {
	case 1:  
		withdraw(c);
		break; //Withdraw
	case 2:  
		deposit(c);
		break; //Deposit
	default: System.out.println("Sorry, that's not an option. Please try again");
	checking(c);
	}
	
	}
	
	private void deposit(Checking c) {
	System.out.println("How much would you like to deposit?");
	double amount = 0;
	
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			deposit(c);
		}
	//Check if the amount is sufficient
	if(amount < 0) {
		System.out.println("Enter a positive amount!");
		deposit(c);
	}else {
		c.setBalance(c.getBalance() + amount);
		checking.update(c);
		System.out.println("Your new balance is: $" +formatter.format(c.getBalance()));
		System.out.println();
		accountManage(account.getById(c.getAccountID()));
	}
}

	private void withdraw(Checking j) {
	System.out.println("How much would you like to withdraw?"); 
	double amount = 0;
	
	if(j.getBalance() == 0) {
		System.out.println("You don't have any money in your account!");
		accountManage(account.getById(j.getAccountID()));
	}
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			withdraw(j);
		}
	//Check if the amount is sufficient
	if(amount > j.getBalance()) {
		System.out.println("You don't have enough money! Withdraw Less!");
		withdraw(j);
	}else if(amount < 0) {
		System.out.println("Enter a positive amount!");
		withdraw(j);
	}else {
		j.setBalance(j.getBalance() - amount);
		checking.update(j);
		
		System.out.println("Your new balance is: $" +formatter.format(j.getBalance()));
		accountManage(account.getById(j.getAccountID()));
	}
	
	
	
}

	private void deposit(Savings s) {
	System.out.println("How much would you like to deposit?");
	double amount = 0;
	
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			deposit(s);
		}
	//Check if the amount is sufficient
	if(amount < 0) {
		System.out.println("Enter a positive amount!");
		deposit(s);
	}else {
		s.setBalance(s.getBalance() + amount);
		savings.update(s);
		System.out.println("Your new balance is: $" +formatter.format(s.getBalance()));
		System.out.println();
		accountManage(account.getById(s.getAccountID()));
	}
	
}

	private void withdraw(Savings j) {
	System.out.println("How much would you like to withdraw?"); 
	double amount = 0;
	if(j.getBalance() == 0) {
		System.out.println("You don't have any money in your account!");
		accountManage(account.getById(j.getAccountID()));
	}
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			withdraw(j);
		}
	//Check if the amount is sufficient
	if(amount > j.getBalance()) {
		System.out.println("You don't have enough money! Withdraw Less!");
		withdraw(j);
	}else if(amount < 0) {
		System.out.println("Enter a positive amount!");
		withdraw(j);
	}else {
		j.setBalance(j.getBalance() - amount);
		savings.update(j);
		
		System.out.println("Your new balance is: $" +formatter.format(j.getBalance()));
		accountManage(account.getById(j.getAccountID()));
	}
	
}
	
	private void deposit(Credit c) {
	System.out.println("How much would you like to deposit?");
	double amount = 0;
	
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			deposit(c);
		}
	//Check if the amount is sufficient
	if(amount < 0) {
		System.out.println("Enter a positive amount!");
		deposit(c);
	}else {
		c.setBalance(c.getBalance() + amount);
		credit.update(c);
		System.out.println("Your new balance is: $" +formatter.format(c.getBalance()));
		System.out.println();
		accountManage(account.getById(c.getAccountID()));
	}
	
}

	private void withdraw(Credit j) {
	System.out.println("How much would you like to withdraw?"); 
	double amount = 0;
	if(j.getBalance() == 0) {
		System.out.println("You don't have any money in your account!");
		accountManage(account.getById(j.getAccountID()));
	}
	//make sure the input is an integer
	try {
		amount = Double.parseDouble(scan.nextLine());
		}catch(NumberFormatException nfe) {
			System.out.println("!!INVALID INPUT!! Try Again! ");
			withdraw(j);
		}
	//Check if the amount is sufficient
	if(amount > j.getBalance()) {
		System.out.println("You don't have enough money! Withdraw Less!");
		withdraw(j);
	}else if(amount < 0) {
		System.out.println("Enter a positive amount!");
		withdraw(j);
	}else {
		j.setBalance(j.getBalance() - amount);
		credit.update(j);
		
		System.out.println("Your new balance is: $" +formatter.format(j.getBalance()));
		accountManage(account.getById(j.getAccountID()));
	}
	
}
}
