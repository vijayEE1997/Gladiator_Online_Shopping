import { CustomerService } from 'src/app/Service/customer.service';
import { User } from './../../DTO/User';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'user-edit-profile',
  templateUrl: './user-edit-profile.component.html',
  styleUrls: ['./user-edit-profile.component.css']
})
export class UserEditProfileComponent implements OnInit {

  updateUser : User;
  newUpdatedUser;
  oldUser : User;
  constructor
  (
    private customerService : CustomerService,
    private router : Router
  ) 
  {
    this.updateUser = new User();
  }

  ngOnInit(): void
  {
    if(sessionStorage.getItem('user')=="null")
    {
      alert("User Not Logged In");
      this.router.navigate(['home']);
    }
    else
    {
      this.oldUser = JSON.parse(sessionStorage.getItem('user-details'));
    }
  }

  onUpdateUserClick()
  {
    let uId = parseInt(sessionStorage.getItem('user'));
    this.updateUser.uId = uId;
    console.log(this.updateUser);
    this.customerService.updateUser(this.updateUser)
    .subscribe((data)=>
      {
        this.newUpdatedUser = data;
        if(this.newUpdatedUser==-100)
        {
          alert("Your Profile Not Updated");
        }
        else
        {
          alert("Profile Updated Successfull");
          this.router.navigate(['user-profile']);
        }
      })
  }

}
