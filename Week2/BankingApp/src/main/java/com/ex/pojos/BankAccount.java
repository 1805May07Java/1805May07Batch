package com.ex.pojos;

public class BankAccount 
{
	
	private int id;
	private int typeId;
	private double balance;
	
	
	public BankAccount() {}
	
	public BankAccount(int typeId, double balance) {
		super();
		this.typeId = typeId;
		this.balance = balance;
	}
	
	public BankAccount(int id, int typeId, double balance) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", typeId=" + typeId + ", balance=" + balance + "]";
	}
	
	
	

}
