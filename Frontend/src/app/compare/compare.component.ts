import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../Service/customer.service';
import { EncrDecrService } from '../Service/encr-decr.service';
import { SessionService } from '../Services_X/session.service';

@Component({
  selector: 'compare',
  templateUrl: './compare.component.html',
  styleUrls: ['./compare.component.css']
})
export class CompareComponent implements OnInit {

  uId:number;
  compares:any[]
  status:boolean;
  constructor(private customerService:CustomerService,
              private sessionService:SessionService,
              private router:Router,
              private EncrDecr:EncrDecrService) { }

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
       this.customerService.getCompare(this.uId).subscribe(data=>{
        this.compares=data;
        console.log(data)

        if(data.length==0)
        this.status=true;

       })
       
     }
       else{
         this.router.navigate(['/login']);
       }
  }

  removeFromComp(comp){
    this.customerService.removeFromCompare(comp.compId).subscribe(data=>{
      this.compares=data;
      console.log(data)
      if(data.length==0)
        this.status=true;
    })
  }

}
