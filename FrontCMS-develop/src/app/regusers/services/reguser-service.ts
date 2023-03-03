import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reguser } from '../../regusers/model/reguser.model';

@Injectable({
  providedIn: 'root'
})
export class RegUserService {

  private regusersUrl: string;

  constructor(private http: HttpClient) {
    this.regusersUrl = 'http://127.0.0.1:8080/regusers';
   }

   public findRegUser(idRegUser: String |null) {
    const findurl = this.regusersUrl+"/"+idRegUser;
    return this.http.get<Reguser>(findurl+"/edit")}  

   public findRegUserByIdUser(idUser: String |null) {
    const findurl = this.regusersUrl+"/"+idUser;
    return this.http.get<Reguser>(findurl+"/usedit")}  
   
   public listRegUsers(idUser: String |null): Observable<Reguser[]> {
    const findurl = this.regusersUrl+"/"+idUser;
    return this.http.get<Reguser[]>(findurl+"/list")  ;  }  

 
  public listRegUsersAll(): Observable<Reguser[]> {
    const findurl = this.regusersUrl;
    return this.http.get<Reguser[]>(findurl+"/list")  ;  }  


  public saveRegUser(reguser: Reguser) {
    return this.http.post<Reguser>(this.regusersUrl+"/new", reguser); }

  public deleRegUser(idRegUser: String |null){
    const findurl = this.regusersUrl+"/"+idRegUser;
    return this.http.get<Reguser>(findurl+"/delete")         
  }  

  public saveRegUserUser(reguser: Reguser) {
    return this.http.post<Reguser>(this.regusersUrl+"/new", reguser); }
}
