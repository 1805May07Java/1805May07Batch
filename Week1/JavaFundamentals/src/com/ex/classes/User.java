package com.ex.classes;

public class User {
	//PLAIN OL JAVA OBJECT (POJO)
	//meant to represent real-life entities
	
	
	private String firstname;
	private String lastname;
	private int age;
	private String email;
	
	public User() {
	System.out.println("this is the no arg constructor");
	}
	
	public User(String firstname, String lastname, int age, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		System.out.println("this is the argument constructor");
	}

	//GETTERS AND SETTER METHODS AKA ACCESSOR AND MUTATOR METHODS, RESPECTIVELY 
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", email=" + email + "]";
	}

	static {
		System.out.println("this is a static block in the user class");
	}
	

}
