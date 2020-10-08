import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Service/admin.service';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';
import { SessionService } from 'src/app/Services_X/session.service';

@Component({
  selector: 'add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.css']
})
export class AddRetailerComponent implements OnInit {
  retailers:any[];
  addRetailerForm:FormGroup;
  already:boolean;
  constructor(private adminService:AdminService, 
              private formBuilder: FormBuilder,
              private router:Router,
              private EncrDecr: EncrDecrService,
              private sessionService:SessionService) {  }

ngOnInit(): void {
  if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
  {
    this.router.navigate(['home']);
  }
 else if(sessionStorage.getItem('retailer')!="null" && sessionStorage.getItem('retailer')!=null)
  {
    this.router.navigate(['home']);
  }
else{
  this.GETALL();
  this.addRetailerForm = this.formBuilder.group({
   rEmail: ['',[ Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
   rName: ['', Validators.required],
   rMobile: ['', [Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
 });
}
}
//////GETING DATA//////////
GETALL(){
  this.adminService.getAllRetailers().subscribe(data => {
    this.retailers = data 
    console.log(this.retailers)
 });
}
//////GETING DATA//////////
  addRetailerF()
  {
    this.adminService.addRetailerCall(this.addRetailerForm.value).subscribe(data=>{
      if(!data)
      this.already=true;
      this.GETALL()
    });

  }
  removeRetailerF(p:any)
  {
    this.adminService.deleteRetailer(p.rId).subscribe(data=>{
      // this.retailers = this.retailers.filter(data=>{ data!==p })
      this.GETALL()
    })
  }
}
