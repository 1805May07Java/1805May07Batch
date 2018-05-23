package com.rev.excersizes;

public class User {
	//Plain old java object
	
	private String firstName;
	private String lastName;
	private int age;
	private String Email;
	
	public User(String firstName, String lastName, int age, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		Email = email;
	}
	
	public User() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", Email=" + Email + "]";
	}



	static {
		System.out.println("this is a static block in user");
	}
}
