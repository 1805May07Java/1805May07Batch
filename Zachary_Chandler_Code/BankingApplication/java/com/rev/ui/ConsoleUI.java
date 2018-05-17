package com.rev.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import com.rev.dao.AccountDAO;
import com.rev.dao.AccountDAOImpl;
import com.rev.dao.CustomerDAO;
import com.rev.dao.CustomerDAOImpl;
import com.rev.dao.SharedAccountsDAO;
import com.rev.dao.SharedAccountsDAOImpl;
import com.rev.pojo.Account;
import com.rev.pojo.AccountType;
import com.rev.pojo.Customer;
import com.rev.util.Format;
import com.rev.util.Hash;

public class ConsoleUI implements AutoCloseable {

	private final Scanner in;
	private final PrintStream out;
	private final CustomerDAO customers;
	private final AccountDAO accounts;
	private final SharedAccountsDAO sharedAccounts;
	private Customer user;
	
	public ConsoleUI(InputStream in, PrintStream out) {
		this.in = new Scanner(in);
		this.out = out;
		this.user = null;
		
		this.customers = new CustomerDAOImpl();
		this.accounts = new AccountDAOImpl();
		this.sharedAccounts = new SharedAccountsDAOImpl();
	}

	public void start() {
		while (user == null)
			login();

		out.println();
		out.println("Welcome " + user.getFirstName());
		
		while (options());
	}

	private void login() {
		out.print("Please enter your email: ");
		String email = in.nextLine().toLowerCase();
		
		if (customers.exists(email)) {
			out.print("Please enter your password: ");
			String password = Hash.hash(email + in.nextLine());
			user = customers.get(email);
			
			if (!password.equals(user.getPassword())) {
				user = null;
				out.println("Incorrect email/password combination");
			}
		} else {
			out.print("Email not found, would you like to create a new account(Y/N): ");
			String ans = in.nextLine();

			if (Character.toUpperCase(ans.charAt(0)) != 'Y') {
				return;
			}
			
			user = createNewAccount(email);
		}
	}

	private Customer createNewAccount(String email) {

		out.print("Enter a password: ");
		String p1 = Hash.hash(email + in.nextLine());
		
		out.print("Re-enter the password: ");
		String p2 = Hash.hash(email + in.nextLine());
		
		if (!p1.equals(p2)) {
			out.println("Error, passwords do not match.");
			return null;
		}
		
		out.print("Enter your first name: ");
		String firstName = Format.name(in.nextLine());
		
		out.print("Enter your last name: ");
		String lastName = Format.name(in.nextLine());
		
		return customers.create(email, p1, firstName, lastName);
	}

	private boolean options() {
		boolean shouldContinue = true;

		Account[] userAccounts = accounts.getAccounts(user);
		Account[] shared = sharedAccounts.getShared(user);

		out.println();
		
		printAccounts(userAccounts, shared);
		
		out.println();

		out.println("What would you like to do?");
		if (shared.length > 0 || userAccounts.length > 0) {
			out.println("1) deposit");
			out.println("2) withdraw");
		}
		
		if (userAccounts.length > 0) {
			out.println("3) share an account");
		}
		
		out.println("4) create account");
		out.println("0) exit");
		out.print("Enter your choice: ");
		
		String choice = in.nextLine();
		out.println();

		Account account = null;

		if ((choice.equals("1") || choice.equals("2")) && shared.length == 0 && userAccounts.length == 0) {
			choice = "-1";
		}

		if (choice.equals("3") && userAccounts.length == 0) {
			choice = "-1";
		}
		
		if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
			
			if (choice.equals("3")) {
				account = chooseAccount(userAccounts, null); 
			} else {
				account = chooseAccount(userAccounts, shared); 
			}
			
			if (account == null) {
				choice = "-1";
			}
		}
		
		switch(choice) {
		case "0":
			shouldContinue = false;
			break;
			
		case "1":
			deposit(account);
			break;

		case "2":
			withdraw(account);
			break;

		case "3":
			shareAccount(account);
			break;

		case "4":
			createAccount(userAccounts);
			break;
			
		default:
			out.println("That wasn't a valid choice.");
		}
		
