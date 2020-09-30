package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.CartDao;
import com.lti.model.Cart;
@Service("cartservice")
@Scope(scopeName="singleton")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartdao = null;

	@Override
	public boolean findaddToCart(int uId, int pId) {
		return cartdao.addToCart(uId, pId);
	}

	@Override
	public boolean findupdateCart(int cId, int addOrMinus) {
		return cartdao.updateCart(cId, addOrMinus);
	}

	@Override
	public boolean finddeleteCartBycId(int cId) {
		return cartdao.deleteCartBycId(cId);
	}

	@Override
	public List<Cart> findviewCart(int uId) {
		return cartdao.viewCart(uId);
	}

	@Override
	public boolean finddeleteCartByuId(int uId) {
		return cartdao.deleteCartByuId(uId);
	}

}
