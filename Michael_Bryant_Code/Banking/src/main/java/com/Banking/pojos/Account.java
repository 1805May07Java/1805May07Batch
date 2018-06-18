package com.Banking.pojos;

public class Account {
	
	private int accountId;
	private String user;
	private String pass;
	private String email = " ";
	
	public Account() {
		
	}
	
	public Account(String user, String pass, String email) {
		super();
		this.user = user;
		this.pass = pass;
		this.email = email;
	}
	public Account(int i, String user, String pass, String email) {
		super();
		accountId = i;
		this.user = user;
		this.pass = pass;
		this.email = email;
	}


	public int getAccountid() {
		return accountId;
	}

	public void setAccountid(int accountid) {
		accountId = accountid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return "[Account id: " +accountId +", Username: " +user +", Password: " +pass +", Email: " +email +"]";
	}

}
