package com.ex.pojos;

import java.sql.Blob;

public class Reimbursement {
	int ID;
	int amount;
	String submitTime;
	String resolveTime;
	String description;
	Blob reciept;
	int author;
	int resolver;
	int status;
	int type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getResolveTime() {
		return resolveTime;
	}
	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReciept() {
		return reciept;
	}
	public void setReciept(Blob reciept) {
		this.reciept = reciept;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
