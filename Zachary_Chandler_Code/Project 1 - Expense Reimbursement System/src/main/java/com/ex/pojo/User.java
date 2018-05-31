package com.ex.pojo;

import java.util.NoSuchElementException;

public class User {
	private long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;

	public static enum Role {
		
		Employee(0), FinanceManager(1);
		
		public int value;
		
		private Role(int value) {
			this.value = value;
		}
		
		public static Role translate(int value) {
			Role[] values = values();

			for (int i = 0; i < values.length; i++) {
				if (values[i].value == value) {
					return values[i];
				}
			}
			
			throw new NoSuchElementException();
		}
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
