import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppAgree } from '../model/appagree';
import { AppAgreeService } from '../services/appagree.service';

@Component({
  selector: 'app-appagree-form',
  templateUrl: './appagree-form.component.html',
  styleUrls: ['./appagree-form.component.css']
})
export class AppAgreeFormComponent implements OnInit {
  appagree:AppAgree ;
  appagrees:AppAgree[];
  id: String |null  ;
  regAppAgree: String |null  ;

  constructor(    private route: ActivatedRoute, 
    private router: Router, 
    private appAgreeService: AppAgreeService ) 
    {
      this.appagree = new AppAgree();  } 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
        if (params.has("appagree.id")) {
          this.appAgreeService.findAppAgree(params.get("appagree.id")).subscribe(appagree =>this.appagree = appagree);
          this.regAppAgree = this.appagree.id;
        } 
        if (params.has("id")) {
          this.id = params.get("id")!;
          this.appagree.id = params.get("id")!;
        } 
      }) 
  }

  onSubmit() {
    this.appAgreeService.saveAppAgree(this.appagree)
    .subscribe(data => {      });
    if (this.regAppAgree!== null)
    {this.gotoAppAgreeList(); } else
    {this.router.navigate(["/appagrees",'list']);}
    
    
    }
  gotoAppAgreeSave(id:String){
        this.appAgreeService.saveAppAgree(this.appagree).subscribe(data => {
        });
        this.router.navigate(["/appagrees",'list']);
  }
  gotoAppAgreeList() {
    this.appAgreeService.listAppAgrees().subscribe(data => {
      this.appagrees = data;
    });
    this.router.navigate(["/appagrees",'list']);
  }
  gotoAppAgreeEdit(id:String){
    this.router.navigate(["/appagrees",id, 'edit']);
  }
  gotoAppAgreeDelete(id:String){
      this.appAgreeService.deleAppAgree(id).subscribe(data => {
      });
      this.router.navigate(["/appagrees",'list']);
  }
}