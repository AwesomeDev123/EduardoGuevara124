import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppTplateListComponent } from '@app/apptplates/apptplate-list/apptplate-list.component';
import { AppTplateFormComponent } from '@app/apptplates/apptplate-form/apptplate-form.component';

const routes: Routes = [
  { path: 'apptplates', component: AppTplateListComponent },
  { path: 'apptplates/list', component: AppTplateListComponent },  
  { path: 'apptplates/new', component:  AppTplateFormComponent  }, 
  { path: 'apptplates/:apptplate.id/new', component:  AppTplateFormComponent  }, 
  { path: 'apptplates/:apptplate.id/edit', component: AppTplateFormComponent, pathMatch: 'full' }, 
  { path: 'apptplates/:apptplate.id/delete', component: AppTplateFormComponent, pathMatch: 'full' }, 
  { path: 'addapptplate', component: AppTplateFormComponent},
  { path: 'regapptplates/:apptplate.id/list', component: AppTplateListComponent },
  { path: 'regapptplates', component: AppTplateListComponent},
];


//{ path: '', redirectTo:'/apptplates' , pathMatch: 'full' }


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppTplatetRoutingModule { }