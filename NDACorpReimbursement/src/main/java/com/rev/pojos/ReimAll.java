package com.rev.pojos;

public class ReimAll {
	private int reimId;
	private double reimAmmount;
	private String dateSub;
	private String dateRes;
	private String notes;
	private String author;
	private String resolver;
	private String status;
	private String type;
	
	public ReimAll(int reimId, double reimAmmount, String dateSub, String dateRes, String notes, String author,
			String resolver, String status, String type) {
		this.reimId = reimId;
		this.reimAmmount = reimAmmount;
		this.dateSub = dateSub;
		this.dateRes = dateRes;
		this.notes = notes;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimAll [reimId=" + reimId + ", reimAmmount=" + reimAmmount + ", dateSub=" + dateSub + ", dateRes="
				+ dateRes + ", notes=" + notes + ", author=" + author + ", resolver=" + resolver + ", status=" + status
				+ ", type=" + type + "]";
	}

	public ReimAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public double getReimAmmount() {
		return reimAmmount;
	}

	public void setReimAmmount(double reimAmmount) {
		this.reimAmmount = reimAmmount;
	}

	public String getDateSub() {
		return dateSub;
	}

	public void setDateSub(String dateSub) {
		this.dateSub = dateSub;
	}

	public String getDateRes() {
		return dateRes;
	}

	public void setDateRes(String dateRes) {
		this.dateRes = dateRes;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResolver() {
		return resolver;
	}

	public void setResolver(String resolver) {
		this.resolver = resolver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
	
}
