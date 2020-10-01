import { ForgotPassword } from './../../DTO/ForgotPassword';
import { CustomerService } from 'src/app/Service/customer.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  email: string = "";
  password: string = "";
  cpassword: string = "";
  recievedOTP: number;
  otp: Observable<number>;
  message: string;

  constructor(private router: Router,
    private customerService: CustomerService) { }

  ngOnInit(): void {
    if (parseInt(sessionStorage.getItem('user')) > 0) {
      this.router.navigate(['home']);
    }
  }


  generateOTP() {
    if (this.password === "" && this.cpassword === "") {
      alert("First Enter Passwords");
    }
    else if (this.password != this.cpassword) {
      alert("Password do not Match");
    }
    else {
      this.otp = this.customerService.generateOTP();
    }
  }


  
  changePassword() {
    if (this.password === "" && this.cpassword === "") {
      alert("First Enter Passwords");
    }
    else if (this.password != this.cpassword) {
      alert("Password do not Match");
    }
    else if (this.recievedOTP === 0) {
      alert("OTP is missing");
    }
    else {
      let forgotPassword = new ForgotPassword();

      forgotPassword.email = this.email;
      forgotPassword.password = this.cpassword;
      forgotPassword.otp = this.recievedOTP.toString();

      this.customerService.forgotPassword(forgotPassword)
        .subscribe(data => { this.message = data });

      if (this.message == "Password Updated Successfull")
      {
        alert("Password Updated Successfull");

        sessionStorage.setItem('forgot-email', null);
        this.router.navigate(['login']);
      }
    }

  }





}
