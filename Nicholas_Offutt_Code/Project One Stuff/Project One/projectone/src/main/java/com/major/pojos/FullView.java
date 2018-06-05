package com.major.pojos;

//class for passing an easier full view for display.
public class FullView 
{
	private int id;
	private String authorFirst;
	private String authorLast;
	private double amount;
	private String description;
	private String submit;
	private String resolved;
	private String type;
	private String status;
	private String resolverFirst;
	private String resolverLast;
	private int reqId;
	private int resolvId;
	
	public FullView() {
		super();
	}
	
	//get and set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorFirst() {
		return authorFirst;
	}
	public void setAuthorFirst(String first) {
		this.authorFirst = first;
	}
	public String getAuthorLast() {
		return authorLast;
	}
	public void setAuthorLast(String last) {
		this.authorLast = last;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolverFirst() {
		return resolverFirst;
	}

	public void setResolverFirst(String resolverFirst) {
		this.resolverFirst = resolverFirst;
	}

	public String getResolverLast() {
		return resolverLast;
	}

	public void setResolverLast(String resolverLast) {
		this.resolverLast = resolverLast;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getResolvId() {
		return resolvId;
	}

	public void setResolvId(int resolvId) {
		this.resolvId = resolvId;
	}
	
}

