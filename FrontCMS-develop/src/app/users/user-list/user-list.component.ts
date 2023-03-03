import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../services/user-service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: User[];
  user: User;
  errorMessage = "";
  repos: User[];
  repo:User;
 
  constructor(private userService: UserService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }
ngOnInit() {

  this.route.paramMap.subscribe(params =>{
    if (params.has("user.id")) {
      this.userService.findUser(params.get("user.id"))
      .subscribe(
        (response) => { this.user = response;
        },
        (error) => {   this.errorMessage = error;

        }
      )

   //   this.router.navigate(["/users",this.user.id, 'edit']);
    }else{ 
      this.userService.listUsers()
      .subscribe(
        (response) => {  this.users = response;
        },
        (error) => {     this.errorMessage = error;
        }
      )
     }
  }
  )
} 

  gotoUserList() {
    this.userService.listUsers()
    .subscribe(
      (response) => {     },
      (error) => {   this.errorMessage = error;  
      }
    );
    this.router.navigate(['/users/list']);
  }

  gotoUserAdd() {
    this.router.navigate(['/users/new']);
  }

  gotoUserEdit(id:String){
    this.router.navigate(["/users",id, 'edit']);
  }

  gotoUserDelete(id:String){
      this.userService.deleUser(id)
      .subscribe(
        (response) => {  this.user = response;
        },
        (error) => {     this.errorMessage = error;   
        }
      );
      this.router.navigate(['/users/list']);
    }
}
