import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppMod } from '../model/appmod';
import { AppModService } from '../services/appmod.service';

@Component({
  selector: 'app-appmod-form',
  templateUrl: './appmod-form.component.html',
  styleUrls: ['./appmod-form.component.css']
})
export class AppModFormComponent implements OnInit {
  appmod:AppMod ;
  appmods:AppMod[];
  id: String |null  ;
  regAppMod: String |null  ;

  constructor(    private route: ActivatedRoute, 
    private router: Router, 
    private appModService: AppModService ) 
    {
      this.appmod = new AppMod();  } 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
        if (params.has("appmod.id")) {
          this.appModService.findAppMod(params.get("appmod.id")).subscribe(appmod =>this.appmod = appmod);
          this.regAppMod = this.appmod.id;
        } 
        if (params.has("id")) {
          this.id = params.get("id")!;
          this.appmod.id = params.get("id")!;
        } 
      }) 
  }

  onSubmit() {
    this.appModService.saveAppMod(this.appmod)
    .subscribe(data => {      });
    if (this.regAppMod!== null)
    {this.gotoAppModList(); } else
    {this.router.navigate(["/appmods",'list']);}
    
    
    }
  gotoAppModSave(id:String){
        this.appModService.saveAppMod(this.appmod).subscribe(data => {
        });
        this.router.navigate(["/appmods",'list']);
  }
  gotoAppModList() {
    this.appModService.listAppMods().subscribe(data => {
      this.appmods = data;
    });
    this.router.navigate(["/appmods",'list']);
  }
  gotoAppModEdit(id:String){
    this.router.navigate(["/appmods",id, 'edit']);
  }
  gotoAppModDelete(id:String){
      this.appModService.deleAppMod(id).subscribe(data => {
      });
      this.router.navigate(["/appmods",'list']);
  }
}