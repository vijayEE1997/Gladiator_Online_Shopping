import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.css']
})
export class AddRetailerComponent implements OnInit {
  addRetailer:boolean=false;
  removeRetailer:boolean=false;
  constructor() { }

  ngOnInit(): void {
  }
  addRetailerF()
  {
    this.removeRetailer=false;
    this.addRetailer=!this.addRetailer
  }
  removeRetailerF()
  {
    this.addRetailer=false;
    this.removeRetailer=!this.removeRetailer
  }
}
