import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppTxtFormComponent } from '@app/apptxts/apptxt-form/apptxt-form.component';
import { AppTxtListComponent } from '@app/apptxts/apptxt-list/apptxt-list.component';

const routes: Routes = [
  { path: 'apptxts', component: AppTxtListComponent, pathMatch: 'full' },
  { path: 'apptxts/list', component: AppTxtListComponent, pathMatch: 'full' }, 
  { path: 'apptxts/list', component: AppTxtListComponent, pathMatch: 'full' },
  { path: 'apptxts/:apptxt.id/list', component: AppTxtListComponent, pathMatch: 'full' }, 
  { path: 'apptxts/:apptxt.id/list', component: AppTxtListComponent, pathMatch: 'full' }, 
  { path: 'apptxts/new', component: AppTxtFormComponent, pathMatch: 'full' },  
  { path: 'apptxts/new', component:  AppTxtFormComponent , pathMatch: 'full' }, 
  { path: 'apptxts/apptxt.id/new', component: AppTxtFormComponent, pathMatch: 'full' }, 
  { path: 'apptxts/:apptxt.id/edit', component: AppTxtFormComponent, pathMatch: 'full' }, 
  { path: 'apptxts/:apptxt.id/:idUser/edit', component: AppTxtFormComponent, pathMatch: 'full' },
  { path: 'apptxts/:apptxt.id/delete', component: AppTxtFormComponent, pathMatch: 'full' },  
  { path: 'apptxts/:apptxt.id/:idUser/delete', component: AppTxtFormComponent, pathMatch: 'full' } 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppTxtRoutingModule { }
