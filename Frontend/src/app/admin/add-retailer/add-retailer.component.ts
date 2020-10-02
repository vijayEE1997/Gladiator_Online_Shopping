import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.css']
})
export class AddRetailerComponent implements OnInit {
  // addRetailer:boolean=false;
  // removeRetailer:boolean=false;
  retailers:any[];
  addRetailerForm:FormGroup;
  constructor(private adminService:AdminService, 
              private formBuilder: FormBuilder,
              private router:Router,
              private EncrDecr: EncrDecrService) {  }

ngOnInit(): void {
 this.adminService.getAllRetailers().subscribe(data => {
    this.retailers = data 
    console.log(this.retailers)
 });
 this.addRetailerForm = this.formBuilder.group({
  rEmail: ['', Validators.required],
  rName: ['', Validators.required],
  rMobile: ['', Validators.required],
});
}
  addRetailerF()
  {
    // this.removeRetailer=false;
    // this.addRetailer=!this.addRetailer
    this.adminService.addRetailerCall(this.addRetailerForm.value).subscribe(data=>{
      this.adminService.getAllRetailers().subscribe(data => {
        this.retailers = data 
        console.log(this.retailers)
     });
    });

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
