import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AppUploadService {

    private baseUrl = 'http://localhost:8080';

    constructor(private http: HttpClient) {
    }

    async upload(file: File): Promise<any> {


        const formData: FormData = new FormData();

        formData.append('file', file);

        let headers = new HttpHeaders();
        headers.append('Content-Type', 'multipart/form-data');
        headers.append('Accept', 'application/json');

        const req = new HttpRequest('POST', `${this.baseUrl}/file/upload`, formData, {
            headers: headers,
            reportProgress: true,
            responseType: 'json',
        });

        return await this.http.request(req).toPromise();

    }

    getFiles(): Observable<any> {
        return this.http.get(`${this.baseUrl}/files/files`);
    }

}
