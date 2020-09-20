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
 class Product {
	
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
	
	@ManyToOne
	@JoinColumn(name="A_ID")
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name="R_ID")
	private Admin retailer;

	@ManyToMany(mappedBy="wProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> wUsers;
	
	@ManyToMany(mappedBy="cProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> cUsers;
	
	@ManyToMany(mappedBy="comProducts",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<User> comUsers;
	
	@ManyToMany(mappedBy="pOrderDetails",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Order> uOrderDetails;
		
	public Product(){
			
	}

	public Product(int pId, String pCategory, String pSubCategory, String pName, int pPrice, String pDesc,
			String pBrand, int pStock, String pImage) {
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getRetailer() {
		return retailer;
	}

	public void setRetailer(Admin retailer) {
		this.retailer = retailer;
	}

	public Set<User> getwUsers() {
		return wUsers;
	}

	public void setwUsers(Set<User> wUsers) {
		this.wUsers = wUsers;
	}

	public Set<User> getcUsers() {
		return cUsers;
	}

	public void setcUsers(Set<User> cUsers) {
		this.cUsers = cUsers;
	}

	public Set<User> getComUsers() {
		return comUsers;
	}

	public void setComUsers(Set<User> comUsers) {
		this.comUsers = comUsers;
	}

	public Set<Order> getuOrderDetails() {
		return uOrderDetails;
	}

	public void setuOrderDetails(Set<Order> uOrderDetails) {
		this.uOrderDetails = uOrderDetails;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCategory=" + pCategory + ", pSubCategory=" + pSubCategory + ", pName="
				+ pName + ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand=" + pBrand + ", pStock=" + pStock
				+ ", pImage=" + pImage + "]";
	}
	
}