import { not } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/Service/customer.service';

@Component({
  selector: 'user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {

  // userCart: Cart[];
  uId;
  totalPrice: number = 0;
  buyProductButton: boolean = false;
  constructor
  (
    private customerservice : CustomerService,
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
  // onAddUpdateClick(cId:number)
  // {
  //   this.customerservice.updateMyCart(cId,1)
  //   .subscribe((data:string)=>
  //   {
  //     //alert(data);
  //     //this.reloadData();
  //   });
  // }
  // onMinusUpdateClick(cId:number)
  // {
  //   this.customerservice.updateMyCart(cId,0)
  //   .subscribe((data:string)=>
  //   {
  //     //alert(data);
  //    // this.reloadData();
  //   });
  // }
}
