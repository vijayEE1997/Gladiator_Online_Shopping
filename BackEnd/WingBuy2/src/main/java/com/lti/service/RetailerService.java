package com.lti.service;

import java.util.List;

import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface RetailerService {
	public Retailer findgetRetailerById(int rId);//return Retailer
	public int findgetRetailerByEmailAndPassword(String eail,String password);//return rId
	public Retailer findgetRetailerByEmail(String email);//return Retailer
	//public int addRetalier(Retailer newRetailer);//return rId after adding
//	public boolean addProductForApproval(ProductForApproval product);
//	public updateRea
//	public boolean updateProduct()
	public List<Product> findshowMyApprovedProducts(int rId);
	public List<Retailer> findshowAllRetailers();
	public List<ProductForApproval> findshowMyRejectedProducts(int rId);
}
