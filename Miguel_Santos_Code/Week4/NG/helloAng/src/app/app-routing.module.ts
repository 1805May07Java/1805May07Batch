import { NgModule } from "@angular/core";
import {RouterModule, Routes} from '@angular/router'
import { DemoComponent } from "./components/demo/demo.component";
import { MainComponent } from "./components/main/main.component";
import { TodoComponent } from "./components/todo/todo.component";

export const routes: Routes = [
    { path: '', redirectTo: '/main', pathMatch: 'full'},
    { path: 'main', component: MainComponent },
    { path: 'demo', component: DemoComponent },
    { path: 'todo', component: TodoComponent}
]
@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [ RouterModule]
})
export class AppRoutingModule {}