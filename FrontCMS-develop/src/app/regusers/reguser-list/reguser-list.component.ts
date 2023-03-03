import { Component, NgModule, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { Reguser } from '../model/reguser.model';
import { RegUserService } from '../services/reguser-service';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-reguser-list',
  templateUrl: './reguser-list.component.html',
  styleUrls: ['./reguser-list.component.css']
})
export class ReguserListComponent implements OnInit {
  regusers: Reguser[];
  reguser: Reguser;
  userId: String;
  errorMessage = "";


  constructor(
    private regUserService: RegUserService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("user.id")) {
         this.userId = params.get("user.id")!;
         this.regUserService.listRegUsers(params.get("user.id"))
         .subscribe(
         (response) => { this.regusers = response;
         },  
         (error) => {   this.errorMessage = error;
        }
         )
      }else{
          this.regUserService.listRegUsersAll()
          .subscribe(
          (response) => { this.regusers = response;
          },  
          (error) => {   this.errorMessage = error;
         } 
       )
      }
    })            
    
  }
    gotoRegUserList() {
      this.router.navigate(["/regusers",this.userId, 'list']);
    }
    
    gotoRegUserEdit(id:String){
      this.router.navigate(["/regusers",id, 'edit']);   
    }
  
    gotoRegUserNew(id:String){
      this.router.navigate(["/regusers",id, 'new']);
  }
}