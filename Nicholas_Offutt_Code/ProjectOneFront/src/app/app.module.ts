import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { LogviewComponent } from './logview/logview.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginServiceService } from './service/login-service.service';

import 'rxjs/Rx';

@NgModule({
  declarations: [
    AppComponent,
    LogviewComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],exports:[],
  providers: [LoginServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
