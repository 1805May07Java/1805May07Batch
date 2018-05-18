package com.ex.main;

import java.util.List;

import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.dao.GenreDao;
import com.ex.pojos.Book;
import com.ex.pojos.Genre;

public class App {
	
	public static void main(String[] args) {
		Dao<Genre, Integer> genredao = new GenreDao();
		
//		List<Genre> genres = genredao.getAll();
//		
//		for(Genre g : genres) {
//			System.out.println(g.toString());
//		}

		
		Dao<Book, Integer> bd = new BookDao();
		List<Book> books = bd.getAll();
		for(Book b : books) {
			System.out.println(b.toString());
		}
	}

}
