package com.lti.dao;

import java.util.List;

import com.lti.dto.ProductForApprovalDTO;
import com.lti.dto.RetailerSignUp;
import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface RetailerDao {
	public Retailer getRetailerById(int rId);//return Retailer
	public int addRetailer(RetailerSignUp newRetailer);
	public int getRetailerByEmailAndPassword(String email,String password);//return rId
	public Retailer getRetailerByEmail(String email);//return Retailer

//	public boolean addProductForApproval(ProductForApproval product);
//	public updateRea
//	public boolean updateProduct()

	public List<Retailer> showAllRetailers();
	public List<ProductForApproval> showMyApprovedProducts(int rId);
	public List<ProductForApproval> showMyRejectedProducts(int rId);
	public List<ProductForApproval> showMyPendingProducts(int rId);
	public boolean addProduct(ProductForApprovalDTO pfa);
	
}
