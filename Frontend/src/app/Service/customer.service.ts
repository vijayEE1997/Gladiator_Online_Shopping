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
import { CartMyDTO } from '../DTO/CartMyDTO';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseurl =  'http://localhost:8080/WingBuy/admin/';
  private url ='';

  constructor(private http : HttpClient) { }

  login(login : Login) :Observable<number>
  {
    this.url = this.baseurl;
    this.url += 'userlogin';
    return  this.http.post<number>(this.url,login);
  }
  register(register:Registration)
  {
    console.log(register)
    this.url = this.baseurl;
    this.url += 'addNewUser';
    return  this.http.post<number>(this.url,register);
  }
  generateOTP(email:string) : Observable<number>
  {
    console.log(email)
    this.url = this.baseurl;
    this.url += 'generateOTP';
    return this.http.post<number>(this.url,email);
  }
  resetPassword(e:string,p:string): Observable<number>
  {
    let login=new Login() 
    login.email=e
    login.password=p
    this.url = this.baseurl;
    this.url += 'resetPassword';
    return this.http.post<number>(this.url,login);
  } 
   getMyCart(uId : number) : Observable<CartMyDTO[]>
   {
     console.log(uId)
     this.url = this.baseurl;
     this.url += 'getCart/' + uId;
     return this.http.get<CartMyDTO[]>(this.url);
   }
   getAddress(uId : number) : Observable<User>
   {
     console.log(uId)
     this.url = this.baseurl;
     this.url += 'getAddress/' + uId;
     return this.http.get<User>(this.url);
   }
   updateAddress(user:User) : Observable<User>
   {
     console.log(user)
     this.url = this.baseurl;
     this.url += 'updateAddress';
     return this.http.put<User>(this.url,user);
   }
  //  updateMyCart(cId:number, addOrMinus: number)
  //  {
  //   this.url = this.tempurl;
  //    this.url += 'updateMyCart/' + cId;
  //    if(addOrMinus==1)
  //    {
  //      this.url += '/' + 1;
  //      return this.http.get(this.url,{responseType:'text'});
  //    }
  //    else
  //    {
  //      this.url += '/' + 0;
  //      return this.http.get(this.url,{responseType:'text'});
  //    }
  //  }
//   deleteMyCart(cId: string)
//   {
//     this._url = this._tempurl;
//     this._url += 'deleteMyCart/' + cId;
//     return this._http.delete(this._url,{responseType:'text'});
//   }
  addToCart(uId: number, pId: number)
  {
    let cart=new Cart()
    cart.pId=pId;
    cart.uId=uId;
    this.url = this.baseurl;
    this.url += 'addToCart';
    return this.http.post(this.url,cart);
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
  

 addToWishList(uId: number, pId: number)
  {
    let wishlist=new Wishlist()
    wishlist.pId=pId;
    wishlist.uId=uId;
    this.url = this.baseurl;
    this.url += 'addToWishlist';
    return this.http.post(this.url,wishlist);
  }

  // // backend me ni bna ye wala
  // getCartTotalPrice(cId: string)
  // {
  //   this.url = this.tempurl;
  //   this.url += 'getCartTotalPrice/' + cId;
  //   return this.http.delete(this.url,{responseType:'text'});
  // }


}
