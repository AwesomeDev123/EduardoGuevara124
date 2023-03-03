import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppOptListComponent } from '@app/appopts/appopt-list/appopt-list.component';
import { AppOptFormComponent } from '@app/appopts/appopt-form/appopt-form.component';


const routes: Routes = [
  { path: 'appopts', component: AppOptListComponent },
  { path: 'appopts/list', component: AppOptListComponent },  
  { path: 'appopts/new', component:  AppOptFormComponent  }, 
  { path: 'appopts/:appopt.id/new', component:  AppOptFormComponent  }, 
  { path: 'appopts/:appopt.id/edit', component: AppOptFormComponent, pathMatch: 'full' }, 
  { path: 'appopts/:appopt.id/delete', component: AppOptFormComponent, pathMatch: 'full' }, 
  { path: 'addappopt', component: AppOptFormComponent},
  { path: 'appopts/:appopt.id/list', component: AppOptListComponent },
  { path: 'appopts', component: AppOptListComponent},
];


//{ path: '', redirectTo:'/appopts' , pathMatch: 'full' }


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppOptRoutingModule { }
