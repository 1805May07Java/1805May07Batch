package com.ex.POJO;

public class Account {
	int accountNumber;
	double balance;
	int accType; 		//LOOKUP TABLE

	public Account() {
	}
	
	public Account(int accNo, int accType) {
		accountNumber = accNo;
		this.accType = accType;
		balance = 0;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void chargeBalance(double charge) {
		this.balance -= charge;
	}
	
	public void depositBalance(double deposit) {
		this.balance += deposit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accNo) {
		accountNumber = accNo;
	}
	
	public int getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}
	
	public void displayAccountInfo() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Balance: " + balance);
	}
}
