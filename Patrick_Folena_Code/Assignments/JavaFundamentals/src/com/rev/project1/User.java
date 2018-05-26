package com.rev.project1;

public class User 
{
	String userName;
	String passWord;
	
	String firstName;
	String lastName;
	String email;
	
	double cashAmount;

	public User() {}

	public User(String userName, String passWord, String firstName, String lastName, String email, double cashAmount) {
		super();
		
		this.userName = userName;
		this.passWord = passWord;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cashAmount = cashAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(double CashAmount) {
		this.cashAmount = CashAmount;
	}
	
	public void updateCashAmount (double deltaAmount) {
		this.cashAmount += deltaAmount;
	}
	
	@Override
	public String toString() {
		return userName + ":" + passWord + ":" + firstName + ":" + lastName + ":" + email + ":" + cashAmount;
	}
}
