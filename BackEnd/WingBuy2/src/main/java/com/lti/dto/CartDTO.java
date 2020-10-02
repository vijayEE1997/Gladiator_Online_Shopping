package com.lti.dto;

public class CartDTO {
	private int cId;
	private int pId;
	private int qty;
	private String pImage1;
	private String pName;
	private String pModel;
	private String pCategory;
	private String pSubCategory;
	private double pPrice;
	
	
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
	public String getpImage1() {
		return pImage1;
	}
	public void setpImage1(String pImage1) {
		this.pImage1 = pImage1;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpModel() {
		return pModel;
	}
	public void setpModel(String pModel) {
		this.pModel = pModel;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public String getpSubCategory() {
		return pSubCategory;
	}
	public void setpSubCategory(String pSubCategory) {
		this.pSubCategory = pSubCategory;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public CartDTO(int cId, int pId, int qty, String pImage1, String pName, String pModel, String pCategory,
			String pSubCategory, double pPrice) {
		super();
		this.cId = cId;
		this.pId = pId;
		this.qty = qty;
		this.pImage1 = pImage1;
		this.pName = pName;
		this.pModel = pModel;
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pPrice = pPrice;
	}
	@Override
	public String toString() {
		return "Cart [cId=" + cId + ", pId=" + pId + ", qty=" + qty + ", pImage1=" + pImage1 + ", pName=" + pName
				+ ", pModel=" + pModel + ", pCategory=" + pCategory + ", pSubCategory=" + pSubCategory + ", pPrice="
				+ pPrice + "]";
	}
	
}

