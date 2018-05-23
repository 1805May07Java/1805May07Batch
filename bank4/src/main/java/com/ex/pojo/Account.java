package com.ex.pojo;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {

	private UUID accountid; //.toString()
	private String accounttype;
	private double balance;
	
	public Account() {}
	public Account(UUID accountid, String accounttype, double balance) {
		super();
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.balance = balance;
	}
	
	public Account(String accounttype) {
		super();
		this.accountid = UUID.randomUUID();
		this.accounttype = accounttype;
		this.balance = 0.0;
		
	}
	
	public Account(UUID accountid, String accounttype) {
		super();
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.balance = 0.0;
	}
	public UUID getAccountid() {
		return accountid;
	}
	public void setAccountid(UUID accountid) {
		this.accountid = accountid;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
