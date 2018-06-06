package com.ex.pojos;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;

import com.ex.service.ReimbStatusService;
import com.ex.service.ReimbTypeService;
import com.ex.service.ReimbursementService;
import com.ex.service.UserService;

public class Reimbursement {
	int ID;
	double amount;
	Date submitTime;
	Date resolveTime;
	String description;
	String reciept_64;
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date date) {
		this.submitTime = date;
	}
	public Date getResolveTime() {
		return resolveTime;
	}
	public void setResolveTime(Date date) {
		this.resolveTime = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReciept() {
		return reciept_64;
	}
	public void setReciept(Blob reciept) {
		if(reciept == null) reciept_64 = "";
		else try {
			reciept_64 = Base64.getEncoder().encodeToString(reciept.getBytes(1, (int)reciept.length()));
		} catch (SQLException e) {
			System.out.println("Unable to encode incoming Blob object");
			reciept_64 = "";
		}
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
