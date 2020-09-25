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
@Table(name = "PAYMENT")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAY_ID")
	private int payId;

	@Column(name = "PAY_TYPE")
	private String payType;

	@ManyToOne
	@JoinColumn(name = "U_ID")
	private User pUser;

	@OneToOne(mappedBy = "payment")
	private Order order;

	public Payment() {
	}

	public Payment(String payType, User pUser) {
		super();
		this.payType = payType;
		this.pUser = pUser;
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

	public User getpUser() {
		return pUser;
	}

	public void setpUser(User pUser) {
		this.pUser = pUser;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", payType=" + payType + ", pUser=" + pUser + "]";
	}

	
	
}