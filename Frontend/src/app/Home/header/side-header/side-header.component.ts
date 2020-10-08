import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/DTO/User';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'side-header',
  templateUrl: './side-header.component.html',
  styleUrls: ['./side-header.component.css']
})
export class SideHeaderComponent implements OnInit {

  uId:number;
  customer:User;
  loginFlag:boolean;
  constructor(private EncrDecr: EncrDecrService,
              private customerService:CustomerService,
              private router:Router,
              private sessionService:SessionService) { }

  ngOnInit(): void {

    this.sessionService.checkSession();

    let encr = sessionStorage.getItem('user')
    if (encr != null) {
      this.uId = parseInt(this.EncrDecr.get('123456$#@$^@1ERF', encr))
      this.customerService.getUserById(this.uId).subscribe(data=>{
          this.customer=data;
          this.loginFlag=true;
        }
      )
    }

  }
  logout(){
    sessionStorage.setItem('user',null);
    sessionStorage.setItem('admin',null);
    sessionStorage.setItem('retailer',null);
    this.router.navigate(['home']);
  }

}
