package com.lti.service;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.ProductForApproval;

public interface AdminService {
	public int loginadmin(String aEmail, String aPassword);
	public Admin findAdminById(int aId);//return Retailer
	public int findAdminByEmailAndPassword(String email,String password);//return rId
	public Admin findAdminByEmail(String email);
	public List<ProductForApproval> viewProductstobeApproved(int aId);
}
