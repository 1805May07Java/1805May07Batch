package com.rev.pojos;

public class Customer {
	
	private int id;
	private String username;
	
	public Customer() {}
	
	public Customer(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	@Override
	public String toString() {
		return "Customer " + id + ": " + username + "";
		// Customer [ id = 1, name = Genesis]
		// Customer 1: Genesis
	}

}