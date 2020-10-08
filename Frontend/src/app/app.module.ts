import { RetailerModule } from './retailer/retailer.module';
import { AdminModule } from './admin/admin.module';
import { AuthorizationModule } from './authorization/authorization.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Home/header/header.component';
import { FooterComponent } from './Home/footer/footer.component';
import { ContainerComponent } from './Home/container/container.component';
import { HomeComponent } from './Home/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from './Service/customer.service';
// import { UploadService } from './Services_X/upload.service'
import { ProductService } from './Service/product.service';
import { HttpClientModule } from '@angular/common/http';
import { PaymentComponent } from './payment/payment.component';
import { UserCartComponent } from './user/user-cart/user-cart.component';
import { UserWishlistComponent } from './user/user-wishlist/user-wishlist.component';
import { AllProductComponent } from './Products/all-product/all-product.component';
import { SingleProductComponent } from './Products/single-product/single-product.component';
import { SideHeaderComponent } from './Home/header/side-header/side-header.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { UploadService } from './Services_X/upload.service'
import { AuthService } from './Services_X/auth.service'
import { SessionService } from './Services_X/session.service';
import { ProfileUserComponent } from './user/profile-user/profile-user.component';
import { CompareComponent } from './compare/compare.component';
import { AboutComponent } from './about/about.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ContainerComponent,
    HomeComponent,
    PaymentComponent,
    UserCartComponent,
    UserWishlistComponent,
    AllProductComponent,
    SingleProductComponent,
    SideHeaderComponent,
    OrdersComponent,
    OrderDetailComponent,
    ProfileUserComponent,
    CompareComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AuthorizationModule,
    FormsModule,
    AdminModule,
    RetailerModule,
    HttpClientModule
  ],
  providers: [CustomerService,ProductService,UploadService,AuthService,SessionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
