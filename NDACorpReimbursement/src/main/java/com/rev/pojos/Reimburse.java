package com.rev.pojos;

public class Reimburse {
	private int reimId;
	private double reimAmmount;
	private String dateSub;
	private String dateRes;
	private String notes;
	private int author;
	private int resolver;
	private int status;
	private int type;
	
	
	public Reimburse(int reimId, double reimAmmount, String dateSub, String dateRes, String notes, int author,
			int resolver, int status, int type) {
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

	public Reimburse(double reimAmmount, String dateSub, String dateRes, String notes, int author, int resolver,
			int status, int type) {
		this.reimAmmount = reimAmmount;
		this.dateSub = dateSub;
		this.dateRes = dateRes;
		this.notes = notes;
		this.author = author;
		this.resolver = resolver;
		this.status = status;
		this.type = type;
	}
	
	public Reimburse() {}

	@Override
	public String toString() {
		return "reimburse= " + reimId + ", reimAmmount= " + reimAmmount + ", dateSub= " + dateSub + ", dateRes= "
				+ dateRes + ", notes= " + notes + ", author= " + author + ", resolver= " + resolver + ", status= " + status
				+ ", type= " + type;
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

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	};
	
	
}
