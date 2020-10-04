import { ProductForApproval } from './../../DTO/ProductForApproval';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerService } from 'src/app/Service/retailer.service';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  
  pCategories=[{"pCategory":{"Mobile":{"pSubCategory":{"Android":"","Keypad":""}}}},{"pCategory":"Electronics"},{"pCategory":"Appliances"}]
  pSubCategories=""
  addProduct:FormGroup
  constructor
  (
    private retailerService : RetailerService,
    private router : Router,
    private formBuilder: FormBuilder,
  ) { }
  
  ngOnInit(): void {

  }

}
