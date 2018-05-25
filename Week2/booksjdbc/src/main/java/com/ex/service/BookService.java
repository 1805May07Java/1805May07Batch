package com.ex.service;

import java.util.List;

import com.ex.dao.BookDao;
import com.ex.dao.Dao;
import com.ex.pojos.Author;
import com.ex.pojos.Book;

public class BookService {

	static Dao<Book, Integer> bookdao = new BookDao();
	
	public List<Book> getBooksByAuthor(Author a){
		return null;
	}

	public List<Book> getAllBooks(){
		return bookdao.getAll();
	}

	public void addBookToAuthor(Author a, Book b){

	}
	public Book getBookById(int id){
	    Book book = new Book();

	    return book;
    }




}
