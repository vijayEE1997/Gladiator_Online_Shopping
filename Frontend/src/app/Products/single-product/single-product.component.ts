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
  outOfStock:boolean;
  uId:number;
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
      if(stock!=0)
      {
        let encr = sessionStorage.getItem('user')
        let uId = this.EncrDecr.get('123456$#@$^@1ERF', encr)
        this.customerService.addToCart(parseInt(uId), this.product.pId).subscribe(data => {
          if (data==1)
            alert("Added Successfully")
          else if(data==0)
            alert("Already")
            else{
              alert("Retry")
            }
        })
      }
      else{
        this.outOfStock=true;
      }
    }     
      else{
        alert("Login as a User")
        this.router.navigate(['/home']);
      }
  }
  
  addToWishListF() {
      if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      let encr = sessionStorage.getItem('user')
      let uId = this.EncrDecr.get('123456$#@$^@1ERF', encr)
      this.customerService.addToWishList(parseInt(uId), this.product.pId).subscribe(data => {
        if (data==1)
        alert("Added Successfully")
      else if(data==0)
        alert("Already")
        else{
          alert("Retry")
        }
      })
    }else{
      alert("Login as a User")
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
     let encr = sessionStorage.getItem('user')
     this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
     this.customerService.addToCompare(this.uId,pId).subscribe(data=>{
       if(data==1)
       alert("added")
       else if(data==0)
       alert("already added")
       else if(data== -1){
        alert("choose same category or remove product from Compare")
        }
        else{
          alert("Cannot add more than 4")
        }
     })
   }
   else{
     this.router.navigate(['/login']);
   }
  }

}
