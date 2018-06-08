package com.Project1.pojos;

public class Reimb {
	int id;
	double amount;
	String submitted;
	String resolved;
	String description;
	int author;
	int resolver;
	int statusId;
	int reimbType;
	
	

	public Reimb(int id, double amount, String submitted, String resolved, String description, int author, int resolver,
			int statusId, int typeId) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusId = statusId;
		this.reimbType = typeId;
	}
	
	

	public Reimb(double amount, String description, int typeId, int author) {
		super();
		this.amount = amount;
		this.description = description;
		this.reimbType = typeId;
		this.author = author;
	}



	public Reimb() {}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
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
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getReimbType() {
		return reimbType;
	}
	public void setReimbType(int typeId) {
		this.reimbType = typeId;
	}
	
	
}
