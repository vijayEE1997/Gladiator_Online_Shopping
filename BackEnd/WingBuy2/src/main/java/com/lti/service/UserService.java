package com.lti.service;

import java.util.List;

import com.lti.dto.Login;
import com.lti.model.Cart;
import com.lti.model.User;
import com.lti.model.WishList;

public interface UserService {
	public int login(Login login);
	public User findgetUserById(int uId);//return Retailer
	public int findgetUserByEmailAndPassword(String email,String password);//return rId
	public User findgetUserByEmail(String email);
	public boolean findaddAddress(int uId , String address);
	public User findupdateUser(int uId, User user);
	public List<Cart> findgetCartOfUser(int uId);
	public List<WishList> findgetWishlistOfUser(int uId);
	//public int addUser(UserSignUp newUser);
	//public User updateUser(UpdateUser updateUser);
}
