import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppImg } from '../model/appimg';
import { AppImgService } from '../services/appimg.service';

@Component({
  selector: 'app-appimg-form',
  templateUrl: './appimg-form.component.html',
  styleUrls: ['./appimg-form.component.css']
})
export class AppImgFormComponent implements OnInit {
  appimg:AppImg ;
  appimgs:AppImg[];
  id: String |null  ;
  regAppImg: String |null  ;

  constructor(    private route: ActivatedRoute, 
    private router: Router, 
    private appImgService: AppImgService ) 
    {
      this.appimg = new AppImg();  } 

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
        if (params.has("appimg.id")) {
          this.appImgService.findAppImg(params.get("appimg.id")).subscribe(appimg =>this.appimg = appimg);
          this.regAppImg = this.appimg.id;
        } 
        if (params.has("id")) {
          this.id = params.get("id")!;
          this.appimg.id = params.get("id")!;
        } 
      }) 
  }

  onSubmit() {
    this.appImgService.saveAppImg(this.appimg)
    .subscribe(data => {      });
    if (this.regAppImg!== null)
    {this.gotoAppImgList(); } else
    {this.router.navigate(["/appimgs",'list']);}
    
    
    }
  gotoAppImgSave(id:String){
        this.appImgService.saveAppImg(this.appimg).subscribe(data => {
        });
        this.router.navigate(["/appimgs",'list']);
  }
  gotoAppImgList() {
    this.appImgService.listAppImgs().subscribe(data => {
      this.appimgs = data;
    });
    this.router.navigate(["/appimgs",'list']);
  }
  gotoAppImgEdit(id:String){
    this.router.navigate(["/appimgs",id, 'edit']);
  }
  gotoAppImgDelete(id:String){
      this.appImgService.deleAppImg(id).subscribe(data => {
      });
      this.router.navigate(["/appimgs",'list']);
  }
}