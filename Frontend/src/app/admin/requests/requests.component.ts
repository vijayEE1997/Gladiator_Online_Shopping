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
  desc:string;
  request:ProductForApproval;
  descOpen:boolean=false;
  productsforApproval:ProductForApproval[]=[];

  constructor(private adminService:AdminService) {  }

  ngOnInit(): void {
   this.adminService.getProductForApproval().subscribe(data => { 
      this.productsforApproval = data 
    });

  }

  //for description
  viewDesc(productforapproval:ProductForApproval)
  {
    this.desc=productforapproval.pDesc;
    this.request=productforapproval;
    this.descOpen=true;
  }

  //For Approval
  approveProductF(){
    this.adminService.approveProductCall(this.request).subscribe(data => { 
      if(data)
      this.productsforApproval = this.productsforApproval.filter(p=>p.pReqId!=this.request.pReqId)
    });
  }

  //For Rejection
  rejectProductF(){
    this.adminService.rejectProductCall(this.request).subscribe(data => { 
      if(data)
      this.productsforApproval = this.productsforApproval.filter(p=>p.pReqId!=this.request.pReqId)
    });
  }

  closeDesc()
  {
    this.descOpen=false;
  }
}
