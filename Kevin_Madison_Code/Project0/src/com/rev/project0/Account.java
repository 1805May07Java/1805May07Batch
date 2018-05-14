package com.rev.project0;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fn;
	private String ln;
	private String username;
	transient private String password;
	private double balance;

	public Account() {
	}

	private Account(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public Account(String fn, String ln, String username, String password, double balance) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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

	@Override
	public String toString() {
		return fn + ":" + ln + ":" + username + ":" + password + ":" + balance + "\n";
	}
}
