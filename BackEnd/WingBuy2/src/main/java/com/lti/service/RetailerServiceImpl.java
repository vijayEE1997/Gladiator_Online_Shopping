package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.RetailerDao;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
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
	public List<Product> findshowMyApprovedProducts(int rId) {
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

	

}
