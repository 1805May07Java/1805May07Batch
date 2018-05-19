package com.ex.POJO;

public class User {
	static int userID;
	int isAdmin;
	int accountID;
	String firstName;
	String lastName;
	String email;
	String password;
	
	
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
	
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public static int getUserID() {
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

}
