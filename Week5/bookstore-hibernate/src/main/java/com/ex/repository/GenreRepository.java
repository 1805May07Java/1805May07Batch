package com.ex.repository;

import java.util.List;

import com.ex.beans.Genre;

public interface GenreRepository {

	public Genre addGenre(Genre g);
	public List<Genre> getAll();
	
	
}
