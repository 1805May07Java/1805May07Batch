package com.banking.ui;


public class Account {
	
	private String username;
	private String password;
	private double balance = 0;
	
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		
	}
	
	public Account() {
		
	}
	
	public void deposit(double d) {
		balance += d;
		System.out.println(  "------------------------------------" +"\n"
							+"Deposit for " +d +" is being made!" +"\n"
							+"New account balance is : " + balance
							+"------------------------------------");
		
	}
	
	public void withdraw(double w) {
		balance -= w;
		System.out.println(  "------------------------------------" +"\n"
							+"Withdraw for " +w +" is being made!" +"\n"
							+"New account balance is : " + balance
							+"------------------------------------" +"\n");
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		 this.balance= balance;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String toString = username +":" + password +":" +balance;
		return toString;
	}
	

}
