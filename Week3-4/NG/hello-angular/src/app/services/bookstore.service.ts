import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { Genre } from '../models/genre.model';

import 'rxjs/Rx';

@Injectable()
export class BookStoreService {

    public getGenres(): Observable<Genre[]> {
        return null;
    }
}
