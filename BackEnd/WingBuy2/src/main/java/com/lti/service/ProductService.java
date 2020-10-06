package com.lti.service;

import java.util.List;

import com.lti.model.Product;

public interface ProductService {
	public List<Product> getProductBySearch(String pSubCategory);
	public List<Product> findgetProductByBrand(String pBrand,String pCategory);
	public List<Product> findProductByPrice(String pBrand, int min, int max);
	public List<String> findSubCategoryByCategory(String Category);
	public List<Product> findCategory(String Category);


}
