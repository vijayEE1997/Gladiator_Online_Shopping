import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import { AddProductComponent } from './add-product/add-product.component';



@NgModule({
  declarations: [ProfileComponent, AddProductComponent],
  imports: [
    CommonModule
  ],
  exports:[
    ProfileComponent
  ]
})
export class RetailerModule { }
