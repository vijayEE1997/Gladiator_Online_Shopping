package com.lti.service;

import java.util.List;

import com.lti.dto.CartDTO;
import com.lti.dto.CartMyDTO;
import com.lti.model.Cart;

public interface CartService {
	public int findaddToCart(int uId, int pId);
	public boolean findupdateCart(int cId, int addOrMinus);
	public boolean finddeleteCartBycId(int cId); //throws CartException;//to remove product from cart
	//public boolean buycart
	public List<CartMyDTO> findviewCart(int uId);
	public boolean finddeleteCartByuId(int uId);//to delete cart
}
