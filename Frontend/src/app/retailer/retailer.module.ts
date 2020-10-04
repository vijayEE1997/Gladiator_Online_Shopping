import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { AddProductComponent } from './add-product/add-product.component';
import { MyProductsComponent } from './my-products/my-products.component';



@NgModule({
  declarations: [ProfileComponent, AddProductComponent, MyProductsComponent],
  imports: [
    CommonModule
  ],
  exports:[
    ProfileComponent,AddProductComponent,MyProductsComponent
  ]
})
export class RetailerModule { }
