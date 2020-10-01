import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileUserComponent } from './profile-user/profile-user.component';
import { UserEditProfileComponent } from './user-edit-profile/user-edit-profile.component';
import { UserCartComponent } from './user-cart/user-cart.component';



@NgModule({
  declarations: [ProfileUserComponent, UserEditProfileComponent, UserCartComponent],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
