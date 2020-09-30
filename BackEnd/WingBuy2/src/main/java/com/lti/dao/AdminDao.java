package com.lti.dao;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.ProductForApproval;

public interface AdminDao {
	public Admin getAdminById(int aId);//return Retailer
	public int getAdminByEmailAndPassword(String email,String password);//return rId
	public Admin getAdminByEmail(String email);
	public List<ProductForApproval> getProductstobeApproved(int aId);
}
