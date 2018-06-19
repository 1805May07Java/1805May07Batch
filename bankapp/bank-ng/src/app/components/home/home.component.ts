import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string;
  password: string;
  message: string;

  constructor(private router: Router, private uService: UserService) { }

  ngOnInit() {
  }

  login() {
    console.log('-- in login--');
    this.uService.getByUsername(this.username)
    .subscribe(
    data => {
      console.log(data);
      if (data == null) {
        console.log('something wrong');
      } else {
        if (data.password === this.password) {
          console.log('passwords match');
          localStorage.setItem('currentUser', JSON.stringify(data));
          this.router.navigate(['landing']);
        }
      }
    }, err => {
      console.log('Error occurred');
    });
  }

  register() {
    this.router.navigate(['register']);
  }

}
