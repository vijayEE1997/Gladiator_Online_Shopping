import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Retailer } from 'src/app/DTO/Retailer';
import { RetailerService } from 'src/app/Service/retailer.service';

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
    if(parseInt(sessionStorage.getItem('retailer'))>0)
    {
      this.rId = parseInt(sessionStorage.getItem('retailer'));
      this.retailerService.getRetailerById(sessionStorage.getItem('retailer'))
      .subscribe(data=>{
        this.retailer = data;
      });
    }
    else
    {
      alert("Retaier Not Logged In");
     // this.router.navigate(['home']);
    }
  }
  onAddProduct()
  {
    this.retailerService.addProduct(this.product,this.rId.toString())
    .subscribe(data=>{
      alert(data);
    })
  }


}
