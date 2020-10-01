import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { Registration } from '../DTO/Registration';
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
    this.url = this.tempurl;
    this.url += 'userlogin';
    return  this.http.post<number>(this.url,login);
  }
  register(register:Registration)
  {
    console.log(register)
    this.url = this.tempurl;
    this.url += 'addNewUser';
    return  this.http.post<number>(this.url,register);
  }
}
