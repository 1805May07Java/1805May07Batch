package com.proj0.pojo;

public class AccountType {
	private int accountTypeId;
	private String accountTypeLabel;
	
	public AccountType() {
		super();
	}
	public AccountType(int accountTypeId, String accountTypeLabel) {
		super();
		this.accountTypeId = accountTypeId;
		this.accountTypeLabel = accountTypeLabel;
	}
	
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getAccountTypeLabel() {
		return accountTypeLabel;
	}
	public void setAccountTypeLabel(String accountTypeLabel) {
		this.accountTypeLabel = accountTypeLabel;
	}
	
}
