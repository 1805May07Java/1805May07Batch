package com.ex.pojos;

public class BankUser 
{
	private int id;
	private String fn;
	private String ln;
	private String username;
	private String email;
	private String password;

	public BankUser() {}
	
	public BankUser(String fn, String ln, String username, String email, String password) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public BankUser(int id, String fn, String ln, String username, String email, String password) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BankUser [id=" + id + ", fn=" + fn + ", ln=" + ln + ", username=" + username + ", email=" + email + "]";
	}

	
	
}
