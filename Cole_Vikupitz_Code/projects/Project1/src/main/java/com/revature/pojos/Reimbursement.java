/*
 * Reimbursement.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.pojos;

public class Reimbursement {

	private int id;
	private double amount;
	String description;
	String submitted, reviewed;
	private int sender, reviewer, type, status;

	public Reimbursement() {}

	public Reimbursement(int id, double amt, String desc, String subm,
			String recv, int sid, int rid, int type, int status) {
		this.id = id;
		this.amount = amt;
		this.description = desc;
		this.submitted = subm;
		this.reviewed = recv;
		this.sender = sid;
		this.reviewer = rid;
		this.type = type;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getReviewed() {
		return reviewed;
	}

	public void setReviewed(String reviewed) {
		this.reviewed = reviewed;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public int getReviewer() {
		return reviewer;
	}

	public void setReviewer(int reviewer) {
		this.reviewer = reviewer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return String.format("[%d]: %d\n%s\n%s", this.id, this.amount,
				this.submitted, this.reviewed);
	}

}
