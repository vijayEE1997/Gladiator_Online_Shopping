import { RetailerModule } from './retailer/retailer.module';
import { AdminModule } from './admin/admin.module';
import { AuthorizationModule } from './authorization/authorization.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Home/header/header.component';
import { FooterComponent } from './Home/footer/footer.component';
import { ContainerComponent } from './Home/container/container.component';
import { HomeComponent } from './Home/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from './Service/customer.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContainerComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AuthorizationModule,
    FormsModule,
    AdminModule,
    RetailerModule,
    HttpClientModule
  ],
  providers: [CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
