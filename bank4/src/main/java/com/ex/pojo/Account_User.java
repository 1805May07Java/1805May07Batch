package com.ex.pojo;

import java.util.UUID;

public class Account_User {
	private UUID accountid;
	private UUID userid;
	
	
	public Account_User(UUID accountid, UUID userid) {
		super();
		this.accountid = accountid;
		this.userid = userid;
	}
	
	public UUID getAccountid() {
		return accountid;
	}
	public void setAccountid(UUID accountid) {
		this.accountid = accountid;
	}
	
	public UUID getUserId() {
		return userid;
	}
	public void setUserId(UUID userid) {
		this.userid=userid;
	}
	
}
