import { Router } from '@angular/router';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Login } from '../../DTO/Login'
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { RetailerService } from 'src/app/Service/retailer.service';
import { AdminService } from 'src/app/Service/admin.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

loginForm:FormGroup;
submitted:boolean=false;
invalidLogin: boolean = false;


//////////////////
AsUser:boolean=true;
AsAdmin:boolean=false;
AsRetailer:boolean=false;
//////////////////

  login: Login;
  email: string = "";
  password: string = "";
  uId : number=-1;
  rId : number=-1;
  aId : number=-1;

  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private customerService:CustomerService,
              private retailerService:RetailerService,
              private adminService:AdminService,
              private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      alert("Already Logged In");
      this.router.navigate(['home']);
    }
    if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('admin')!=null)
    {
      alert("Already Logged In");
      this.router.navigate(['home']);
    }
    if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('retailer')!=null)
    {
      alert("Already Logged In");
      this.router.navigate(['home']);
    }
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }


  //////////////Switch?///////////////

  AsUserF(){
    this.AsAdmin=false;
    this.AsRetailer=false;
    this.invalidLogin=false;
    this.AsUser=true;
  }

  AsAdminF(){
    this.AsUser=false;
    this.AsRetailer=false;
    this.invalidLogin=false;
    this.AsAdmin=true;
  }

  AsRetailerF(){
    this.AsUser=false;
    this.AsAdmin=false;
    this.invalidLogin=false;
    this.AsRetailer=true;
  }

  //////////////Switch?///////////////



  goToRegister(){
    this.router.navigate(['/register']);
  }

  onLogin(){
      this.submitted = true;
      if(this.loginForm.invalid){
        this.invalidLogin=true;
        return
      }
      else{
            if(this.AsUser){
              this.customerService.login(this.loginForm.value).subscribe(data=>{
                this.uId=data;
                this.createSession()
                this.router.navigate(['home']);
              });
            }
            else if(this.AsRetailer)
            {
              this.retailerService.login(this.loginForm.value).subscribe(data=>{
                this.rId=data;
                console.log("jih")
                console.log(this.rId)
                this.createSession()
              })
                this.router.navigate(['/profile-retailer']);
            }
            else{
              this.adminService.login(this.loginForm.value).subscribe(data=>{
                this.aId=data;
                this.createSession()})
                this.router.navigate(['/profile-admin']);
            }
      }
  }
  createSession(){
    if(this.uId!=-1)
    {
      /*Encription*/
      let encr=this.EncrDecr.set('123456$#@$^@1ERF',this.uId.toString())
      /*Encription*/
      /*Decription*/
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',encr)
      /*Decription*/
      sessionStorage.setItem('user',encr);
    }
   else if(this.rId!=-1)
    {
      /*Encription*/
      let encr=this.EncrDecr.set('123456$#@$^@1ERF',this.rId.toString())
      /*Encription*/
      /*Decription*/
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',encr)
      /*Decription*/
      sessionStorage.setItem('retailer',encr);
    }
   else if(this.aId!=-1)
    {
      /*Encription*/
      let encr=this.EncrDecr.set('123456$#@$^@1ERF',this.aId.toString())
      /*Encription*/
      /*Decription*/
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',encr)
      /*Decription*/
      sessionStorage.setItem('admin',encr);
    }
    else{
      this.invalidLogin=true;
      this.router.navigate(['/home']);
    }
  }
 }
  