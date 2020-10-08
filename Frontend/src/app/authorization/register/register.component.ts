import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { CustomvalidationService } from 'src/app/Services_X/customvalidation.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm:FormGroup;
  already:boolean;
  constructor(private formBuilder: FormBuilder,
              private router:Router,
              private customerService:CustomerService,
              private EncrDecr: EncrDecrService,
              private customvalidation:CustomvalidationService) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      uEmail: ['', [ Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      uPassword: ['', Validators.compose([Validators.required, this.customvalidation.patternValidator()])],
      // uPassword: ['',Validators.compose([Validators.required,this.customvalidation.patternValidator()])],
      uName: ['', Validators.required],
      uMobile: ['',  [Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      //confirmPassword: ['', [Validators.required]],
    },
    // {
    //   validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
    // }
    );
}
  login(){
    
    this.router.navigate(['/login']);
  }

  register(){
    if(this.registerForm.invalid){
      return;
    }
    else{
          this.customerService.register(this.registerForm.value).subscribe(data=>{
            console.log(data)
            if(data==1)
            this.router.navigate(['/login']);
            else if(data==0)
            {
              this.already=true;
            }
            else{
              alert("Retry")
              this.router.navigate(['/register']);
            }
          });
    }
}

// patternValidator(): ValidatorFn {
//   return (control: AbstractControl): { [key: string]: any } => {
//     if (!control.value) {
//       return null;
//     }
//     const regex = new RegExp('^(?=.?[A-Z])(?=.?[a-z])(?=.*?[0-9]).{8,}$');
//     const valid = regex.test(control.value);
//     return valid ? null : { invalidPassword: true };
//   };
// }

}
