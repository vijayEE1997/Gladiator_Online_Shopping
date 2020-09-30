package com.lti.dao;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import com.lti.model.Payment;
import com.lti.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("paymentdao")
public class PaymentDaoImpl implements PaymentDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long makePayment(int uId, String payType) {

		Payment payment = new Payment();
		User user = entityManager.find(User.class, uId);

		payment.setPayId((new Timestamp(System.currentTimeMillis())).getTime());

		payment.setPayType(payType);
		payment.setpUser(user);

		entityManager.persist(payment);

		return payment.getPayId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Payment getPaymentById(long pay_Id) {

		Payment payment = entityManager.find(Payment.class, pay_Id);

		return payment;
	}

}
