import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { WishMyDTO } from 'src/app/DTO/WishMyDTO';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'user-wishlist',
  templateUrl: './user-wishlist.component.html',
  styleUrls: ['./user-wishlist.component.css']
})
export class UserWishlistComponent implements OnInit {

  uId:number;
  wishMyDTO:WishMyDTO[];
  status:boolean;
  constructor(private customerService: CustomerService,
              private EncrDecr:EncrDecrService,
              private sessionService:SessionService,
              private router:Router ) { }

  ngOnInit(): void {

    this.sessionService.checkSession()

    let encr = sessionStorage.getItem('user')
    if (encr != null) {
      this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
      this.WISHDETAIL()
    }
    else{
      this.router.navigate(['/login']);
    }
  }
  WISHDETAIL(){
    this.customerService.getMyWishlist(this.uId).subscribe(data=>{
      this.wishMyDTO=data;
      console.log(data)
      //////CHECKING CART IS EMPTY OR NOT //////
      if(this.wishMyDTO.length!=0)
      this.status=true
      //////CHECKING CART IS EMPTY OR NOT //////
      console.log(this.status)
    })
  }
  addToCartF(wishlist) {
      this.customerService.addToCart(wishlist.wishlistdto.uId,wishlist.productdto.pId).subscribe(data => {
        if (data==1)
          {
            alert("Added Successfully")
            this.deleteF(wishlist);
          }
        else if(data==0)
          alert("Already")
          else{
            alert("Retry")
          }
      })
    }
    deleteF(wishlist){
      this.customerService.delete(wishlist.wishlistdto.wId).subscribe(data => {
        if (data==1)
          {
            this.WISHDETAIL()
          }
        else if(data==0)
          alert("Already")
          else{
            alert("Retry")
          }
      })
    }
  
}
