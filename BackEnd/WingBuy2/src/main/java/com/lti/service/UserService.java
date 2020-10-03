package com.lti.service;

import java.util.List;

import javax.mail.MessagingException;

import com.lti.dto.Login;
import com.lti.dto.UserSignUp;
import com.lti.model.Cart;
import com.lti.model.User;
import com.lti.model.WishList;

public interface UserService {
	public int loginuser(Login login);
	public int addUser(UserSignUp newUser);
	public User findgetUserById(int uId);//return Retailer
	public int findgetUserByEmailAndPassword(String email,String password);//return rId
	public User findgetUserByEmail(String email);
	public boolean findaddAddress(int uId , String address);
	public User findupdateUser(int uId, User user);
	public List<Cart> findgetCartOfUser(int uId);
	public List<WishList> findgetWishlistOfUser(int uId);
	public int generateOTP(String email);
	public int resetPass(Login login);
	
	//public User updateUser(UpdateUser updateUser);
}
