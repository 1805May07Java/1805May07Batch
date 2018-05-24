package com.rev.pojos;

public class JointAccount {
	
	private int id;
	private String name;
	
	public JointAccount() {}
	
	public JointAccount(int id, String name) {
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
		return "JointAccount " + id + ": " + name + "";
		// JointAccount [ id = 1, name = Genesis]
		// JointAccount 1: Genesis
	}
	
}