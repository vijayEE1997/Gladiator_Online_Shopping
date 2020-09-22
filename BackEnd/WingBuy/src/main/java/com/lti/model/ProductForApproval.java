package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_F_A")
public class ProductForApproval {

	@Id
	@Column(name = "P_REQ_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pReqId;
	@Column(name = "P_CATEGORY")
	private String pCategory;
	@Column(name = "P_SUBCATEGORY")
	private String pSubCategory;
	@Column(name = "P_NAME")
	private String pName;
	@Column(name = "P_PRICE")
	private double pPrice;
	@Column(name = "P_DESC")
	private String pDesc;
	@Column(name = "P_BRAND")
	private String pBrand;
	@Column(name = "P_STOCK")
	private int pStock;
	@Column(name = "P_IMAGE")
	private String pImage;
	@Column(name = "P_STATUS")
	private char pStatus;

	@ManyToOne
	@JoinColumn(name = "A_ID")
	private Admin admin;

	@ManyToOne
	@JoinColumn(name = "R_ID")
	private Retailer retailer;

	public ProductForApproval() {

	}

	@Override
	public String toString() {
		return "ProductForApproval [pReqId=" + pReqId + ", pCategory=" + pCategory + ", pSubCategory=" + pSubCategory
				+ ", pName=" + pName + ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand=" + pBrand + ", pStock="
				+ pStock + ", pImage=" + pImage + ", pStatus=" + pStatus + ", admin=" + admin + ", retailer=" + retailer
				+ "]";
	}

	public ProductForApproval(int pReqId, String pCategory, String pSubCategory, String pName, int pPrice, String pDesc,
			String pBrand, int pStock, String pImage, char pStatus, Admin admin, Retailer retailer) {
		super();
		this.pReqId = pReqId;
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pBrand = pBrand;
		this.pStock = pStock;
		this.pImage = pImage;
		this.pStatus = pStatus;
		this.admin = admin;
		this.retailer = retailer;
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

	public char getpStatus() {
		return pStatus;
	}

	public void setpStatus(char pStatus) {
		this.pStatus = pStatus;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

}
