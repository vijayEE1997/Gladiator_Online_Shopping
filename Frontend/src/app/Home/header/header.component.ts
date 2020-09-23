import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'Aheader',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public active:boolean;
  public innerWidth:any;
  public searchButton:boolean;
  constructor(private router:Router) { 
  }

  ngOnInit(): void {
  }
  goToLogin(){
    this.router.navigate(['/login']);
  }
  searchButtonF(value:boolean){
      this.searchButton=value;
  }
}
