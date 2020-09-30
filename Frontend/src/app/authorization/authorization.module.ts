import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from '../Service/customer.service'
import { EncrDecrService } from '../Service/encr-decr.service'


@NgModule({
  declarations: [LoginComponent, RegisterComponent, ForgotPasswordComponent],
  imports: [
    CommonModule,ReactiveFormsModule,FormsModule
  ],
  providers:[CustomerService,EncrDecrService],
  exports:[
    LoginComponent, RegisterComponent, ForgotPasswordComponent
  ]
})
export class AuthorizationModule { }
