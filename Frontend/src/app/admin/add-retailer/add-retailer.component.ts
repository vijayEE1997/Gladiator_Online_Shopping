import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Service/admin.service';

@Component({
  selector: 'add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.css']
})
export class AddRetailerComponent implements OnInit {
  // addRetailer:boolean=false;
  // removeRetailer:boolean=false;
  retailers:any[];

  constructor(private adminService:AdminService) {  }

ngOnInit(): void {
 this.adminService.getAllRetailers().subscribe(data => {
    this.retailers = data 
    console.log(this.retailers)
 });
}
  addRetailerF()
  {
    // this.removeRetailer=false;
    // this.addRetailer=!this.addRetailer
  }
  removeRetailerF(p:any)
  {
    // this.addRetailer=false;
    // this.removeRetailer=!this.removeRetailer
    this.adminService.deleteRetailer(p.rId).subscribe(data=>{
      this.retailers = this.retailers.filter(data=>{ data!==p })
    })
  }
}
