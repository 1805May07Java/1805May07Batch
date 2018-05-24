package com.rev.pojos;

public class Account {
	
	/*
	 * POJO
	 */
	private int id; 
	private String username;
	transient private String password;
	public double balance;
	public int type;
		
	public Account() {}
	
	private Account(String username, String password, String type, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.getBalance(balance);
		this.setBalance(balance);
				
	}

	public Account(int id, String username, String password, int type, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.type = type;
		this.balance = balance;
		this.getBalance(balance);
		this.setBalance(balance);
	}
	 	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}

	public double getBalance(double balance) {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return  id + ":" + username + ":" + password + ":" + type + ":" + balance;
	}
}