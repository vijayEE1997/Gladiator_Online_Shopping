import { User } from './../../DTO/User';
import { CustomerService } from 'src/app/Service/customer.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'profile-user',
  templateUrl: './profile-user.component.html',
  styleUrls: ['./profile-user.component.css']
})
export class ProfileUserComponent implements OnInit {

  User: User;
  uId: number;
  constructor(
    private customerService : CustomerService,
    private router : Router
  ) { }

  ngOnInit(): void 
  {
    if(sessionStorage.getItem('user')!="null")
    {
      this.uId = parseInt(sessionStorage.getItem('user'));
    this.customerService.getUserById(this.uId.toString())
    .subscribe(data=>
      {
        this.User = data;
      });
    }
    else
    {
      alert("User Not Logged In");
      this.router.navigate(['home']);
    }
    
  }

  onEditProfileClick()
  {
    sessionStorage.setItem('user-details',JSON.stringify(this.User));
    this.router.navigate(['user-edit']);
  }

}
