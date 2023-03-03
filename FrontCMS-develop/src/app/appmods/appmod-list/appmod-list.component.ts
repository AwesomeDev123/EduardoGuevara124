import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppMod } from '../model/appmod';
import { AppModService } from '../services/appmod.service';

@Component({
  selector: 'app-appmod-list',
  templateUrl: './appmod-list.component.html',
  styleUrls: ['./appmod-list.component.css']
})
export class AppModListComponent implements OnInit {
  appmods: AppMod[];
  appmod: AppMod;
  appmodId: String;
  errorMessage = "";


  constructor(
    private appModService: AppModService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("appmod.id")) {
         this.appmodId = params.get("appmod.id")!;
         this.appModService.findAppMod(params.get("appmod.id"))
         .subscribe(
         (response) => { this.appmod = response;
         },  
         (error) => {   this.errorMessage = error;
        }
         )
      }else{
          this.appModService.listAppMods()
          .subscribe(
          (response) => { this.appmods = response;
          },  
          (error) => {   this.errorMessage = error;
         } 
       )
      }
    })            
    
  }
    gotoAppModList() {
      this.router.navigate(["/appmods",this.appmodId, 'list']);
    }
    
    gotoAppModEdit(id:String){
      this.router.navigate(["/appmods",id, 'edit']);   
    }
  
    gotoAppModNew(){
      this.router.navigate(["/appmods",'new']);
  }
}
