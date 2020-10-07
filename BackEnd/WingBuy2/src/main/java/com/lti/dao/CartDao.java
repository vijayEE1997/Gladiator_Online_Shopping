package com.lti.dao;

import java.util.List;
import java.util.Set;

import com.lti.model.Cart;
import com.lti.model.Compare;

public interface CartDao {
	public int addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCartBycId(int cId); //throws CartException;//to remove product from cart
	//public boolean buycart
	public List<Cart> viewCart(int uId);
	public boolean deleteCartByuId(int uId);//to delete cart
	public int addToCompare(int uId, int pId);
	public Set<Compare> getCompare(int uId);
	public Set<Compare> removeFromComp(int compId);
}
