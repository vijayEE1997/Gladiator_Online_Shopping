import { ProductForApproval } from './../DTO/ProductForApproval';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../DTO/Product';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseurl="http://localhost:8080/WingBuy/buy/";
  url='';
  
  constructor(private http:HttpClient) { }
  
  getProductForApproval(){
    this.url=this.baseurl+'requests/1';
    return this.http.get<ProductForApproval[]>(this.url);
  }
  getProducts(){
    this.url=this.baseurl+'allProducts/1';
    return this.http.get<Product[]>(this.url);
  }
  getAllRetailers(){
    this.url=this.baseurl+'getAllRetailers';
    return this.http.get<any[]>(this.url);
  }
  deleteRetailer(rId:number){
    this.url=this.baseurl+'deleteRetailer/'+rId;
    return this.http.get<any[]>(this.url);
  }


}
