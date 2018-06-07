/*
 * ReimbursementType.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Type {

	private int id;
	private String name;

	public Type() {}

	public Type(int id, String name) {
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
		return String.format("[%d]: %s", this.id, this.name);
	}

}
