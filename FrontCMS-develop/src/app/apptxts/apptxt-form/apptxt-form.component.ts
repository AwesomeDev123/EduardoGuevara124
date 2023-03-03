import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppTxt } from '../model/apptxt';
import { AppTxtService } from '../services/apptxt.service';

@Component({
  selector: 'app-apptxt-form',
  templateUrl: './apptxt-form.component.html',
  styleUrls: ['./apptxt-form.component.css']
})
export class AppTxtFormComponent implements OnInit {
  apptxt:AppTxt ;
  apptxts:AppTxt[];
  id: String |null  ;
  regAppTxt: String |null  ;

  constructor(    private route: ActivatedRoute, 
    private router: Router, 
    private appTxtService: AppTxtService ) 
    {
      this.apptxt = new AppTxt();  } 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
        if (params.has("apptxt.id")) {
          this.appTxtService.findAppTxt(params.get("apptxt.id")).subscribe(apptxt =>this.apptxt = apptxt);
          this.regAppTxt = this.apptxt.id;
        } 
        if (params.has("id")) {
          this.id = params.get("id")!;
          this.apptxt.id = params.get("id")!;
        } 
      }) 
  }

  onSubmit() {
    this.appTxtService.saveAppTxt(this.apptxt)
    .subscribe(data => {      });
    if (this.regAppTxt!== null)
    {this.gotoAppTxtList(); } else
    {this.router.navigate(["/apptxts",'list']);}
    
    
    }
  gotoAppTxtSave(id:String){
        this.appTxtService.saveAppTxt(this.apptxt).subscribe(data => {
        });
        this.router.navigate(["/apptxts",'list']);
  }
  gotoAppTxtList() {
    this.appTxtService.listAppTxts().subscribe(data => {
      this.apptxts = data;
    });
    this.router.navigate(["/apptxts",'list']);
  }
  gotoAppTxtEdit(id:String){
    this.router.navigate(["/apptxts",id, 'edit']);
  }
  gotoAppTxtDelete(id:String){
      this.appTxtService.deleAppTxt(id).subscribe(data => {
      });
      this.router.navigate(["/apptxts",'list']);
  }
}