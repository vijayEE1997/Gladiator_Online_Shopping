import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

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
              private router:Router
              ) { }

  ngOnInit(): void { 
  let encr = sessionStorage.getItem('user')
  if (encr != null) {
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
    alert("login kro")
    this.router.navigate(['home']);
  }
  }

}
