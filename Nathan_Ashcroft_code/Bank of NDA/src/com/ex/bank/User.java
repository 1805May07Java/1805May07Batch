package com.ex.bank;

public class User {
	private String fName;
	private String lName;
	private String userName;
	private String password;
	private double balance;
	
	@Override
	public String toString() {
		return fName + ":" + lName + ":" + userName + ":"+ password + ":" + balance + "\n";
	}
	
	public User() {
		
	}

	public User(String fName, String lName, String userName, String password, double balance) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
