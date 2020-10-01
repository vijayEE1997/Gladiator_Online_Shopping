import { ProductForApproval } from '../../DTO/ProductForApproval';
import { AdminService } from './../../Service/admin.service';
import { RetailerService } from './../../Service/retailer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  desc:any;
  descOpen:boolean=false;
  productsforApproval:ProductForApproval[]=[];

  constructor(private adminService:AdminService) {  }

  ngOnInit(): void {
   this.adminService.getProductForApproval().subscribe(data => { 
      this.productsforApproval = data 
    });

  }

  //for description
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
