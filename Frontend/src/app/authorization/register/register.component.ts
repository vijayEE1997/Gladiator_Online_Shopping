import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
// import { CustomvalidationService } from 'src/app/services/customvalidation.service';

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
      uEmail: ['', Validators.required,],
      //uPassword: ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
      uPassword: ['',],
      uName: ['', ],
      uMobile: ['', ],
      //confirmPassword: ['', [Validators.required]],
    },
    // {
    //   validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
    // }
    );
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
