import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
 // template: `<h1>This is in-line HTML</h1> We can still bind data -- {{ test }}`,
  templateUrl: `./demo.component.html`,
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {
  test = 'It works!';
  count = 0;
  color = '#12a4bc';
  val = true;
  name = 'Genesis';
  genres = ['Hip hop', 'classical', 'pop', 'screaming music that people like idk why'];
  imgSrc = 'http://r.ddmcdn.com/w_830/s_f/o_1/cx_0/cy_66/cw_288/ch_162/APL/uploads/2014/10/cat_5-1.jpg';
  styles = {
    background: 'yellow',
    border: '30px solid green'
  };
  lowerPipe = 'TEST';

  currentTime: Date;

  constructor() {
    setInterval( () => {
      this.currentTime = new Date;
    }, 1000);
  }

  ngOnInit() {
  }

  doCount() {
    this.count++;
  }

  toggleDisabled() {
    this.val = !this.val;
  }

}
