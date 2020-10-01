import { ProductForApproval } from './../../DTO/ProductForApproval';
import { AdminService } from './../../Service/admin.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/DTO/Product';

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
desc:any;
descOpen:boolean=false;
products:any=[{"pid":"123",
               "rid":"235",
              "category":"Mobile",
              "subCategory":"Android",
              "brand":"Samsung",
              "model":"M31",
              "stock":"11",
              "price":"13000",
              "desc":"huhuh"},
              {"pid":"123",
              "rid":"235",
             "category":"Mobile",
             "subCategory":"Android",
             "brand":"Samsung",
             "model":"M31",
             "stock":"11",
             "price":"13000",
             "desc":"puuuh"}]
  constructor(private adminService:AdminService, private router : Router) { }

  prodsForApproval:ProductForApproval[]=[];
  prods:Product[]=[];
  
  ngOnInit(): void {
    this.adminService.getProductForApproval()
    .subscribe((data: ProductForApproval[]) => { console.log(data); this.prodsForApproval = data ;
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
