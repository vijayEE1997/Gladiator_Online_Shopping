package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "CART")
public class Cart implements Serializable {
	@Id
	@Column(name = "C_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;

	@Column(name = "P_ID_QTY")
	private int pIdQty;

	// bi-directional many-to-one association to ProductTable

	@ManyToOne
	@JoinColumn(name = "P_ID")
	private Product cProducts;

	// bi-directional many-to-one association to UserTable

	@ManyToOne
	@JoinColumn(name = "U_ID")
	private User cUser;

	public Cart() {

	}

	public Cart(int pIdQty, Product cProducts, User cUser) {
		super();
		this.pIdQty = pIdQty;
		this.cProducts = cProducts;
		this.cUser = cUser;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getpIdQty() {
		return pIdQty;
	}

	public void setpIdQty(int pIdQty) {
		this.pIdQty = pIdQty;
	}

	public Product getcProducts() {
		return cProducts;
	}

	public void setcProducts(Product cProducts) {
		this.cProducts = cProducts;
	}

	public User getcUser() {
		return cUser;
	}

	public void setcUser(User cUser) {
		this.cUser = cUser;
	}

	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", pIdQty=" + pIdQty + ", cProducts=" + cProducts + ", cUser=" + cUser + "]";
	}

	
}
