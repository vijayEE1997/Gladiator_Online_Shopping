package com.lti.dao;

import java.util.List;

import com.lti.dto.UserSignUp;
import com.lti.model.Cart;
import com.lti.model.Product;
import com.lti.model.Retailer;
import com.lti.model.User;
import com.lti.model.WishList;


public interface UserDao {
	
	public int addUser(UserSignUp newUser);
	public User getUserById(int uId);//return Retailer
	public int getUserByEmailAndPassword(String email,String password);//return rId
	public User getUserByEmail(String email);
	public boolean addAddress(int uId , String address);
	public User updateUser(int uId, User user);
	public List<Cart> getCartOfUser(int uId);
	public List<WishList> getWishlistOfUser(int uId);
	public int resetPassword(User user);
	public List<Product> findAllProductByCat(String keyword);
	public Product findAllProductByPID(int pId);
	
	//public User updateUser(UpdateUser updateUser);
}
