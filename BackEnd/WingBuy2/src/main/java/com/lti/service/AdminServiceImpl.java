package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.RetailerDao;
import com.lti.dto.RetailerSignUp;
import com.lti.model.Admin;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
@Service("adminservice")
@Scope(scopeName="singleton")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao = null;
	
	@Autowired
	private RetailerDao retailerdao = null;
	
	@Override
	public int loginadmin(String aEmail, String aPassword) {
		return this.admindao.getAdminByEmailAndPassword(aEmail, aPassword);
	}
	
	@Override
	public Admin findAdminById(int aId) {
		return admindao.getAdminById(aId);
	}

	@Override
	public int findAdminByEmailAndPassword(String email, String password) {
		return admindao.getAdminByEmailAndPassword(email, password);
	}

	@Override
	public Admin findAdminByEmail(String email) {
		return admindao.getAdminByEmail(email);
	}

	@Override
	public List<ProductForApproval> viewProductstobeApproved(int aId) {
		return admindao.getProductstobeApproved(aId);
	}

	@Override
	public List<Product> viewProducts(int aId) {
		return admindao.getProducts(aId);
	}

	@Override
	public boolean approveProductByrqID(int aId, int rqId) {
		return admindao.addProductByrqID(aId,rqId);
	}

	@Override
	public boolean rejectProductByrqID(int aId, int rqId) {
		return admindao.rejectProductByrqIdd(aId,rqId);
	}

	@Override
	public List<Retailer> viewAllRetailers() {
		return admindao.getAllRetailers();
	}

	@Override
	public List<Retailer> deleteRetailer(int rId) {
		return admindao.removeRetailer(rId);
	}

	@Override
	public boolean addRetailer(RetailerSignUp retailer) {
		Retailer newRetailer=retailerdao.getRetailerByEmail(retailer.getrEmail());
		if(newRetailer!=null)
		return false;
		newRetailer=new Retailer();
		newRetailer.setrName(retailer.getrName());
		newRetailer.setrEmail(retailer.getrEmail());
		newRetailer.setrMobile(retailer.getrMobile());
		String password=retailer.getrName().substring(0,4)+"@"+"12345";
		newRetailer.setrPassword(password);
		return admindao.addRetailer(newRetailer);
	}

	

}
