import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppTxt } from '../../apptxts/model/apptxt';

@Injectable({
  providedIn: 'root'
})
export class AppTxtService {

  private apptxtsUrl: string;

  constructor(private http: HttpClient) {
    this.apptxtsUrl = 'http://127.0.0.1:8080/apptxts';
   }

   public findAppTxt(idAppTxt: String |null) {
    const findurl = this.apptxtsUrl+"/"+idAppTxt;
    return this.http.get<AppTxt>(findurl+"/edit")}  

   public findAppTxtByIdUser(idAppTxt: String |null) {
    const findurl = this.apptxtsUrl+"/"+idAppTxt;
    return this.http.get<AppTxt>(findurl+"/usedit")}  
   
   public listAppTxts(): Observable<AppTxt[]> {
    const findurl = this.apptxtsUrl;
    return this.http.get<AppTxt[]>(findurl+"/list")  ;  }  

 
  public listAppTxtsAll(): Observable<AppTxt[]> {
    const findurl = this.apptxtsUrl;
    return this.http.get<AppTxt[]>(findurl+"/list")  ;  }  


  public saveAppTxt(apptxt: AppTxt) {
    return this.http.post<AppTxt>(this.apptxtsUrl+"/new", apptxt); }

  public deleAppTxt(idAppTxt: String |null){
    const findurl = this.apptxtsUrl+"/"+idAppTxt;
    return this.http.get<AppTxt>(findurl+"/delete")         
  }  

  public saveAppTxtUser(apptxt: AppTxt) {
    return this.http.post<AppTxt>(this.apptxtsUrl+"/new", apptxt); }
}
