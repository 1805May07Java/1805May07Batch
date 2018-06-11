/*
 * User.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class User {

	private int id, roleId;
	private String firstName, lastName, email, password;

	public User() {}

	public User(int id, int roleId, String fn, String ln,
			String email, String pw) {
		this.id = id;
		this.roleId = roleId;
		this.firstName = fn;
		this.lastName = ln;
		this.email = email;
		this.password = pw;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	@Override
	public String toString() {
		return String.format("[%d]: %s %s\n%s\n%s\n%d",
				this.id, this.firstName, this.lastName,
				this.email, this.password, this.roleId);
	}

}
