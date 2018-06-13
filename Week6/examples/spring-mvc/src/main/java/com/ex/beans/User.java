package com.ex.beans;

public class User {
	
	String name;
	String pass;
	String favColor;
	
	public User() {}
	
	public User(String name, String pass, String favColor) {
		super();
		this.name = name;
		this.pass = pass;
		this.favColor = favColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFavColor() {
		return favColor;
	}

	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}
	
	
	
	
	

}
