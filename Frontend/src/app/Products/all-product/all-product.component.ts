import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Product } from 'src/app/DTO/Product';
import { ProductService } from 'src/app/Service/product.service';

@Component({
  selector: 'all-product',
  templateUrl: './all-product.component.html',
  styleUrls: ['./all-product.component.css']
})
export class AllProductComponent implements OnInit {

  products:Product[];
  constructor(private router:Router,
              private route:ActivatedRoute,
              private productService:ProductService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params: ParamMap)=>
    {
      let keyword = params.get('keyword');
      this.productService.getProductBySearch(keyword)
      .subscribe((data: Product[])=>{console.log(data);this.products=data});
    });
  }
  showProductById(product){
    this.router.navigate(['product/'+product.pId]);
  }
}
