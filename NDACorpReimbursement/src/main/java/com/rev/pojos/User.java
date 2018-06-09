package com.rev.pojos;

public class User {
	private int userID;
	private String userName;
	private String password;
	private String fName;
	private String lName;
	private String email;
	private int role;
	
	
	
	public User(int userID, String userName, String password, String fName, String lName,  String email, int role) {
		this.userID = userID;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public User(String userName, String password, String fName, String lName, String email, int role) {
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	public User() {}

	@Override
	public String toString() {
		return "User= " + userID + ", fName= " + fName + ", lName= " + lName + ", userName= " + userName
				+ ", password= " + password + ", email= " + email + ", role= " + role;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	};
	
	
	
	
}
