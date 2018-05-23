package com.rev.designpatterns.dao;

//import java.io.Serializable;

public class Student /*implements Serializable*/{
	
	
	@Override
	public String toString() {
		return id + ":" + userName + ":" + password + ":" + gpa + "\n";
	}
	private int id;
	private String name;
	private String userName;
	transient private String password;
	private double gpa;
	
	
	
	public Student(String userName, String password, double gpa) {
		super();
		//this.name = name;
		this.userName = userName;
		this.password = password;
		this.gpa = gpa;
	}
	public Student(int id, String userName, String password, double gpa) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gpa = gpa;
	}
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
}
