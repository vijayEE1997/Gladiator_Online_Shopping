package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_TBL")
 public class Product {
	
	@Id
	@Column(name="P_ID")
	@GeneratedValue( strategy=GenerationType.AUTO)
	private int pId;
	@Column(name="P_CATEGORY")
	private String pCategory;
	@Column(name="P_SUBCATEGORY")
	private String pSubCategory;
	@Column(name="P_NAME")
	private String pName;
	@Column(name="P_PRICE")
	private int pPrice;
	@Column(name="P_DESC")
	private String pDesc;
	@Column(name="P_BRAND")
	private String pBrand;
	@Column(name="P_STOCK")
	private int pStock;
	@Column(name="P_IMAGE")
	private String pImage;
	
	/*//@ManyToMany(mappedBy="products")
	private Set<Admin> admins;
	//@ManyToMany(mappedBy="products")
	private Set<Retailer> retailers;*/
	
	@ManyToOne
	@JoinColumn(name="A_ID")
	private Admin admin;
	
	//@ManyToOne
	//@JoinColumn(name="R_ID")
	private int retailer;
	
	
//	@OneToMany(mappedBy="product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private Set<OrderDetail> orderdetails;
	
	@ManyToMany(mappedBy="wProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> wusers;
	
	@ManyToMany(mappedBy="cProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> cusers;
	
	@ManyToMany(mappedBy="comProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> comusers;
	
	@ManyToMany(mappedBy="pOrderDetails",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Order> uorderdetails;
	
public Product(){
		
	}


public Admin getAdmin() {
	return admin;
}


public void setAdmin(Admin admin) {
	this.admin = admin;
}


public void setRetailer(int retailer) {
	this.retailer = retailer;
}


public Set<User> getWusers() {
	return wusers;
}


public void setWusers(Set<User> wusers) {
	this.wusers = wusers;
}


public Set<User> getCusers() {
	return cusers;
}


public void setCusers(Set<User> cusers) {
	this.cusers = cusers;
}

public Set<User> getComusers() {
	return comusers;
}


public void setComusers(Set<User> comusers) {
	this.comusers = comusers;
}



public Product(int pId, String pCategory, String pSubCategory, String pName, int pPrice, String pDesc, String pBrand,
		int pStock, String pImage) {
	super();
	this.pId = pId;
	this.pCategory = pCategory;
	this.pSubCategory = pSubCategory;
	this.pName = pName;
	this.pPrice = pPrice;
	this.pDesc = pDesc;
	this.pBrand = pBrand;
	this.pStock = pStock;
	this.pImage = pImage;
}


public int getpId() {
	return pId;
}


public void setpId(int pId) {
	this.pId = pId;
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


public int getpPrice() {
	return pPrice;
}


public void setpPrice(int pPrice) {
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

		
	}