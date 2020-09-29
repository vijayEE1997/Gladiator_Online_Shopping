package com.lti.service;

import java.util.List;

import com.lti.model.WishList;

public interface WishListService {
	public boolean findaddToWishList(int uId, int pId);
	public boolean finddeleteWishList(int wId);
	public List<WishList> findviewWishList(int uId);
}
