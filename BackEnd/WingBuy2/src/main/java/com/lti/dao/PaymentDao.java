package com.lti.dao;

import com.lti.model.Payment;

public interface PaymentDao {

	public long makePayment(int uId, String payType);
	public Payment getPaymentById(long pay_Id);
}
