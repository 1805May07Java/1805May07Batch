package com.ex.main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ex.pojos.AccountType;
import com.ex.pojos.BankAccount;
import com.ex.pojos.Person;
import com.ex.service.AccountTypeService;
import com.ex.service.BankAccountService;
import com.ex.service.PersonService;

public class App {
	// intialize service object
	static PersonService person_service = new PersonService();
	static BankAccountService account_service = new BankAccountService();
	static AccountTypeService account_type_service = new AccountTypeService();

	// main class to run Account app
	public static void main(String[] args) {

		// Testing
		System.out.println("Starting...");

		start();

	}

	static void start() {
		System.out.print("|| Welcome to 'Kev Jumbo's Bank'! A place to stow dough for the above average joe. "
				+ "\n|| What would you like to do?" + "\n|| 1: Log In" + "\n|| 2: Sign up\n->");

		Scanner scan = new Scanner(System.in);
		int op = 0;
		try {
			op = Integer.parseInt(scan.nextLine());
		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();
			System.out.println("Sorry, that's not an option. Please try again");
			start();
			scan.close();
			return;
		}

		switch (op) {
		case 1:
			logIn();
			break;
		case 2:
			signUp();
			break;
		default:
			System.out.println("Sorry, that's not an option. Please try again");
			start();
			scan.close();
			return;
		}
		scan.close();
	}

	static void signUp() {

		// instantiate scanner
		Scanner scan = new Scanner(System.in);

		// get user's first name
		System.out.println("||-----------------------------||");
		System.out.println("||-----------Sign Up-----------||");
		System.out.println("||-----------------------------||");
		System.out.print("First Name: ");
		String fn = scan.nextLine();

		// get user's last name
		System.out.print("Last Name: ");
		String ln = scan.nextLine();

		// get user's prefered username and check to see if it's unique
		System.out.print("Enter your username/email: ");
		String username = scan.nextLine();
		
		//create a new person to check the username
		Person tempPerson = new Person();
		tempPerson.setUsername(username);
		
		if (person_service.exists(tempPerson)) {
			System.out.println("Sorry, that username/email is already in use.");
			signUp();
		} else {
			// username is unqiue, so get the user's password.
			System.out.print("Thanks, " + username + ". What's your password?:");
			String password = scan.nextLine();
			System.out.print("How much money would you like to open your account with? ($5.00 min)\n->$");
			String initialBalance = scan.nextLine();
			double balance = 0;
			try {
				balance = Double.parseDouble(initialBalance); // do input validation
				if (balance < 5.0) {
					System.out.println(
							"~Please enter an amount greater than $5.00." + "~\nTry to sign up again with enough money.");
					signUp();
				} else if (balance > 250000.00) {
					System.out.println("~That is too much money for one account."
							+ "\n~Try to sign up again with less than $250,000.");
				}
			} catch (NumberFormatException nfe) {
				// nfe.printStackTrace();
				System.out.println(
						"~That was not a valid amount of money. Please sign up again with enough money next time.");
				signUp();
				return;
			}

			System.out.println("|| Now the final step, what kind of account would you like to open?");
			System.out.println("|| 1: Credit");
			System.out.println("|| 2: Saving");
			System.out.println("|| 3: Checking");
			System.out.print("->");

			int accountType = scan.nextInt();

			while(accountType<1 || accountType>3) {
				System.out.println("~Try again, numbers can be challenging...");
				System.out.println("|| Now the final step, what kind of account would you like to open?");
				System.out.println("|| 1: Credit");
				System.out.println("|| 2: Saving");
				System.out.println("|| 3: Checking");
				System.out.print("->");
				accountType = scan.nextInt();
			}
			
			Person newPerson = new Person();
			newPerson.setFirstname(fn);
			newPerson.setLastname(ln);
			newPerson.setUsername(username);
			newPerson.setPassword(password);
			
			BankAccount newAccount = new BankAccount();
			newAccount.setBalance(balance);
			newAccount.setBank_type(accountType);
			
			newPerson = person_service.add(newPerson);
			
			newAccount.setOwner_id(newPerson.getPerson_id());
			
			newAccount = account_service.add(newAccount);
			System.out.println(newPerson.toString());
			System.out.println(newAccount.toString());
			
			// loggedIn(account);
		}
		// login or dothings

	}

