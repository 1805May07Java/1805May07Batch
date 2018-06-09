package com.rev.pojos;

public class ReimTypes {
	private int id;
	private String type;
	
	
	
	public ReimTypes(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public ReimTypes() {

	}

	@Override
	public String toString() {
		return "ReimTypes [Id=" + id + ", type=" + type + "]";
	}

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
