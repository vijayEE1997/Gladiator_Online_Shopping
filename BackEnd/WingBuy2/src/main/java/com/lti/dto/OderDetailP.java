package com.lti.dto;

import com.lti.model.OrderDetail;
import com.lti.model.Product;

public class OderDetailP {
	private Product product;
	private OrderDetail od;
	public OderDetailP(Product product, OrderDetail od) {
		super();
		this.product = product;
		this.od = od;
	}
	public OderDetailP() {
		super();
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public OrderDetail getOd() {
		return od;
	}
	public void setOd(OrderDetail od) {
		this.od = od;
	}
	@Override
	public String toString() {
		return "OderDetailP [product=" + product + ", od=" + od + "]";
	}

	
	
}
