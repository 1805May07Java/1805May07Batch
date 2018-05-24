package com.ex.pojos;

public class User_Account 
{
	private BankUser user;
	private BankAccount acc;
	
	public User_Account(BankUser user, BankAccount acc) {
		super();
		this.user = user;
		this.acc = acc;
	}

	public User_Account() {
		
	}

	public BankUser getUser() {
		return user;
	}

	public void setUser(BankUser user) {
		this.user = user;
	}

	public BankAccount getAcc() {
		return acc;
	}

	public void setAcc(BankAccount acc) {
		this.acc = acc;
	}
	
	
	
	
	
	

}
