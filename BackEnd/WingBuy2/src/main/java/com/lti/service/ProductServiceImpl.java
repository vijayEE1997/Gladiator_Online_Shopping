package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.dao.RetailerDao;
import com.lti.model.Product;

@Service("productservice")
@Scope(scopeName="singleton")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productdao = null;
	@Override
	public List<Product> getProductBySearch(String pSubCategory) {
		return productdao.readProductBySearch(pSubCategory);
	}
	@Override
	public List<Product> findgetProductByBrand(String pBrand,String pCategory) {
		return productdao.getProductByBrand(pBrand, pCategory);
	}
	@Override
	public List<Product> findProductByPrice(String pBrand, int min, int max) {
		return productdao.filterProductByPrice(pBrand, min, max);
	}
	@Override
	public List<String> findSubCategoryByCategory(String Category) {
		return productdao.readSubCategoryByCategory(Category);
	}
	
	@Override
	public List<String> findSubBrandByCategory(String Category) {
		return productdao.readBrandByCategory(Category);
	}
	
	@Override
	public List<Product> findCategory(String Category) {
		return productdao.readCategory(Category);
	}

	
		
	

}
