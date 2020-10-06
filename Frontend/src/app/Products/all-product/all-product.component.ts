import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Product } from 'src/app/DTO/Product';
import { ProductService } from 'src/app/Service/product.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'all-product',
  templateUrl: './all-product.component.html',
  styleUrls: ['./all-product.component.css']
})
export class AllProductComponent implements OnInit {

  products:Product[];
  SubCategory:string[];
  prodsfilteredByBrand:Product[];
  SubCategoryflag=false;
  keyword:string;
  constructor(private router:Router,
              private route:ActivatedRoute,
              private productService:ProductService,
              private sessionService:SessionService,
              ) { }

  ngOnInit(): void {
    this.sessionService.checkSession()
    this.route.paramMap.subscribe((params: ParamMap)=>
    {
      this.keyword = params.get('keyword');
     this.getall()
            
    });

  }
  showProductById(product){
    this.router.navigate(['product/'+product.pId]);
  }

  filteredByBrand(Sub) {
                    this.prodsfilteredByBrand = this.products
                    .filter(p =>p.pSubCategory==Sub                      
                    )
  }
getall(){
  this.productService.getProductByCategory(this.keyword)
  .subscribe((data: Product[])=>{this.products=data
    this.prodsfilteredByBrand=data;
    this.productService.getSubCategoryByCategory(this.keyword).subscribe(data=>{this.SubCategory=data})
          });
}

   filter( Sub: string) {
    this.SubCategoryflag=!this.SubCategoryflag
     if(this.SubCategoryflag) 
     {
       this.productService.getProductBySubCategory(Sub).subscribe(data=>{this.prodsfilteredByBrand=data})
     }
else{
  this.getall()
 }
      }
      range(){
        let lr=(<HTMLInputElement>(document.getElementById("lr"))).value
        let hr=(<HTMLInputElement>(document.getElementById("hr"))).value
        this.prodsfilteredByBrand=this.prodsfilteredByBrand.filter(p=>{return (p.pPrice >parseInt(lr)) && (p.pPrice<parseInt(hr))})
      }
reset(){
  this.prodsfilteredByBrand=this.products
}
sortasc(){
  this.prodsfilteredByBrand=this.products.sort((a,b)=>(a.pPrice)-(b.pPrice))
}
sortdesc(){
  this.prodsfilteredByBrand=this.products.sort((a,b)=>(b.pPrice)-(a.pPrice))
}

}
