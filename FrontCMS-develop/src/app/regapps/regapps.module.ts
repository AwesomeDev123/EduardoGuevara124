import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegAppsRoutingModule } from './regapps-routing.module';
import { RegAppComponent } from '@app/regapps/regapp/regapp.component';
import { RegAppFormComponent } from '@app/regapps/regapp-form/regapp-form.component';
import { RegAppListComponent } from '@app/regapps/regapp-list/regapp-list.component';

@NgModule({
  declarations: [
    RegAppListComponent,
    RegAppFormComponent,
    RegAppComponent 
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RegAppsRoutingModule
  ]
})
export class RegAppsModule { }
