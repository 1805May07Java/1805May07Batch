package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BankAccountDAO;
import dao.UserDAO;
import dao.User_BankAccount_DAO;
import pojo.BankAccount;
import pojo.User;
import pojo.User_BankAccount;

public class Service {
	private static ArrayList<User> users;
	private static ArrayList<BankAccount> bas;
	
	static {
		users = UserDAO.getAll();
		bas = BankAccountDAO.getAll();

	}
	
	/**
	 * The ArrayList of Users is a static list, so this function is just to return it
	 * 
	 * @return Returns 'users', the static list of all Users in the app.
	 */
	public static ArrayList<User> getAllUsers() {
		return users;
	}
	
	/**
	 * The ArrayList of BankAccounts is a static list, so this function is just to return it
	 * 
	 * @return Returns 'bas', the static list of all BankAccounts in the app.
	 */
	public static ArrayList<BankAccount> getAllBankAccounts() {
		return bas;
	}
	
	
	public static void addNewUser(User u, int accounttype) {
		BankAccount ba = BankAccountDAO.insertBankAccount(0, accounttype);
		u = UserDAO.insertUser(ba.getId(), u.getUsername(), u.getPassword(), u.getFirstname(), u.getLastname()); 
		User_BankAccount_DAO.insert(u, ba);
		bas.add(ba);
		users.add(u);
	}
	
	
	public static ArrayList<BankAccount> getBankAccountsByUsername(String username) {
		return User_BankAccount_DAO.getAllAccounts(username);
	}
	
	
	/**
	 * 
	 * This function deletes a user from the list, then sync's it with the users.txt file
	 * 
	 * @param username The User's username, we fill find the User based off this information
	 * @return Returns true if the User is removed, and false if we dont remove the User (usually because the User isn't in the list).
	 */
	boolean deleteUser(String username) { return false;
//		User u = findUser(username);		
//		if(users.remove(u)) {
//			DAO.syncUsers(users);
//			return true;
//		}
//		return false;
		
	}
	
	/**
	 * 
	 * This function deposits money into a User's account balance, then sync's it to the users.txt file
	 * If the User doesn't exist or if amt <= 0, the function does an early return (basically doing nothing)
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @param amt The amount that the User wants to deposit.
	 */
	public static String deposit(String username, double amt) {
		User u = findUser(username);
		
		if(u == null || amt <= 0) return "Could not deposit";
		ArrayList<BankAccount> list = User_BankAccount_DAO.getAllAccounts(username);
		for(int i=1; i<=list.size(); i++) {
			System.out.println("("+ i + ") " + list.get(i-1));
		}
		
		Scanner scan = new Scanner(System.in);
		int option = 0;
		option_loop:
			while(true) {
				try {
					option = Integer.parseInt(scan.nextLine());
					if(option > 0 && option <= list.size())
						break option_loop;
					System.out.println("Not a valid option, try again:");
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid option, try again:");
				}
			}
		
		BankAccount b = list.get(option-1);
		BankAccountDAO.deposit(b, amt);
		b.setBalance(b.getBalance() + amt);
		
		return "Money was deposited";
	}

	/**
	 * 
	 * This function withdraws money from the User's account balance, then sync's it to the users.txt file
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @param amt The amount the User wants to withdraw
	 * @return Returns true if the user successfully withdraws money, and returns false if the user tries to withdraw too much money.
	 */
	public static String withdraw(String username, double amt) {
		User u = findUser(username);
	
		if(u == null || amt <= 0) return "Could not withdraw";
		ArrayList<BankAccount> list = User_BankAccount_DAO.getAllAccounts(username);
		for(int i=1; i<=list.size(); i++) {
			System.out.println("("+ i + ") " + list.get(i-1));
		}
	
		Scanner scan = new Scanner(System.in);
		int option = 0;
		option_loop:
			while(true) {
				try {
					option = Integer.parseInt(scan.nextLine());
					if(option > 0 && option <= list.size())
						break option_loop;
					System.out.println("Not a valid option, try again:");
				}
				catch(NumberFormatException nfe) {
					System.out.println("Not a valid option, try again:");
				}

			}
	
		BankAccount b = list.get(option-1);
		double bal = BankAccountDAO.withdraw(b, amt);
		if(bal == b.getBalance()) return "Did not withdraw";
		b.setBalance(bal);
	
		return "Money was withdrawn";
	}

	/**
	 * 
	 * Given a username, this function will find the User.
	 * 
	 * @param username The User's username so we can find the User in the list
	 * @return The User object that corresponds to the username. Returns null if the User is not in the list.
	 */
	public static User findUser(String username) {
		for(User u : users) {
			if(u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	private static void printUsers(ArrayList<User> list) {
		for(User u : list) {
			System.out.println(u);
		}
	}
	private static void printBA(ArrayList<BankAccount> list) {
		for(BankAccount b : list) {
			System.out.println(b);
		}
	}
}

