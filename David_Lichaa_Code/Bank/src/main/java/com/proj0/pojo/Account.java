package com.proj0.pojo;

public class Account {
	private int accountId;
	private int userId;
	private int accountTypeId;
	private int balance;
	
	public Account() {
		super();
	}
	
	public Account (int userId, int accountTypeId) {
		super();
		this.userId = userId;
		this.accountTypeId = accountTypeId;
	}
	public Account(int userId, int accountTypeId, int balance) {
		super();
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
	}
	public Account(int accountId, int userId, int accountTypeId, int balance) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountTypeId = accountTypeId;
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
