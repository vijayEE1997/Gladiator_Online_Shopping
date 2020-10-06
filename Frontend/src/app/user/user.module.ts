import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileUserComponent } from './profile-user/profile-user.component';
import { UserEditProfileComponent } from './user-edit-profile/user-edit-profile.component';
import { UserCartComponent } from './user-cart/user-cart.component';
import { CartComponent } from './cart/cart.component';
import { UserWishlistComponent } from './user-wishlist/user-wishlist.component';



@NgModule({
  declarations: [ProfileUserComponent, UserEditProfileComponent, UserCartComponent, CartComponent, UserWishlistComponent],
  imports: [
    CommonModule
  ]
})
export class UserModule { }
