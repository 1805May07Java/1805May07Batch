package com.rev.pojos;

public class Account {
	private int accID;
	private int accType;  //1.Credit 2. Savings 3. Checking
	private int UserID;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int accType, int userID, double balance) {
		this.accType = accType;
		UserID = userID;
		this.balance = balance;
	}

	public Account(int accID, int accType, int userID, double balance) {
		this.accID = accID;
		this.accType = accType;
		UserID = userID;
		this.balance = balance;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accID=" + accID + ", accType=" + accType + ", UserID=" + UserID + ", balance=" + balance + "]";
	}
	
	
}
