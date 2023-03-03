import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegPayService } from '../services/regpay.service';
import { Regpay } from '../model/regpay';

@Component({
  selector: 'app-regpay-form',
  templateUrl: './regpay-form.component.html',
  styleUrls: ['./regpay-form.component.css']
})
export class RegpayFormComponent implements OnInit {
  regPays: Regpay[];
  regPay: Regpay = new Regpay();
  errorMessage:String|null;

  constructor(
    private regPayService : RegPayService,
    private route: ActivatedRoute, 
    private router: Router) {

   }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>{
      if (params.has("regpay.id")) {
        this.regPayService.findRegPays(params.get("regpay.id")).subscribe(regPay =>this.regPay = regPay);
          }else{
        // this.regPayService.listRegPays().subscribe(regPays =>this.regPays = regPays);
       }
        })
  }
  
  onSubmit() {
    this.regPayService.saveRegPay(this.regPay).subscribe(result => this.gotoRegPayList()); 
    this.router.navigate(['/regpays/list']);
    }

  gotoRegPayList(){
    this.router.navigate(['/regpays/list']);
  };

    gotoRegPayDelete(regpayId: string){
      this.regPayService.deleRegPay(regpayId).subscribe(result => this.gotoRegPayList());
      this.router.navigate(['/regpays/list']);
  };

  gotoRegPaySave(regpayId: string,idUser: string){
    regpayId ="";
    idUser ="";
  };

}
