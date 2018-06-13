import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Genre } from '../models/genre.model';
import { Book } from '../models/book.model';
import { BookAuthor } from '../models/bookauthor.model';
import { Author } from '../models/author.model';

import 'rxjs/Rx';


@Injectable()
export class BookStoreService {

    constructor(private http: HttpClient) {}

    public handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
    public getGenres(): Observable<Genre[]> {
        return this.http.get('http://localhost:3000/genres').catch(this.handleError);
    }

    public getBooks(): Observable<Book[]> {
        return this.http.get('http://localhost:3000/books').catch(this.handleError);
    }
    public getBookAuthors(): Observable<BookAuthor[]> {
        return this.http.get('http://localhost:3000/book_authors').catch(this.handleError);
    }

    public getAuthors(): Observable<Author[]> {
        return this.http.get('http://localhost:3000/authors').catch(this.handleError);
    }
}
