package com.ex.bank;

import java.io.Serializable;

public class User implements Serializable{

	private String fn;
	private String ln;
	private String username;
	private String password;
	private double balance;
	
	public User(String fn, String ln, String un, String pw) {
		this.fn = fn;
		this.ln = ln;
		this.username = un;
		this.password = pw;
		balance = 0;
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
	public String getUsername() {
		return username;
	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
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
	
	@Override
	public String toString() {
		return fn + " " + ln + "(" + username + ")" + " has a balance of: " + balance;
	}
	
}
