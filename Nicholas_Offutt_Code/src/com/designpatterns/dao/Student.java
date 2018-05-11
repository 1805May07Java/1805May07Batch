package com.designpatterns.dao;



public class Student 
{
	
	//private instance variables
	private int id;
	private String userName;
	private String name;
	private double gpa;
	private String major;
	private String passCode;
	private boolean isEnrolled;
	
	
	
	//general purpose constructor for creating a student object
	Student(int id, String userName, String name, double gpa, String major, String passcode, boolean isEnrolled)
	{
		this.setId(id);
		this.setUserName(userName);
		this.setName(name);
		this.setGpa(gpa);
		this.setMajor(major);
		this.setPassCode(passcode);
		this.setEnrolled(isEnrolled);
	}
	
	
	//default blank constructor
	Student()
	{
		setId(000000);
		setUserName("Blank");
		setName("Blank Test");
		setGpa(0.0);
		setMajor("Undecided");
		setPassCode("test");
		setEnrolled(false);
	}

	
	
	
	
	//all our gets and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPassCode() {
		return passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public boolean isEnrolled() {
		return isEnrolled;
	}

	public void setEnrolled(boolean isEnrolled) {
		this.isEnrolled = isEnrolled;
	}
	
}


