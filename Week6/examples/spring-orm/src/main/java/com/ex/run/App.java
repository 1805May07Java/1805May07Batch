package com.ex.run;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.Author;
import com.ex.beans.Book;
import com.ex.beans.Genre;
import com.ex.repository.BookRepository;
import com.ex.service.BookService;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BookRepository repo = ac.getBean("bookRepository", BookRepository.class);
		/*
		Book b = new Book("2233445566", "The Illiad", 85.00);
		Author a = new Author("Homer", "HisLastName", "World reknown author");
		Author a2 = new Author("Test", "Author", "ipsum");
		Set<Author> authors = new HashSet<Author>();
		authors.add(a);
		authors.add(a2);
		b.setAuthors(authors);
		
		Genre g = new Genre("Classic");
		b.setGenreId(g);
		
		repo.add(b);
		*/
		
	///////////////// use service layer
		
		BookService bs = ac.getBean("bookService", BookService.class);
		List<Book> books = bs.getAllBooks();
		for(Book book : books) {
			System.out.println(book.toString());
		}
		
	}

}
