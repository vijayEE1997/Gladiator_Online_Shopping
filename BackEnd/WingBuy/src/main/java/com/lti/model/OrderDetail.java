package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail implements Serializable {
	@Id
	@Column(name = "OD_ID")
	private int odId;

	// bi-directional many-to-one association to ProductTable

	@ManyToOne
	@JoinColumn(name = "P_ID")
	private Product odProducts;

	// bi-directional many-to-one association to UserTable

	@ManyToOne
	@JoinColumn(name = "O_ID")
	private Order odOrders;
	
	@Column(name = "OD_QTY")
	private int odQty;
	

}
