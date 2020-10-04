package com.lti.dto;

public class PaymentDTO {
	private int uId;
	private String payType;
	private long payId;
	
	
	public PaymentDTO() {
		super();
	}


	public PaymentDTO(int uId, String payType, long payId) {
		super();
		this.uId = uId;
		this.payType = payType;
		this.payId = payId;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getPayType() {
		return payType;
	}


	public void setPayType(String payType) {
		this.payType = payType;
	}


	public long getPayId() {
		return payId;
	}


	public void setPayId(long payId) {
		this.payId = payId;
	}


	@Override
	public String toString() {
		return "PaymentDTO [uId=" + uId + ", payType=" + payType + ", payId=" + payId + "]";
	}
	
	
}
