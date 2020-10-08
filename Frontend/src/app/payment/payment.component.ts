import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Subscriber } from 'rxjs';
import { User } from '../DTO/User';
import { CustomerService } from '../Service/customer.service';
import { EncrDecrService } from '../Service/encr-decr.service';
import { SessionService } from '../Services_X/session.service';

@Component({
  selector: 'payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  payType:string;
  amount:number;
  otpB:number;
  otpF:number;
  otpField:boolean;
  uId:number;
  user:User;
  address:string;
  hideInput:boolean=false;
  paymentAmount:number;

  error:boolean;
  message:string;
  popUp:boolean;

  constructor(private customerService:CustomerService,
              private router:Router,
              private sessionService:SessionService,
              private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {

    this.sessionService.checkSession()
    
    if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
     {
       this.router.navigate(['/home']);
     }
     else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
     {
       this.router.navigate(['/home']);
     }
     else if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
     {  
        let pay =sessionStorage.getItem('pay')
        if(pay!="null" && pay!=null)
        {
          this.paymentAmount=parseInt(this.EncrDecr.get('123456$#@$^@1ERF', pay))
          sessionStorage.setItem('pay',null);
          let encr = sessionStorage.getItem('user')
          this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
          this.customerService.getAddress(this.uId).subscribe(data=>{
         this.user=data;
         this.address=data.uAddress;
         console.log(data)
       })
        }
        else{
          this.router.navigate(['/MyCart']);
        }
        
     }
    else{
         this.router.navigate(['/login']);
    }
  }

  COD(){
    this.payType="Cash On Delivery"
    this.payment();
  }

  DEBITCARD(){
    this.payType="Debit Card"
    this.payment();
  }

  addAddressF(){
    this.hideInput=true;
    this.addressSetF()
  }
  updateAddressF(){
    this.address=null;
    this.hideInput=false;
    this.addressSetF()
  }
  addressSetF(){
    this.user.uAddress=(<HTMLInputElement>(document.getElementById("address"))).value;
    this.customerService.updateAddress(this.user).subscribe(data=>{
      console.log(data)
      this.customerService.getAddress(this.uId).subscribe(data=>{
        this.user=data;
        this.address=data.uAddress;
        console.log(data)
      })
    })
  }

payment(){

  this.customerService.generateOTPById(this.uId).subscribe(
    data=>{
      this.otpB=data;
      console.log(this.otpB)
    }
  )

  this.otpField=true;
}
paymentConfirm(){
  this.otpF=parseInt((<HTMLInputElement>(document.getElementById("OTP"))).value);
  this.popUp=true;
  this.error=false;
  if(this.otpF==this.otpB)
  {
    this.customerService.makePayment(this.payType,this.uId).subscribe(
    data=>{
      if(data>0)
      {
        this.message="*Order placed succesfully!!!"
        setTimeout(()=>{this.router.navigate(['/orders']);}, 2000);
        
      }
      else
      {
        this.error=true;
        this.message="*Retry"
      }
    }
  )
  }
  else
  {
    this.error=true;
    this.message="*Incorrect OTP"
  }
}

}
