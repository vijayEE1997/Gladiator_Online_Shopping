import { ForgotPassword } from './../../DTO/ForgotPassword';
import { CustomerService } from 'src/app/Service/customer.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  forgotForm:FormGroup;
  recievedOTP: number;
  invalidEmail:boolean=false;
  Email="";
  Password="";
  option:string;
  step1:boolean=true;
  step2:boolean=false;
  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private customerService: CustomerService) { }

  ngOnInit(): void {
    this.forgotForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      cpassword: ['', Validators.required]
    });
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
            alert("User Not Exixts")
            return
          }
          else
          {  
            this.recievedOTP=data;
            this.step1=false;
            this.step2=true;
          }
        })
      }
    }
  }

  resetPassword(){
    if(this.forgotForm.controls.password.value===this.forgotForm.controls.cpassword.value)
    {
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
            alert("success")
            this.router.navigate(['login']);
          }
        })
      }
    }
    else{
      alert("Password Mismatch")
      return
    }
  }





}
