package com.major.pojos;



public class LoginCredentials 
{
	private String userName;
	private String password;
	public LoginCredentials() {
		super();
	}
	public LoginCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
