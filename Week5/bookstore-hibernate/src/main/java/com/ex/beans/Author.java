package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BS_AUTHORS")
public class Author {
	
	@Id
	@Column(name="AUTHOR_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="author")
	@SequenceGenerator(name="author", sequenceName="author_seq", allocationSize=1)
	private int id;
	
	@Column(name="FIRST_NAME")
	private String firstname;
	
	@Column(name="LAST_NAME")
	private String lastname;
	
	@Column(name="BIO")
	private String bio;
	
	public Author() {}

	public Author(String firstname, String lastname, String bio) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
	}

	public Author(int id, String firstname, String lastname, String bio) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", bio=" + bio + "]";
	}
	
	

}
