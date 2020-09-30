package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;
import com.lti.model.ProductForApproval;
import com.lti.model.Retailer;

@Repository("admindao")
public class AdminDaoImpl implements AdminDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminById(int aId) {
		String query = "SELECT E FROM Admin E WHERE E.aId=:aId";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("aId", aId);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int getAdminByEmailAndPassword(String email, String password) {
		String query = "SELECT E FROM Admin E WHERE E.aEmail=:email AND E.aPassword=:password";
		int aId = -1;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("email", email);
			tquery.setParameter("password", password);

			aId = tquery.getResultList().get(0).getaId();

		}

		catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return aId;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Admin getAdminByEmail(String email) {
		String query = "SELECT E FROM Admin E WHERE E.aEmail=:email";
		Admin admin = null;
		TypedQuery<Admin> tquery = null;
		try {
			tquery = entityManager.createQuery(query, Admin.class);
			tquery.setParameter("email", email);
			admin = tquery.getResultList().get(0);
		} catch (Exception e) {
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProductForApproval> getProductstobeApproved(int aId) {
		
			String query = "SELECT E FROM ProductForApproval E WHERE E.admin.aId=:aId AND E.pStatus='P'";
			List<ProductForApproval> product = null;
			TypedQuery<ProductForApproval> tquery = null;
			try {
				tquery = entityManager.createQuery(query, ProductForApproval.class);
				tquery.setParameter("aId", aId);
				product = tquery.getResultList();
			} catch (Exception e) {
				System.out.println("No pending requests or some error");
			}
			return product;
		
	}

}
