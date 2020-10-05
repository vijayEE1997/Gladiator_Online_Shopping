package com.lti.service;

import java.util.List;

import com.lti.dto.WishMyDTO;
import com.lti.model.WishList;

public interface WishListService {
	public int findaddToWishList(int uId, int pId);
	public boolean finddeleteWishList(int wId);
	public List<WishMyDTO> findviewWishList(int uId);
}
