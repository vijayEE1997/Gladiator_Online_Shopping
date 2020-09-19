import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddRetailerComponent } from './add-retailer/add-retailer.component';
import { ProfileAdminComponent } from './profile-admin/profile-admin.component';



@NgModule({
  declarations: [AddRetailerComponent, ProfileAdminComponent],
  imports: [
    CommonModule
  ],
  exports:[
    AddRetailerComponent,
    ProfileAdminComponent
  ]
})
export class AdminModule { }
