import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { AddProductComponent } from './add-product/add-product.component';
import { MyProductsComponent } from './my-products/my-products.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [ProfileComponent, AddProductComponent, MyProductsComponent],
  imports: [
    CommonModule,ReactiveFormsModule,FormsModule
  ],
  exports:[
    ProfileComponent,AddProductComponent,MyProductsComponent
  ]
})
export class RetailerModule { }
