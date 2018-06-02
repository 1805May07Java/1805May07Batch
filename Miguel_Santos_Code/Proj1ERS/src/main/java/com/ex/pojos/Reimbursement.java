package com.ex.pojos;

import java.sql.Timestamp;

public class Reimbursement{
    private int id;
    private double amount;
    private Timestamp time_submitted;
    private Timestamp time_resolved;
    private String description;
    private int author_id;
    private int resolver_id;
    private int status_id;
    private int type_id;

    public Reimbursement() {};
    public Reimbursement(double amount, Timestamp submitted, String description, int author_id, int resolver_id, int status_id, int type_id) {
    	
    };
    public Reimbursement(double amount, Timestamp submitted, int author_id, int status_id, int type_id) {
    	
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
	public Timestamp getTime_submitted() {
		return time_submitted;
	}
	public void setTime_submitted(Timestamp time_submitted) {
		this.time_submitted = time_submitted;
	}
	public Timestamp getTime_resolved() {
		return time_resolved;
	}
	public void setTime_resolved(Timestamp time_resolved) {
		this.time_resolved = time_resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public int getResolver_id() {
		return resolver_id;
	}
	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	};
    

}