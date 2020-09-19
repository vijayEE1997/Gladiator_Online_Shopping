import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {
  desc:any;
  descOpen:boolean=false;
products:any=[{"rqid":"123",
               "rid":"235",
              "category":"Mobile",
              "subCategory":"Android",
              "brand":"Samsung",
              "model":"M31",
              "stock":"11",
              "price":"13000",
              "desc":"huhuh",
              "status":"P"},
              {"rqid":"123",
              "rid":"235",
             "category":"Mobile",
             "subCategory":"Android",
             "brand":"Samsung",
             "model":"M31",
             "stock":"11",
             "price":"13000",
             "desc":"puuuh",
             "status":"P"}]

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
