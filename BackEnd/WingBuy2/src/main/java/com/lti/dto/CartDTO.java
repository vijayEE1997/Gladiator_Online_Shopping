package com.lti.dto;

public class CartDTO {
	private int cId;
	private int pId;
	private int qty;
	private int uId;
	
	public CartDTO() {

	}

	public CartDTO(int cId, int pId, int qty, int uId) {
		super();
		this.cId = cId;
		this.pId = pId;
		this.qty = qty;
		this.uId = uId;
	}
	@Override
	public String toString() {
		return "CartDTO [cId=" + cId + ", pId=" + pId + ", qty=" + qty + ", uId=" + uId + "]";
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	
	
	
}

