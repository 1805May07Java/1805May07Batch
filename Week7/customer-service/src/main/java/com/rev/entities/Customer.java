package com.rev.entities;

import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	private List<Account> accounts;
	
	public Customer() {}

	public Customer(int id, String name, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
