import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import { Login } from 'src/app/DTO/Login';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { AuthService } from 'src/app/Services_X/auth.service';
import { SessionService } from 'src/app/Services_X/session.service';

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
  USER:any="Login";
  LogOut:boolean=false;
  CUSTOMER:boolean=false;
  ADMIN:boolean=false;
  RETAILER:boolean=false;
  constructor(private router:Router,
              private encrdecr:EncrDecrService,
              private authService:AuthService,
              private sessionService:SessionService) { 
  }

  ngOnInit(): void {
    this.sessionService.checkSession();
    // this.USERF()
    this.authService.getLoggedInName.subscribe(name =>{
      this.USER = name
      console.log(name)
      if(name!="Login")
      {
        this.LogOut=true;
      }
      else
      {
        this.LogOut=false;
      }

      if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
      {
        this.CUSTOMER=true;
        this.RETAILER=false;
        this.ADMIN=false;
      }
      else if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
      {
        this.RETAILER=true;
        this.ADMIN=false;
        this.CUSTOMER=false;
      }
      else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
      {
        this.ADMIN=true;
        this.RETAILER=false;
        this.CUSTOMER=false;
      }
      else
      {
        this.RETAILER=false;
        this.ADMIN=false;
        this.CUSTOMER=false;
      }

    });
  }

  
//  USERF(){
//   if(sessionStorage.getItem('user')!=null)
//   {
//     console.log(this.encrdecr.get('123456$#@$^@1ERF',sessionStorage.getItem('user')))
//     this.USER=this.encrdecr.get('123456$#@$^@1ERF',sessionStorage.getItem('user'));
    
//   }
//   else
//   {
//     this.USER="Login";
//   }
//  }
 
  goToLogin(){
    this.router.navigate(['/login']);
  }
  searchButtonF(value:boolean){
      this.searchButton=value;
  }

  myCartF(){
    this.router.navigate(['/MyCart']);
  }

  logout(){
    console.log("logout")
    sessionStorage.setItem('user',null);
    sessionStorage.setItem('admin',null);
    sessionStorage.setItem('retailer',null);
    this.authService.logout()
    this.router.navigate(['home']);
  }

}
