import {
    HttpEvent,
    HttpInterceptor,  
    HttpHandler,  
    HttpRequest,  
    HttpResponse,  
    HttpErrorResponse   
   } from '@angular/common/http';
   import { ActivatedRoute, Router, RouterModule, Routes } from '@angular/router';
   import { Observable, throwError } from 'rxjs';  
   import { retry, catchError } from 'rxjs/operators';
   
   export class GlobalHttpInterceptorService implements HttpInterceptor {
/*     errorMessage:string;
  
    constructor(private route: ActivatedRoute, 
      private router: Router ) { 
     } */
     
//https://satyapriyamishra111.medium.com/angular-error-interceptor-4b102f938065
//https://javascript.plainenglish.io/angular-handle-http-errors-using-interceptors-5cc483103740
//https://javascript.plainenglish.io/angular-handle-http-errors-using-interceptors-5cc483103740
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request)
         .pipe(
           retry(1),  
            catchError((error) => {  
              console.log('error is intercept')
              console.error(error);    
              //mas detalle de errores  
/*              if (error.error instanceof ErrorEvent) {    
                // client-side error     
                this.errorMessage = error.message + "client-side error";    
              } else {   
                // server-side error    
                this.errorMessage = this.errorMessage + "server-side error";               
              }  
 */
/*               if (error instanceof HttpErrorResponse) {
                if (error.error instanceof ErrorEvent) {
                    console.error("Error Event");
                } else {
                     console.log(`error status : ${error.status} ${error.statusText}`);
                    switch (error.status) {
                        case 401:      //login
                            this.router.navigateByUrl("/login");
                            break;
                        case 403:     //forbidden
                            this.router.navigateByUrl("/unauthorized");
                            break;
                    } 
                } 
            } else {
                console.error("some thing else happened");
            } */

              window.alert(error.message);    
              return throwError(error.message);    
            })  
          )      
      }     
 }

