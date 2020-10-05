package com.lti.service;

import java.util.List;

import com.lti.dto.ProductForApprovalDTO;
import com.lti.dto.RetailerSignUp;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface RetailerService {
	public int loginRetailer(String rEmail, String rPassword); //throws CustomerException;
	public int addRetailer(RetailerSignUp newRetailer);
	public Retailer findgetRetailerById(int rId);//return Retailer
	public int findgetRetailerByEmailAndPassword(String email,String password);//return rId
	public Retailer findgetRetailerByEmail(String email);//return Retailer
	
//	public boolean addProductForApproval(ProductForApproval product);
//	public updateRea
//	public boolean updateProduct()
	public List<Retailer> findshowAllRetailers();
	public List<ProductForApproval> findshowMyApprovedProducts(int rId);
	public List<ProductForApproval> findshowMyPendingProducts(int rId);
	public List<ProductForApproval> findshowMyRejectedProducts(int rId);
	public boolean addProductFA(ProductForApprovalDTO pfa);
	
}
