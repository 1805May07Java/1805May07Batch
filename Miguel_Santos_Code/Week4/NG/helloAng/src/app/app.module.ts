import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
 
import { AppComponent } from './app.component';
import { DemoComponent } from './components/demo/demo.component';
import { SqrtPipe } from './pipes/sqrt.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MainComponent } from './components/main/main.component';
import { AppRoutingModule } from './app-routing.module';
import { TodoComponent } from './components/todo/todo.component';
import { ModelComponent } from './model/model.component';
import { BooksComponent } from './components/books/books.component';
import { UserComponent } from './components/user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoComponent,
    SqrtPipe,
    NavbarComponent,
    MainComponent,
    TodoComponent,
    ModelComponent,
    BooksComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
