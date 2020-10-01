import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/DTO/Product';
import { AdminService } from 'src/app/Service/admin.service';

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
 this.adminService.getProducts()
  .subscribe((data: Product[]) => { console.log(data); this.products = data 
    console.log(this.products)
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
