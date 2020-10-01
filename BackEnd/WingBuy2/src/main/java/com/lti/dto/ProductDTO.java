package com.lti.dto;

public class ProductDTO {

	private String pCategory;
	private String pSubCategory;
	private String pName;
	private double pPrice;
	private String pDesc;
	private String pBrand;
	private int pStock;
	private String pImage;
	private int rId;
	private int pId;
	
public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
public ProductDTO(){
		
	}
	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
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
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public ProductDTO(String pCategory, String pSubCategory, String pName, double pPrice, String pDesc, String pBrand,
			int pStock, String pImage, int rId, int pId) {
		super();
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pBrand = pBrand;
		this.pStock = pStock;
		this.pImage = pImage;
		this.rId = rId;
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "ProductDTO [pCategory=" + pCategory + ", pSubCategory=" + pSubCategory + ", pName=" + pName
				+ ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand=" + pBrand + ", pStock=" + pStock + ", pImage="
				+ pImage + ", rId=" + rId + ", pId=" + pId + "]";
	}
	
	
	
}