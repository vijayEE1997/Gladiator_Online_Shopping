package com.lti.dao;

import java.util.List;

import com.lti.model.Cart;

public interface CartDao {
	public int addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCartBycId(int cId); //throws CartException;//to remove product from cart
	//public boolean buycart
	public List<Cart> viewCart(int uId);
	public boolean deleteCartByuId(int uId);//to delete cart
}