	static void logIn() {
		Person person = new Person();
		BankAccount account = new BankAccount();
		Scanner in = new Scanner(System.in);

		System.out.println("||-----------------------------||");
		System.out.println("||-----------Log  In-----------||");
		System.out.println("||-----------------------------||");
		
		System.out.print("Enter your username:");
		String username = in.nextLine();
		
		//create a new person to check the username
				Person tempPerson = new Person();
				tempPerson.setUsername(username);
				
		if (!person_service.exists(tempPerson)) {
			System.out.println("You arent a user. Nice Try!");
			logIn();
			return;
		} else {
			person = person_service.getByUsername(username);
		} // printing the current user
		

		System.out.print("Enter your password: ");
		String password = in.nextLine();
		// test if password is valid
		if (person.getPassword().equals(password)) {
			loggedIn(person);
		} else

		{
			System.out.println("Sorry, your password was incorrect. try again");
			logIn();
		}

	}

	static void loggedIn(Person s) {
		BankAccount account = new BankAccount();
		String fn = s.getFirstname();
		String ln = s.getLastname();
		Scanner scan = new Scanner(System.in);

		System.out.println("-----------------------------------------------------------");
		System.out.println("||Welcome " + fn + "_" + ln + " to your personal bank account.");
		System.out.println("-----------------------------------------------------------");
		System.out.println("||Which account would you like to access?");
		System.out.println("|| 1: Credit");
		System.out.println("|| 2: Saving");
		System.out.println("|| 3: Checking");
		System.out.print("->");
		int response = scan.nextInt();

		while (response < 1 || response > 3) {
			System.out.println("This isnt a valid response...\n->");
			response = scan.nextInt();
		}

		BankAccount temp = new BankAccount();
		temp.setBank_type(response);
		temp.setOwner_id(s.getPerson_id());

		if (!account_service.exists(temp)) {// this user does not have this type of bank account
			int response2;
			switch (response) {
			case 1:
				System.out.print(
						"Sorry you dont have a 'Credit' account.\n Would you like to make one?\n1: yes\n2: no\n->");
				response2 = scan.nextInt();
				while (response2 < 1 || response2 > 3) {
					System.out.println("Sorry try again\n->");
					response2 = scan.nextInt();
				}

				if (response2 == 1) {
					makeNewAccount(s, 1);
					loggedIn(s);
				} else {
					loggedIn(s);
					return;
				}
				break;
			case 2:
				System.out.print(
						"Sorry you dont have a 'Saving' account.\n Would you like to make one?\n1: yes\n2: no\n->");
				response2 = scan.nextInt();
				while (response2 < 1 || response2 > 3) {
					System.out.println("Sorry try again\n->");
					response2 = scan.nextInt();
				}

				if (response2 == 1) {
					makeNewAccount(s, 2);
					loggedIn(s);
				} else {
					loggedIn(s);
					return;
				}
				break;
			case 3:
				System.out.print(
						"Sorry you dont have a 'Checking' account.\n Would you like to make one?\n1: yes\n2: no\n->");
				response2 = scan.nextInt();
				while (response2 < 1 || response2 > 3) {
					System.out.println("Sorry try again\n->");
					response2 = scan.nextInt();
				}

				if (response2 == 1) {
					makeNewAccount(s, 3);
					loggedIn(s);
				} else {
					loggedIn(s);
					return;
				}
				break;
			default:
			}
		} else {
			account = account_service.getAccount(s.getPerson_id(), response);
			loggedInAccount(s, account);
		}

	}
	private static void makeNewAccount(Person s, int bankType) {
		System.out.println("||-----------------------------||");
		System.out.println("||--- Making a new Account ----||");
		System.out.println("||-----------------------------||");
		
		System.out.println("|| How much would you like to deposit? ($5.00 minimum)");
		System.out.print("->$");
		Scanner scan = new Scanner(System.in);
		String initialBalance = scan.nextLine();
		
		
		double balance = 0;
		try {
			balance = Double.parseDouble(initialBalance); // do input validation
			while(balance<5.0 || balance>250000.00) {
				if (balance < 5.0) {
					System.out.println(
							"~Please enter an amount greater than $5.00." + "~\nTry to sign up again with enough money.");
					System.out.print("->$");
					initialBalance = scan.nextLine();
					balance = Double.parseDouble(initialBalance);
					scan = new Scanner(System.in);
				} else if (balance > 250000.00) {
					System.out.println("~That is too much money for one account."
							+ "\n~Try to sign up again with less than $250,000.");
					System.out.print("->$");
					initialBalance = scan.nextLine();
					balance = Double.parseDouble(initialBalance);
				}
			}
			
		} catch (NumberFormatException nfe) {
			// nfe.printStackTrace();
			System.out.println(
					"~That was not a valid amount of money. Please sign up again with enough money next time.");
			signUp();
			return;
		}
		BankAccount ba = new BankAccount();
		ba.setBalance(balance);
		ba.setBank_type(bankType);
		ba.setOwner_id(s.getPerson_id());
		
		account_service.add(ba);
	
		
	}

	
	static void loggedInAccount(Person s, BankAccount b) {

		// retrieve account information
		Double balance = b.getBalance();

		// change user info or whatever
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		System.out.println("-----------------------------------------------------------");
		System.out.println("||You currently have: $" + decimalFormat.format(balance));
		System.out.println("-----------------------------------------------------------");

		System.out.print("||--------------------------||" + "\n||What would you like to do?||"
				+ "\n|| 1: Withdrawl             ||" + "\n|| 2: Deposit               ||"
				+ "\n|| 3: Log Out               ||" + "\n||--------------------------||\n" + "Option: ");

		Scanner keyboard = new Scanner(System.in);
		int response = 0;
		response = keyboard.nextInt(); // keyboard.close();

		switch (response) {
		case 1:
			withdrawl(b);
			break;
		case 2:
			deposit(b);
			break;
		case 3:
			logOut();
			return;
		default:
			System.out.println("Enter a valid response.");
			break;
		}
		loggedIn(s);

	}

