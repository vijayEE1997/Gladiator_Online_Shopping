import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Product } from 'src/app/DTO/Product';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { ProductService } from 'src/app/Service/product.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'all-product',
  templateUrl: './all-product.component.html',
  styleUrls: ['./all-product.component.css']
})
export class AllProductComponent implements OnInit {

  products: Product[];
  SubCategory: string[];
  Brand: string[];
  prodsfilteredByBrand: Product[];
  SubCategoryflag = false;
  keyword: string;
  Range: boolean;
  uId: number;

  popUp: boolean;
  message: string
  error: boolean;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private productService: ProductService,
    private sessionService: SessionService,
    private customerService: CustomerService,
    private EncrDecr: EncrDecrService
  ) { }

  ngOnInit(): void {
    this.sessionService.checkSession()
    this.route.paramMap.subscribe((params: ParamMap) => {
      this.keyword = params.get('keyword');
      this.getall()

    });
  }
  showProductById(product) {
    this.router.navigate(['product/' + product.pId]);
  }

  filteredByBrand(Sub) {
    this.Range = false;
    this.prodsfilteredByBrand = this.products
      .filter(p => p.pSubCategory == Sub
      )
  }
  filteredByCat(brand) {
    this.Range = false;
    this.prodsfilteredByBrand = this.products
      .filter(p => p.pBrand == brand
      )
  }
  getall() {
    this.productService.getProductByCategory(this.keyword)
      .subscribe((data: Product[]) => {
        this.products = data.sort((a, b) => (b.pPrice) - (a.pPrice))
        this.prodsfilteredByBrand = data;
        this.productService.getSubCategoryByCategory(this.keyword).subscribe(data => {
          this.SubCategory = data
          this.productService.getBrandByCategory(this.keyword).subscribe(data => {
            this.Brand = data
          })
        })
      });
  }

  filter(Sub: string) {
    this.SubCategoryflag = !this.SubCategoryflag
    if (this.SubCategoryflag) {
      this.Range = false;
      this.productService.getProductBySubCategory(Sub).subscribe(data => { this.prodsfilteredByBrand = data })
    }
    else {
      this.getall()
    }
  }
  range() {
    let lr = (<HTMLInputElement>(document.getElementById("lr"))).value
    let hr = (<HTMLInputElement>(document.getElementById("hr"))).value
    if (lr < hr) {
      this.Range = false;
      this.prodsfilteredByBrand = this.products.filter(p => { return (p.pPrice > parseInt(lr)) && (p.pPrice < parseInt(hr)) })
    }
    else {
      this.Range = true;
    }
  }
  reset() {
    this.prodsfilteredByBrand = this.products
    this.Range = false;
  }
  sortasc() {
    this.prodsfilteredByBrand = this.prodsfilteredByBrand.sort((a, b) => (a.pPrice) - (b.pPrice))
    this.Range = false;
  }
  sortdesc() {
    this.prodsfilteredByBrand = this.prodsfilteredByBrand.sort((a, b) => (b.pPrice) - (a.pPrice))
    this.Range = false;
  }


  onCompareClick(product) {

    if (sessionStorage.getItem('retailer') != "null" && sessionStorage.getItem('retailer') != null) {
      this.router.navigate(['/home']);
    }
    else if (sessionStorage.getItem('admin') != "null" && sessionStorage.getItem('admin') != null) {
      this.router.navigate(['/home']);
    }
    else if (sessionStorage.getItem('user') != "null" && sessionStorage.getItem('user') != null) {
      let encr = sessionStorage.getItem('user')
      this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
      this.customerService.addToCompare(this.uId, product.pId).subscribe(data => {
        if (data == 1)
          alert("Successfully Added !!!")
        else if (data == 0)
          alert("Alread added to Compare.")
        else if (data == -1) {
          alert("Choose product from same Sub-Category to Compare.")
        }
        else {
          alert("Cannot compare more than 4 products.")
        }
      })
      setTimeout(() => { this.popUp = false, this.error = false }, 1000);
    }
    else {
      this.router.navigate(['/login']);
    }
  }

}
