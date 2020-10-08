package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.dto.CartDTO;
import com.lti.dto.CartMyDTO;
import com.lti.model.Cart;
import com.lti.model.Compare;

public interface CartService {
	public int findaddToCart(int uId, int pId);
	public boolean findupdateCart(int cId, int addOrMinus);
	public boolean finddeleteCartBycId(int cId); //throws CartException;//to remove product from cart
	//public boolean buycart
	public List<CartMyDTO> findviewCart(int uId);
	public boolean finddeleteCartByuId(int uId);//to delete cart
	public int addToCompare(int uId, int pId);
	public Set<Compare> getCompare(int uId);
	public Set<Compare> deleteFromComp(int compId);
}
