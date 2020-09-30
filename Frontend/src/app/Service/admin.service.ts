import { ProductForApproval } from './../DTO/ProductForApproval';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseurl="http://localhost:8080/WingBuy/buy/";
  url='';
  
  constructor(private http:HttpClient) { }

  getProductForApproval(){
    this.url=this.baseurl+'getProductForApproval';
    return this.http.get<ProductForApproval[]>(this.url);
  }

}
