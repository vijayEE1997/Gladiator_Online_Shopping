import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'profile-admin',
  templateUrl: './profile-admin.component.html',
  styleUrls: ['./profile-admin.component.css']
})
export class ProfileAdminComponent implements OnInit {
  products:boolean=false;
  requests:boolean=false;
  retailers:boolean=true;

  constructor() { }

  ngOnInit(): void {
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
