package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

public class RetailerDaoImpl implements RetailerDao{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}
	public void commit() {
		entityManager.getTransaction().commit();
	}
	@Override
	public Retailer getRetailerById(int rId) {
		String query="SELECT E FROM Retailer E WHERE E.rId=:rId";
		Retailer retailer=null;
		TypedQuery<Retailer> tquery=null;
		try {
			tquery=entityManager.createQuery(query,Retailer.class);
			tquery.setParameter("rId",rId);
			retailer=tquery.getResultList().get(0);
		}catch(Exception e)
		{
			System.out.println("Retailer not exists.");
		}
		return retailer;
	}

	@Override
	public int getRetailerByEmailAndPassword(String eail, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Retailer getRetailerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addRetalier(Retailer newRetailer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addProductForApproval(ProductForApproval product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> showMyApprovedProducts(int rId) {
		String query="SELECT E FROM Product E WHERE E.rId=:rId";
		List<Product> product=null;
		TypedQuery<Product> tquery=null;
		try {
			tquery=entityManager.createQuery(query,Product.class);
			tquery.setParameter("rId",rId);
			product=tquery.getResultList();
		}catch(Exception e)
		{
			System.out.println("Retailer not exists.");
		}
		return product;
	}

	@Override
	public List<Retailer> showAllRetailers() {
		String query="SELECT E FROM Retailer E ";
		List<Retailer> retailer=null;
		TypedQuery<Retailer> tquery=null;
		try {
			tquery=entityManager.createQuery(query,Retailer.class);
			retailer=tquery.getResultList();
		}catch(Exception e)
		{
			System.out.println("Retailers not exists.");
		}
		return retailer;
	}

}
