import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { homeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { UserListComponent } from '@app/users/user-list/user-list.component';
import { ReguserListComponent } from '@app/regusers/reguser-list/reguser-list.component';
import { RegpayListComponent } from '@app/regpays/regpay-list/regpay-list.component';
import { RegAppListComponent } from '@app/regapps/regapp-list/regapp-list.component';
import { AppTxtListComponent } from '@app/apptxts/apptxt-list/apptxt-list.component';
import { AppTplateListComponent } from '@app/apptplates/apptplate-list/apptplate-list.component';
import { AppOptListComponent } from '@app/appopts/appopt-list/appopt-list.component';
import { AppModListComponent } from '@app/appmods/appmod-list/appmod-list.component';
import { AppImgListComponent } from '@app/appimgs/appimg-list/appimg-list.component';
import { AppAgreeListComponent } from '@app/appagrees/appagree-list/appagree-list.component';
import { AppUploadFormComponent } from '@app/appuploads/appupload-form/appupload-form.component';

const routes: Routes = [
  { path: '', redirectTo:'/home' , pathMatch: 'full' },
  { path: 'home',     component: homeComponent },
  { path: 'link',     component: NavbarComponent },
  { path: 'users',    component: UserListComponent },
  { path: 'reguser',  component: ReguserListComponent },
  { path: 'regpays',  component: RegpayListComponent },
  { path: 'regapps',  component: RegAppListComponent },
  { path: 'apptxts',  component: AppTxtListComponent },
  { path: 'apptplts',  component: AppTplateListComponent },
  { path: 'appopts',  component: AppOptListComponent },
  { path: 'appmods',  component: AppModListComponent },
  { path: 'appimgs',  component: AppImgListComponent },
  { path: 'appagrees',  component: AppAgreeListComponent },
  { path: 'appuploads',  component: AppUploadFormComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LandingRoutingModule { }
