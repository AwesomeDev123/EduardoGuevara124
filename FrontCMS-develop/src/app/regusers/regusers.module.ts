import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReguserListComponent } from '@app/regusers/reguser-list/reguser-list.component';
import { ReguserFormComponent } from '@app/regusers/reguser-form/reguser-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegusersRoutingModule } from './regusers-routing.module';
import { RegusersComponent } from './regusers/regusers.component';


@NgModule({
  declarations: [
    ReguserListComponent,
    ReguserFormComponent,
    RegusersComponent 
  ],
  imports: [
    CommonModule,
    RegusersRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class RegUsersModule { }
