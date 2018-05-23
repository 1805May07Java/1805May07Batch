package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BankAccountDAO;
import dao.DAO;
import dao.UserDAO;
import dao.User_BankAccount_DAO;
import pojo.BankAccount;
import pojo.User;
import service.Service;

public class BankingApp {
	public static void main(String[] args) {
		start();
	}

	/**
	 * 
	 * This function 'starts' the app. It goes through the basic menu and acts as the starting point for the rest of the app.
	 */
	static void start(){
		System.out.println("The Banking App!"
				+ "\nMenu - select your option"
				+ "\n1: Log In"
				+ "\n2: Sign up");

		Scanner scan = new Scanner(System.in);
		int option = 0;

		start_loop:
			while(true) {
				try {
					option = Integer.parseInt(scan.nextLine());

					switch(option) {
					case 1: logIn(); break start_loop;
					case 2: signUp(); break start_loop;
					case 3: break start_loop;
					default: System.out.println("Sorry, that's not an option. Please try again");
					}
				}
				catch(NumberFormatException nfe) {
					//nfe.printStackTrace();
					System.out.println("Sorry, that's not an option. Please try again");
				}
			}
		scan.close();
	}

	/**
	 * 
	 * This function will walk the user through to sign up.
	 * Currently this function runs on an infinite loop and forces the user to give valid inputs.
	 */
	static void signUp() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your username");
		String username = scan.nextLine();

		// Make sure username is valid
		while(true) {
			if(Service.findUser(username) != null) {
				System.out.println("sorry, that username is taken,\nEnter a differnt username");
				username = scan.nextLine();
			}
			else {
				break;
			}
		}

		// Ask the user for his first, last name, and his password
		System.out.println("What is your first name?");
		String firstname = scan.nextLine();
		System.out.println("What is your last name");
		String lastname = scan.nextLine();
		// Get the account type
		printAccountType();
		String account_type = scan.nextLine();
		while(!(account_type.equals("1") || account_type.equals("2") || account_type.equals("3"))) {
			System.out.println("Not a valid option.");
			printAccountType();
			account_type = scan.nextLine();
		}
		int accounttype = Integer.parseInt(account_type);
		// Get a password from the user
		System.out.println("Thanks, " + firstname + " " + lastname + "\nWhat's your password?");
		String password =  scan.nextLine();

		
		
		// Add the user to our users list and to the users.txt file
		User u = new User(username, password, firstname, lastname);
		Service.addNewUser(u, accounttype);

		System.out.println("Returning to the menu\n");
		start();
	}

	/**
	 * 
	 * This function logs the user into his account.
	 * This function runs an infinite loop, and the user must input the correct username and corresponding password to break out.
	 * After a valid username and password, the user will go to the log-in menu.
	 */
	static void logIn() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Log-in Menu\n"
				+ "Enter username:");
		String username = scan.nextLine();
		while(Service.findUser(username) == null) {
			System.out.println("You arent a user. please try again:");
			username = scan.nextLine();
		}

		System.out.println("Enter password:");
		User u = Service.findUser(username);
		String password = scan.nextLine();
		
		while(!Service.findUser(username).getPassword().equals(password) /*&& !UserDAO.getPassword(username).equals(password)*/) {
			System.out.println("Wrong password, try again:");
			password = scan.nextLine();;
		}

		logInMenu(Service.findUser(username));
	}

	/**
	 * 
	 * This function is the log-in menu, similar to start(). The user will have 4 choices:
	 * 1. See the user's account info
	 * 2. Deposit money in to balance
	 * 3. Withdraw money out of balance
	 * 4. Log out
	 * 
	 * @param u The User object
	 */
	static void logInMenu(User u) {

		printLogInMenu();
		Scanner scan = new Scanner(System.in);
		int option = 0;

		start_loop:
			while(true) {
				try {
					option = Integer.parseInt(scan.nextLine());

					switch(option) {
					case 1: getUserInfo(u);
							printLogInMenu();
							continue start_loop;
							
					case 2: updateBalance(u, 0);
							printLogInMenu(); 
							continue start_loop;
							
					case 3: updateBalance(u, 1);
							printLogInMenu(); 
							continue start_loop;
							
					case 4: addBankAccount(u);
							printLogInMenu(); 
							continue start_loop;
						
					case 5: break start_loop;
					default: System.out.println("Sorry, that's not an option. Please try again:");
					}
				}
				catch(NumberFormatException nfe) {
					//nfe.printStackTrace();
					System.out.println("Sorry, that's not an option. Please try again:");
				}
			}
		System.out.println("Logging out \nClosing the app");
		scan.close();
	}

	/**
	 * 
	 * This function will allow the User to either deposit or withdraw money.
	 * The program inputs the option for the User so that they don't mess with it directly.
	 * option == 0, The user wants to deposit money
	 * option == 1, The user wants to withdraw money
	 * Any other option results in the function returning early. 
	 * 
	 * @param u The User that wants to update their balance
	 * @param option An integer to correspond whether the User wants to deposit or withdraw.
	 */
	static void updateBalance(User u, int option) {
		if(option == 0) System.out.println("How much do you want to deposit?:");
		else if(option == 1) System.out.println("How much do you want to withdraw");
		else return;

		Scanner scan = new Scanner(System.in);
		double amt = 0;

		amount_loop:
			while(true) {
				try {
					amt = Double.parseDouble(scan.nextLine());
					break amount_loop;
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid number, try again:");
				}
			}

		if(option == 0) { // option for depositing money
			System.out.println(Service.deposit(u.getUsername(), amt));
		}
		else if(option == 1) { // option for withdrawing money;
			System.out.println(Service.withdraw(u.getUsername(), amt));
		}
	}
	
	static void addBankAccount(User u) {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		printAccountType();
		start_loop:
			while(true) {
				try {
					option = Integer.parseInt(scan.nextLine());
					if(option > 0 && option <= 3) 
						break start_loop;

					System.out.println("Select a valid account type:");
					printAccountType();
				}
				catch(NumberFormatException nfe) {
					//nfe.printStackTrace();
					System.out.println("Select a valid account type:");
					printAccountType();
				}
			}
		//insert bank account to db
		BankAccount b = BankAccountDAO.insertBankAccount(0, option);
		User_BankAccount_DAO.insert(u,  b);
		//insert bank account to list
		Service.getAllBankAccounts().add(b);
	}
	
	/**
	 * 
	 * A helper function to print out the User's information in the log-in menu.
	 * 
	 * @param u The User object
	 */
	private static void getUserInfo(User u) {
		ArrayList<BankAccount> list = Service.getBankAccountsByUsername(u.getUsername());
		System.out.println("Username:\n\t" + u.getUsername()
						+ "\nYour Name:\n\t" + u.getFirstname() + " " + u.getLastname());
		
		System.out.println("\nYour Accounts:");
		for(BankAccount b : list) System.out.println(b);
	}

	/**
	 * 
	 * A helper function to print out the log-in menu
	 */
	private static void printLogInMenu() {
		System.out.println("\nYou are logged in!"
				+ "\nMenu - select your option"
				+ "\n1: Get Account Info"
				+ "\n2: Deposit Money"
				+ "\n3: Withdraw Money"
				+ "\n4: Add Bank Account"
				+ "\n5: Log Out");
	}

	private static void printAccountType() {
		System.out.println("\nPick an Account Type:" 
				+ "\n1: Credit"
				+ "\n2: Savings"
				+ "\n3: Checkings");
	}
	
	private static void printAll(ArrayList<User> list) {
		for(User u : list) {
			System.out.println(u.toString());
		}
	}

}
