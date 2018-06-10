package com.ex.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="BS_BOOKS")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book")
	@SequenceGenerator(name="book", sequenceName="book_seq", allocationSize=1)
	@Column(name="BOOK_ID")
	private int id;
	private String isbn;
	private String title;
	private double price;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="BOOK_GENRE")
	private Genre genreId;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="BOOK_AUTHORS",
			joinColumns=@JoinColumn(name="BOOK_ID"),
			inverseJoinColumns=@JoinColumn(name="AUTHOR_ID"))
	private Set<Author> authors;
	
	public Book() {}

	public Book(int id, String isbn, String title, double price, Genre genreId, Set<Author> authors) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.genreId = genreId;
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
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

	public Genre getGenreId() {
		return genreId;
	}

	public void setGenreId(Genre genreId) {
		this.genreId = genreId;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", price=" + price + ", genreId=" + genreId.toString()
				+ ", authors=" + authors.toString() + "]";
	}
	
	
	
	

}
