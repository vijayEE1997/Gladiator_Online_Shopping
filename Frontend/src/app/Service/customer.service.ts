import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { HttpClient, HttpHeaderResponse, HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private tempurl =  'http://localhost:8080/WingBuy/buy/';
  private url ='';

  constructor(private http : HttpClient) { }

  login(login : Login) :Observable<number>
  {
    console.log(login)
    this.url = this.tempurl;
    this.url += 'login';
    console.log(this.url)
    return  this.http.post<number>(this.url,login);
  }
}
