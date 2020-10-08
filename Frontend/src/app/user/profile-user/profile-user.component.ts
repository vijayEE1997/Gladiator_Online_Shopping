import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/DTO/User';
import { CustomerService } from 'src/app/Service/customer.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css']
})
export class ProfileUserComponent implements OnInit {

  uId:number;
  user:any;
  constructor(private customerService : CustomerService,
              private EncrDecr: EncrDecrService,
              private router:Router,
              private sessionService:SessionService) { }

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
       this.customerService.getUserById(this.uId).subscribe(data=>{
          this.user=data;
       })
       
     }
       else{
         this.router.navigate(['/login']);
       }

  }

}
