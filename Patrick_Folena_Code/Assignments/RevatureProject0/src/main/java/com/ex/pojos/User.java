package com.ex.pojos;

public class User {
	private int ID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
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
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void copy(User copy) {
		this.setID(copy.getID());
		this.setUsername(copy.getUsername());
		this.setPassword(copy.getPassword());
		this.setFirstname(copy.getFirstname());
		this.setLastname(copy.getLastname());
		this.setEmail(copy.getEmail());
	}
}
