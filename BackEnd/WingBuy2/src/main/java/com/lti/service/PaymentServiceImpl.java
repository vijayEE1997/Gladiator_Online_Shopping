package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.dao.CartDao;
import com.lti.dao.PaymentDao;
import com.lti.model.Payment;

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentdao = null;
	
	@Override
	public long findmakePayment(int uId, String payType) {
	return paymentdao.makePayment(uId, payType);
	}

	@Override
	public Payment findgetPaymentById(long pay_Id) {
		return paymentdao.getPaymentById(pay_Id);
	}

}
