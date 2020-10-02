import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerService } from 'src/app/Service/retailer.service';

@Component({
  selector: 'my-products',
  templateUrl: './my-products.component.html',
  styleUrls: ['./my-products.component.css']
})
export class MyProductsComponent implements OnInit {

  productsPending: ProductForApproval[] = [];
  productsRejected: ProductForApproval[] = [];
  productsApproved: ProductForApproval[] = [];

  constructor(private retailerService: RetailerService,
    private router: Router) { }

  ngOnInit(): void {
    let rId = sessionStorage.getItem('retailer');
    if (sessionStorage.getItem('retailer') == "null") {
      alert("Retailer Not Logged In");
      this.router.navigate(['home']);
    }
  }

  // getRejectedProducts() {
  //   let rId = sessionStorage.getItem('retailer');
  //   if (rId != "null") {
  //     this.retailerService.getRejectedProduct(rId)
  //       .subscribe((data: ProductForApproval[]) => { console.log(data); this.productsRejected = data });
  //   }
  // }
  // getApprovedProducts() {
  //   let rId = sessionStorage.getItem('retailer');
  //   if (rId != "null") {
  //     this.retailerService.getApprovedProduct(rId)
  //       .subscribe((data: ProductForApproval[]) => { console.log(data); this.productsApproved = data });
  //   }
  // }
  // getPendingProducts() {
  //   let rId = sessionStorage.getItem('retailer');
  //   if (rId != "null") {
  //     this.retailerService.getPendingProduct(rId)
  //       .subscribe((data: ProductForApproval[]) => { console.log(data); this.productsPending = data });
  //   }
  // }

}
