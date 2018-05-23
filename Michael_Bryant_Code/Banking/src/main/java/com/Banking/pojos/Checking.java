package com.Banking.pojos;

public class Checking {
	
	private int accountID;
	private int checkingId;
	private double balance;
	
	public Checking() {
		
		
	}

	public Checking(int accountId, double balance) {
		super();
		this.accountID = accountId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Checking [checkingId=" + checkingId + ", balance=" + balance + "]";
	}
	

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCheckingId() {
		return checkingId;
	}

	public void setCheckingId(int checkingId) {
		this.checkingId = checkingId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
