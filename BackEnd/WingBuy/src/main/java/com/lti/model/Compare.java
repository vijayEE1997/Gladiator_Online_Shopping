package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPARE")
public class Compare implements Serializable {
	@Id
	@Column(name = "COMP_ID")
	private int compId;

	@Column(name = "P_ID_QTY")
	private int pIdQty;

	// bi-directional many-to-one association to ProductTable

	@ManyToOne
	@JoinColumn(name = "P_ID")
	private Product compProducts;

	// bi-directional many-to-one association to UserTable

	@ManyToOne
	@JoinColumn(name = "U_ID")
	private User compUser;

	public Compare() {

	}

	public Compare(int pIdQty, Product compProducts, User compUser) {
		super();
		this.pIdQty = pIdQty;
		this.compProducts = compProducts;
		this.compUser = compUser;
	}

	@Override
	public String toString() {
		return "Compare [compId=" + compId + ", pIdQty=" + pIdQty + ", compProducts=" + compProducts + ", compUser="
				+ compUser + "]";
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public int getpIdQty() {
		return pIdQty;
	}

	public void setpIdQty(int pIdQty) {
		this.pIdQty = pIdQty;
	}

	public Product getCompProducts() {
		return compProducts;
	}

	public void setCompProducts(Product compProducts) {
		this.compProducts = compProducts;
	}

	public User getCompUser() {
		return compUser;
	}

	public void setCompUser(User compUser) {
		this.compUser = compUser;
	}

}
