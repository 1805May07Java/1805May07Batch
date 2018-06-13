package com.ex.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BS_GENRES")
public class Genre {
	
	@Id
	@Column(name="GENRE_ID")
	@SequenceGenerator(name="G_SEQ_GEN", sequenceName="G_SEQ")	
	@GeneratedValue(generator="G_SEQ_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="GENRE", nullable=false)
	private String genre;

	public Genre() {}
	
	public Genre(String genre) {
		super();
		this.genre = genre;
	}
	
	public Genre(int id, String genre) {
		super();
		this.id = id;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}