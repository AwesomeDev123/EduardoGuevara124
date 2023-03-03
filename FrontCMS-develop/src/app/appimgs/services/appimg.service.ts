import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AppImg } from '../../appimgs/model/appimg';

@Injectable({
  providedIn: 'root'
})
export class AppImgService {

  private appimgUrl: string;

  constructor(private http: HttpClient) {
    this.appimgUrl = 'http://127.0.0.1:8080/appimgs';
   }

   public findAppImg(idAppImg: String |null) {
    const findurl = this.appimgUrl+"/"+idAppImg;
    return this.http.get<AppImg>(findurl+"/edit")}  

   public findAppImgByIdUser(idAppImg: String |null) {
    const findurl = this.appimgUrl+"/"+idAppImg;
    return this.http.get<AppImg>(findurl+"/usedit")}  
   
   public listAppImgs(): Observable<AppImg[]> {
    const findurl = this.appimgUrl;
    return this.http.get<AppImg[]>(findurl+"/list")  ;  }  

 
  public listAppImgsAll(): Observable<AppImg[]> {
    const findurl = this.appimgUrl;
    return this.http.get<AppImg[]>(findurl+"/list")  ;  }  


  public saveAppImg(appimg: AppImg) {
    return this.http.post<AppImg>(this.appimgUrl+"/new", appimg); }

  public deleAppImg(idAppImg: String |null){
    const findurl = this.appimgUrl+"/"+idAppImg;
    return this.http.get<AppImg>(findurl+"/delete")         
  }  

  public saveAppImgUser(appimg: AppImg) {
    return this.http.post<AppImg>(this.appimgUrl+"/new", appimg); }
}
