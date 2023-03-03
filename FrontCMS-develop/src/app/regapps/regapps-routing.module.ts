import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegAppComponent } from '@app/regapps/regapp/regapp.component';
import { RegAppFormComponent } from '@app/regapps/regapp-form/regapp-form.component';
import { RegAppListComponent } from '@app/regapps/regapp-list/regapp-list.component';

const routes: Routes = [
  { path: 'regapps', component: RegAppListComponent },
  { path: 'regapps/list', component: RegAppListComponent },  
  { path: 'regapps/new', component:  RegAppFormComponent  }, 
  { path: 'regapps/:app.id/new', component:  RegAppFormComponent  }, 
  { path: 'regapps/:app.id/edit', component: RegAppFormComponent, pathMatch: 'full' }, 
  { path: 'regapps/:app.id/delete', component: RegAppFormComponent, pathMatch: 'full' }, 
  { path: 'regapps', component: RegAppFormComponent},
  { path: 'regregapps/:app.id/list', component: RegAppListComponent },
  { path: 'regregapps', component: RegAppListComponent},
];


//{ path: '', redirectTo:'/regapps' , pathMatch: 'full' }


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegAppsRoutingModule { }

