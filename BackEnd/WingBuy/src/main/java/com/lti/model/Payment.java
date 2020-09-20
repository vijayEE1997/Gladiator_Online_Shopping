package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_TBL")
public class Payment {
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO)
	@Column(name="PAY_ID")
	private int payId;
	
	@Column(name="PAY_TYPE")
	private String payType;
	
	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private User user;
		
	@OneToOne(mappedBy="payment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Order order;

	public Payment() {
		super();
	}

	public Payment(int payId, String payType) {
		super();
		this.payId = payId;
		this.payType = payType;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", payType=" + payType + "]";
	}
	
}