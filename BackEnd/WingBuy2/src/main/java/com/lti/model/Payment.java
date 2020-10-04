package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "PAYMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","order"})
public class Payment {

	@Id
	@Column(name = "PAY_ID")
	private long payId;

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

	public long getPayId() {
		return payId;
	}

	public void setPayId(long payId) {
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