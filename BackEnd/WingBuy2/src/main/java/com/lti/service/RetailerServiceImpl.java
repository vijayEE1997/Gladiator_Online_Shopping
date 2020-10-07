package com.lti.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.RetailerDao;
import com.lti.dto.Login;
import com.lti.dto.ProductForApprovalDTO;
import com.lti.dto.RetailerSignUp;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import com.lti.model.User;
import com.lti.utility.JavaSMSUtil;
@Service("retailerservice")
@Scope(scopeName="singleton")
public class RetailerServiceImpl implements RetailerService{
	@Autowired
	private RetailerDao retailerdao = null;
	
	@Override
	public int loginRetailer(String rEmail, String rPassword) {
		return this.retailerdao.getRetailerByEmailAndPassword(rEmail, rPassword);
	}

	@Override
	public int addRetailer(RetailerSignUp newRetailer) {
		int id = 0;
		try
		{
			Retailer retailer = this.retailerdao.getRetailerByEmail(newRetailer.getrEmail());
			return -100;
		}
		catch(NullPointerException e)
		{
			return -100;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			id = this.retailerdao.addRetailer(newRetailer);
		}
		return id;
	}
	
	@Override
	public Retailer findgetRetailerById(int rId) {
		return retailerdao.getRetailerById(rId);
	}

	@Override
	public int findgetRetailerByEmailAndPassword(String email, String password) {
		return retailerdao.getRetailerByEmailAndPassword(email, password);
	}

	@Override
	public Retailer findgetRetailerByEmail(String email) {
		return retailerdao.getRetailerByEmail(email);
	}

	@Override
	public List<ProductForApproval> findshowMyApprovedProducts(int rId) {
		return retailerdao.showMyApprovedProducts(rId);
	}

	@Override
	public List<Retailer> findshowAllRetailers() {
		return retailerdao.showAllRetailers();
	}

	@Override
	public List<ProductForApproval> findshowMyRejectedProducts(int rId) {
		return retailerdao.showMyRejectedProducts(rId);
	}

	@Override
	public List<ProductForApproval> findshowMyPendingProducts(int rId) {
		return retailerdao.showMyPendingProducts(rId);
	}

	@Override
	public boolean addProductFA(ProductForApprovalDTO pfa) {
		return retailerdao.addProduct(pfa);
	}

	@Override
	public int generateOTP(String email) {
		int OTP=0;
		Retailer retailer=retailerdao.getRetailerByEmail(email);
		if(retailer==null)
		return -1;
		else
		{
//				OTP=JavaMailUtil.sendMail("vijay1997dhakad@gmail.com");
//				System.out.println(OTP);
//				return OTP;
			OTP=(int)Math.ceil(Math.random()*1000000);
			String message="Dont Worry!!!"+"\nWe are here to help you\n"+"Your OTP is "+OTP+"\n";
			try {
				JavaSMSUtil.sendSMS(message+"\n"+ new Date().toLocaleString(),""+retailer.getrMobile());
			} catch (IOException e) {
				System.out.println("No. Not Exists");
			}
//			return 1;
			return OTP;
		}
		
	}

	
	@Override
	public int resetPass(Login login) {
		Retailer retailer=retailerdao.getRetailerByEmail(login.getEmail());
		retailer.setrPassword(login.getPassword());
		return retailerdao.resetPassword(retailer);
	}
	

}
