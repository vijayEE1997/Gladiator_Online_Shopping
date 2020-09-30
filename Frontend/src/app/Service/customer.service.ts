import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { HttpClient, HttpHeaderResponse, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private _tempurl =  'http://localhost:3000/';
  private _url =      'http://localhost:3000/';

  constructor(private _http : HttpClient) { }

  login(login : Login) : Observable<number>
  {
    this._url = this._tempurl;
    this._url += 'login';
    return this._http.post<number>(this._url,login);
  }
}