		return shouldContinue;
	}

	private void printAccounts(Account[] userAccounts, Account[] shared) {
		for (Account a : userAccounts) {
			out.printf("Your %s Account: %s\n", a.getType(), moneyFormat(a.getBalance()));
		}
		
		for (Account a : shared) {
			Customer other = customers.get(a.getCustomerID());
			out.printf("%s's %s account: %s\n", other.getFirstName(), a.getType().toString(), moneyFormat(a.getBalance()));
		}
	}

	private void withdraw(Account userAccounts) {
		out.print("Enter an amount to withdraw: ");
		
		long value;
		
		try {
			value = asMoney(in.nextLine());
		} catch (NumberFormatException e) {
			out.println("Error, invalid format.\n");
			return;
		}
		
		if (value < 0) {
			out.println("Error, cannot withdraw negative values");
			return;
		}
		
		if (value > userAccounts.getBalance()) {
			out.println("Error, you cannot withdraw that much.\n");
			return;
		}
		
		userAccounts.setBalance(userAccounts.getBalance() - value);
		accounts.updateBalance(userAccounts);
	}

	private void deposit(Account userAccounts) {
		out.print("Enter an amount to deposit: ");
		
		long value;
		
		try {
			value = asMoney(in.nextLine());
		} catch (NumberFormatException e) {
			out.println("Error, invalid format.\n");
			return;
		}
		
		if (value < 0) {
			out.println("Error, cannot deposit negative values");
			return;
		}
		
		if (value + userAccounts.getBalance() < 0) {
			out.println("Error, cannot deposit that much");
			return;
		}
		
		userAccounts.setBalance(userAccounts.getBalance() + value);
		accounts.updateBalance(userAccounts);
	}

	private void shareAccount(Account userAccounts) {
		out.println("Who would you like to share the account with?");
		out.print("Enter the user's email: ");
		
		String email = in.nextLine().toLowerCase();
		
		if (!customers.exists(email)) {
			out.println("Could not find that user.");
			return;
		}
		
		Customer other = customers.get(email);
		
		if (other.getCustomerID() == user.getCustomerID()) {
			out.println("You already own the account.");
			return;
		}
		
		if (sharedAccounts.isShared(userAccounts, other)) {
			out.println("That account is already shared with them.");
			return;
		}
		
		sharedAccounts.share(userAccounts, other);
		out.println("Account shared.");
	}

	private void createAccount(Account[] userAccounts) {
		
		out.println("Which account would you like to create?");
		
		if (!containsAccount(userAccounts, AccountType.CHECKING))
			out.println("1) checking");

		if (!containsAccount(userAccounts, AccountType.SAVINGS))
			out.println("2) savings");
		
		if (!containsAccount(userAccounts, AccountType.CREDIT))
			out.println("3) credit");
		
		out.println("0) return");
		out.print("Enter your choice: ");
		
		String choice = in.nextLine();
		out.println();
		
		if (choice.equals("0")) {
			return;
		}
		

		AccountType type = null;
		
		try {
			int choiceI = Integer.parseInt(choice) - 1;
			
			AccountType[] types = AccountType.values();
			
			if (choiceI < 0 || choiceI > types.length) {
				throw new NumberFormatException();
			}
			
			type = types[choiceI];

			if (containsAccount(userAccounts, type)) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("That wasn't a valid choice.");
			return;
		}
		
		accounts.createAccount(user, type);
		out.printf("Created a %s account!\n", type.toString());
	}

	private static boolean containsAccount(Account[] accounts, AccountType type) {
		
		for (Account a : accounts) {
			if (a.getType() == type) {
				return true;
			}
		}
		
		return false;
	}
	
	private Account chooseAccount(Account[] userAccounts, Account[] shared) {
		
		if (shared == null) {
			shared = new Account[0];
		}
		
		out.println();
		
		int i;
		
		for (i = 1; i <= userAccounts.length; i++) {
			Account a = userAccounts[i - 1];
			out.printf("%d) Your %s Account: %s\n", i, a.getType(), moneyFormat(a.getBalance()));
		}
		
		for (;i <= userAccounts.length + shared.length; i++) {
			Account a = shared[i - userAccounts.length - 1];
			Customer other = customers.get(a.getCustomerID());
			out.printf("%d) %s's %s Account: %s\n", i, other.getFirstName(), a.getType(), moneyFormat(a.getBalance()));
		}
		
		out.print("Please choose an account: ");
		String choice = in.nextLine();
		
		Integer choiceI = null;
		
		try {
			choiceI = Integer.parseInt(choice) - 1;
		} catch (NumberFormatException e) {
			return null;
		}
		
		Account choiceA = null;
		
		if (choiceI >= 0 && choiceI < userAccounts.length) {
			choiceA = userAccounts[choiceI];
		} else {
			choiceI -= userAccounts.length;
			
			if (choiceI >= 0 && choiceI < shared.length) {
				choiceA = shared[choiceI];
			}
		}
		
		return choiceA;
	}

	private static String moneyFormat(long value) {
		return String.format("$%d.%02d", value / 100, value % 100);
	}
	
	private long asMoney(String value) {
		
		String[] values = value.split("\\.");
		
		long result;
		
		if (values.length == 1) {
			result = Integer.parseInt(values[0]) * 100;
		} else if (values.length == 2) {
			
			if (values[0].length() == 0) {
				values[0] = "0";
			}
			
			if (values[1].length() == 1) {
				values[1] = values[1] + "0";
			} else if (values[1].length() == 0) {
				values[1] = "00";
			} else if (values[1].length() != 2) {
				throw new NumberFormatException();
			}
			
			result = Long.parseLong(values[0]) * 100;
			
			if (values[0].charAt(0) == '-' ) {
				result -= Long.parseLong(values[1]);
			} else {
				result += Long.parseLong(values[1]);
			}
		} else {
			throw new NumberFormatException();
		}
		
		return result;
	}
	
	@Override
	public void close() {
		in.close();
	}

}
