package com.ex.pojos;

public class BankAccount {
	int account_id;
	double balance;
	int bank_type;
	int owner_id;
	
	public BankAccount(){}

	public BankAccount(int account_id, double balance, int bank_type, int owner_id) {
		super();
		this.account_id = account_id;
		this.balance = balance;
		this.bank_type = bank_type;
		this.owner_id = owner_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBank_type() {
		return bank_type;
	}

	public void setBank_type(int bank_type) {
		this.bank_type = bank_type;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "BankAccount [account_id=" + account_id + ", balance=" + balance + ", bank_type=" + bank_type
				+ ", owner_id=" + owner_id + "]";
	}

	
}
