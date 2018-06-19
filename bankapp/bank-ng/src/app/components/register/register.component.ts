import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  firstname: string;
  lastname: string;
  password: string;
  username: string;
  message: string;
  user: User = new User();
  valid = false;
  registered = false;

  // add password validation?
  constructor(private uService: UserService, private router: Router) { }

  ngOnInit() { }

  fullForm() {
    this.message = '';
    console.log(`firstname: ${this.firstname} lastname: ${this.lastname} password: ${this.password} username: ${this.username}`);
    if (this.firstname != null && this.lastname != null && this.password != null && this.username != null) {
      this.register();
    } else {
      this.message = 'Please fill out all fields!';
      this.valid = true;
    }

  }

  setUser() {
    this.user.firstname = this.firstname;
    this.user.lastname = this.lastname;
    this.user.password = this.password;
    this.user.username = this.username;
  }

  validate() {
    console.log('validating email');
    this.message = '';
    this.uService.getByUsername(this.username)
      .subscribe(
      data => {
        console.log(data);
        if (data == null) {
          this.valid = true;
        } else {
          this.message = 'Username taken';
        }
      }, err => {
        console.log('Error occurred');
      });
  }


register() {
  this.setUser();
  console.log('adding user' + this.firstname + this.lastname);
  this.uService.addUser(this.user)
    .subscribe(
    (user) => this.message = `Congratulations ${user.firstname}! Welcome to the app! Please log in with your credentials`
    );
  this.registered = true;

}

toLogin() {
  this.router.navigate(['']);
}


}
