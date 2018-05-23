package com.ex.pojo;

import java.util.UUID;

public class User {
	
	private UUID userid;
	private String uname;
	private String pwd;
	private String fname;
	private String lname;
	
	public User() {}
	
	public User(UUID userid, String uname, String pwd, String fname, String lname) {
		super();
		this.userid = userid;
		this.uname = uname;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
	}

	public UUID getUserId() {
		return userid;
	}

	public void setUserId(UUID userid) {
		this.userid = userid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
}
