package com.ex.main;

import java.util.List;

import com.ex.dao.Dao;
import com.ex.dao.GenreDao;
import com.ex.pojos.Genre;

public class App {
	
	public static void main(String[] args) {
		Dao<Genre, Integer> genredao = new GenreDao();
		
		List<Genre> genres = genredao.getAll();
		
		for(Genre g : genres) {
			System.out.println(g.toString());
		}
	}

}
