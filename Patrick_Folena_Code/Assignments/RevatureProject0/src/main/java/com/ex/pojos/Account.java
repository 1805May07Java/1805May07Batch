package com.ex.pojos;

public class Account 
{
	private int ID;
	private String nickname;
	private boolean isJoint;
	private String jointPassword;
	private String accountNumber;
	private float accountAmount;
	private int acctType;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public int getAccountType() {
		return acctType;
	}
	public void setAccountType(int type) {
		acctType = type;
	}
	
	public boolean isJoint() {
		return isJoint;
	}
	public void setJoint(boolean isJoint) {
		this.isJoint = isJoint;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getJointPassword() {
		return jointPassword;
	}
	public void setJointPassword(String jointPassword) {
		this.jointPassword = jointPassword;
	}
	
	public float getAccountAmount() {
		return accountAmount;
	}
	public void setAccountAmount(float accountAmount) {
		this.accountAmount = accountAmount;
	}
	
	public void copy(Account copy)
	{
		this.setID(copy.getID());
		this.setNickname(copy.getNickname());
		this.setJoint(copy.isJoint());
		this.setJointPassword(copy.getJointPassword());
		this.setAccountNumber(copy.getAccountNumber());
		this.setAccountAmount(copy.getAccountAmount());
		this.setAccountType(copy.getAccountType());
	}
}
