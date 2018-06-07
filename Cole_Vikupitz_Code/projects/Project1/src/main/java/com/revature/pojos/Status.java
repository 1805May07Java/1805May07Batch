/*
 * ReimbursementStatus.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Status {

	private int id;
	private String status;

	public Status() {}

	public Status(int id, String status) {
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("[%d]: %s", this.id, this.status);
	}

}
