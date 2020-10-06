import { not } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from 'src/app/DTO/Cart';
import { Product } from 'src/app/DTO/Product';
import { CartMyDTO } from 'src/app/DTO/CartMyDTO';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'user-cart',
  templateUrl: './user-cart.component.html',
  styleUrls: ['./user-cart.component.css']
})
export class UserCartComponent implements OnInit {

  // userCart: Cart[];
  status:boolean=false;
  uId:number;
  cartMyDTO:CartMyDTO[];
  totalPrice: number = 0;
  buyProductButton: boolean = false;
  constructor (private customerService : CustomerService,
               private EncrDecr: EncrDecrService,
               private router:Router,
               private sessionService:SessionService
              ) { }

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
      let encr = sessionStorage.getItem('user')
      if (encr != null) {
        this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
        this.CARTDETAIL()
      }
    }
      else{
        this.router.navigate(['/login']);
      }
  }

  buyProductF(){
    this.router.navigate(['/payment']);
  }

  delete(cId){
    console.log(cId)
    this.customerService.deleteFromCart(cId).subscribe(data=>{
      console.log(data)
      if(data){
        alert("deleted")
        this.CARTDETAIL()
      }
      else{
        alert("Retry")
      }
    })
  }


  onAddUpdateClick(cId:number)
  {
    this.customerService.updateMyCart(cId,1)
    .subscribe((data)=>
    {
      this.CARTDETAIL()
    });
  }
  onMinusUpdateClick(cId:number)
  {
    this.customerService.updateMyCart(cId,-1)
    .subscribe((data)=>
    {
      this.CARTDETAIL()
    });
  }

  
  CARTDETAIL(){
    this.customerService.getMyCart(this.uId).subscribe(data=>{
      this.cartMyDTO=data;
      console.log(data)
      this.totalPrice= 0;
      //////CHECKING CART IS EMPTY OR NOT //////
      if(this.cartMyDTO.length!=0)
      this.status=true
      //////CHECKING CART IS EMPTY OR NOT //////
      console.log(this.status)

      this.cartMyDTO.map(data=>{
            this.totalPrice+=(data.cartdto.qty*data.productdto.pPrice)
        })
    })
  }
}
