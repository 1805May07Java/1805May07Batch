package com.major.pojos;

public class ClaimDecision 
{
	private int id;
	private String decision;
	
	public ClaimDecision() {
		super();
	}
	
	public ClaimDecision(int id, String decision) {
		super();
		this.id = id;
		this.decision = decision;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String isDecision() {
		return decision;
	}
	
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
}
