/*
 * Account.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Account {

	private int id, userId, typeId;
	private double balance;

	public Account(int id, int userId, int typeId, double balance) {

		this.id = id;
		this.userId = userId;
		this.typeId = typeId;
		this.balance = balance;
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

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
