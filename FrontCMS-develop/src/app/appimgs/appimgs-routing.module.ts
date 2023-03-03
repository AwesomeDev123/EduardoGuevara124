import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppImgFormComponent } from '@app/appimgs/appimg-form/appimg-form.component';
import { AppImgListComponent } from '@app/appimgs/appimg-list/appimg-list.component';

const routes: Routes = [
  { path: 'appimgs', component: AppImgListComponent, pathMatch: 'full' },
  { path: 'appimgs/list', component: AppImgListComponent, pathMatch: 'full' }, 
  { path: 'appimgs/list', component: AppImgListComponent, pathMatch: 'full' },
  { path: 'appimgs/:appimg.id/list', component: AppImgListComponent, pathMatch: 'full' }, 
  { path: 'appimgs/:appimg.id/list', component: AppImgListComponent, pathMatch: 'full' }, 
  { path: 'appimgs/new', component: AppImgFormComponent, pathMatch: 'full' },  
  { path: 'appimgs/new', component:  AppImgFormComponent , pathMatch: 'full' }, 
  { path: 'appimgs/appimg.id/new', component: AppImgFormComponent, pathMatch: 'full' }, 
  { path: 'appimgs/:appimg.id/edit', component: AppImgFormComponent, pathMatch: 'full' }, 
  { path: 'appimgs/:appimg.id/:idUser/edit', component: AppImgFormComponent, pathMatch: 'full' },
  { path: 'appimgs/:appimg.id/delete', component: AppImgFormComponent, pathMatch: 'full' },  
  { path: 'appimgs/:appimg.id/:idUser/delete', component: AppImgFormComponent, pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppImgRoutingModule { }
