package com.lti.dao;

import java.util.List;

import com.lti.model.WishList;

public interface WishListDao {
	public boolean addToWishList(int uId, int pId);
	public boolean deleteWishList(int wId);
	public List<WishList> viewWishList(int uId);
}
