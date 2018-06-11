import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import 'rxjs/Rx';

import { User } from '../models/user.model';

@Injectable()
export class UserService {


  temp: User;
  constructor(private http: HttpClient) {  }

  add() {

  }
  private handleError(error: Response) {
    return Observable.throw(error.statusText);
}

  public getUsers(): Observable<User[]> {
    return this.http
    .get('http://localhost:8083/helloservlets/users')
    .catch(this.handleError);
  }

}
