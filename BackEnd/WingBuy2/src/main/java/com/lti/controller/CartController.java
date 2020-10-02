package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Cart;
import com.lti.service.CartService;

@RestController
@RequestMapping(path ="Cbuy")
@CrossOrigin
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@GetMapping(path = "{cId,addOrMinus}") //addition or deletion of product from cart
	public boolean  cfindupdateCart(@PathVariable("cId")int cId, @PathVariable("addOrMinus")int addOrMinus) {
		return cartservice.findupdateCart(cId, addOrMinus); 
		}
	  
	  @GetMapping(path = "{cId}") //delete the product 
	  public boolean cfinddeleteCartBycId(@PathVariable("cId") int cId) { 
		  return cartservice.finddeleteCartBycId(cId);
		  }
	  
	  @GetMapping(path = "{uId}") //delete the entire cart
	  public boolean cfinddeleteCartByuId(@PathVariable("uId") int uId) {
		  return cartservice.finddeleteCartByuId(uId); 
		  }
	  
	  @GetMapping(path = "{uId}")
	  public List<Cart> cfindviewCart(@PathVariable("uId") int uId) {
		  List<Cart> carts = cartservice.findviewCart(uId); return carts; }

}
