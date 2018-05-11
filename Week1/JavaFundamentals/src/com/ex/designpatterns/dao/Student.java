package com.ex.designpatterns.dao;

public class Student {
	
	/*
	 * POJO
	 */
	private int id; // hardest 
	private String username;
	private String password;
	private double gpa;
	
	
	public Student() {}
	
	private Student(String username, String password, double gpa) {
		super();
		this.username = username;
		this.password = password;
		this.gpa = gpa;
	}

	public Student(int id, String username, String password, double gpa) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.gpa = gpa;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", gpa=" + gpa + "]";
	}
	
	
	
	
	

}
