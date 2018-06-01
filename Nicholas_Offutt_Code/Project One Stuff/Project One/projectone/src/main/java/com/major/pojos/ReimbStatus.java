package com.major.pojos;

public class ReimbStatus 
{
	private int id;
	private String status;
	
	//constructors
	public ReimbStatus() {
		super();
	}

	public ReimbStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	
	//get an sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
