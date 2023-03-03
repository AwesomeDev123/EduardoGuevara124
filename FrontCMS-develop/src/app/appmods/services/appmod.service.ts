import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppMod } from '../../appmods/model/appmod';

@Injectable({
  providedIn: 'root'
})
export class AppModService {

  private appmodUrl: string;

  constructor(private http: HttpClient) {
    this.appmodUrl = 'http://127.0.0.1:8080/appmods';
   }

   public findAppMod(idAppMod: String |null) {
    const findurl = this.appmodUrl+"/"+idAppMod;
    return this.http.get<AppMod>(findurl+"/edit")}  

   public findAppModByIdUser(idAppMod: String |null) {
    const findurl = this.appmodUrl+"/"+idAppMod;
    return this.http.get<AppMod>(findurl+"/usedit")}  
   
   public listAppMods(): Observable<AppMod[]> {
    const findurl = this.appmodUrl;
    return this.http.get<AppMod[]>(findurl+"/list")  ;  }  

 
  public listAppModsAll(): Observable<AppMod[]> {
    const findurl = this.appmodUrl;
    return this.http.get<AppMod[]>(findurl+"/list")  ;  }  


  public saveAppMod(appmod: AppMod) {
    return this.http.post<AppMod>(this.appmodUrl+"/new", appmod); }

  public deleAppMod(idAppMod: String |null){
    const findurl = this.appmodUrl+"/"+idAppMod;
    return this.http.get<AppMod>(findurl+"/delete")         
  }  

  public saveAppModUser(appmod: AppMod) {
    return this.http.post<AppMod>(this.appmodUrl+"/new", appmod); }
}
