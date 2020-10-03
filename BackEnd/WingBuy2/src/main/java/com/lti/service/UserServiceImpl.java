package com.lti.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

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
import com.lti.utility.JavaMailUtil;
import com.lti.utility.JavaSMSUtil;

@Service("userservice")
@Scope(scopeName="singleton")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao = null;
	

	@Override
	public int loginuser(Login login){
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
					System.out.println(user);
					if(user==null)
						return this.userdao.addUser(newUser);
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				return -100;
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

	@Override
	public int generateOTP(String email){
		int OTP=0;
		User user=userdao.getUserByEmail(email);
		if(user==null)
		return -1;
		else
		{
//				OTP=JavaMailUtil.sendMail("vijay1997dhakad@gmail.com");
//				System.out.println(OTP);
//				return OTP;
//			OTP=(int)Math.ceil(Math.random()*1000000);
//			String message="Dont Worry!!!"+"\nWe are here to help you\n"+"Your OTP is "+OTP+"\n";
//			try {
//				JavaSMSUtil.sendSMS(message+"\n"+ new Date().toLocaleString(),"8305940684");
//			} catch (IOException e) {
//				System.out.println("No. Not Exists");
//			}
			return 1;
//			return OTP;
		}
		
	}

	@Override
	public int resetPass(Login login) {
		User user=userdao.getUserByEmail(login.getEmail());
		user.setuPassword(login.getPassword());
		return userdao.resetPassword(user);
	}
	

}
