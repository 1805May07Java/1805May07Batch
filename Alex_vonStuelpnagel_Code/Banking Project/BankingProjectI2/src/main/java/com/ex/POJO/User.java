package com.ex.POJO;

import java.util.ArrayList;

public class User {
	static int userID;
	boolean isAdmin;
	int accountID;
	String firstName;
	String lastName;
	String email;
	String password;
	
	ArrayList<Account> accounts;
	
	
	//default contstructor
	public User() {
		
	}
	
	public User(int uN, String fN, String lN, String eml, String pw){
		userID = uN;
		firstName = fN;
		lastName = lN;
		email = eml;
		password = pw;
		
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Account> getAccounts(){
		return accounts;
	}
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
	}
	
	public void removeAccount(Account account) {
		int index = 0;
		for (Account a : accounts) {
			if (a.equals(account)) {
				accounts.remove(index);
				return;
			}
			index++;
		}
	}

}
