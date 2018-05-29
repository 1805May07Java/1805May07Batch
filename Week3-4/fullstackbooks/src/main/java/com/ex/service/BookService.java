package com.ex.service;

import java.util.List;

import com.ex.dao.BookAuthorDao;
import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.pojos.Author;
import com.ex.pojos.Book;
import com.ex.pojos.BookAuthor;

public class BookService {

	static Dao<Book, Integer> bookdao = new BookDao();
	static Dao<BookAuthor, Integer> joindao = new BookAuthorDao();
	
	public List<Book> getBooksByAuthor(Author a){
		return null;
	}
	
	public void update(Book b) {
		bookdao.update(b);
	}

	public List<Book> getAllBooks(){
		return bookdao.getAll();
	}

	public Book addBook(Book b){
		return bookdao.save(b);
	}
	
	public void addBookAuthor(Author a, Book b) {
		joindao.save(new BookAuthor(b, a));
	}

	public Book getById(int id) {
		return bookdao.findOne(id);
	}

	public boolean unique(String isbn) {
		Book dummy = new Book();
		dummy.setIsbn(isbn);
		return bookdao.isUnique(dummy);
		
	}


}
