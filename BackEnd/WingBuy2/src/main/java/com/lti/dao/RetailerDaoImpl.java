package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lti.model.Product;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("retailerdao")
public class RetailerDaoImpl implements RetailerDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Retailer getRetailerById(int rId) {
		String query = "SELECT E FROM Retailer E WHERE E.rId=:rId";
		Retailer retailer = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			tquery.setParameter("rId", rId);
			retailer = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return retailer;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getRetailerByEmailAndPassword(String email, String password) {

		String query = "SELECT E FROM Retailer E WHERE E.rEmail=:email AND E.rPassword=:password";
		int rId = -1;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			tquery.setParameter("email", email);
			tquery.setParameter("password", password);
			rId = tquery.getResultList().get(0).getrId();
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return rId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Retailer getRetailerByEmail(String email) {
		String query = "SELECT E FROM Retailer E WHERE E.rEmail=:email";
		Retailer retailer = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			tquery.setParameter("email", email);
			retailer = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return retailer;
	}

	/*
	 * @Override public boolean addRetalier(Retailer newRetailer) {
	 * 
	 * begin(); entityManager.persist(newRetailer); commit(); return true;
	 * 
	 * }
	 */

	/*
	 * @Override public boolean addProductForApproval(ProductForApproval
	 * product) {
	 * 
	 * Retailer retailer = null; begin();
	 * 
	 * return retailer ; }
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> showMyApprovedProducts(int rId) {
		String query = "SELECT E FROM Product E WHERE E.rId=:rId";
		List<Product> product = null;
		TypedQuery<Product> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Product.class);
			tquery.setParameter("rId", rId);
			product = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("Retailer not exists.");
		}
		return product;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Retailer> showAllRetailers() {
		String query = "SELECT E FROM Retailer E ";
		List<Retailer> retailer = null;
		TypedQuery<Retailer> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Retailer.class);
			retailer = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("Retailers not exists.");
		}
		return retailer;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductForApproval> showMyRejectedProducts(int rId) {
		String query = "SELECT E FROM ProductForApproval E WHERE E.retailer.rId=:rId AND E.pStatus='R'";
		List<ProductForApproval> product = null;
		TypedQuery<ProductForApproval> tquery = null;
		try {
			tquery = entityManager.createQuery(query, ProductForApproval.class);
			tquery.setParameter("rId", rId);
			product = tquery.getResultList();
		} catch (Exception e) {
			System.out.println("Either approved or not requested");
		}
		return product;
	}

}
