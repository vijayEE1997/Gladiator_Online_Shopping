import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { OrderDetailDTO } from '../DTO/OrderDetailDTO';
import { CustomerService } from '../Service/customer.service';
import { EncrDecrService } from '../Service/encr-decr.service';
import { SessionService } from '../Services_X/session.service';

@Component({
  selector: 'order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  uId;
  orderds: OrderDetailDTO[];
  constructor(private customerService: CustomerService,
    private EncrDecr: EncrDecrService,
    private route: ActivatedRoute,
    private sessionService:SessionService,
    private router: Router
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
        if (encr != null) {
        this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
        this.route.paramMap.subscribe((params: ParamMap) => {
        let id = params.get('oId');
        console.log(id)
        this.customerService.getOrderDetailById(parseInt(id))
          .subscribe((data) => {  this.orderds = data ;console.log(this.orderds);
          });
      });
    }
    else {
      this.router.navigate(['/login']);
    }
  }
}
}
