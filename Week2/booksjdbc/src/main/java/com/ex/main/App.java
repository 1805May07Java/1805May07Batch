package com.ex.main;

import java.util.List;
import java.util.Scanner;

import com.ex.pojos.Book;
import com.ex.service.BookService;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to the book store app!");
		run();

	}

	static void run() {
		System.out.println("---------Main Menu----------\n"
				+ "1. View All Books\n"
				+ "2. View All Authors\n"
				+ "3. View All Genres\n"
				+ "4. Add Book"
				+ "5. Add Author" );

		Scanner scan = new Scanner(System.in);
		int option = Integer.parseInt(scan.nextLine());

		switch(option) {
		case 1: viewBooks(); break;
		case 2:
		case 3: 
		case 4:
		case 5:
		default: break;
		}
		
		scan.close();
	}

	static void viewBooks() {
		BookService bs = new BookService();
		List<Book> books = bs.getAllBooks();
		System.out.println("We have the following books in store. To edit a book, enter its id."
				+ "To return to the main menu, type any non-number");
		for(Book b : books) {
			System.out.println(b.toString());
		}
		Scanner scan = new Scanner(System.in);
		int id = 0;
		try {
			id = Integer.parseInt(scan.nextLine());
			editBook(id);
		}
		catch(NumberFormatException e) {
			run();
		}
		
		scan.close();
	}

	static void add() {}

	static void editBook(int id) {
		
	}


}
