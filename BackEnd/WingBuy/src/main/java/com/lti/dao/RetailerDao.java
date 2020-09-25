package com.lti.dao;

import java.util.List;

import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public interface RetailerDao {
	public Retailer getRetailerById(int rId);//return Retailer
	public int getRetailerByEmailAndPassword(String eail,String password);//return rId
	public Retailer getRetailerByEmail(String email);//return Retailer
	public int addRetalier(Retailer newRetailer);//return rId after adding
	public boolean addProductForApproval(ProductForApproval product);
//	public updateRea
//	public boolean updateProduct()
	public List<Product> showMyApprovedProducts(int rId);
	public List<Retailer> showAllRetailers();
}
