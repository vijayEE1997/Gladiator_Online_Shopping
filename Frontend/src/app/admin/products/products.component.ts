import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
desc:any;
descOpen:boolean=false;
products:any=[{"pid":"123",
               "rid":"235",
              "category":"Mobile",
              "subCategory":"Android",
              "brand":"Samsung",
              "model":"M31",
              "stock":"11",
              "price":"13000",
              "desc":"huhuh"},
              {"pid":"123",
              "rid":"235",
             "category":"Mobile",
             "subCategory":"Android",
             "brand":"Samsung",
             "model":"M31",
             "stock":"11",
             "price":"13000",
             "desc":"puuuh"}]
  constructor() { }

  ngOnInit(): void {
  }
  viewDesc(desc:any)
  {
    this.desc=desc;
    this.descOpen=true;
  }
  closeDesc()
  {
    this.descOpen=false;
  }
}
