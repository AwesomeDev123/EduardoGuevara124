import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegpayListComponent } from '@app/regpays/regpay-list/regpay-list.component';
import { RegpayFormComponent } from '@app/regpays/regpay-form/regpay-form.component';


const routes: Routes = [
  { path: 'regpays', component: RegpayListComponent },
  { path: 'regpays/list', component: RegpayListComponent },  
  { path: 'regpays/new', component:  RegpayFormComponent  }, 
  { path: 'regpays/:regpay.id/edit', component: RegpayFormComponent, pathMatch: 'full' }, 
  { path: 'regpays/:regpay.id/delete', component: RegpayFormComponent, pathMatch: 'full' }, 
  { path: 'addregpay', component: RegpayFormComponent},
  { path: 'regpays/:regpay.id/list', component: RegpayListComponent },
  { path: 'regpays', component: RegpayListComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegpaysRoutingModule { }
