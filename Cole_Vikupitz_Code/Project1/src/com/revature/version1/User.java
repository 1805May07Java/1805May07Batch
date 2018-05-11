/*
 * User.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.version1;

public class User {

	private String username, password;
	private long balance;

	public User(String username, String password, long balance) {

		this.username = username;
		this.password = password;
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

}
