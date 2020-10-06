import { CustomerService } from 'src/app/Service/customer.service';
import { Cart } from './../../DTO/Cart';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RetailerService } from 'src/app/Service/retailer.service';

@Component({
  selector: 'cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carts: Cart[] = [];
  uId;
  totalPrice;
  buyProductButton: boolean = false;

  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit(): void {

    this.uId = sessionStorage.getItem('user');
    if (this.uId == "null") {
      alert("User Not Logged In");
      this.router.navigate(['home']);
    }
    this.customerService.getMyCart(this.uId)
      .subscribe((data: Cart[]) => {
        this.carts = data;
        if (this.carts.length == 0) {
          this.totalPrice = 0;
          this.buyProductButton = true;
          return;
        }
        this.customerService.getCartTotalPrice(this.uId)
          .subscribe((data: string) => {
            this.totalPrice = data;
          });
      });
  }


  reloadData() {
    this.customerService.getMyCart(this.uId)
      .subscribe((data: Cart[]) => {
        this.carts = data;
        if (this.carts.length == 0) {
          this.totalPrice = 0;
          this.buyProductButton = true;
          return;
        }
        this.customerService.getCartTotalPrice(this.uId)
          .subscribe((data: string) => {
            this.totalPrice = data;
          });
      });
  }

  onAddUpdateClick(cId: number) {
    this.customerService.updateMyCart(cId.toString(), '1')
      .subscribe((data: string) => {
        //alert(data);
        this.reloadData();
      });
  }
  onMinusUpdateClick(cId: number) {
    this.customerService.updateMyCart(cId.toString(), '0')
      .subscribe((data: string) => {
        //alert(data);
        this.reloadData();
      });
  }
  onDeleteCartProductClick(cId: number) {
    this.customerService.deleteMyCart(cId.toString())
      .subscribe((data: string) => {
        this.reloadData();
      })
  }
}
