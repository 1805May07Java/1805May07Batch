import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  //template: `<h1>This is in-line HTML</h1> We can still bind data -- {{ test }}`,
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  test  = "it works!";
  count = 0;
  color = 'red';
  color2 = 'green';
  val = true;
  genres = ['hip hop', 'rap', 'jazz'];
  imgSrc = 'https://vignette.wikia.nocookie.net/tana-mongeau4885/images/3/36/Photo.jpg/revision/latest?cb=20170412031044';
  styles = {
    background: 'yellow',
    border: '25px solid green'
  };
  lowerPipe = '151';
  currentTime: Date;
  
  
  constructor() { 
    setInterval( () => {
      this.currentTime = new Date;
    }, 1000);
   }

  ngOnInit() {
  }

  doCount(){
    this.count++;
  }
  toggleDisable(){
    this.val = !this.val;
  }

}
