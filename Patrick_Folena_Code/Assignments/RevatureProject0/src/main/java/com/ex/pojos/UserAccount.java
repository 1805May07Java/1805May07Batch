package com.ex.pojos;

public class UserAccount {
	
	private User user;
	private Account acct;
	
	public UserAccount(User user, Account acct) {
		super();
		this.user = user;
		this.acct = acct;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Account getAccount() {
		return acct;
	}
	public void setAccount(Account acct) {
		this.acct = acct;
	}
}
