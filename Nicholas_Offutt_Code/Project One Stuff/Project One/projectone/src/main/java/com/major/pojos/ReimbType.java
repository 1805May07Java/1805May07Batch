package com.major.pojos;

public class ReimbType 
{
	private int id;
	private String type;
	
	//constructors	
	public ReimbType() {
		super();
	}

	public ReimbType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	//get and sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
