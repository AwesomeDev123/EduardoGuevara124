import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppuploadRoutingModule } from './appupload-routing.module';
import { AppUploadFormComponent } from './appupload-form/appupload-form.component';


@NgModule({
  declarations: [
    AppUploadFormComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    AppuploadRoutingModule,

  ]
})
export class AppUploadModule { }
