import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit(): void {
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
