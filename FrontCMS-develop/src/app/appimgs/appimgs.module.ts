import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppImgRoutingModule } from './appimgs-routing.module';
import { AppImgsComponent } from './appimgs/appimgs.component';
import { AppImgFormComponent } from './appimg-form/appimg-form.component';
import { AppImgListComponent } from './appimg-list/appimg-list.component';



@NgModule({
  declarations: [
    AppImgsComponent,
    AppImgFormComponent,
    AppImgListComponent
  ],
  imports: [
    CommonModule,
    AppImgRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppImgsModule { }
