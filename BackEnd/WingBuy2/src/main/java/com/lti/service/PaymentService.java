package com.lti.service;

import com.lti.model.Payment;

public interface PaymentService {
	public long findmakePayment(int uId, String payType);
	public Payment findgetPaymentById(long pay_Id);
}
