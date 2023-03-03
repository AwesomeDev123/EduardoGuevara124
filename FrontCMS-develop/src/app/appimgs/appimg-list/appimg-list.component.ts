import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppImg } from '../model/appimg';
import { AppImgService } from '../services/appimg.service';

@Component({
  selector: 'app-appimg-list',
  templateUrl: './appimg-list.component.html',
  styleUrls: ['./appimg-list.component.css']
})
export class AppImgListComponent implements OnInit {
  appimgs: AppImg[];
  appimg: AppImg;
  appimgId: String;
  errorMessage = "";


  constructor(
    private appImgService: AppImgService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }


  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("appimg.id")) {
         this.appimgId = params.get("appimg.id")!;
         this.appImgService.findAppImg(params.get("appimg.id"))
         .subscribe(
         (response) => { this.appimg = response;
         },  
         (error) => {   this.errorMessage = error;
        }
         )
      }else{
          this.appImgService.listAppImgs()
          .subscribe(
          (response) => { this.appimgs = response;
          },  
          (error) => {   this.errorMessage = error;
         } 
       )
      }
    })            
    
  }
    gotoAppImgList() {
      this.router.navigate(["/appimgs",this.appimgId, 'list']);
    }
    
    gotoAppImgEdit(id:String){
      this.router.navigate(["/appimgs",id, 'edit']);   
    }
  
    gotoAppImgNew(){
      this.router.navigate(["/appimgs",'new']);
  }
}
