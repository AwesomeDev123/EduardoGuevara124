import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegpaysRoutingModule } from './regpays-routing.module';
import { RegpayListComponent } from '@app/regpays/regpay-list/regpay-list.component';
import { RegpayFormComponent } from '@app/regpays/regpay-form/regpay-form.component';
import { RegpaysComponent } from './regpays/regpays.component';


@NgModule({
  declarations: [
    RegpayListComponent,
    RegpayFormComponent,
    RegpaysComponent
  ],
  imports: [
    CommonModule,
    RegpaysRoutingModule,
    FormsModule,
    ReactiveFormsModule
    
  ]
})
export class RegPaysModule { }
