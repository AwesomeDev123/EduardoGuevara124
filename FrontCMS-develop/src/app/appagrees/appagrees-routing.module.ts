import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppAgreeFormComponent } from '@app/appagrees/appagree-form/appagree-form.component';
import { AppAgreeListComponent } from '@app/appagrees/appagree-list/appagree-list.component';

const routes: Routes = [
  { path: 'appagrees', component: AppAgreeListComponent, pathMatch: 'full' },
  { path: 'appagrees/list', component: AppAgreeListComponent, pathMatch: 'full' }, 
  { path: 'appagrees/list', component: AppAgreeListComponent, pathMatch: 'full' },
  { path: 'appagrees/:appagree.id/list', component: AppAgreeListComponent, pathMatch: 'full' }, 
  { path: 'appagrees/:appagree.id/list', component: AppAgreeListComponent, pathMatch: 'full' }, 
  { path: 'appagrees/new', component: AppAgreeFormComponent, pathMatch: 'full' },  
  { path: 'appagrees/new', component:  AppAgreeFormComponent , pathMatch: 'full' }, 
  { path: 'appagrees/appagree.id/new', component: AppAgreeFormComponent, pathMatch: 'full' }, 
  { path: 'appagrees/:appagree.id/edit', component: AppAgreeFormComponent, pathMatch: 'full' }, 
  { path: 'appagrees/:appagree.id/:idUser/edit', component: AppAgreeFormComponent, pathMatch: 'full' },
  { path: 'appagrees/:appagree.id/delete', component: AppAgreeFormComponent, pathMatch: 'full' },  
  { path: 'appagrees/:appagree.id/:idUser/delete', component: AppAgreeFormComponent, pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppAgreeRoutingModule { }
