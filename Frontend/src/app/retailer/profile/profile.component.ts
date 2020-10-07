import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  addProduct:boolean=true;
  myProducts:boolean=false;
  myProfit:boolean=false;
  myAccount:boolean=false;

  constructor(private router:Router,
              private sessionService:SessionService
              ) { }

  ngOnInit(): void {

    this.sessionService.checkSession()

    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.router.navigate(['home']);
    }
    if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
    {
      this.router.navigate(['home']);
    }
  }
  addProductF(){
    this.myProducts=false;
    this.myAccount=false;
    this.myProfit=false;
    this.addProduct=true;
  }
  myProductsF(){
    this.myProducts=true;
    this.myAccount=false;
    this.myProfit=false;
    this.addProduct=false;
  }
  myProfitF(){
    this.myProducts=false;
    this.myAccount=false;
    this.myProfit=true;
    this.addProduct=false;
  }
  myAccountF(){
    this.myProducts=false;
    this.myAccount=true;
    this.myProfit=false;
    this.addProduct=false;
  }
}
