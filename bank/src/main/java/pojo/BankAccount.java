package pojo;

import java.text.DecimalFormat;

public class BankAccount {
	private int id;
	private double balance;
	private int account_type;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int id, double balance, int account_type) {
		super();
		this.id = id;
		this.balance = balance;
		this.account_type = account_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		String type = "Bank";
		switch(account_type) {
		case 1: type = "Credit"; break;
		case 2: type = "Savings"; break;
		case 3: type = "Checking"; break;
		}
		DecimalFormat money = new DecimalFormat("0.00");
		return type + " Account " + id + ": balance: $" + money.format(balance);
	}


}
