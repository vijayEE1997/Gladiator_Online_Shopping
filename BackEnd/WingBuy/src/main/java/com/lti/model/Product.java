package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="PRODUCT_TBL")
public class Product implements Serializable{
	@Id
	@Column(name="PRODUCT_ID")
	private int pId;
	
	@Column(name="PRODUCT_NAME")
	private String ptName;
	
	@Column(name="PRODUCT_CATEGORY")
	private String pCategaory;
	
	@Column(name="PRODUCT_SUBCATEGORY")
	private String pSubCategaory;
	
	@Column(name="PRODUCT_PRICE")
	private int pPrice;
	
	@Column(name="PRODUCT_DESCRIPTION")
	private String pDesc;
	
	@Column(name="PRODUCT_BRAND")
	private String pBrand;
	
	@Column(name="PRODUCT_STOCK")
	private String pStock;
	
	@ManyToMany(mappedBy="products")
	private Set<Order> orders;
	
	public Product() {
		
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Product(int pId, String ptName, String pCategaory, String pSubCategaory, int pPrice, String pDesc,
			String pBrand, String pStock) {
		super();
		this.pId = pId;
		this.ptName = ptName;
		this.pCategaory = pCategaory;
		this.pSubCategaory = pSubCategaory;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pBrand = pBrand;
		this.pStock = pStock;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", ptName=" + ptName + ", pCategaory=" + pCategaory + ", pSubCategaory="
				+ pSubCategaory + ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand=" + pBrand + ", pStock="
				+ pStock + "]";
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getPtName() {
		return ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getpCategaory() {
		return pCategaory;
	}

	public void setpCategaory(String pCategaory) {
		this.pCategaory = pCategaory;
	}

	public String getpSubCategaory() {
		return pSubCategaory;
	}

	public void setpSubCategaory(String pSubCategaory) {
		this.pSubCategaory = pSubCategaory;
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

	public String getpStock() {
		return pStock;
	}

	public void setpStock(String pStock) {
		this.pStock = pStock;
	}
	
	
}
