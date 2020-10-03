import { not } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/DTO/Cart';
import { Product } from 'src/app/DTO/Product';
import { CartMyDTO } from 'src/app/DTO/CartMyDTO';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {

  // userCart: Cart[];
  uId:number;
  cartMyDTO:CartMyDTO[];
  totalPrice: number = 0;
  buyProductButton: boolean = false;
  constructor (private customerService : CustomerService,
               private EncrDecr: EncrDecrService,
               private router:Router
              ) { }

  ngOnInit(): void {
      let encr = sessionStorage.getItem('user')
      if (encr != null) {
        this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
        this.customerService.getMyCart(this.uId).subscribe(data=>{
          this.cartMyDTO=data;
          console.log(data)
          this.cartMyDTO.map(data=>{
                this.totalPrice+=(data.cartdto.qty*data.productdto.pPrice)
            })
        })
      }
      else{
        alert("login kro")
        this.router.navigate(['home']);
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
