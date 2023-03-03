import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppModFormComponent } from '@app/appmods/appmod-form/appmod-form.component';
import { AppModListComponent } from '@app/appmods/appmod-list/appmod-list.component';

const routes: Routes = [
  { path: 'appmods', component: AppModListComponent, pathMatch: 'full' },
  { path: 'appmods/list', component: AppModListComponent, pathMatch: 'full' }, 
  { path: 'appmods/list', component: AppModListComponent, pathMatch: 'full' },
  { path: 'appmods/:appmod.id/list', component: AppModListComponent, pathMatch: 'full' }, 
  { path: 'appmods/:appmod.id/list', component: AppModListComponent, pathMatch: 'full' }, 
  { path: 'appmods/new', component: AppModFormComponent, pathMatch: 'full' },  
  { path: 'appmods/new', component:  AppModFormComponent , pathMatch: 'full' }, 
  { path: 'appmods/appmod.id/new', component: AppModFormComponent, pathMatch: 'full' }, 
  { path: 'appmods/:appmod.id/edit', component: AppModFormComponent, pathMatch: 'full' }, 
  { path: 'appmods/:appmod.id/:idUser/edit', component: AppModFormComponent, pathMatch: 'full' },
  { path: 'appmods/:appmod.id/delete', component: AppModFormComponent, pathMatch: 'full' },  
  { path: 'appmods/:appmod.id/:idUser/delete', component: AppModFormComponent, pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppModRoutingModule { }
