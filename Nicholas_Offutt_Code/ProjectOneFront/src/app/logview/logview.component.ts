import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';

@Component({
  selector: 'app-logview',
  templateUrl: './logview.component.html',
  styleUrls: ['./logview.component.css']
})
export class LogviewComponent implements OnInit {

  constructor(private service: LoginServiceService) 
  {}

  ngOnInit() {
  }

}
