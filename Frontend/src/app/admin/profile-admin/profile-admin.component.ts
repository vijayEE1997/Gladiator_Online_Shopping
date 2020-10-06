import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'profile-admin',
  templateUrl: './profile-admin.component.html',
  styleUrls: ['./profile-admin.component.css']
})
export class ProfileAdminComponent implements OnInit {
  products:boolean=false;
  requests:boolean=false;
  retailers:boolean=true;

  constructor(private router:Router,
              private sessionService:SessionService,
              ) { }

  ngOnInit(): void {

    this.sessionService.checkSession()
    
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.router.navigate(['home']);
    }
   else if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
    {
      this.router.navigate(['home']);
    }
  }

  productsF(){
    this.requests=false;
    this.retailers=false;
    this.products=true;
  }
  requestsF(){
    this.products=false;
    this.retailers=false;
    this.requests=true;
  }
  retailersF(){
    this.products=false;
    this.requests=false;
    this.retailers=true;
  }
}
