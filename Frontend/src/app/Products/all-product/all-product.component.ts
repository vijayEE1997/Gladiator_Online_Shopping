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
  prodsfilteredByBrand:Product[];
  constructor(private router:Router,
              private route:ActivatedRoute,
              private productService:ProductService,
              private sessionService:SessionService,
              ) { }

  ngOnInit(): void {
    this.sessionService.checkSession()
    this.route.paramMap.subscribe((params: ParamMap)=>
    {
      let keyword = params.get('keyword');
      this.productService.getProductBySearch(keyword)
      .subscribe((data: Product[])=>{this.products=data
        this.prodsfilteredByBrand=data;
      });
    });
  }
  showProductById(product){
    this.router.navigate(['product/'+product.pId]);
  }

  brands = ['Samsung', 'Nokia'];
  filteredByBrand() {
                    this.prodsfilteredByBrand = this.products
                    .filter(p =>{
                      for (let i = 0; i < this.brands.length; i++) {
                        (this.brands[i] == p.pBrand) 
                        }})
      .sort((c1,c2)=>c1.pPrice-c2.pPrice);
  }

}
