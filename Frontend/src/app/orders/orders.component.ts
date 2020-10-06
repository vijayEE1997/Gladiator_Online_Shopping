import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from '../Services_X/session.service';

@Component({
  selector: 'orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  uId;
  status:boolean=false;
  orders:any[];
  constructor(private customerService:CustomerService,
              private EncrDecr:EncrDecrService,
              private router:Router,
              private sessionService:SessionService
              ) { }

  ngOnInit(): void { 

  this.sessionService.checkSession()
    
  if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
   {
     this.router.navigate(['/home']);
   }
   else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
   {
     this.router.navigate(['/home']);
   }
   else if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
   {      
      let encr = sessionStorage.getItem('user')
      this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
      this.customerService.getOrders(this.uId).subscribe(data=>{
      this.orders=data;
      console.log(data)
      
      //////CHECKING ORDERS ARE THERE OR NOT //////
      if(this.orders.length!=0)
      this.status=true
      //////CHECKING ORDERS ARE THERE OR NOT //////
      console.log(this.status)
    })
  }
  else{
    this.router.navigate(['/login']);
  }
  }

}
