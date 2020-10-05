import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerService } from 'src/app/Service/retailer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  
  pCategories=[{"pCategory":{"Mobile":{"pSubCategory":{"Android":"","Keypad":""}}}},{"pCategory":"Electronics"},{"pCategory":"Appliances"}]
  pSubCategories=""

  addProductForm:FormGroup
  constructor
  (
    private retailerService : RetailerService,
    private router : Router,
    private formBuilder: FormBuilder,
  ) { }
  
  ngOnInit(): void {
    if(sessionStorage.getItem('user')!="null" && sessionStorage.getItem('user')!=null)
    {
      this.router.navigate(['home']);
    }
   else if(sessionStorage.getItem('admin')!="null" && sessionStorage.getItem('admin')!=null)
    {
      this.router.navigate(['home']);
    }
   else{
    this.addProductForm=this.formBuilder.group({
      pCategory:['',Validators.required],
      subCategory:['',Validators.required],
      pBrand:['',Validators.required],
      pName:['',Validators.required],
      pPrice:['',Validators.required],
      pDesc:['',Validators.required],
      pImage1:['',Validators.required],
      pImage2:['',Validators.required],
      pStock:['',Validators.required]
    })
  }
  }

  addPF(){
    alert(this.addProductForm.controls.pBrand.value)
    console.log(this.addProductForm.controls.pBrand.value)
  }
}
