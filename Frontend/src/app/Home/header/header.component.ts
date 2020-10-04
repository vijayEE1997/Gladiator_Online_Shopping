import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Login } from 'src/app/DTO/Login';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'Aheader',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public loginFlag:boolean;
  public active:boolean;
  public innerWidth:any;
  public searchButton:boolean;
  USER:string="Login";
  constructor(private router:Router,private encrdecr:EncrDecrService) { 
  }

  ngOnInit(): void {
    this.USERF()
  }

  
 USERF(){
  if(sessionStorage.getItem('user')!=null)
  {
    console.log(this.encrdecr.get('123456$#@$^@1ERF',sessionStorage.getItem('user')))
    this.USER=this.encrdecr.get('123456$#@$^@1ERF',sessionStorage.getItem('user'));
    
  }
  else
  {
    this.USER="Login";
  }
 }

  goToLogin(){
    this.router.navigate(['/login']);
  }
  searchButtonF(value:boolean){
      this.searchButton=value;
  }

  myCartF(){
    this.router.navigate(['/MyCart']);
  }

}
