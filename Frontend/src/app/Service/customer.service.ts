import { Wishlist } from './../DTO/Wishlist';
import { PlacedOrder } from './../DTO/PlacedOrder';
import { ForgotPassword } from './../DTO/ForgotPassword';
import { User } from './../DTO/User';
import { WishMyDTO } from './../DTO/WishMyDTO';
import { Payment } from './../DTO/Payment';
import { OrderDetailDTO } from './../DTO/OrderDetailDTO';
import { Cart } from './../DTO/Cart';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../DTO/Login';
import { Registration } from '../DTO/Registration';
import { HttpClient, HttpHeaderResponse, HttpErrorResponse } from '@angular/common/http';
import { CartMyDTO } from '../DTO/CartMyDTO';
import { PaymentComponent } from '../payment/payment.component';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseurl=environment.BASE_URL+"/WingBuy/admin/";
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
  getUserById(uId:number):Observable<User>{
    this.url=this.baseurl;
    this.url+='getUserById/'+uId
    return this.http.get<User>(this.url)
  }
  generateOTP(email:string) : Observable<number>
  {
    console.log(email)
    this.url = this.baseurl;
    this.url += 'generateOTP';
    return this.http.post<number>(this.url,email);
  }
  generateOTPById(uId:number) : Observable<number>
  {
    console.log(uId)
    this.url = this.baseurl;
    this.url += 'generateOTPById';
    return this.http.post<number>(this.url,uId);
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
   makePayment(payType:string,uId:number): Observable<number>{
     let payment=new Payment()
     payment.payType=payType;
     payment.uId=uId;
     console.log(payment)
     this.url = this.baseurl;
     this.url += 'makePayment';
     return this.http.post<number>(this.url,payment);
   }

   getOrders(uId:number):Observable<any[]>{
    this.url=this.baseurl;
    this.url+='getOrders/'+uId;
   return this.http.get<any[]>(this.url)
  }

  getOrderDetailById(oId:number):Observable<OrderDetailDTO[]>
  {
    this.url=this.baseurl;
    this.url+='getOrderDetails/'+oId;
    return this.http.get<OrderDetailDTO[]>(this.url);
  }
 
  addToCart(uId: number, pId: number)
  {
    let cart=new Cart()
    cart.pId=pId;
    cart.uId=uId;
    this.url = this.baseurl;
    this.url += 'addToCart';
    return this.http.post(this.url,cart);
  }

  addToCompare(uId: number, pId: number)
  {
    this.url = this.baseurl;
    this.url += 'addToCompare/'+uId+"/"+pId;
    return this.http.get(this.url);
  }

  deleteFromCart(cId:number){
    this.url = this.baseurl;
    this.url += 'deleteFromCart/'+cId;
    return this.http.get(this.url);
  }

  getCompare(uId:number):Observable<any[]>{
    this.url=this.baseurl;
    this.url+='getCompare/'+uId;
   return this.http.get<any[]>(this.url)
  }

  removeFromCompare(compId:number):Observable<any[]>{
    this.url = this.baseurl;
    this.url += 'removeFromComp/'+compId;
    return this.http.get<any[]>(this.url);
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

  updateMyCart(cId: number,addOrMinus:number)
  {
    this.url = this.baseurl;
    this.url += 'updateMyCart/' + cId +"/"+addOrMinus;
      return this.http.get(this.url);
  }

  getMyWishlist(uId : number) : Observable<WishMyDTO[]> 
  {
    this.url = this.baseurl;
    this.url += 'getWishlist/' + uId;
    return this.http.get<WishMyDTO[]>(this.url);
  }
  

  delete(wId: number)
      {
        this.url = this.baseurl;
        this.url += 'deleteFromWishlist/' + wId;
        return this.http.delete(this.url);
      }
    
   addToWishList(uId: number, pId: number)
  {
    let wishlist=new Wishlist()
    wishlist.pId=pId;
    wishlist.uId=uId;
    this.url = this.baseurl;
    this.url += 'addToWishlist';
    return this.http.post(this.url,wishlist);
  }
  

}
