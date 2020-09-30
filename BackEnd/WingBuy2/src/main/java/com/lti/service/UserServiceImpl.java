package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.RetailerDao;
import com.lti.dao.UserDao;
import com.lti.dto.Login;
import com.lti.dto.UserSignUp;
import com.lti.model.Cart;
import com.lti.model.User;
import com.lti.model.WishList;
@Service("userservice")
@Scope(scopeName="singleton")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao = null;
	

	@Override
	public int loginuser(Login login){//throws CustomerException {
			int id = this.userdao.getUserByEmailAndPassword(login.getEmail(),login.getPassword());
			return id;
		}
	
	@Override
	public int addUser(UserSignUp newUser) {
		//first check if user is present or not!
				int id = 0;
				try
				{
					User user = this.userdao.getUserByEmail(newUser.getuEmail());
					return -100;
				}
				catch(NullPointerException e)
				{
					return -100;
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					id = this.userdao.addUser(newUser);
				}
				return id;
	}

	@Override
	public User findgetUserById(int uId) {
		return userdao.getUserById(uId);
	}
		
	@Override
	public int findgetUserByEmailAndPassword(String email, String password) {
	return userdao.getUserByEmailAndPassword(email, password);
	}

	@Override
	public User findgetUserByEmail(String email) {
		return userdao.getUserByEmail(email);
	}

	@Override
	public boolean findaddAddress(int uId, String address) {
		return userdao.addAddress(uId, address);
	}

	@Override//pending need to implement in dao and in main controller
	public User findupdateUser(int uId, User user) {
		return userdao.updateUser(uId, user);
	}

	@Override
	public List<Cart> findgetCartOfUser(int uId) {
		return userdao.getCartOfUser(uId);
	}

	@Override
	public List<WishList> findgetWishlistOfUser(int uId) {
		return userdao.getWishlistOfUser(uId);
	}

	
	

}
