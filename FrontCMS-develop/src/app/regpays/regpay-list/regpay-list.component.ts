import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Regpay } from '../model/regpay';
import { RegPayService } from '../services/regpay.service';

@Component({
  selector: 'app-regpay-list',
  templateUrl: './regpay-list.component.html',
  styleUrls: ['./regpay-list.component.css']
})
export class RegpayListComponent implements OnInit {
  regPays: Regpay[];
  regPay: Regpay;
  errorMessage:String|null;

  constructor( 
    private regPayService : RegPayService,
    private route: ActivatedRoute, 
    private router: Router ) {  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      if (params.has("regPay.id")) {
        this.regPayService.findRegPays(params.get("regPay.id"))
        .subscribe(
          (response) => { this.regPay = response;
          },
          (error) => {   this.errorMessage = error;
          }
        )
      }else{ 
        this.regPayService.listRegPays()
        .subscribe(
          (response) => {  this.regPays = response;
          },
          (error) => {     this.errorMessage = error;
          }
        )
       }
    }
    )
  } 
  
    gotoRegPayList() {
      this.regPayService.listRegPays()
      .subscribe(
      (response) => {     },
      (error) => {   this.errorMessage = error;  
      }
      );
      this.router.navigate(['/regpays/list']);
    }

    gotoRegPayAdd() {
      this.router.navigate(['/regpays/new']);
    }

    gotoRegPayEdit(id:String){
      this.router.navigate(["/regpays",id, 'edit']);
    }

    gotoRegPayDelete(id:String){
      this.regPayService.deleRegPay(id)
      .subscribe(
      (response) => {  this.regPay = response;
      },
      (error) => {     this.errorMessage = error;   
      }
      );
      this.router.navigate(['/regpays/list']);
    }
  }
  


