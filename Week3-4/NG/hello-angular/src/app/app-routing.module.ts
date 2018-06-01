import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DemoComponent } from './components/demo/demo.component';
import { MainComponent } from './components/main/main.component';
import { TodoComponent } from './components/todo/todo.component';
import { UserComponent } from './components/user/user.component';

/*
ROUTES!
Routing is the mechanism used to navigate between views or pages of your
Angular app. Much like a browser manages displaying different plages based
on links clicked, the Angular Router is used to manage such navigation 
in your application. It is a module, RouterModule, that defines a service
and special directives and components for use

*/

export const routes: Routes = [
    { path: '', redirectTo: '/main', pathMatch: 'full'},
    { path: 'main', component: MainComponent },
    { path: 'demo', component: DemoComponent },
    { path: 'todo', component: TodoComponent},
    { path: 'users', component: UserComponent}
];
@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}

