import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddRetailerComponent } from './add-retailer/add-retailer.component';
import { ProfileAdminComponent } from './profile-admin/profile-admin.component';
import { RequestsComponent } from './requests/requests.component';
import { ProductsComponent } from './products/products.component';



@NgModule({
  declarations: [AddRetailerComponent, ProfileAdminComponent, RequestsComponent, ProductsComponent],
  imports: [
    CommonModule
  ],
  exports:[
    AddRetailerComponent,
    ProfileAdminComponent
  ]
})
export class AdminModule { }
