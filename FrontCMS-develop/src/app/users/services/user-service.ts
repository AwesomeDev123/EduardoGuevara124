import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError,map } from 'rxjs/operators';
import { User } from '../model/user';

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
export class UserService {
  private usersUrl: string;
  // private userUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://127.0.0.1:8080/users';
   }

/*    public listUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl+"/list");  } */

  public listUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl+"/list").pipe(
      retry(1),
      catchError(this.handleError)  );
  }

  public saveUser(user: User) {
    return this.http.post<User>(this.usersUrl+"/new", user);
   }
    /* llamado a direcciones en users-routing
     NOPE! const routes: Routes = [ { path: 'users/new', component:  UserFormComponent  }]; 
     en el servicio se hace la peticion Http: Get o Post*/
     
  public findUser(idUser: String |null) {
    const findurl = this.usersUrl+"/"+idUser;
    return this.http.get<User>(findurl+"/edit")
  }  

  public deleUser(idUser: String |null): Observable<User> {
    const findurl = this.usersUrl+"/"+idUser;
    return this.http.get<User>(findurl+"/delete")     
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
