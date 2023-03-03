import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';
import {AppOpt} from '../model/appopt';
import {AppOptService} from '../services/appopt.service';
import {AppUploadService} from "@app/appuploads/services/appupload.service";
import {HttpClient} from '@angular/common/http';

@Component({
    selector: 'app-appopt-form',
    templateUrl: './appopt-form.component.html',
    styleUrls: ['./appopt-form.component.css']
})
export class AppOptFormComponent implements OnInit {
    appopt: AppOpt;
    appopts: AppOpt[];
    id: String | null;
    regAppOpt: String | null;
    //Gestion de imagenes
    //https://www.bezkoder.com/angular-multiple-files-upload/
    //Angular 8 Multiple Files upload example
    //https://www.bezkoder.com/spring-boot-upload-multiple-files/
    //https://stackoverflow.com/questions/51587241/how-to-upload-multiple-files-in-angular-6-with-addmore-button
    imgSrc: string;
    icoSrc: string;
    imgFile: any = [];
    icoFile: any = [];
    loading: boolean;
    //
    /*   private appoptsUrl: string;
      progress = 0;
      fileUploadForm = new FormGroup({
        optTitleImg: new FormControl(null, Validators.required),
        optSrcImg: new FormControl(null, [Validators.required, requiredFileType('png')])
      });
     */

    constructor(
        private http: HttpClient,
        private route: ActivatedRoute,
        private sanitizer: DomSanitizer,
        private router: Router,
        private appOptService: AppOptService,
        private appUploadService: AppUploadService,
    ) {
        // {this.appoptsUrl = 'http://127.0.0.1:8080/appopts/new';
        this.appopt = new AppOpt();
    }

    ngOnInit(): void {
        this.route.paramMap.subscribe(params => {
            if (params.has("appopt.id")) {
                this.appOptService.findAppOpt(params.get("appopt.id")).subscribe(appopt => this.appopt = appopt);
                this.regAppOpt = this.appopt.id;
            }
            if (params.has("id")) {
                this.id = params.get("id")!;
                this.appopt.id = params.get("id")!;
            }
        })
    }

    async onSubmit() {
        if (this.imgFile.length > 0) {
            let file = this.imgFile[0];
            await this.appUploadService.upload(file).then(response => {
                this.appopt.optSrcImgUrl = response.body.fileDownloadUri;
                this.appopt.optSrcImgId = response.body.fileId;
            });
        }

        if (this.icoFile.length > 0) {
            let file = this.icoFile[0];
            await this.appUploadService.upload(file).then(response => {
                this.appopt.optSrcIconUrl = response.body.fileDownloadUri;
                this.appopt.optSrcIconId = response.body.fileId;
            });
        }

        await this.appOptService.saveAppOpt(this.appopt).then(response => {

        });

        if (this.regAppOpt !== null) {
            this.gotoAppOptList();
        }
        else {
            this.router.navigate(["/appopts", 'list']);
        }

        /*     this.http.post(this.appoptsUrl, toFormData(this.fileUploadForm.value), {
              reportProgress: true,
              observe: 'events'
            }).subscribe(event => {

              if ( event.type === HttpEventType.UploadProgress ) {
                // this.progress = Math.round((100 * event.loaded) / event.total);
              }

              if ( event.type === HttpEventType.Response ) {
                console.log(event.body);
                this.fileUploadForm.reset();
              }
            }); */

    }

    public processForm(): void {

        console.group("Form View-Model");
        console.log("Name:", this.appopt.id);
        console.log("Email:", this.appopt.optSrcImgUrl);
        console.log("Resume:", this.appopt.optTitleImg);
        console.groupEnd();

    }

    catchSrcImg(event: any) {
        if (event.target.files && event.target.files.length > 0) {
            const imageCapture = event.target.files[0];
            this.extraerBase64(imageCapture).then((cImage: any) => {
                this.imgSrc = cImage.base;
            });
            this.imgFile.push(imageCapture);
        }


    }

    catchSrcIco(event: any) {
        if (event.target.files && event.target.files.length > 0) {
            const imageCapture = event.target.files[0];
            this.extraerBase64(imageCapture).then((cImage: any) => {
                this.icoSrc = cImage.base;
            });
            this.icoFile.push(imageCapture)
        }

    }

    clearSrcImg(): any {
        //   this.appopt.optSrcImg = '';
        this.imgSrc = '';
        this.imgFile = [];
    }

    clearSrcIco(): any {
        //   this.appopt.optSrcIcon= '';
        this.icoSrc = '';
        this.icoFile = [];
    }

    upLoadImage(): any {
        //  https://www.geeksforgeeks.org/angular-file-upload/
        console.log('Respuesta del servidor');
        try {
            this.loading = true;
            this.appopt.optSrcImg = this.imgFile;
            const formularioDeDatos = new FormData();
            this.imgFile.forEach((archivo: string | Blob) => {
                formularioDeDatos.append('files', archivo)
                this.loading = false;
            })
            // formularioDeDatos.append('_id', 'MY_ID_123')
            /*        this.appOptService.postImage(`http://localhost:3001/upload`, formularioDeDatos)
                      .subscribe(res => {
                        this.loading = false;
                    //    console.log('Respuesta del servidor', res);

                      }, () => {
                        this.loading = false;
                        alert('Error');
                      })
                            this.appopt.optSrcIcon = this.archivos;
             */
        } catch (e) {
            this.loading = false;
            //
            //  this.appopt.optSrcIcon = this.imgFile;
            console.log('ERROR', e);

        }
        //   this.appopt.optSrcIcon = this.imgFile;
    }

    upLoadIco(): any {
        console.log('Respuesta del servidor');
        try {
            this.loading = true;
            this.appopt.optSrcIcon = this.icoFile;
            const formularioDeDatos = new FormData();
            this.icoFile.forEach((archivo: string | Blob) => {
                formularioDeDatos.append('files', archivo)
                this.loading = false;
            })
            // formularioDeDatos.append('_id', 'MY_ID_123')
            /*        this.appOptService.postImage(`http://localhost:3001/upload`, formularioDeDatos)
                      .subscribe(res => {
                        this.loading = false;
                    //    console.log('Respuesta del servidor', res);

                      }, () => {
                        this.loading = false;
                        alert('Error');
                      })
                            this.appopt.optSrcIcon = this.archivos;
             */
        } catch (e) {
            this.loading = false;
            //
            this.appopt.optSrcIcon = this.icoFile;
            console.log('ERROR', e);

        }
        this.appopt.optSrcIcon = this.icoFile;
    }

    extraerBase64 = async ($event: any) => new Promise((resolve, reject) => {
        try {
            const unsafeImg = window.URL.createObjectURL($event);
            const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
            const reader = new FileReader();
            reader.readAsDataURL($event);
            reader.onload = () => {
                resolve({
                    base: reader.result
                });
            };
            reader.onerror = error => {
                resolve({
                    base: null
                });
            };
            return null;
        } catch (e) {
            return null;
        }
    })

    gotoAppOptSave(id: String) {
        this.appOptService.saveAppOpt(this.appopt).then(data => {
        });
        this.router.navigate(["/appopts", 'list']);
    }

    gotoAppOptList() {
        this.appOptService.listAppOpts().subscribe(data => {
            this.appopts = data;
        });
        this.router.navigate(["/appopts", 'list']);
    }

    gotoAppOptEdit(id: String) {
        this.router.navigate(["/appopts", id, 'edit']);
    }

    gotoAppOptDelete(id: String) {
        this.appOptService.deleAppOpt(id).subscribe(data => {
        });
        this.router.navigate(["/appopts", 'list']);
    }
}

