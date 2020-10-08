import { ForgotPassword } from './../../DTO/ForgotPassword';
import { CustomerService } from 'src/app/Service/customer.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RetailerService } from 'src/app/Service/retailer.service';
import { AdminService } from 'src/app/Service/admin.service';

@Component({
  selector: 'forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotForm:FormGroup;
  recievedOTP: number;
  invalidEmail:boolean=false;
  incorrectOTP:boolean=false;
  mismatchPass:boolean=false;
  success:boolean=false;
  Email="";
  Password="";
  option:string;
  step1:boolean=true;
  step2:boolean=false;
  step3:boolean=false;
  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private retailerService:RetailerService,
              private adminService:AdminService) { }

  ngOnInit(): void {
    this.forgotForm = this.formBuilder.group({
      email: ['', Validators.required],
      OTP:['',Validators.required],
      password: ['', Validators.required],
      cpassword: ['', Validators.required]
    });
  }

  checkOTP(){
    if(this.forgotForm.controls.OTP.value==this.recievedOTP)
    {
      this.step3=true;
      this.step2=false;
      this.step1=false;
    }
    else{
      this.incorrectOTP=true;
      this.step1=true;
      this.step2=false;
      this.step3=false;
    }
  }

  generateOTP()
  {
    if(this.forgotForm.controls.email.value=='')
    {
      alert("Invalid Email")
      return;
    }
    else{
      this.option=(<HTMLInputElement>(document.getElementById('#'))).value
      if(this.option==='user')
      {
        this.Email=this.forgotForm.controls.email.value
        this.customerService.generateOTP(this.Email).subscribe(data=>{
          if(data==-1)
          {
            this.router.navigate(['/register']);
          }
          else
          {  
            this.recievedOTP=data;
            this.step1=false;
            this.step2=true;
            this.step3=false;
          }
        })
      }
      else if(this.option==='retailer')
      {
        this.Email=this.forgotForm.controls.email.value
        this.retailerService.generateOTP(this.Email).subscribe(data=>{
          if(data==-1)
          {
            this.router.navigate(['/register']);
          }
          else
          {  
            this.recievedOTP=data;
            this.step1=false;
            this.step2=true;
            this.step3=false;
          }
        })
      }
    }
  }

  resetPassword(){
    if(this.forgotForm.controls.password.value===this.forgotForm.controls.cpassword.value)
    {
      this.mismatchPass=false;
      if(this.option==='user')
      {
        this.Password=this.forgotForm.controls.password.value
        this.customerService.resetPassword(this.Email,this.Password).subscribe(data=>{
          if(data==-1)
          {
            alert("Plz Retry")
            return
          }
          else
          {  
            this.success=true;
            // this.router.navigate(['login']);
          }
          setTimeout(()=>{this.router.navigate(['login']);}, 2000);
        })
      }
      else if(this.option==='retailer')
      {
        this.Password=this.forgotForm.controls.password.value
        this.retailerService.resetPassword(this.Email,this.Password).subscribe(data=>{
          if(data==-1)
          {
            alert("Please Retry")
            return
          }
          else
          {  
            this.success=true;
            // alert("Successfully updated!!!")
          }
          setTimeout(()=>{this.router.navigate(['login']);}, 2000);
        })
      }
    }
    else{
      this.mismatchPass=true;
      return
    }
  }





}
