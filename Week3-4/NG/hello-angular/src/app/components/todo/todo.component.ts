import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  newTask: string;
  items = [];
  complete = [];

  constructor() { }

  ngOnInit() {
  }

  addItem() {
    this.items.push(this.newTask);
  }

  markComplete(item) {
    this.complete.push(item);
    this.items = this.items.filter(i => i !== item);

  }

}
