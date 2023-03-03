import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UsersRoutingModule } from './users-routing.module';
import { UserListComponent } from '@app/users/user-list/user-list.component';
import { UserFormComponent } from '@app/users/user-form/user-form.component';
import { UsersComponent } from './user/users.component';

/* An NgModule is a class marked by the @NgModule decorator. 
@NgModule takes a metadata object that describes how to compile a component's 
template and how to create an injector at runtime.
-declarations: componentes
-imports : modulos del sistema y modulos z 
 */

@NgModule({
  declarations: [
  UserListComponent,
  UserFormComponent,
  UsersComponent 
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    UsersRoutingModule
  ]
})
export class UsersModule { }
