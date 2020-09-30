import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../DTO/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

 
  private _tempurl =  'http://localhost:8090/';
  private _url =      'http://localhost:8090/';
  constructor(private _http : HttpClient) { }


  getProductById(id : number) : Observable<Product>
  {
    this._url = this._tempurl;
    this._url += 'getProductById/' + id;
    return this._http.get<Product>(this._url);
  }

  getProductBySearch(keyword: string) : Observable<Product[]>
  {
    this._url = this._tempurl;
    this._url += 'getProductBySearch/' + keyword;
    return this._http.get<Product[]>(this._url);
  }
  sortProduct(by :string, order : number) : Observable<Product[]>
  {
    this._url = this._tempurl;
    this._url += 'sortProduct/'+by+'/'+order;
    return this._http.get<Product[]>(this._url);
  }
  filterProduct(by: string, s: number, e: number) : Observable<Product[]>
  {
    this._url = this._tempurl;
    this._url += 'filterProduct/'+by+'/'+s+'/'+e; 
    return this._http.get<Product[]>(this._url);
  }
}
