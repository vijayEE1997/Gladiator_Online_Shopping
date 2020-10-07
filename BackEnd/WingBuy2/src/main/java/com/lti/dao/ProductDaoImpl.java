package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Product;
@Repository("productdao")
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<String> readSubCategoryByCategory(String Category) {
		List<String> products = new ArrayList<String>();
		String query = "Select e from Product e where e.pCategory=:x";
		//pBrand=:x or pCategory=:x or pName like :y
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("x",Category);
		//q.setParameter("y", "%"+SubCategory+"%");
		List<Product> prod = q.getResultList();
		for(Product p : prod)
		{
			if(!products.contains(p.getpSubCategory()))
			{
				products.add(p.getpSubCategory());
			}
		}
		return products;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<String> readBrandByCategory(String Category) {
		List<String> products = new ArrayList<String>();
		String query = "Select e from Product e where e.pCategory=:x";
		//pBrand=:x or pCategory=:x or pName like :y
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("x",Category);
		//q.setParameter("y", "%"+SubCategory+"%");
		List<Product> prod = q.getResultList();
		for(Product p : prod)
		{
			if(!products.contains(p.getpBrand()))
			{
				products.add(p.getpBrand());
			}
		}
		return products;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> readProductBySearch(String SubCategory) {
		List<Product> products = new ArrayList<Product>();
		String query = "Select e from Product e where e.pSubCategory=:x ";
		//pBrand=:x or pCategory=:x or pName like :y
		Query q = (Query)this.entityManager.createQuery(query);
		q.setParameter("x",SubCategory);
		//q.setParameter("y", "%"+SubCategory+"%");
		 products = q.getResultList();		
		return products;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getProductByBrand(String pBrand,String pCategory) {
		List<Product> products = new ArrayList<Product>();
			String q = "Select e from Product e where e.pBrand=:x and e.pCategory=:y";
			
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("x", pBrand);
			query.setParameter("y", pCategory);
			
			products= query.getResultList();
				return products;	
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
		public List<Product> filterProductByPrice(String pBrand, int min, int max) {
			{
				List<Product> products = new ArrayList<Product>();
			String q = "Select e from Product e where pBrand=:a and pPrice between :x and :y ";
			Query query = (Query)this.entityManager.createQuery(q);
			query.setParameter("a", pBrand);
			query.setParameter("x", min);
			query.setParameter("y", max);
			List<Product> prod = query.getResultList();
			for(Product  p : prod)
			{
				int pId = 		 p.getpId();
				String pImage1 =  p.getpImage();
				String pName = 	 p.getpName();
				String pbrand =  p.getpBrand();
				double pPrice =  	 p.getpPrice();
				String pDesc = p.getpDesc();
				//products.add(new Product(pImage1,pDesc,pId,pName,pbrand,pPrice));
			}
			return products;
			}
		
			
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> readCategory(String Category) {
	
		
			List<Product> products = new ArrayList<Product>();
			String query = "Select e from Product e where e.pCategory=:x ";
			//pBrand=:x or pCategory=:x or pName like :y
			Query q = (Query)this.entityManager.createQuery(query);
			q.setParameter("x",Category);
			//q.setParameter("y", "%"+SubCategory+"%");
			 products = q.getResultList();		
			return products;
	}

}
