import { Component, OnInit } from '@angular/core';
import { BookStoreService } from '../../services/bookstore.service';

import { Genre } from '../../models/genre.model';
import { Book } from '../../models/book.model';
import { BookAuthor } from '../../models/bookauthor.model';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  genres: Genre[] = [];
  books: Book[] = [];
  bookauthors: BookAuthor[] = [];

  constructor(private bookstoreService: BookStoreService) { }

  ngOnInit() {
    this.getGenres();
    this.getBooks();
  }

  getBookAuthors() {
    this.bookstoreService.getBookAuthors().subscribe(
      ba => {
        if (ba != null) {
          this.bookauthors = ba;
        } else {
          console.log('null');
        }
      }
    );
  }

  getGenres(): void {
    this.bookstoreService.getGenres().subscribe(
      g => {
        if (g != null) {
          this.genres = g;
          console.log('loaded genres');
        } else {
          console.log('null');
        }
      }
    );
  }

  getGenreById(id: number) {
    let gen = '';
    console.log(id);
    this.genres.filter(g => {
      if (g.id === id) {
        console.log(g.name);
        gen = g.name;
      }
    });
    return gen;
  }
  getBooks(): void {
    this.bookstoreService.getBooks().subscribe(
      b => {
        if (b != null) {
          this.books = b;
          console.log('loaded books');
        } else {
          console.log('no books loaded');
        }
      }
    );
  }


  getAuthorByBook(book: Book) {

  }

}
