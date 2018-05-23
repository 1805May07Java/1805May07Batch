package com.ex.pojos;

public class Person {
	int person_id;
	String firstname;
	String lastname;
	String username;
	String password;
	
	public Person() {}

	public Person(int person_id, String firstname, String lastname, String username, String password) {
		super();
		this.person_id = person_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

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

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + "]";
	}
		
}
