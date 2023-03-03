import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppTxt } from '../model/apptxt';
import { AppTxtService } from '../services/apptxt.service';

@Component({
  selector: 'app-apptxt-list',
  templateUrl: './apptxt-list.component.html',
  styleUrls: ['./apptxt-list.component.css']
})
export class AppTxtListComponent implements OnInit {
  apptxts: AppTxt[];
  apptxt: AppTxt;
  apptxtId: String;
  errorMessage = "";


  constructor(
    private appTxtService: AppTxtService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("apptxt.id")) {
         this.apptxtId = params.get("apptxt.id")!;
         this.appTxtService.findAppTxt(params.get("apptxt.id"))
         .subscribe(
         (response) => { this.apptxt = response;
         },  
         (error) => {   this.errorMessage = error;
        }
         )
      }else{
          this.appTxtService.listAppTxts()
          .subscribe(
          (response) => { this.apptxts = response;
          },  
          (error) => {   this.errorMessage = error;
         } 
       )
      }
    })            
    
  }
    gotoAppTxtList() {
      this.router.navigate(["/apptxts",this.apptxtId, 'list']);
    }
    
    gotoAppTxtEdit(id:String){
      this.router.navigate(["/apptxts",id, 'edit']);   
    }
  
    gotoAppTxtNew(){
      this.router.navigate(["/apptxts",'new']);
  }
}
