/*
 * Account.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Account {

	private int id, userId;
	private double balance;
	private String type;

	public Account(int id, int userId, double balance, String type) {

		this.id = id;
		this.userId = userId;
		this.balance = balance;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public boolean withdraw(double amount) {
		if (this.balance - amount < 0.0)
			return false;
		this.balance -= amount;
		return true;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
