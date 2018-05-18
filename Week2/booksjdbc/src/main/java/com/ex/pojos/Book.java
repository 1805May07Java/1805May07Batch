package com.ex.pojos;

public class Book {
	
	private int id;
	private long isbn;
	private String title;
	private double price;
	private int genreId;
	
	public Book() {}
	
	public Book(long isbn, String title, double price, int genreId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genreId = genreId;
	}

	public Book(int id, long isbn, String title, double price, int genreId) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genreId = genreId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
	
	
	

}
