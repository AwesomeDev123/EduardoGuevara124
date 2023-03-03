import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AppTplate } from '../model/apptplate';
import { AppTplateService } from '../services/apptplate.service';

@Component({
  selector: 'app-apptplate-list',
  templateUrl: './apptplate-list.component.html',
  styleUrls: ['./apptplate-list.component.css']
})
export class AppTplateListComponent implements OnInit {
  apptplates: AppTplate[];
  apptplate: AppTplate;
  errorMessage = "";
  repos: AppTplate[];
  repo:AppTplate;
 
  constructor(private appTpltService: AppTplateService,   
    private route: ActivatedRoute, 
    private router: Router ) { 
   }
ngOnInit() {

  this.route.paramMap.subscribe(params =>{
    if (params.has("apptplate.id")) {
      this.appTpltService.findAppTplate(params.get("apptplate.id"))
      .subscribe(
        (response) => { this.apptplate = response;
        },
        (error) => {   this.errorMessage = error;

        }
      )

   //   this.router.navigate(["/apptplates",this.apptplate.id, 'edit']);
    }else{ 
      this.appTpltService.listAppTplates()
      .subscribe(
        (response) => {  this.apptplates = response;
        },
        (error) => {     this.errorMessage = error;
        }
      )
     }
  }
  )
} 

  gotoAppTplateList() {
    this.appTpltService.listAppTplates()
    .subscribe(
      (response) => {     },
      (error) => {   this.errorMessage = error;  
      }
    );
    this.router.navigate(['/apptplates/list']);
  }

  gotoAppTplateAdd() {
    this.router.navigate(['/apptplates/new']);
  }

  gotoAppTplateEdit(id:String){
    this.router.navigate(["/apptplates",id, 'edit']);
  }

  gotoAppTplateDelete(id:String){
      this.appTpltService.deleAppTplate(id)
      .subscribe(
        (response) => {  this.apptplate = response;
        },
        (error) => {     this.errorMessage = error;   
        }
      );
      this.router.navigate(['/apptplates/list']);
    }
}
