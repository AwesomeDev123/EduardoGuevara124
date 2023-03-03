import { Component, NgModule, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{

  ngOnInit(): void { this.initialLoad }

  initialLoad(){
  //  console.log("Initial console.log"); 
  }

  constructor(private modalService: NgbModal) {
  }
  public open(modal: any): void {
    this.modalService.open(modal);
  }
  
  title = 'sfgclt-app';
  
}
