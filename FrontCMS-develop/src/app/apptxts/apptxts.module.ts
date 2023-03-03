import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppTxtRoutingModule } from './apptxts-routing.module';
import { AppTxtsComponent } from './apptxts/apptxts.component';
import { AppTxtFormComponent } from './apptxt-form/apptxt-form.component';
import { AppTxtListComponent } from './apptxt-list/apptxt-list.component';



@NgModule({
  declarations: [
    AppTxtFormComponent,
    AppTxtListComponent,
    AppTxtsComponent
  ],
  imports: [
    CommonModule,
    AppTxtRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppTxtsModule { }
