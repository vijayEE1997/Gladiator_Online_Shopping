import { AdminService } from './../Service/admin.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddRetailerComponent } from './add-retailer/add-retailer.component';
import { ProfileAdminComponent } from './profile-admin/profile-admin.component';
import { RequestsComponent } from './requests/requests.component';
import { ProductsComponent } from './products/products.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AddRetailerComponent, ProfileAdminComponent, RequestsComponent, ProductsComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports:[
    AddRetailerComponent,
    ProfileAdminComponent,
  ],
  providers:[AdminService]
})
export class AdminModule { }
