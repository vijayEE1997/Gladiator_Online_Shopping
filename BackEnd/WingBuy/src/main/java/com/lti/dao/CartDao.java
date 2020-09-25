package com.lti.dao;

public interface CartDao {
	public boolean addToCart(int uId, int pId);
	public boolean updateCart(int cId, int addOrMinus);
	public boolean deleteCart(int cId); //throws CartException;
	//public boolean buycart
}
