package com.lti.dto;

public class ProductForApprovalDTO {
	private int pReqId;
	private String pCategory;
	private String pSubCategory;
	private String pImage;
	private String pName;
	private double pPrice;
	private String pDesc;
	private String pBrand;
	private int pStock;
	private char pStatus;
	private int rId;

	public ProductForApprovalDTO() {

	}

	public int getpReqId() {
		return pReqId;
	}

	public void setpReqId(int pReqId) {
		this.pReqId = pReqId;
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

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	public char getpStatus() {
		return pStatus;
	}

	public void setpStatus(char pStatus) {
		this.pStatus = pStatus;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public ProductForApprovalDTO(int pReqId, String pCategory, String pSubCategory, String pImage, String pName,
			double pPrice, String pDesc, String pBrand, int pStock, char pStatus, int rId) {
		super();
		this.pReqId = pReqId;
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pImage = pImage;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pBrand = pBrand;
		this.pStock = pStock;
		this.pStatus = pStatus;
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "ProductForApproval [pReqId=" + pReqId + ", pCategory=" + pCategory + ", pSubCategory=" + pSubCategory
				+ ", pImage=" + pImage + ", pName=" + pName + ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand="
				+ pBrand + ", pStock=" + pStock + ", pStatus=" + pStatus + ", rId=" + rId + "]";
	}

}
