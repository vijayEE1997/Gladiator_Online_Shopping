import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { RetailerService } from 'src/app/Service/retailer.service';
import { Retailer } from '../../DTO/Retailer'

@Component({
  selector: 'myaccount',
  templateUrl: './myaccount.component.html',
  styleUrls: ['./myaccount.component.css']
})
export class MyaccountComponent implements OnInit {


  rId:number;
  retailer:Retailer;
  profit:any[];

  constructor(private retailerService: RetailerService,
              private router: Router,
              private EncrDecr:EncrDecrService) { }

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
     this.rId=parseInt(this.EncrDecr.get('123456$#@$^@1ERF',sessionStorage.getItem('retailer')))

    this.retailerService.getRetailerById(this.rId).subscribe(data=>{
      this.retailer=data;
      console.log(data);
      // this.retailerService.getProfit(this.rId).subscribe(data=>{
      //   this.profit=data;
      // })

    })

   }
  }

}
