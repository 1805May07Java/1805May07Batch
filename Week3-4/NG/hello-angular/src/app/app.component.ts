import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'RevBank';
  bal = 45.66;
  notes = ` Templates are defines the view in Angular applications.
       They are HTML code mixed with Angular that specify the output
        for what you’ll see in your browser.`;
}
