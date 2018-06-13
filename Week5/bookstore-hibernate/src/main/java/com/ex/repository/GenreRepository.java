package com.ex.repository;

import java.util.List;

import com.ex.beans.Genre;

public interface GenreRepository {

	Genre addGenre(Genre g);
	List<Genre> getAll();
	Genre updateGenre(Genre g);
	
	
}
