/*
 * Account.java
 * Author: Cole Vikupitz
 */

package com.revature.pojos;

public class Account {

	private int id, type;
	private double balance;

	public Account(int id, int type, double balance) {
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance < 0.0D)
			this.balance = 0.0D;
		else
			this.balance = balance;
	}
}
