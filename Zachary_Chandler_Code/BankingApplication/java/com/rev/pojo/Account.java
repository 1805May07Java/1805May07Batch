package com.rev.pojo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Account {
	private long AccountID;
	private long CustomerID;
	private AccountType type;
	private long Balance;
	
	public long getAccountID() {
		return AccountID;
	}
	
	public void setAccountID(long accountID) {
		AccountID = accountID;
	}

	public long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(long customerID) {
		CustomerID = customerID;
	}

	public long getBalance() {
		return Balance;
	}

	public void setBalance(long balance) {
		Balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		for (Field f : this.getClass().getDeclaredFields()) {
			
			
			try {
				
				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				
				String value = f.get(this).toString();
				
				result.append(f.getName());
				result.append(": ");
				result.append(value);
				result.append('\n');
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		return result.toString();
	}
}
