package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.CartDao;
import com.lti.dao.WishListDao;
import com.lti.model.WishList;
@Service("wishlistservice")
@Scope(scopeName="singleton")
public class WishListServiceImpl implements WishListService{
	
	@Autowired
	private WishListDao wishlistdao = null;

	@Override
	public boolean findaddToWishList(int uId, int pId) {
		return wishlistdao.addToWishList(uId, pId);
	}

	@Override
	public boolean finddeleteWishList(int wId) {
		return wishlistdao.deleteWishList(wId);
	}

	@Override
	public List<WishList> findviewWishList(int uId) {
	return wishlistdao.viewWishList(uId);
	}

}
