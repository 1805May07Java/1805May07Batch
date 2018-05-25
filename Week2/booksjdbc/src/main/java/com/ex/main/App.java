package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Author;
import com.ex.pojos.Book;
import com.ex.pojos.Genre;
import com.ex.service.AuthorService;
import com.ex.service.BookService;
import com.ex.service.GenreService;

public class App {
<<<<<<< HEAD
	static BookService bookService = new BookService();
=======
	static Scanner scan = new Scanner(System.in);
	static BookService bs = new BookService();
	static GenreService gs = new GenreService();
	static AuthorService as = new AuthorService();

>>>>>>> master
	public static void main(String[] args) {
		System.out.println("Welcome to the book store app!");
		run();



	}

	static void run() {
		System.out.println("---------Main Menu----------\n"
				+ "1. View All Books\n"
				+ "2. View All Authors\n"
				+ "3. View All Genres\n"
				+ "4. Add Book\n"
				+ "5. Add Author" );

		int option = Integer.parseInt(scan.nextLine());

		switch(option) {
		case 1: viewBooks(); break;
		case 2:
		case 3: 
		case 4: addBook(); break;
		case 5:
		default: break;
		}

	}

	static void addBook() {
		System.out.println("Enter your ISBN:");
		String isbn = scan.nextLine();
		if(!bs.unique(isbn)) {  // make sure user does not enter more than 10 chars
			System.out.println("Sorry that ISBN is not unique!");
			addBook();
			return;
		}
		System.out.println("Title:");
		String title = scan.nextLine();
		System.out.println("Price:");
		double price = Double.parseDouble(scan.nextLine());
		System.out.println("Enter a Genre ID from the following:");
		viewGenres();
		int genre = Integer.parseInt(scan.nextLine());
		Book book = new Book(isbn, title, price, genre);
		
		
		
		System.out.println("Who wrote this book? Enter 0 for a new author, or the id of one of the following:");
		viewAuthorsNoBio();
		int id = Integer.parseInt(scan.nextLine());
		if (id == 0) addAuthor();
		else {
			Author dummy = new Author();
			dummy.setId(id); // do input validation; make sure user entered valid authorid
			// we create this dummy to pass it to the bookauthor object, which only needs id's
			
			book = bs.addBook(book);
			bs.addBookAuthor(dummy, book);
		}
		
	}
	
	static void viewAuthorsNoBio() {
		List<Author> authors = as.getAll();
		for(Author a: authors) {
			System.out.println(a.getId() + ": " + a.getFirstName() + " "+ a.getLastName());
			
		}
	}
	
	static void viewGenres() {
		List<Genre> genres = gs.getAll();
		for(Genre g : genres) {
			System.out.println(g.getId() + ": " + g.getName());
		}
	}
	static void viewBooks() {

		List<Book> books = bs.getAllBooks();
		System.out.println("We have the following books in store. To edit a book, enter its id."
				+ "To return to the main menu, type any non-number");
		for(Book b : books) {
			System.out.println(b.toString());
		}
		int id = 0;
		try {
			id = Integer.parseInt(scan.nextLine());
			editBook(id);
		}
		catch(NumberFormatException e) {
			run();
		}

	}

	static void addAuthor() {
		System.out.println("Enter the Author's first name");
		String fn = scan.nextLine();
		System.out.println("Enter the Author's last name");
		String ln = scan.nextLine();
		System.out.println("Enter their bio");
		String bio = scan.nextLine();
		Author a = new Author(fn, ln, bio);
		as.add(a);
	}

	static void editBook(int id) {
<<<<<<< HEAD
		Book book = bookService.getBookById(id);
=======
		Book book = bs.getById(id);
		boolean more = true;

		while(more) {
			System.out.println("Book No. " + id + "\n"
					+  "(I)SBN: " + book.getIsbn() + "\n"
					+  "(T)itle: " + book.getTitle() + "\n"
					+  "(P)rice: $" + book.getPrice() + "\n"
					+  "(G)enre: " + gs.findById(book.getGenreId()).getName());
			String option = scan.nextLine();
			switch(option.toLowerCase()) {
			case("i"):
				System.out.println("New ISBN:");
			String isbn = scan.nextLine();
			boolean unique = bs.unique(isbn);
			if(unique)	book.setIsbn(isbn);
			else {
				System.out.println("sorry, ISBN not unique");
				continue;
			}
			break;
			case("t"):
				System.out.println("New Title:");
			book.setTitle(scan.nextLine());
			break;
			case("p"):
				System.out.println("New Price:");
			book.setPrice(Double.parseDouble(scan.nextLine()));
			break;
			case("g"): break;
			// list all genres allow them to pick from menu
			}

			System.out.println("Edit more? Y/N");
			String edit = scan.nextLine();
			if(edit.equalsIgnoreCase("n")) more = false;
		}
		bs.update(book);
>>>>>>> master
	}


}
