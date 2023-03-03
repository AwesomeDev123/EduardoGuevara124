import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegApp } from '../../regapps/model/regapp';

@Injectable({
  providedIn: 'root'
})
export class RegAppService {
  private appUrl: string;

  constructor(private http: HttpClient) {
    this.appUrl = 'http://127.0.0.1:8080/regapps';
   }

   public findApp(idApp: String |null) {
    const findurl = this.appUrl+"/"+idApp;
    return this.http.get<RegApp>(findurl+"/edit")}  

   public listApps(): Observable<RegApp[]> {
    const findurl = this.appUrl+"/list";
    return this.http.get<RegApp[]>(findurl)  ;  }  

  public saveApp(regapp: RegApp) {
    return this.http.post<RegApp>(this.appUrl+"/new", regapp); }

  public deleApp(idApp: String |null){
    const findurl = this.appUrl+"/"+idApp;
    return this.http.get<RegApp>(findurl+"/delete")         
  }  

}
