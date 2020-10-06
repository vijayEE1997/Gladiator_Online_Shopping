import { ProductForApproval } from '../../DTO/ProductForApproval';
import { AdminService } from './../../Service/admin.service';
import { RetailerService } from './../../Service/retailer.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  desc:string;
  src="";
  request:ProductForApproval;
  descOpen:boolean=false;
  productsforApproval:ProductForApproval[]=[];

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
   this.adminService.getProductForApproval().subscribe(data => { 
      this.productsforApproval = data 
    });
  }
  }

  //for description
  viewDesc(productforapproval:ProductForApproval)
  {
    this.desc=productforapproval.pDesc;
    this.request=productforapproval;
    this.descOpen=true;
    this.src=productforapproval.pImage;
  }

  //For Approval
  approveProductF(){
    this.adminService.approveProductCall(this.request).subscribe(data => { 
      if(data)
      {
        this.productsforApproval = this.productsforApproval.filter(p=>p.pReqId!=this.request.pReqId)
        this.descOpen=false;
      }
    });
  }

  //For Rejection
  rejectProductF(){
    this.adminService.rejectProductCall(this.request).subscribe(data => { 
      if(data)
      {
        this.productsforApproval = this.productsforApproval.filter(p=>p.pReqId!=this.request.pReqId)
        this.descOpen=false;
      }
    });
  }

  closeDesc()
  {
    this.descOpen=false;
  }
}
