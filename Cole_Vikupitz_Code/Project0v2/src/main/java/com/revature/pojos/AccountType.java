/*
 * AccountType.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class AccountType {

	private int id;
	private String type;

	public AccountType(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
