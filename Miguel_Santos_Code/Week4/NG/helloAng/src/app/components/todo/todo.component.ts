import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  items = ['this', 'that'];
  done = ['done1'];
  constructor() { }

  ngOnInit() {
  }

  addToList(value: string){
    this.items.push(value);
  }
  transferItem(item: string){
    this.done.push(item);
    this.items.splice(this.items.indexOf(item),1);
  }

}
