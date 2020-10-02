
import { Product } from './../DTO/Product';
import { HttpClient, HttpClientModule  } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { Retailer } from '../DTO/Retailer';
import { ProductForApproval } from '../DTO/ProductForApproval';

@Injectable({
  providedIn: 'root'
})
export class RetailerService {

  
  private baseurl =  'http://localhost:8080/WingBuy/Rbuy/';
  private url = '';
  constructor(private http : HttpClient) { }

  // login(login : Login) : Observable<number>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'retailerLogin';
  //   return this._http.post<number>(this._url,login);
  // }

  // addProduct(newProduct:Product,rId: string)
  // {
  //   this._url = this._tempurl;
  //   this._url += 'addProduct/' + rId;
  //   return this._http.post(this._url,newProduct);
  // }
  // getMyProduct(rId: string) : Observable<Product[]>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'getMyProduct/' + rId;
  //   return this._http.get<Product[]>(this._url);
  // }
  // getRetailerById(rId: string) : Observable<Retailer>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'getRetailerById/' + rId;
  //   return this._http.get<Retailer>(this._url);
  // }
  // updateProduct(updateProduct : Product, pId: string) : Observable<Product>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'updateProduct/' + pId;
  //   return this._http.put<Product>(this._url,updateProduct);
  // }
  // addNewRetailer(newRetailer:Retailer) : Observable<number>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'addNewRetailer';
  //   return this._http.post<number>(this._url,newRetailer);
  // }
  // showAllRetailers() : Observable<Retailer[]>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'showAllRetailers';
  //   return this._http.get<Retailer[]>(this._url);
  // }
  
    // backend me ni bna ye wala
  getRejectedProduct(rId: number) : Observable<ProductForApproval[]>
  {
    this.url = this.baseurl;
    this.url += 'rejected/' + rId;
    return this.http.get<ProductForApproval[]>(this.url);
  }
   // backend me ni bna ye wala
   getPendingProduct(rId:number) : Observable<ProductForApproval[]>
   {
     this.url = this.baseurl;
     this.url += 'pending/' + rId;
     return this.http.get<ProductForApproval[]>(this.url);
   }
    // backend me ni bna ye wala
  getApprovedProduct(rId: number) : Observable<ProductForApproval[]>
  {
    this.url = this.baseurl;
    this.url += 'approved/' + rId;
    return this.http.get<ProductForApproval[]>(this.url);
  }

}
