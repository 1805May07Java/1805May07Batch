package com.ex.POJO;

public class Account {
	int accountNumber;
	double balance;
	String accType; 		

	public Account() {
	}
	
	public Account(int accNo, int accType) {
		accountNumber = accNo;
		setAccType(accType);
		balance = 0;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double charge) {
		this.balance -= charge;
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accNo) {
		accountNumber = accNo;
	}
	
	public String getAccType() {
		return accType;
	}

	public void setAccType(int accType) {
		switch (accType) {
		case 0:
			this.accType = "Credit";
			break;
		case 1:
			this.accType = "Savings";
			break;
		case 2:
			this.accType = "Checking";
			break;
		}
	}
	
	public void displayAccountInfo() {
		System.out.println("Account Number: " + accountNumber + " " + accType + " Balance: " + balance);
	}
}
