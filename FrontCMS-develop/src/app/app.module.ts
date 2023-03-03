import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LandingModule } from './landings/landings.module';
import { UsersModule } from './users/users.module';
import { RegUsersModule } from './regusers/regusers.module';
import { RegPaysModule } from './regpays/regpays.module';
import { RegAppsModule } from './regapps/regapps.module';
import { AppTxtsModule } from './apptxts/apptxts.module';
import { AppTplatesModule } from './apptplates/apptplates.module';
import { AppOptsModule } from './appopts/appopts.module';
import { AppModsModule } from './appmods/appmods.module';
import { AppImgsModule } from './appimgs/appimgs.module';
import { AppAgreesModule } from './appagrees/appagrees.module';
import { AppUploadModule } from './appuploads/appupload.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './landings/navbar/navbar.component';
import { BodyComponent } from './landings/body/body.component';
import { FooterComponent } from './landings/footer/footer.component';
import { HeaderComponent } from './landings/header/header.component';

import { UserService } from './users/services/user-service';
import { RegUserService } from './regusers/services/reguser-service';
import { RegPayService } from './regpays/services/regpay.service';
import { RegAppService } from './regapps/services/regapp.service';
import { AppTxtService } from './apptxts/services/apptxt.service';
import { AppTplateService } from './apptplates/services/apptplate.service';
import { AppOptService } from './appopts/services/appopt.service';
import { AppModService } from './appmods/services/appmod.service';
import { AppImgService } from './appimgs/services/appimg.service';
import { AppAgreeService } from './appagrees/services/appagree.service';
import { AppUploadService } from './appuploads/services/appupload.service';

import { GlobalHttpInterceptorService } from './services/GlobalHttpInterceptorService';






@NgModule({
  declarations: [ 
    AppComponent,
    NavbarComponent,
    BodyComponent,
    FooterComponent,
    HeaderComponent,
   ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    LandingModule,
    AppRoutingModule,
    UsersModule,
    RegUsersModule,
    RegPaysModule,
    RegAppsModule,
    AppTxtsModule,
    AppTplatesModule,
    AppOptsModule,
    AppModsModule,
    AppImgsModule,
    AppAgreesModule,
    AppUploadModule   
  ],
  providers: [UserService,RegUserService,RegPayService,RegAppService,AppTxtService,
              AppTplateService,AppOptService,AppModService,AppImgService,AppAgreeService,AppUploadService,
  { provide: HTTP_INTERCEPTORS, useClass: GlobalHttpInterceptorService, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }