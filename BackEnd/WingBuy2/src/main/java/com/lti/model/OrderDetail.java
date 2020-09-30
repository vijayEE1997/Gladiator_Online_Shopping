package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {
	@Id
	@Column(name = "OD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int odId;

	// bi-directional many-to-one association to ProductTable

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "P_ID")
	private Product odProducts;

	// bi-directional many-to-one association to UserTable

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "O_ID")
	private Order odOrder;

	@Column(name = "OD_QTY")
	private int odQty;

	public OrderDetail() {
	}

	public OrderDetail(Product odProducts, Order odOrder, int odQty) {
		super();
		this.odProducts = odProducts;
		this.odOrder = odOrder;
		this.odQty = odQty;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public Product getOdProducts() {
		return odProducts;
	}

	public void setOdProducts(Product odProducts) {
		this.odProducts = odProducts;
	}

	public Order getOdOrder() {
		return odOrder;
	}

	public void setOdOrder(Order odOrder) {
		this.odOrder = odOrder;
	}

	public int getOdQty() {
		return odQty;
	}

	public void setOdQty(int odQty) {
		this.odQty = odQty;
	}

	@Override
	public String toString() {
		return "OrderDetail [odId=" + odId + ", odProducts=" + odProducts + ", odOrder=" + odOrder + ", odQty=" + odQty
				+ "]";
	}
	
	

}
