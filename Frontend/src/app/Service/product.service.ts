import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../DTO/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

 
  private _tempurl=environment.BASE_URL+"/WingBuy/admin/";
  private _url = '';
  constructor(private _http : HttpClient) { }

  getSubCategoryByCategory(pCategory:string)
  {
    this._url = this._tempurl;
    this._url += 'getSubCatByCat/'+ pCategory;
    return this._http.get<string[]>(this._url);
  }
  getBrandByCategory(pCategory:string)
  {
    this._url = this._tempurl;
    this._url += 'getProductByBrand/'+ pCategory;
    return this._http.get<string[]>(this._url);
  }

  getProductById(id : number) : Observable<Product>
  {
    this._url = this._tempurl;
    this._url += 'getProductById/' + id;
    return this._http.get<Product>(this._url);
  }

  getProductBySubCategory(keyword: string) : Observable<Product[]>
  {
    this._url = this._tempurl;
    this._url += 'getProductBySubCategory/' + keyword;
    return this._http.get<Product[]>(this._url);
  }

  getProductByCategory(keyword: string) : Observable<Product[]>
  {
    this._url = this._tempurl;
    this._url += 'getProductBySearch/' + keyword;
    console.log(this._url);
    return this._http.get<Product[]>(this._url);
  }

  // sortProduct(by :string, order : number) : Observable<Product[]>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'sortProduct/'+by+'/'+order;
  //   return this._http.get<Product[]>(this._url);
  // }
  // filterProduct(by: string, s: number, e: number) : Observable<Product[]>
  // {
  //   this._url = this._tempurl;
  //   this._url += 'filterProduct/'+by+'/'+s+'/'+e; 
  //   return this._http.get<Product[]>(this._url);
  // }
}
