package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WISHLIST")
public class WishList implements Serializable {
	@Id
	@Column(name = "W_ID")
	private int wId;

	// bi-directional many-to-one association to ProductTable

	@ManyToOne
	@JoinColumn(name = "P_ID")
	private Product wProducts;

	// bi-directional many-to-one association to UserTable

	@ManyToOne
	@JoinColumn(name = "U_ID")
	private User wUser;

	public WishList() {

	}

	public WishList(Product wProducts, User wUser) {
		super();
		this.wProducts = wProducts;
		this.wUser = wUser;
	}

	@Override
	public String toString() {
		return "WishList [wId=" + wId + ", wProducts=" + wProducts + ", wUser=" + wUser + "]";
	}

	public int getwId() {
		return wId;
	}

	public void setwId(int wId) {
		this.wId = wId;
	}

	public Product getwProducts() {
		return wProducts;
	}

	public void setwProducts(Product wProducts) {
		this.wProducts = wProducts;
	}

	public User getwUser() {
		return wUser;
	}

	public void setwUser(User wUser) {
		this.wUser = wUser;
	}

}
