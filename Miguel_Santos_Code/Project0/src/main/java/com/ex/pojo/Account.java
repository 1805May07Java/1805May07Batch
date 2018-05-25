package com.ex.pojo;

public class Account {
	private int id;
	private double balance;
	private int type;
	//private int userID;
	
	public Account() {}
	public Account(int id, double balance, int type) {
		super();
		this.id = id;
		this.balance = balance;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
