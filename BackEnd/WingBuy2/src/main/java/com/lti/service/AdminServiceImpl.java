package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.model.Admin;
import com.lti.model.ProductForApproval;
@Service("adminservice")
@Scope(scopeName="singleton")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao = null;
	
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

	

}
