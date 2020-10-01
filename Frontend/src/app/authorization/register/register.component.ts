import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm:FormGroup;
  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private customerService:CustomerService,
              private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      uEmail: ['', Validators.required],
      uPassword: ['', Validators.required],
      uName: ['', Validators.required],
      uMobile: ['', Validators.required]
    });
  }
  register(){
    if(this.registerForm.invalid){
      return;
    }
    else{
          this.customerService.register(this.registerForm.value).subscribe(data=>{
            console.log(data)
          });
    }
}
}
