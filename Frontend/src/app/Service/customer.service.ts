import { Wishlist } from './../DTO/Wishlist';
import { PlacedOrder } from './../DTO/PlacedOrder';
import { ForgotPassword } from './../DTO/ForgotPassword';
import { User } from './../DTO/User';
import { Cart } from './../DTO/Cart';
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
  generateOTP() : Observable<number>
  {
    this.url = this.tempurl;
    this.url += 'generateOTP';
    return this.http.get<number>(this.url);
  }
  forgotPassword(forgotPassword : ForgotPassword)
  {
    this.url = this.tempurl;
    this.url += 'forgotPassword';
    return this.http.post(this.url,forgotPassword,{responseType:'text'});
  } 
   getMyCart(uId : string) : Observable<Cart[]>
   {
     this.url = this.tempurl;
     this.url += 'getMyCart/' + uId;
     return this.http.get<Cart[]>(this.url);
   }
//   addNewUser(newUser:User)
//   {
//     this.url = this._tempurl;
//     this.url += 'addNewUser';
//     return this.http.post(this.url,newUser);
//   }
//   getUserById(uId : string) : Observable<User>
//   {
//     this.url = this._tempurl;
//     this.url += 'getUserById/' + uId;
//     return this._http.get<User>(this._url);
//   }
//   updateUser(updateUser : User) : Observable<User>
//   {
//     this._url = this._tempurl;
//     this._url += 'updateUser';
//     return this._http.put<User>(this._url,updateUser);
//   }
//   getMyPlacedOrders(uId: string) : Observable<PlacedOrder[]>
//   {
//     this._url = this._tempurl;
//     this._url += 'getMyPlacedOrders/' + uId;
//     return this._http.get<PlacedOrder[]>(this._url);
//   }
//   updateMyCart(cId: string, addOrMinus: string)
//   {
//     this._url = this._tempurl;
//     this._url += 'updateMyCart/' + cId;
//     if(addOrMinus==='1')
//     {
//       this._url += '/' + '1';
//       return this._http.get(this._url,{responseType:'text'});
//     }
//     else
//     {
//       this._url += '/' + '0';
//       return this._http.get(this._url,{responseType:'text'});
//     }
//   }
//   deleteMyCart(cId: string)
//   {
//     this._url = this._tempurl;
//     this._url += 'deleteMyCart/' + cId;
//     return this._http.delete(this._url,{responseType:'text'});
//   }
//   addToMyCart(uId: string, pId: string)
//   {
//     this._url = this._tempurl;
//     this._url += 'addToMyCart/' + uId + '/' + pId;
//     return this._http.get(this._url,{responseType:'text'});
//   }
//   placeOrder(cart:Cart[],type:string)
//   {
//     this._url = this._tempurl;
//     this._url += 'placeOrder' + '/' + type;
//     return this._http.post(this._url,cart,{responseType:'text'});
//   }
//   getMyWishlist(uId : string) : Observable<Wishlist[]> 
//   {
//     this._url = this._tempurl;
//     this._url += 'getMyWishlist/' + uId;
//     return this._http.get<Wishlist[]>(this._url);
//   }
  

// deleteMyWishlist(cId: string)
//   {
//     this._url = this._tempurl;
//     this._url += 'deleteMyWishlist/' + cId;
//     return this._http.delete(this._url,{responseType:'text'});
//   }
  

//  addToMyWishlist(uId: string, pId: string)
//   {
//     this._url = this._tempurl;
//     this.url += 'addToMyWishlist/' + uId + '/' + pId;
//     return this.http.get(this._url,{responseType:'text'});
//   }

  // backend me ni bna ye wala
  getCartTotalPrice(cId: string)
  {
    this.url = this.tempurl;
    this.url += 'getCartTotalPrice/' + cId;
    return this.http.delete(this.url,{responseType:'text'});
  }


}
