import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppTplatetRoutingModule } from './apptplates-routing.module';
import { AppTplateListComponent } from '@app/apptplates/apptplate-list/apptplate-list.component';
import { AppTplateFormComponent } from '@app/apptplates/apptplate-form/apptplate-form.component';
import { AppTplateComponent } from './apptplate/apptplate.component';

/* An NgModule is a class marked by the @NgModule decorator. 
@NgModule takes a metadata object that describes how to compile a component's 
template and how to create an injector at runtime.
-declarations: componentes
-imports : modulos del sistema y modulos z 
 */

@NgModule({
  declarations: [
    AppTplateListComponent,
    AppTplateFormComponent,
    AppTplateComponent 
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AppTplatetRoutingModule
  ]
})
export class AppTplatesModule { }
