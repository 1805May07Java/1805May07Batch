package com.Banking.pojos;

public class Credit {
	
	private int accountID;
	private int creditId;
	private double balance;
	
	public Credit() {
		
		
	}

	public Credit(int accountId, double balance) {
		super();
		this.accountID = accountId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "credit [creditId=" + creditId + ", balance=" + balance + "]";
	}
	

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
