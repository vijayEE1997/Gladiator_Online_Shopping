package com.lti.dao;

import java.util.List;

import com.lti.model.Product;

public interface ProductDao  {
//	public Product  getProductById(int pId);
	
//	public List<Product> sortProduct(String by, int order);
//	public List<Product> filterProduct(String brand, int s, int e);

public List<Product> readProductBySearch(String SubCategory);
public List<Product> getProductByBrand(String pBrand,String pCategory);
public List<Product> filterProductByPrice(String pBrand, int min, int max);
public List<String> readSubCategoryByCategory(String Category);
public List<Product> readCategory(String Category);
List<String> readBrandByCategory(String Category);

}
