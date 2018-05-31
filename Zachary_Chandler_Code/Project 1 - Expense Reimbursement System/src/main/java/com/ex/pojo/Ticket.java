package com.ex.pojo;

import java.sql.Date;
import java.util.NoSuchElementException;

public class Ticket {
	private long id;
	private long ammount;
	private Date submitted;
	private Date resolved;
	private String description;
	private User author;
	private User resolver;
	private Status status;
	private Type type;
	
	public static enum Type {

		Lodging(0), Travel(1), Food(2), Other(3);

		public int value;
		
		private Type(int value) {
			this.value = value;
		}
		
		public static Type translate(int value) {
			Type[] values = values();

			for (int i = 0; i < values.length; i++) {
				if (values[i].value == value) {
					return values[i];
				}
			}
			
			throw new NoSuchElementException();
		}
	}
	
	public enum Status {

		Pending(0), Approved(1), Denied(2);

		public int value;
		
		private Status(int value) {
			this.value = value;
		}
		
		public static Status translate(int value) {
			Status[] values = values();

			for (int i = 0; i < values.length; i++) {
				if (values[i].value == value) {
					return values[i];
				}
			}
			
			throw new NoSuchElementException();
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAmmount() {
		return ammount;
	}

	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}

	public Date getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Date submitted) {
		this.submitted = submitted;
	}

	public Date getResolved() {
		return resolved;
	}

	public void setResolved(Date d) {
		this.resolved = d;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
}
