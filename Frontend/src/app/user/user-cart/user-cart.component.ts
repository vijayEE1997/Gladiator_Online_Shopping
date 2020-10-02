import { not } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {

  //userCart: Cart[];
  uId;
  totalPrice: number = 0;
  buyProductButton: boolean = false;
  constructor
  (
    //private _customerService : CustomerServiceService,
    //private _router : Router
  ) { }

  ngOnInit(): void {
    // first check in the session storage if user is login or not
    // if not loggined direct to home page.
    this.uId = sessionStorage.getItem('user');
    if(this.uId=="null")
    {
      alert("User Not Logged In");
      //this.router.navigate(['home']);
    }
  }

}
