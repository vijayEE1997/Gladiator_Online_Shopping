package com.lti.service;

import com.lti.model.Admin;

public interface AdminService {
	public Admin findAdminById(int aId);//return Retailer
	public int findAdminByEmailAndPassword(String email,String password);//return rId
	public Admin findAdminByEmail(String email);
}
