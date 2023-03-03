import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError,map } from 'rxjs/operators';
import { AppTplate } from '../model/apptplate';

/* The @Injectable() decorator defines a class as a service 
in Angular and allows Angular to inject it into a component as a dependency. 
Likewise, the @Injectable() decorator indicates that a component, class, pipe, or NgModule 
has a dependency on a service. 
The injector is the main mechanism. */

@Injectable({
  providedIn: 'root'
/*   The providedIn allow us to specify how Angular should provide the dependency in the service class 
  itself instead of in the Angular Module. 
  It also helps to make the service tree shakable i.e. 
  remove the service from the final bundle if the app does not use it. */
})
export class AppTplateService {
  private apptpltsUrl: string;
  // private apptpltUrl: string;

  constructor(private http: HttpClient) {
  this.apptpltsUrl = 'http://127.0.0.1:8080/apptplates';
   }

/*    public listAppTplates(): Observable<AppTplate[]> {
  return this.http.get<AppTplate[]>(this.apptpltsUrl+"/list");  } */

  public listAppTplates(): Observable<AppTplate[]> {
  return this.http.get<AppTplate[]>(this.apptpltsUrl+"/list").pipe(
    retry(1),
    catchError(this.handleError)  );
  }

  public saveAppTplate(apptplt: AppTplate) {
  return this.http.post<AppTplate>(this.apptpltsUrl+"/new", apptplt);
   }
  /* llamado a direcciones en apptplts-routing
   NOPE! const routes: Routes = [ { path: 'apptplts/new', component:  AppTplateFormComponent  }]; 
   en el servicio se hace la peticion Http: Get o Post*/
   
  public findAppTplate(idAppTplate: String |null) {
  const findurl = this.apptpltsUrl+"/"+idAppTplate;
  return this.http.get<AppTplate>(findurl+"/edit")
  }  

  public deleAppTplate(idAppTplate: String |null): Observable<AppTplate> {
  const findurl = this.apptpltsUrl+"/"+idAppTplate;
  return this.http.get<AppTplate>(findurl+"/delete")     
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

   /* 
   handleError(error:Error) viene de la funcion  catchError(this.handleError) del observable
   activa la funcion error en una constante global error 
   y devuelve este mensaje de error 
   */

  }
}
