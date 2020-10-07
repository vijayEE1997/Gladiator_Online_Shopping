import { ProfileComponent } from './retailer/profile/profile.component';
import { ProfileAdminComponent } from './admin/profile-admin/profile-admin.component';
import { ForgotPasswordComponent } from './authorization/forgot-password/forgot-password.component';
import { RegisterComponent } from './authorization/register/register.component';
import { HomeComponent } from './Home/home/home.component';
import { LoginComponent } from './authorization/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllProductComponent } from './Products/all-product/all-product.component';
import { SingleProductComponent } from './Products/single-product/single-product.component';
import { UserCartComponent } from './user/user-cart/user-cart.component';
import { PaymentComponent } from './payment/payment.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { UserWishlistComponent } from './user/user-wishlist/user-wishlist.component';
import { CompareComponent } from './compare/compare.component';

const routes: Routes = [
  {path : '', redirectTo : '/home', pathMatch: 'full'},
  {path : 'home', component : HomeComponent},
  {path : 'login', component : LoginComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'forgotpassword', component : ForgotPasswordComponent},
  {path : 'profile-admin', component : ProfileAdminComponent},
  {path : 'profile-retailer', component : ProfileComponent},
  {path : 'allProducts/:keyword', component : AllProductComponent },
  {path : 'product/:id', component : SingleProductComponent },
  {path : 'MyCart', component : UserCartComponent },
  {path : 'MyWishlist', component : UserWishlistComponent },
  {path : 'payment', component : PaymentComponent },
  {path : 'orders', component : OrdersComponent },
  {path : 'order/:oId', component : OrderDetailComponent },
  {path : 'MyCompare', component : CompareComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
