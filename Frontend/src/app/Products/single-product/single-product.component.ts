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

  addToCartF() {
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
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
        if (data)
          alert("success wish")
        else
          alert("try")
      })
    }else{
      alert("Login as a User")
      this.router.navigate(['/home']);
    }
      
  
  }


}
