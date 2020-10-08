import { ProductForApproval } from './../../DTO/ProductForApproval';
import { AdminService } from './../../Service/admin.service';
import { Component, OnInit } from '@angular/core';

import { Product } from 'src/app/DTO/Product';
import { Router } from '@angular/router';

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
desc:any;
descOpen:boolean=false;
src:string;
products:Product[]=[];
constructor(private adminService:AdminService,
            private router:Router) {  }

ngOnInit(): void {
  if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
  {
    this.router.navigate(['home']);
  }
 else if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
  {
    this.router.navigate(['home']);
  }
else{
 this.adminService.getProducts().subscribe(data => {
    this.products = data 
 });
}
}

  viewDesc(p:Product)
  {
    this.desc=p.pDesc;
    this.descOpen=true;
    this.src=p.pImage;
  }
  closeDesc()
  {
    this.descOpen=false;
  }
}
