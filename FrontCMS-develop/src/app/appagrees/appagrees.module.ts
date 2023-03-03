import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppAgreeRoutingModule } from './appagrees-routing.module';
import { AppAgreesComponent } from './appagrees/appagrees.component';
import { AppAgreeFormComponent } from './appagree-form/appagree-form.component';
import { AppAgreeListComponent } from './appagree-list/appagree-list.component';



@NgModule({
  declarations: [
    AppAgreesComponent,
    AppAgreeFormComponent,
    AppAgreeListComponent
  ],
  imports: [
    CommonModule,
    AppAgreeRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppAgreesModule { }
