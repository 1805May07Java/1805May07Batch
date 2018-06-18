package com.Banking.pojos;

public class Savings {
	
	private int accountID;
	private int savingsId;
	private double balance;
	
	public Savings() {
		
		
	}

	public Savings(int accountId, double balance) {
		super();
		this.accountID = accountId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Savings [SavingsId=" + savingsId + ", balance=" + balance + "]";
	}
	

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getSavingsId() {
		return savingsId;
	}

	public void setSavingsId(int SavingsId) {
		this.savingsId = SavingsId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
