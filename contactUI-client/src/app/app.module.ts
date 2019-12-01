import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateContactComponent } from './create-contact/create-contact.component';
import { ContactListComponent } from './contact-list/contact-list.component';
import { UpdateContactComponent } from './update-contact/update-contact.component';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './http-interceptor.service';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';



@NgModule({
  declarations: [
    AppComponent,
    CreateContactComponent,
    ContactListComponent,
    UpdateContactComponent,
    LoginComponent,
    LogoutComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
   { provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
  }
  ],
  bootstrap: [AppComponent]
})


export class AppModule { }
