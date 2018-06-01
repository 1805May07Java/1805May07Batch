package com.major.pojos;

public class UserRoles 
{
	private int id;
	private String role;
	
	//constructors
	public UserRoles() {
		super();
	}

	public UserRoles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	//get and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
