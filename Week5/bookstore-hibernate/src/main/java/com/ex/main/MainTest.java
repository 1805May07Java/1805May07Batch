package com.ex.main;

import java.util.List;

import com.ex.beans.Book;
import com.ex.repository.BookRepository;
import com.ex.repository.BookRepositoryHibernate;

public class MainTest {

	public static void main(String[] args) {
		BookRepository bookRepo = new BookRepositoryHibernate();
		/* Objects in Hibernate have states. There are 3 states
		 * 1) Transient("new")
		 * 	- An object is transient if instantiated using the new 
		 * 		operator, and has never been associated with a Hibernate session
		 * 	- It has no persistent representation in the database, and no
		 * 		ID has been assigned
		 * 	- Transient instances will be destroyed by the garbage collector
		 * 		if the application does not hold a reference anymore (as it
		 *		does with any object)
		 *  - Use the Hibernate session to persist transient objects
		 * 2) Persistent
		 * 	- A persistent instance has a representation in the DB and has 
		 * 		and identifier value. It might have been saved (save()) or 
		 * 		loaded (load()) but by definition it is in the scope of the Session
		 *  - Hibernate will detect any changes made to an object in 
		 *  	the persistent state and synchronize the state with the 
		 *  	database when the unit of work (tx) is complete
		 *  3) Detached 
		 *  - A detached instance is an object that has persisted but its 
		 *  	Session has closed. The reference to the object is still 
		 *  	valid and the detached instance might even be modified 
		 *  	in this state, but it is no longer associated with a Session
		 *  - A detached instance can be reattached to a new Session at a later point 
		 *  	in time, making it and all its modifications persistent again
		 */
		/*
		//Example detailing Hibernate object states
		GenreRepository genreRep = new GenreRepositoryHibernate();
		Genre g = new Genre();
		g.setGenre("Transient"); //object is in transient state
		
		try(Session session = ConnectionUtil.getSession()) {
			Transaction tx = session.beginTransaction();
			int id = (Integer) session.save(g); //Object is now in the persistent state
			g.setGenre("Persistent");
			g.setGenre("Changing again");
			g.setGenre("Imagine if we made all these DB connections for one commit");
			g.setGenre("Ha");
			System.out.println("after save, before commit");
			tx.commit(); 
			g.setId(id);
			g.setGenre("Detached");
			System.out.println(g.toString());
		}	
		*/
		
		/*
		//Demonstrating adding a new Author, Genre, Book
		Author a1 = new Author("RL", "Stein", "This author has a marvelously scary set of books");
		Author a2 = new Author("Stephen", "King", "He is awesome. and indestructable. wow.");
		
		Genre g = new Genre();
		g.setGenre("Thriller");
		
		Book b = new Book();
		b.setTitle("Goosebumps ft SK");
		b.setPrice(11.99);
		b.setIsbn("8562147896");
		b.setGenreId(g);
		Set<Author> authors = new HashSet<Author>();
		authors.add(a1);
		authors.add(a2);
		b.setAuthors(authors);
		bookRepo.save(b); */
		
		/*
		// Retrieve information from DB. Take a look at fetching strategies here
		Book demo = bookRepo.getById(1);
		Genre g = demo.getGenreId();
		int a = demo.getAuthors().size();
		System.out.println(a);
		System.out.println(demo.toString());
		*/
		
		List<Book> books = bookRepo.getAll();
		for (Book b : books) {
			System.out.println(b.toString());
		}
	}

}
