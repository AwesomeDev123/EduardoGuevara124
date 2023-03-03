import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {AppUploadService} from '../services/appupload.service';


@Component({
    selector: 'app-upload-files',
    templateUrl: './appupload-form.component.html',
    styleUrls: ['./appupload-form.component.css']
})
export class AppUploadFormComponent implements OnInit {
    selectedFiles: FileList;
    //progressInfos = [];
    progressInfos: any[] = [];
    message = '';

    fileInfos: Observable<any>;

    constructor(private appUploadService: AppUploadService) {
    }

    ngOnInit() {
        this.fileInfos = this.appUploadService.getFiles();
    }

    selectFiles(event: any) {
        this.progressInfos = [];
        this.selectedFiles = event.target.files;
    }

    uploadFiles() {
        this.message = '';

        for (let i = 0; i < this.selectedFiles.length; i++) {
            this.upload(i, this.selectedFiles[i]);
        }
    }

    upload(idx: any, file: any) {
        this.progressInfos[idx] = {value: 0, fileName: file.name};

        // this.appUploadService.upload(file).subscribe(
        //     event => {
        //         if (event.type === HttpEventType.UploadProgress) {
        //             if (event.total) {
        //                 const total: number = event.total;
        //                 this.progressInfos[idx].value = Math.round(100 * event.loaded / total);
        //             }
        //             //this.progressInfos[idx].value = Math.round(100 * event.loaded /  event.total?);
        //         } else if (event instanceof HttpResponse) {
        //             this.fileInfos = this.appUploadService.getFiles();
        //         }
        //     },
        //     err => {
        //         this.progressInfos[idx].value = 0;
        //         this.message = 'Could not upload the file:' + file.name;
        //     });
    }

}
