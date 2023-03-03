import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReguserListComponent } from '@app/regusers/reguser-list/reguser-list.component';
import { UserFormComponent } from '@app/users/user-form/user-form.component';
import { UserListComponent } from '@app/users/user-list/user-list.component';

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/list', component: UserListComponent },  
  { path: 'users/new', component:  UserFormComponent  }, 
  { path: 'users/:user.id/new', component:  UserFormComponent  }, 
  { path: 'users/:user.id/edit', component: UserFormComponent, pathMatch: 'full' }, 
  { path: 'users/:user.id/delete', component: UserFormComponent, pathMatch: 'full' }, 
  { path: 'adduser', component: UserFormComponent},
  { path: 'regusers/:user.id/list', component: ReguserListComponent },
  { path: 'regusers', component: ReguserListComponent},
];


//{ path: '', redirectTo:'/users' , pathMatch: 'full' }


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
