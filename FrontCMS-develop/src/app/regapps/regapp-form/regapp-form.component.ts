import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegAppService } from '../services/regapp.service';
import { RegApp } from '../model/regapp';
import { eApps } from '@app/enums/eApps';
import { eAppStatus } from '../../enums/eAppStatus';

@Component({
  selector: 'app-regapp-form',
  templateUrl: './regapp-form.component.html',
  styleUrls: ['./regapp-form.component.css']
})
export class RegAppFormComponent implements OnInit {
  regApp:RegApp ;
  regApps:RegApp[];
  regIdApp: String |null  ;
 // idApp: String |null  ;
  enumappStatus: typeof eAppStatus = eAppStatus;
  eApplications: typeof eApps = eApps;

  
  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private regAppService: RegAppService ) 
    {
      this.regApp = new RegApp();  } 

  ngOnInit() {
    this.route.paramMap.subscribe(params =>{
        if (params.has("app.id")) {
          this.regAppService.findApp(params.get("app.id")).subscribe(regApp =>this.regApp = regApp);
        } 
        if (params.has("id")) {
          this.regApp.id = params.get("id")!;
        } 
      }) 
  }

  onSubmit() {
    this.regAppService.saveApp(this.regApp)
    .subscribe(data => {      });
    if (this.regIdApp!== null)
    {this.gotoRegAppList(); } else
    {this.router.navigate(["/regapps",this.regIdApp, 'list']);}
      
    }
  gotoRegAppSave(regApp: RegApp, id:String|null){
        this.regAppService.saveApp(regApp).subscribe(data => {
        });
        this.router.navigate(["/regapps",id,'list']);
  }
  gotoRegAppList() {
    this.regAppService.listApps().subscribe(data => {
      this.regApps = data;
    });
    this.router.navigate(["/regapps/",'list']);
  }
  gotoRegAppEdit(id:String|null){
    this.router.navigate(["/regapps",id, 'edit']);
  }
  gotoRegAppDelete(id:String|null){
      this.regAppService.deleApp(id).subscribe(data => {
      });
      this.router.navigate(["/regapps",'list']);
  }
}