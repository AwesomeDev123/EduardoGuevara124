import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegApp } from '../model/regapp';
import { RegAppService } from '../services/regapp.service';

@Component({
  selector: 'app-regapp-list',
  templateUrl: './regapp-list.component.html',
  styleUrls: ['./regapp-list.component.css']
})
export class RegAppListComponent implements OnInit {
  regapps: RegApp[];
  regapp: RegApp;
  appId:String;
  errorMessage:String|null;

  constructor(    
    private regappService: RegAppService,   
    private route: ActivatedRoute, 
    private router: Router) {
   }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("app.id")) {
        this.appId = params.get("app.id")!;
        this.regappService.findApp(params.get("app.id"))
        .subscribe(
          (response) => { this.regapp = response;
          },
          (error) => {   this.errorMessage = error;
  
          }
        )
      }else{ 
        this.regappService.listApps()
        .subscribe(
          (response) => {  this.regapps = response;
          },
          (error) => {     this.errorMessage = error;
          }
        )
       }
    }
    )
  } 
  
    gotoAppList() {
      this.regappService.listApps()
      .subscribe(
        (response) => {     },
        (error) => {   this.errorMessage = error;  
        }
      );
      this.router.navigate(['/regapps/list']);
    }
  
    gotoAppAdd() {
      this.router.navigate(['/regapps/new']);
    }
  
    gotoAppEdit(id:String){
      this.router.navigate(["/regapps",id, 'edit']);
    }
  
    gotoAppDelete(id:String){
        this.regappService.deleApp(id)
        .subscribe(
          (response) => {  this.regapp = response;
          },
          (error) => {     this.errorMessage = error;   
          }
        );
        this.router.navigate(['/regapps/list']);
      }
  }
  