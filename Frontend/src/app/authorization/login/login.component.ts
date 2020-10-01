import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Login } from '../../DTO/Login'
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
loginForm:FormGroup;
submitted:boolean=false;
invalidLogin: boolean = false;

  login: Login;
  email: string = "";
  password: string = "";
  uId : number=-1;

  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private customerService:CustomerService,
              private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('user')!=null)
    {
      alert("Already Logged In");
      this.router.navigate(['home']);
    }
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
  goToRegister(){
    this.router.navigate(['/register']);
  }

  onLogin(){
      this.submitted = true;
      if(this.loginForm.invalid){
        return;
      }
      else{
            this.customerService.login(this.loginForm.value).subscribe(data=>{
              this.uId=data;
              this.createSession()
            });
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
      this.router.navigate(['home']);
    }
  }
}
