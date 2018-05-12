/*
 * User.java
 * Author: Cole Vikupitz
 *
 * Class that represents a user in the banking system databases.
 * Contains a user's user name, password, and their account balance.
 */

package com.revature.version1;

public class User {

	// Declare instance members
	private String username, password;
	private double balance;

	// Constructor
	public User(String username, String password, double balance) {

		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	/**
	 * Returns the user account's username.
	 *
	 * @return The account username.
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * Re-assigns the user account's username to 'username'.
	 *
	 * @param username - The new username to assign to the user account.
	 */
	public void setUsername(String username) {

		this.username = username;
	}

	/**
	 * Returns the user account's password.
	 *
	 * @return The account user name.
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * Re-assigns the user account's password to 'password'.
	 *
	 * @param username - The new password to assign to the user account.
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	/**
	 * Returns the balance for this user account.
	 *
	 * @return The account balance.
	 */
	public double getBalance() {

		return balance;
	}

	/**
	 * Withdraws the specified amount from the user account and updates
	 * the balance accordingly. If there is an overdraft, the deposit will
	 * not occur, and false is returned. Otherwise, if there is enough in
	 * the balance to satisfy the request, the update is made and true is
	 * returned.
	 *
	 * @param amount - The amount to withdraw from the account.
	 * @return True if there is no overdraft, false if there is (not enough
	 * money in the account).
	 */
	public boolean withDraw(double amount) {

		if (this.balance - amount < 0.0F)
			return false;
		this.balance -= amount;
		return true;
	}

	/**
	 * Deposits the specified amount of money into the user account.
	 *
	 * @param amount - The amount to deposit into the account.
	 */
	public void deposit(double amount) {

		this.balance += amount;
	}

}
