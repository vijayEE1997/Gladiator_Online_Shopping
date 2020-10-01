package com.lti.service;

import java.util.List;

import com.lti.dto.RetailerSignUp;
import com.lti.model.Admin;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface AdminService {
	public int loginadmin(String aEmail, String aPassword);
	public Admin findAdminById(int aId);//return Retailer
	public int findAdminByEmailAndPassword(String email,String password);//return rId
	public Admin findAdminByEmail(String email);
	public List<ProductForApproval> viewProductstobeApproved(int aId);
	public List<Product> viewProducts(int aId);
	public boolean approveProductByrqID(int aId, int rqId);
	public boolean rejectProductByrqID(int aId, int rqId);
	public List<Retailer> viewAllRetailers();
	public List<Retailer> deleteRetailer(int rId);
}
