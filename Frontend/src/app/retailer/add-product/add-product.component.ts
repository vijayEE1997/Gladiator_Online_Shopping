import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/DTO/Retailer';
import { RetailerService } from 'src/app/Service/retailer.service';
import { Product } from 'src/app/DTO/Product';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  rId : number;
  product = new ProductForApproval;
  retailer : Retailer;
  
  constructor
  (
    private retailerService : RetailerService,
    private router : Router
  ) { }
  
  ngOnInit(): void {
    // if(parseInt(sessionStorage.getItem('retailer'))>0)
    // {
    //   this.rId = parseInt(sessionStorage.getItem('retailer'));
    //   this.retailerService.getRetailerById(sessionStorage.getItem('retailer'))
    //   .subscribe(data=>{
    //     this.retailer = data;
    //   });
    // }
    // else
    // {
    //   alert("Retaier Not Logged In");
    //   this.router.navigate(['home']);
    // }
  }
  onAddProduct()
  {
    // this.retailerService.addProduct(this.product,this.rI
    // .subscrd.toString())ibe(data=>{
    //   alert(data);
    // })
  }

  prods:Product[]=[];
  showApprovedProducts(){
    // this.retailerService.getMyProduct(this.rId.toString())
    // .subscribe((data:Product[])=>{
    //   console.log(data);
    //   this.prods=data;
    // });
  }

}