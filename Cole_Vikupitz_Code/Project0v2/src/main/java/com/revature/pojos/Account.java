/*
 * Account.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Account {

	private int id, userId, typeId;
	private double balance;
	private String type;

	public Account(int id, int userId, int typeId, double balance) {

		this.id = id;
		this.userId = userId;
		this.typeId = typeId;
		this.balance = balance;
		this.type = "";
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
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

	@Override
	public String toString() {

		return String.format("(%d) %s - $%.2f",
				this.id, this.type, this.balance);
	}

}
