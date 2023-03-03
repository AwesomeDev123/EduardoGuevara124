import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {AppOpt} from '../../appopts/model/appopt';

@Injectable({
    providedIn: 'root'
})
export class AppOptService {

    private appoptsUrl = 'http://localhost:8080/appopts';


//https://www.bezkoder.com/angular-spring-boot-file-upload/
    // ULTIMO VIDEO: https://www.youtube.com/watch?v=GKNIzIXrwT8
    constructor(private http: HttpClient) {
    }


    public findAppOpt(idAppOpt: String | null) {
        const findurl = this.appoptsUrl + "/" + idAppOpt;
        return this.http.get<AppOpt>(findurl + "/edit")
    }

    public findAppOptByIdUser(idAppOpt: String | null) {
        const findurl = this.appoptsUrl + "/" + idAppOpt;
        return this.http.get<AppOpt>(findurl + "/usedit")
    }

    public listAppOpts(): Observable<AppOpt[]> {
        const findurl = this.appoptsUrl;
        return this.http.get<AppOpt[]>(findurl + "/list");
    }


    public listAppOptsAll(): Observable<AppOpt[]> {
        const findurl = this.appoptsUrl;
        return this.http.get<AppOpt[]>(findurl + "/list");
    }


    public async saveAppOpt(appopt: AppOpt) {
        let headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        const req = new HttpRequest('POST', `${this.appoptsUrl}/new`, appopt, {
            headers: headers,
            responseType: 'json',
        });
        return await this.http.request(req).toPromise();
    }

    public deleAppOpt(idAppOpt: String | null) {
        const findurl = this.appoptsUrl + "/" + idAppOpt;
        return this.http.get<AppOpt>(findurl + "/delete")
    }

    public saveAppOptUser(appopt: AppOpt) {
        return this.http.post<AppOpt>(this.appoptsUrl + "/new", appopt);
    }


    public getImage(url: string) {
        return this.http.get(url); // GET
    }

    public postImage(url: string, body: any) {
        return this.http.post(url, body); // POST
    }

    upload(file: File): Observable<HttpEvent<any>> {
        const formData: FormData = new FormData();
        formData.append('file', file);

        const req = new HttpRequest('POST', `${this.appoptsUrl}/new`, formData, {
            reportProgress: true,
            responseType: 'json'
        });
        return this.http.request(req);
    }

    getFiles(): Observable<any> {
        return this.http.get(`${this.appoptsUrl}/files`);
    }


}
