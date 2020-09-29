package com.lti.dao;

import com.lti.model.Admin;

public interface AdminDao {
	public Admin getAdminById(int aId);//return Retailer
	public int getAdminByEmailAndPassword(String email,String password);//return rId
	public Admin getAdminByEmail(String email);
}
