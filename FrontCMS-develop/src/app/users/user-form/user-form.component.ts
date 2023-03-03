import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user-service';
import { User } from '../model/user';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})

export class UserFormComponent  {
  user: User ;
  users: User[];

  constructor(
      private route: ActivatedRoute, 
      private router: Router, 
      private userService: UserService
      ) {
  this.user = new User();  }

  ngOnInit() {
  this.route.paramMap.subscribe(params =>{
    if (params.has("user.id")) {
      this.userService.findUser(params.get("user.id")).subscribe(user =>this.user = user);
        }else{
      this.userService.listUsers().subscribe(users =>this.users = users); }
      })
  }

  onSubmit() {
  this.userService.saveUser(this.user).subscribe(result => this.gotoUserList()); 
  }

  gotoUserList() {
  this.userService.listUsers().subscribe(data => {
      this.users = data;
    });
  this.router.navigate(['/users/list']);
  }

  gotoUserEdit(id:String){
  this.router.navigate(["/users",id, 'edit']);
  }

  gotoUserDelete(id:String){
  this.userService.deleUser(id).subscribe(data => {
      });
  this.router.navigate(['/users/list']);
  }

  gotoRegUser(id:String){
  this.router.navigate(["/regusers",id, 'list']);
  }       
}
