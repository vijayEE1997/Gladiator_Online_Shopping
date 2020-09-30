import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
c:number=1; 
i:number=0;
products:any=[{"category":"Mobiles","subCategory":"Android","brand":"Samsung","Name":"M01"},
              {"category":"Mobiles","subCategory":"Android","brand":"Samsung","Name":"M11"},
              {"category":"Mobiles","subCategory":"Android","brand":"Samsung","Name":"M21"},
              {"category":"Mobiles","subCategory":"Android","brand":"Samsung","Name":"M31"}];
src:string="../../../assets/Images/Products/"+this.products[0].category+"/"+this.products[0].subCategory+"/"+this.products[0].brand+"/"+this.products[0].Name+"_image_01.jpeg"; 
  constructor() { }

  ngOnInit(): void {
  }
  call(){
      if(this.c%2!=0)
      this.src="../../../assets/Images/Products/"+this.products[this.i].category+"/"+this.products[this.i].subCategory+"/"+this.products[this.i].brand+"/"+this.products[this.i].Name+"_image_01.jpeg";
      else{
        this.src="../../../assets/Images/Products/"+this.products[this.i].category+"/"+this.products[this.i].subCategory+"/"+this.products[this.i].brand+"/"+this.products[this.i].Name+"_image_02.jpeg";
        this.i+=1;
      }
      this.c+=1;
       }
}
