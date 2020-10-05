import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerService } from 'src/app/Service/retailer.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UploadService } from 'src/app/Services_X/upload.service';
import { Product } from 'src/app/DTO/Product';
import { EncrDecrService } from 'src/app/Service/encr-decr.service';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  
  rId=-1;
  pCategories=["Mobile","Electronics","Appliances"]
  product=new ProductForApproval;
  addProductForm:FormGroup

  selectedFiles1: FileList;
  selectedFiles2: FileList;

  pImage:string="";
  uploadF1:boolean;
  uploadF2:boolean;
  constructor
  (
    private retailerService : RetailerService,
    private router : Router,
    private formBuilder: FormBuilder,
    private uploadService: UploadService,
    private EncrDecr: EncrDecrService
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

    this.rId=parseInt(this.EncrDecr.get('123456$#@$^@1ERF',sessionStorage.getItem('retailer')))

    this.addProductForm=this.formBuilder.group({
      // pCategory:['',Validators.required],
      pSubCategory:['',Validators.required],
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
   if(this.uploadF1 && this.uploadF2)
    {
      this.pImage="https://wingbuy.s3.ap-south-1.amazonaws.com/Product/"+(<HTMLInputElement>(document.getElementById('#'))).value+"/"+this.addProductForm.controls.pBrand.value+"/"+this.addProductForm.controls.pName.value
      this.product.pCategory=(<HTMLInputElement>(document.getElementById('#'))).value
      this.product.pSubCategory=this.addProductForm.controls.pSubCategory.value
      this.product.pBrand=this.addProductForm.controls.pBrand.value
      this.product.pName=this.addProductForm.controls.pName.value
      this.product.pPrice=this.addProductForm.controls.pPrice.value
      this.product.pDesc=this.addProductForm.controls.pDesc.value
      this.product.pImage=this.pImage
      this.product.pStock=this.addProductForm.controls.pStock.value
      console.log(this.product)
      this.retailerService.addProduct(this.product,this.rId).subscribe(data=>{
        if(data)
        alert("added")
        else
        alert("retry")
      })
    }
    else{
      alert("Upload Both Images")
    }
  }

  upload1() {
    const file = this.selectedFiles1.item(0);
    this.uploadF1=true;
    this.uploadService.uploadFile(file,(<HTMLInputElement>(document.getElementById('#'))).value,this.addProductForm.controls.pBrand.value,this.addProductForm.controls.pName.value+"_1")
    }
    
    selectFile1(event) {
    this.selectedFiles1 = event.target.files;
    }
    upload2() {
      const file = this.selectedFiles2.item(0);
      this.uploadF2=true;
      this.uploadService.uploadFile(file,(<HTMLInputElement>(document.getElementById('#'))).value,this.addProductForm.controls.pBrand.value,this.addProductForm.controls.pName.value+"_2");
      }
      
      selectFile2(event) {
      this.selectedFiles2 = event.target.files;
      }

}
