package com.proj0.main;

import java.util.List;
import java.util.Scanner;

import com.proj0.pojo.Account;
import com.proj0.pojo.User;
import com.proj0.service.AccountService;
import com.proj0.service.AccountTypeService;
import com.proj0.service.UsersService;

public class App {
	// static instances of my 3 Service Layer classes 
	static AccountService as = new AccountService();
	static AccountTypeService ats = new AccountTypeService();
	static UsersService us = new UsersService();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		startApp(sc);
		sc.close();
	}

	public static void startApp(Scanner sc) {
		boolean running = true;
		System.out.println("Welcome to Revature Bank\n");
		String userOption;
		do {
			System.out.println("Please select from one of the three options:\n"
					+ "---\n"
					+ "1. Log in \n"
					+ "2. Create new user account\n"
					+ "3. Exit Application");
			userOption = sc.nextLine();
			switch(userOption) {
			case "1": 
				logIn(sc);
				break;
			case "2": 
				signUp(sc);
				break;
			case "3":
				running = false;
				break;
			default: 
				System.out.println("Not a valid option!");
				continue;
			}
		} while (running);
		System.out.println("Thank you for banking with Revature Bank");
	}
	/* Logs in to user account */
	public static void logIn(Scanner sc) {
		System.out.println("Please enter your e-mail: ");
		String email = sc.nextLine();
		String passwordInput, accountPassword;
		if (!us.emailExists(email)) { // Email does not exist in our database
			System.out.println("Our records indicate the given e-mail does not exist in our database");
		} else {
			// load user object with given email
			// prompt password, check with password found in database
			User u = us.getUserByEmail(email);
			accountPassword = u.getPassword();
			System.out.println("Enter password: ");
			passwordInput = sc.nextLine();
			if (passwordInput.equals(accountPassword)) {
				userDashboard(sc, u);
			} else {
				System.out.println("Incorrect credentials!");
			}
		}
	}
/* User has elected to create a new account */
	public static void signUp(Scanner sc) {
		String firstName, lastName, email, password;
		System.out.println("Thank you for choosing Revature Bank!\n"
				+ "Please enter your email");
		email = sc.nextLine();
		if (us.emailExists(email)) { //check if email already exists in Users table
			System.out.println("Our records indicate that " + email + " already has an account with Revature Banking");
		} else {
			// proceed
			System.out.println("Please enter your password");
			password = sc.nextLine();
			System.out.println("Please enter your first name");
			firstName = sc.nextLine();
			System.out.println("Please enter your last name");
			lastName = sc.nextLine();
			us.insertAccount(firstName, lastName, email, password);
		}
	}
/* Screen when the user logs in */
	public static void userDashboard(Scanner sc, User u) {
		boolean loggedIn = true;
		String userOption;
		System.out.println("Welcome to your account " + u.getFirstName() + " " + u.getLastName() + "\n");
		do {
			System.out.println("1. View your bank accounts\n"
					+ 		   "2. Create a new bank account\n"
					+ 		   "3. Log out");
			userOption = sc.nextLine();
			switch(userOption) {
			case "1" : 
				allAccountsView(sc, u);
				break;
			case "2" :
				createNewBankAccount(sc, u);
				break;
			case "3":
				return;
			default : 
				System.out.println("Not a valid option!");
				continue;
			}
			//	loggedIn = false;
		}while(loggedIn);	
	}
	/* Pulls up all accounts owned by the user and prompts them for action */
	public static void allAccountsView(Scanner sc, User u) {
		String userOption;
		List<Account> accounts = as.getAccounts(u.getUserId());
		if (accounts.size() == 0) {
			System.out.println("You have no accounts! ");
		} else {
			System.out.println("These are your accounts: ");
			printAccounts(accounts);
			System.out.println("---\nTo perform an action, please enter the number next to your account, or press 0 to go back");
			userOption = sc.nextLine();
			int numberOfAccounts = accounts.size();
			try {
				int numberOfUserOption = Integer.parseInt(userOption);
				if (numberOfUserOption <= numberOfAccounts && numberOfUserOption > 0) { // user has selected a valid option within the range
					int adjustedIndex = numberOfUserOption - 1; //since our choices are 1-based and the arraylist is 0-based
					Account a = accounts.get(adjustedIndex);
					accountView(sc, a);
				} else if (numberOfUserOption == 0) {
					//exit from this menu
					return;
				} else {
					System.out.println(numberOfUserOption + " is not a valid option!");
				}
			} catch (NumberFormatException e) {
				System.out.println(userOption + " is not a valid option!");
			}
		}
	}
	/* Given an account, pull up the account and prompt the user to see if they wish to do anything */
	public static void accountView(Scanner sc, Account a) {
		String userOption;
		System.out.println("What would you like to do?\n"
				+ "1. Withdraw money\n"
				+ "2. Deposit money\n");
		userOption = sc.nextLine();
		int amountOfTransaction;
		try {
			switch(userOption) {
			case "1":
				System.out.println("Enter the amount you wish to withdraw");
				userOption = sc.nextLine();
				amountOfTransaction = Integer.parseInt(userOption);
				as.withdraw(a, amountOfTransaction);
				break;
			case "2":
				System.out.println("Enter the amount you wish to deposit");
				userOption = sc.nextLine();
				amountOfTransaction = Integer.parseInt(userOption);
				as.deposit(a, amountOfTransaction);
				break;
			default :
				System.out.println("Not a valid option!");
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Not a valid amount!");
		}
	}
	/* Prints to the console all bank accounts the user currently has in the database */
	public static void printAccounts(List<Account> accounts) {
		for(int i = 0; i < accounts.size(); i++) {
			Account a = accounts.get(i);
			System.out.println((i+1) + " <"+ats.getAccountTypeLabel(a.getAccountTypeId())+"> BALANCE: $" + a.getBalance());
		}
	}
/* Creates a new, empty bank account with user_id set as the User u's userId */
	public static void createNewBankAccount(Scanner sc, User u) {
		System.out.println("Revature Bank supports the following accounts: \n"
				+ "1. CHECKING\n"
				+ "2. SAVINGS\n"
				+ "3. CREDIT\n"
				+ "To create an account, press the number next to the account types listed");
		// in the future, i would not hardcode, and instead grab values directly from AccountType table for scalability
		String userOption = sc.nextLine();
		switch(userOption) {
		case "1" :
			as.insertAccount(u.getUserId(), 1); //creates checking account
			System.out.println("Your new checking account has been created.");
			break;
		case "2" :
			as.insertAccount(u.getUserId(), 2); //creates savings account
			System.out.println("Your new savings account has been created.");
			break;
		case "3" :
			as.insertAccount(u.getUserId(), 3);
			System.out.println("Your new credit account has been created.");
			break;
		default :
			System.out.println("Not a valid account type");
		}

	}
}
