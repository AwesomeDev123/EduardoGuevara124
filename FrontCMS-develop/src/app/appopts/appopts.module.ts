import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppOptRoutingModule } from './appopts-routing.module';
import { AppOptsComponent } from './appopts/appopts.component';
import { AppOptFormComponent } from './appopt-form/appopt-form.component';
import { AppOptListComponent } from './appopt-list/appopt-list.component'



@NgModule({
  declarations: [
    AppOptsComponent,
    AppOptListComponent,
    AppOptFormComponent
  ],
  imports: [
    CommonModule,
    AppOptRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppOptsModule { }
