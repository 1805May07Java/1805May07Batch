package com.ex.main;

import com.ex.beans.Genre;
import com.ex.repository.GenreRepository;
import com.ex.repository.GenreRepositoryHibernate;

public class MainTest {

	public static void main(String[] args) {
		
		GenreRepository genreRep = new GenreRepositoryHibernate();
		Genre g = new Genre();
		g.setGenre("Hip-Hop");
		genreRep.addGenre(g);
	}

}
