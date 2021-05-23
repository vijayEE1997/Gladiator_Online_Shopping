 import { ProductForApproval } from './../DTO/ProductForApproval';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../DTO/Product';
import { RetailerSignUp } from '../DTO/RetailerSignUp'
import { Retailer } from '../DTO/Retailer';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  baseurl=environment.BASE_URL+"/WingBuy/admin/";
  url='';
  
  constructor(private http:HttpClient) { }
  
  login(login : Login) :Observable<number>
  {
    this.url = this.baseurl;
    this.url += 'adminlogin';
    return  this.http.post<number>(this.url,login);
  }
  
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
  approveProductCall(pfa:ProductForApproval){
    this.url=this.baseurl+'approveProduct/1/';
    return this.http.post<boolean>(this.url,pfa);
  }
  rejectProductCall(pfa:ProductForApproval){
    this.url=this.baseurl+'rejectProduct/1/';
    return this.http.post<boolean>(this.url,pfa);
  }

  addRetailerCall(retailer:RetailerSignUp){
    let newRetailer =new Retailer()
    newRetailer.rEmail=retailer.rEmail
    newRetailer.rName=retailer.rName
    newRetailer.rMobile=retailer.rMobile
    this.url=this.baseurl+'addRetailer/1/';
    return this.http.post<boolean>(this.url,newRetailer);
  }

  getAdminById(aId:number):Observable<any>{
    this.url=this.baseurl+'getAdmin/'+aId;
    return this.http.get<any>(this.url);
  }

}
