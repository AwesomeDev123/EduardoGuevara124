import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppModRoutingModule } from './appmods-routing.module';
import { AppModsComponent } from './appmods/appmods.component';
import { AppModFormComponent } from './appmod-form/appmod-form.component';
import { AppModListComponent } from './appmod-list/appmod-list.component';



@NgModule({
  declarations: [
    AppModFormComponent,
    AppModListComponent,
    AppModsComponent
  ],
  imports: [
    CommonModule,
    AppModRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppModsModule { }