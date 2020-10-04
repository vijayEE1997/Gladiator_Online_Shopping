package com.lti.dao;

import java.util.List;

import com.lti.model.Payment;

public interface PaymentDao {

	public long makePayment(int uId, String payType);
	public Payment getPaymentById(long pay_Id);
	public List<Payment> getallPayments(int uId);
}
