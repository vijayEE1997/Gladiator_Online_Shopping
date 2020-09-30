import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Login } from '../../DTO/Login'
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/Service/customer.service';


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
  uId$ : Observable<number>;

  constructor(private formBuilder: FormBuilder,private router:Router,private customerService:CustomerService) { }

  ngOnInit(): void {
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
            this.login = new Login();
            this.login.email = this.email;
            this.login.password = this.password;
            this.uId$ = this.customerService.login(this.login);
    //alert(this.login.email);
  }
}
}
