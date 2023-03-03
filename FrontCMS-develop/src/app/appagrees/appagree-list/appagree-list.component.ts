import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppAgree } from '../model/appagree';
import { AppAgreeService } from '../services/appagree.service';

@Component({
  selector: 'app-appagree-list',
  templateUrl: './appagree-list.component.html',
  styleUrls: ['./appagree-list.component.css']
})
export class AppAgreeListComponent implements OnInit {
  appagrees: AppAgree[];
  appagree: AppAgree;
  appagreeId: String;
  errorMessage = "";


  constructor(
    private appAgreeService: AppAgreeService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("appagree.id")) {
         this.appagreeId = params.get("appagree.id")!;
         this.appAgreeService.findAppAgree(params.get("appagree.id"))
         .subscribe(
         (response) => { this.appagree = response;
         },  
         (error) => {   this.errorMessage = error;
        }
         )
      }else{
          this.appAgreeService.listAppAgrees()
          .subscribe(
          (response) => { this.appagrees = response;
          },  
          (error) => {   this.errorMessage = error;
         } 
       )
      }
    })            
    
  }
    gotoAppAgreeList() {
      this.router.navigate(["/appagrees",this.appagreeId, 'list']);
    }
    
    gotoAppAgreeEdit(id:String){
      this.router.navigate(["/appagrees",id, 'edit']);   
    }
  
    gotoAppAgreeNew(){
      this.router.navigate(["/appagrees",'new']);
  }
}
