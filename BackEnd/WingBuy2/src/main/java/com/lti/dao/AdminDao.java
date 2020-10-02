package com.lti.dao;

import java.util.List;

import com.lti.dto.RetailerSignUp;
import com.lti.model.Admin;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface AdminDao {
	public Admin getAdminById(int aId);//return Retailer
	public int getAdminByEmailAndPassword(String email,String password);//return rId
	public Admin getAdminByEmail(String email);
	public List<ProductForApproval> getProductstobeApproved(int aId);
	public List<Product> getProducts(int aId);
	public boolean addProductByrqID(int aId, int rqId);
	public boolean rejectProductByrqIdd(int aId, int rqId);
	public List<Retailer> getAllRetailers();
	public List<Retailer> removeRetailer(int rId);
	public boolean addRetailer(Retailer newRetailer);
}
