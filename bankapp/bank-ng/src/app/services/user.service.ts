import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { error } from 'selenium-webdriver';
import { User } from '../models/user.model';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UserService {

  private url = 'http://localhost:8089/spring-mvc-data/users';

  constructor(private http: HttpClient) { }

  public getUsers() {
    return this.http.get<User[]>(this.url);
  }

  public addUser(user: User) {
  return this.http.post<User>(this.url, user, httpOptions);
  }

  public getByUsername(username: string) { // will likely need to change url to access this once we create our actual API
  return this.http.get<User>(`${this.url}/username=${username}`);
  }
}
