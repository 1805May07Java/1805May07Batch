package com.rev.pojos;

public class User {
	private int userID;
	private String fName;
	private String lName;
	private String userName;
	private String password;
	
	public User() {
	
	}
	
	public User(int userID, String fName, String lName, String userName, String password) {
		this.userID = userID;
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String fName, String lName, String userName, String password) {
		this.fName = fName;
		this.lName = lName;
		this.userName = userName;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [userID=" + userID + ", fName=" + fName + ", lName=" + lName + ", userName=" + userName
				+ ", password=" + password;
	}
	
	
	
	
}
