package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.model.Admin;
import com.lti.model.Retailer;

public class AdminDaoImpl implements AdminDao{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}
	public void commit() {
		entityManager.getTransaction().commit();
	}
	@Override
	public Admin getAdminById(int aId) {
		String query="SELECT E FROM Admin E WHERE E.aId=:aId";
		Admin admin=null;
		TypedQuery<Admin> tquery=null;
		try {
			tquery=entityManager.createQuery(query,Admin.class);
			tquery.setParameter("aId",aId);
			admin=tquery.getResultList().get(0);
		}catch(Exception e)
		{
			System.out.println("Admin not exists.");
		}
		return admin;
	}

	@Override
	public int getAdminByEmailAndPassword(String email, String password) {
		String query="SELECT E FROM Admin E WHERE E.aEmail=:email AND E.aPassword=:password";
		int aId=-1;
		TypedQuery<Admin> tquery=null;
				try {
			tquery=entityManager.createQuery(query,Admin.class);
			tquery.setParameter("email",email);
			tquery.setParameter("password",password);
			
			aId=tquery.getResultList().get(0).getaId();
			
		}
				
		catch(Exception e)
		{
			System.out.println("Admin not exists.");
		}
		return aId ;
	}

	@Override
	public Admin getAdminByEmail(String email) {
		String query="SELECT E FROM Admin E WHERE E.aEmail=:email";
		Admin admin = null;
		TypedQuery<Admin> tquery=null;
		try {
			tquery=entityManager.createQuery(query,Admin.class);
			tquery.setParameter("email",email);
			admin=tquery.getResultList().get(0);
		}
		catch(Exception e)
		{
			System.out.println("Admin not exists.");
		}
		return admin ;
	}

}
