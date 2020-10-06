import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  public getLoggedInName = new Subject(); //Alternate method to Emitting data across Components. Subject() is doing both Emitting data and Subscribing it in another component. So its the best way to compare with Emitting using Output.

  login(fullName:string){
      if (fullName) {
          this.getLoggedInName.next(fullName); //next() method is alternate to emit().
          return true;
      } else {
          this.getLoggedInName.next('Login');
          return false;
      }
  }

  logout(): void {
      this.getLoggedInName.next('Login');
  }
}
