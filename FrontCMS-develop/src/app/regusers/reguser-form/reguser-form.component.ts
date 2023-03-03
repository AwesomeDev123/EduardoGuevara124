import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RegUserService } from '../services/reguser-service';
import { Reguser } from '../model/reguser.model';
import { eApps } from '../../enums/eApps';
import { eUserCountry } from '../../enums/eUserCountry';
import { eUserStatus } from '../../enums/eUserStatus';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-reguser-form',
  templateUrl: './reguser-form.component.html',
  styleUrls: ['./reguser-form.component.css']
})

export class ReguserFormComponent implements OnInit {
  reguser:Reguser ;
  regusers:Reguser[];
  idUser: String |null  ;
  regIdUser: String |null  ;
  eApplications: typeof eApps = eApps;
  eUserStatus: typeof eUserStatus = eUserStatus;
  eUserCountry: typeof eUserCountry = eUserCountry;
  
  constructor(
    private route: ActivatedRoute, 
    private router: Router, 
    private regUserService: RegUserService ) 
    {
      this.reguser = new Reguser();  } 

  ngOnInit() {
    this.route.paramMap.subscribe(params =>{
        if (params.has("reguser.id")) {
          this.regUserService.findRegUser(params.get("reguser.id")).subscribe(reguser =>this.reguser = reguser);
          this.regIdUser = this.reguser.idUser;
        } 
        if (params.has("idUser")) {
          this.idUser = params.get("idUser")!;
          this.reguser.idUser = params.get("idUser")!;
        } 
      }) 
  }

  onSubmit() {
    this.regUserService.saveRegUser(this.reguser)
    .subscribe(data => {      });
    if (this.regIdUser!== null)
    {this.gotoRegUserList(this.reguser.idUser); } else
    {this.router.navigate(["/regusers",this.idUser, 'list']);}
    
//      this.regUserService.saveRegUser(this.reguser).subscribe(result => this.gotoRegUserList(this.reguser.idUser));       
    }
  gotoRegUserSave(idRegUser:String, idUser:String|null){
        this.regUserService.saveRegUser(this.reguser).subscribe(data => {
        });
        this.router.navigate(["/regusers",idUser,'list']);
  }
  gotoRegUserList(idRegUser:String|null) {
    this.regUserService.listRegUsers(idRegUser).subscribe(data => {
      this.regusers = data;
    });
    this.router.navigate(["/regusers",idRegUser, 'list']);
  }
  gotoRegUserEdit(idRegUser:String, idUser:String|null){
    this.router.navigate(["/regusers",idRegUser, 'edit']);
  }
  gotoRegUserDelete(idRegUser:String, idUser:String|null){
      this.regUserService.deleRegUser(idRegUser).subscribe(data => {
      });
      this.router.navigate(["/regusers",this.reguser.idUser,'list']);
  }
}