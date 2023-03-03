import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingRoutingModule } from './landings-routing.module';

import { homeComponent } from './home/home.component';


@NgModule({
  declarations: [
    homeComponent
  ],
  imports: [
    CommonModule,
    LandingRoutingModule
  ]
})
export class LandingModule { }
