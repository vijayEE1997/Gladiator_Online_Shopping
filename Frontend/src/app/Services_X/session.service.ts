import { Injectable } from '@angular/core';
import { Retailer } from '../DTO/Retailer';
import { User } from '../DTO/User';
import { Admin } from '../DTO/Admin';
import { AdminService } from '../Service/admin.service';
import { CustomerService } from '../Service/customer.service';
import { EncrDecrService } from '../Service/encr-decr.service';
import { RetailerService } from '../Service/retailer.service';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  static logger:any;
  constructor(private customerService:CustomerService,
              private adminService:AdminService,
              private retailerService:RetailerService,
              private EncrDecr:EncrDecrService,
              private router:Router,
              private authService:AuthService) { }

  checkSession(){
   if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',sessionStorage.getItem('user'))
      console.log(decr)
      this.customerService.getUserById(parseInt(decr)).subscribe(data=>{
        console.log(data)
        SessionService.logger=data
        this.authService.login(data.uName)
        console.log("session-user")
      })
    }
   else if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
    {
      let retailer = new Retailer()
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',sessionStorage.getItem('retailer'))
      this.retailerService.getRetailerById(parseInt(decr)).subscribe(data=>{
        retailer=data;
        SessionService.logger=data
        this.authService.login(retailer.rName)
        console.log("session-retailer")
      })
    }
    else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
    {
      let admin = new Admin()
      let decr=this.EncrDecr.get('123456$#@$^@1ERF',sessionStorage.getItem('admin'))
      this.adminService.getAdminById(parseInt(decr)).subscribe(data=>{
        admin=data;
        console.log(admin)
        SessionService.logger=data
        this.authService.login(admin.aName)
        console.log("session-admin")
      })
    }
    else{
      this.authService.login("Login")
    }
  }

  getLogger():any{
    return SessionService.logger
  }

}
