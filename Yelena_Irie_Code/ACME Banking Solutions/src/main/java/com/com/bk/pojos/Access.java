package com.bk.pojos;

import com.bk.dao.DAO;

public class Access extends User {
   
	private String username;

	private String password;
	private int id=-1;
	public boolean status = false;

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Access(String username, String password) {

		this.username = username;
		this.password = password;
	}

	public Access() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	boolean Status() {
		return false;
	}


}
