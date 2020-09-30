package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.model.Admin;
@Service("adminservice")
@Scope(scopeName="singleton")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao admindao = null;
	
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

}