	private static void withdrawl(BankAccount b) {

		System.out.println("You currently have: " + b.getBalance());
		System.out.print("\nHow much would you like to withdrawl?" + "\n->$");

		Scanner keyboard = new Scanner(System.in);

		double withdrawlAmount = keyboard.nextDouble();
		double newBalance = b.getBalance() - withdrawlAmount;
		if (newBalance < 0) {
			System.out.println("You cannout withdrawl money that you don't have.");
		} else if (newBalance < 5) {
			System.out.println("!!! You must leave at least $5 in your account to maintain an open account.");
		} else {
			b.setBalance(newBalance);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			System.out.println("\n-----------------------------------------" + "\n||You successfully withdrew $"
					+ withdrawlAmount + "." + "\n||Your new balance is now: $" + decimalFormat.format(b.getBalance())
					+ "." + "\n-----------------------------------------\n");
			account_service.update(b);
		}

	}

	private static void deposit(BankAccount b) {

		System.out.println("You currently have: " + b.getBalance());
		System.out.print("\nHow much would you like to deposit?" + "\n$");

		Scanner keyboard = new Scanner(System.in);
		double deposit = keyboard.nextDouble();
		double newBalance = b.getBalance() + deposit;

		if (newBalance > 250000.0) {
			System.out.println("The amount you entered will exceed your $250,000 limit.");
		} else if (newBalance < b.getBalance()) {
			System.out.println("You cannot deposit negative amounts of money.");
		} else {
			b.setBalance(newBalance);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			System.out.println("\n-----------------------------------------" + "\n||You successfully deposited $"
					+ deposit + "." + "\n||Your new balance is now: $" + decimalFormat.format(b.getBalance()) + "."
					+ "\n-----------------------------------------\n");
			account_service.update(b);

		}

		return;

	}

	static void logOut() {
		 System.out.println("You have successfully logged out. Later.");
		 start();
		 return;
	}
}