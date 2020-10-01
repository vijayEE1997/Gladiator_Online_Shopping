import { ProductForApproval } from './../../DTO/ProductForApproval';
import { AdminService } from './../../Service/admin.service';
import { Component, OnInit } from '@angular/core';

import { Product } from 'src/app/DTO/Product';

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
desc:any;
descOpen:boolean=false;

products:Product[]=[];
constructor(private adminService:AdminService) {  }

ngOnInit(): void {
 this.adminService.getProducts().subscribe(data => {
    this.products = data 
 });

}

  viewDesc(desc:any)
  {
    this.desc=desc;
    this.descOpen=true;
  }
  closeDesc()
  {
    this.descOpen=false;
  }
}
