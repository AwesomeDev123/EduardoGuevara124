import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppAgree } from '../../appagrees/model/appagree';

@Injectable({
  providedIn: 'root'
})
export class AppAgreeService {

  private appagreeUrl: string;

  constructor(private http: HttpClient) {
    this.appagreeUrl = 'http://127.0.0.1:8080/appagrees';
   }

   public findAppAgree(idAppAgree: String |null) {
    const findurl = this.appagreeUrl+"/"+idAppAgree;
    return this.http.get<AppAgree>(findurl+"/edit")}  

   public findAppAgreeByIdUser(idAppAgree: String |null) {
    const findurl = this.appagreeUrl+"/"+idAppAgree;
    return this.http.get<AppAgree>(findurl+"/usedit")}  
   
   public listAppAgrees(): Observable<AppAgree[]> {
    const findurl = this.appagreeUrl;
    return this.http.get<AppAgree[]>(findurl+"/list")  ;  }  

 
  public listAppAgreesAll(): Observable<AppAgree[]> {
    const findurl = this.appagreeUrl;
    return this.http.get<AppAgree[]>(findurl+"/list")  ;  }  


  public saveAppAgree(appagree: AppAgree) {
    return this.http.post<AppAgree>(this.appagreeUrl+"/new", appagree); }

  public deleAppAgree(idAppAgree: String |null){
    const findurl = this.appagreeUrl+"/"+idAppAgree;
    return this.http.get<AppAgree>(findurl+"/delete")         
  }  

  public saveAppAgreeUser(appagree: AppAgree) {
    return this.http.post<AppAgree>(this.appagreeUrl+"/new", appagree); }
}
