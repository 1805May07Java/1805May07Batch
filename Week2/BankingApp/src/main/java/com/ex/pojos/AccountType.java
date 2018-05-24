package com.ex.pojos;

public class AccountType 
{
	
	private int id;
	private String name;
	
	public AccountType () {}
	
	public AccountType(String name)
	{
		super();
		this.name = name;
	}
	
	public AccountType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
