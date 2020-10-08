import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Product } from 'src/app/DTO/Product';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { ProductService } from 'src/app/Service/product.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent implements OnInit {

  product: Product;
  uId:number;

  error:boolean;
  message:string;
  popUp:boolean;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private productService: ProductService,
    private customerService: CustomerService,
    private sessionService:SessionService,
    private EncrDecr: EncrDecrService) { }

  ngOnInit(): void {
    this.sessionService.checkSession()
    this.route.paramMap.subscribe((params: ParamMap) => {
      let id = params.get('id');
      this.productService.getProductById(parseInt(id))
        .subscribe((data) => { console.log(data); this.product = data });
    });
  }

  addToCartF(stock) {
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.popUp=true;
      if(stock!=0)
      {
        let encr = sessionStorage.getItem('user')
        let uId = this.EncrDecr.get('123456$#@$^@1ERF', encr)
        this.customerService.addToCart(parseInt(uId), this.product.pId).subscribe(data => {
          if (data==1)
          {
            this.message="*Succesfully added to Cart!!!"
          }
          else if(data==0)
          {
            this.message="*Already added to Cart."
            this.error=true
          }
          else{
            this.message="*Retry"
            this.error=true
            }
        })
      }
      else{
        this.message="*Item is out of stock"
        this.error=true
      }
      setTimeout(()=>{this.popUp=false;this.error=false}, 1000);
    }     
      else{
        alert("Please, Login as a User")
        this.router.navigate(['/home']);
      }
  }
  
  addToWishListF() {
      if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.popUp=true;
      let encr = sessionStorage.getItem('user')
      let uId = this.EncrDecr.get('123456$#@$^@1ERF', encr)
      this.customerService.addToWishList(parseInt(uId), this.product.pId).subscribe(data => {
        if (data==1)
        {
          this.message="*Succesfully added to Wishlist!!!"
        }
      else if(data==0)
      {
        this.message="*Already added to Wishlist."
        this.error=true
      }
        else{
          this.message="*Retry"
          this.error=true
          }
      })
      setTimeout(()=>{this.popUp=false;this.error=false}, 1000);
    }else{
      alert("Please, Login as a User")
      this.router.navigate(['/home']);
    }
      
  
  }
  addToCompareF(pId){
      
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
    this.popUp=true;
     let encr = sessionStorage.getItem('user')
     this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
     this.customerService.addToCompare(this.uId,pId).subscribe(data=>{
       if(data==1)
       {
        this.message="*Succesfully added to Compare!!!"
      }
       else if(data==0)
       {
        this.message="*Already added to Compare."
        this.error=true
      }
       else if(data== -1){
        this.message="Choose product from same Sub-Category to Compare."
        this.error=true
      }
      else{
        this.message="Cannot compare more than 4 products."
        this.error=true
      }
     })
     setTimeout(()=>{this.popUp=false;this.error=false}, 1000);
   }
   else{
     this.router.navigate(['/login']);
   }
  }

}
