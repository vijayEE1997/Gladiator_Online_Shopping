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

  approved:boolean=false;
  rejected:boolean=false;
  pending:boolean=true;

  rId:number=3;
  constructor(private retailerService: RetailerService,
    private router: Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.router.navigate(['home']);
    }
   else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
    {
      this.router.navigate(['home']);
    }
   else{
    this.getApprovedProducts()
    this.getPendingProducts()
    this.getRejectedProducts()
   }
  }

  pendingF(){
    this.approved=false;
    this.rejected=false;
    this.pending=true;
  }

  approvedF(){
    this.approved=true;
    this.rejected=false;
    this.pending=false;
  }

  rejectedF(){
    this.approved=false;
    this.pending=false;
    this.rejected=true;
  }

  getRejectedProducts() {
      this.retailerService.getRejectedProduct(this.rId)
        .subscribe((data: ProductForApproval[]) => {this.productsRejected = data });
  }
  getApprovedProducts() {
      this.retailerService.getApprovedProduct(this.rId)
        .subscribe((data: ProductForApproval[]) => {this.productsApproved = data });
  }
  getPendingProducts() {
      this.retailerService.getPendingProduct(this.rId)
        .subscribe((data: ProductForApproval[]) => {this.productsPending = data });
  }

}
