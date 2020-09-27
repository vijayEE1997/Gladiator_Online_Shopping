package com.lti.dao;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Payment;
import com.lti.model.User;

public class PaymentDaoImpl implements PaymentDao{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager entityManager = factory.createEntityManager();

	public void begin() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}
	
	@Override
	public long makePayment(int uId, String payType) {
		
		Payment payment =new Payment();
		User user=entityManager.find(User.class, uId);
		
		payment.setPayId((new Timestamp(System.currentTimeMillis())).getTime());
		
		payment.setPayType(payType);
		payment.setpUser(user);
		
		begin();
		entityManager.persist(payment);
		commit();
		
		return payment.getPayId();
	}
	
	
}
