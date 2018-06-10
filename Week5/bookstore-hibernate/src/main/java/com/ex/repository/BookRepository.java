package com.ex.repository;

import java.util.List;

import com.ex.beans.Author;
import com.ex.beans.Book;
import com.ex.beans.Genre;

public interface BookRepository {
	
	Book save(Book b);
	List<Book> getAll();
	Book getById(int id);
	List<Book> getByGenre(Genre g);
	List<Book> getByTitleLike(String title);

}
