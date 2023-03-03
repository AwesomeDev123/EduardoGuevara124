import { Component, OnInit } from '@angular/core';
import { AppTplateService } from '../services/apptplate.service';
import { AppTplate } from '../model/apptplate';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-apptplate-form',
  templateUrl: './apptplate-form.component.html',
  styleUrls: ['./apptplate-form.component.css']
})

export class AppTplateFormComponent  {
  apptplate: AppTplate ;
  apptplates: AppTplate[];

  constructor(
      private route: ActivatedRoute, 
      private router: Router, 
      private appTplateService: AppTplateService
      ) {
  this.apptplate = new AppTplate();  }

  ngOnInit()  {
  this.route.paramMap.subscribe(params =>{
    if (params.has("apptplate.id")) {
      this.appTplateService.findAppTplate(params.get("apptplate.id")).subscribe(apptplate =>this.apptplate = apptplate);
        }else{
      this.appTplateService.listAppTplates().subscribe(apptplates =>this.apptplates = apptplates); }
      })
  }

  onSubmit() {
  this.appTplateService.saveAppTplate(this.apptplate).subscribe(result => this.gotoAppTplateList()); 
  }

  gotoAppTplateList() {
  this.appTplateService.listAppTplates().subscribe(data => {
      this.apptplates = data;
    });
  this.router.navigate(['/apptplates/list']);
  }

  gotoAppTplateEdit(id:String){
  this.router.navigate(["/apptplates",id, 'edit']);
  }

  gotoAppTplateDelete(id:String){
  this.appTplateService.deleAppTplate(id).subscribe(data => {
      });
  this.router.navigate(['/apptplates/list']);
  }

  gotoAppTplate(id:String){
  this.router.navigate(["/regapptplates",id, 'list']);
  }       
}
