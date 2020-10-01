import { Wishlist } from './../DTO/Wishlist';
import { PlacedOrder } from './../DTO/PlacedOrder';
import { ForgotPassword } from './../DTO/ForgotPassword';
import { User } from './../DTO/User';
import { Cart } from './../DTO/Cart';
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
  generateOTP() : Observable<number>
  {
    this._url = this._tempurl;
    this._url += 'generateOTP';
    return this._http.get<number>(this._url);
  }
  forgotPassword(forgotPassword : ForgotPassword)
  {
    this._url = this._tempurl;
    this._url += 'forgotPassword';
    return this._http.post(this._url,forgotPassword,{responseType:'text'});
  } 
  getMyCart(uId : string) : Observable<Cart[]>
  {
    this._url = this._tempurl;
    this._url += 'getMyCart/' + uId;
    return this._http.get<Cart[]>(this._url);
  }
  addNewUser(newUser:User)
  {
    this._url = this._tempurl;
    this._url += 'addNewUser';
    return this._http.post(this._url,newUser);
  }
  getUserById(uId : string) : Observable<User>
  {
    this._url = this._tempurl;
    this._url += 'getUserById/' + uId;
    return this._http.get<User>(this._url);
  }
  updateUser(updateUser : User) : Observable<User>
  {
    this._url = this._tempurl;
    this._url += 'updateUser';
    return this._http.put<User>(this._url,updateUser);
  }
  getMyPlacedOrders(uId: string) : Observable<PlacedOrder[]>
  {
    this._url = this._tempurl;
    this._url += 'getMyPlacedOrders/' + uId;
    return this._http.get<PlacedOrder[]>(this._url);
  }
  updateMyCart(cId: string, addOrMinus: string)
  {
    this._url = this._tempurl;
    this._url += 'updateMyCart/' + cId;
    if(addOrMinus==='1')
    {
      this._url += '/' + '1';
      return this._http.get(this._url,{responseType:'text'});
    }
    else
    {
      this._url += '/' + '0';
      return this._http.get(this._url,{responseType:'text'});
    }
  }
  deleteMyCart(cId: string)
  {
    this._url = this._tempurl;
    this._url += 'deleteMyCart/' + cId;
    return this._http.delete(this._url,{responseType:'text'});
  }
  addToMyCart(uId: string, pId: string)
  {
    this._url = this._tempurl;
    this._url += 'addToMyCart/' + uId + '/' + pId;
    return this._http.get(this._url,{responseType:'text'});
  }
  placeOrder(cart:Cart[],type:string)
  {
    this._url = this._tempurl;
    this._url += 'placeOrder' + '/' + type;
    return this._http.post(this._url,cart,{responseType:'text'});
  }
  getMyWishlist(uId : string) : Observable<Wishlist[]> 
  {
    this._url = this._tempurl;
    this._url += 'getMyWishlist/' + uId;
    return this._http.get<Wishlist[]>(this._url);
  }
  

deleteMyWishlist(cId: string)
  {
    this._url = this._tempurl;
    this._url += 'deleteMyWishlist/' + cId;
    return this._http.delete(this._url,{responseType:'text'});
  }
  

 addToMyWishlist(uId: string, pId: string)
  {
    this._url = this._tempurl;
    this._url += 'addToMyWishlist/' + uId + '/' + pId;
    return this._http.get(this._url,{responseType:'text'});
  }

  // backend me ni bna ye wala
  getCartTotalPrice(cId: string)
  {
    this._url = this._tempurl;
    this._url += 'getCartTotalPrice/' + cId;
    return this._http.delete(this._url,{responseType:'text'});
  }


}
