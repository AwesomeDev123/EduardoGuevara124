import { Injectable } from '@angular/core';
import { Observable, retry, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Regpay } from '../model/regpay';

@Injectable({
  providedIn: 'root'
})
export class RegPayService {
  regPayUrl: string;

    constructor(private http: HttpClient) {
      this.regPayUrl = 'http://127.0.0.1:8080/regpays';
    }

    public listRegPays(): Observable<Regpay[]>{
      return this.http.get<Regpay[]>(this.regPayUrl+"/list").pipe(retry(1))
    }

    public saveRegPay(regPay: Regpay) {
    return this.http.post<Regpay>(this.regPayUrl+"/new", regPay);
    }

    public findRegPays(idRegPay: String |null) {
    const findurl = this.regPayUrl+"/"+idRegPay;
    return this.http.get<Regpay>(findurl+"/edit")
    }  

    public deleRegPay(idRegPay: String |null): Observable<Regpay> {
    const findurl = this.regPayUrl+"/"+idRegPay;
    return this.http.get<Regpay>(findurl+"/delete")     
    }  

    handleError(error:Error) {
    let errorMessage = error;
      if (error instanceof ErrorEvent) {
        // client-side error
        errorMessage = error.error; 
    } else { 
      // server-side error
        errorMessage = error;  }
        window.alert(errorMessage);
    return throwError(errorMessage);

    }
  }
  