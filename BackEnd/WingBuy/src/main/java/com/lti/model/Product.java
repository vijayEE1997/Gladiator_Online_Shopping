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
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
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

	@ManyToOne
	@JoinColumn(name = "A_ID")
	private Admin admin;

	private int retailer;

	@OneToMany(mappedBy = "wProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<WishList> wishlists;

	@OneToMany(mappedBy = "compProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Compare> compares;

	@OneToMany(mappedBy = "cProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cart> carts;

	@OneToMany(mappedBy = "odProducts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	public void addProductToCart(Cart cart){
		carts.add(cart);
		
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getRetailer() {
		return retailer;
	}

	public void setRetailer(int retailer) {
		this.retailer = retailer;
	}

	public Set<WishList> getWishlists() {
		return wishlists;
	}

	public void setWishlists(Set<WishList> wishlists) {
		this.wishlists = wishlists;
	}

	public Set<Compare> getCompares() {
		return compares;
	}

	public void setCompares(Set<Compare> compares) {
		this.compares = compares;
	}

	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCategory=" + pCategory + ", pSubCategory=" + pSubCategory + ", pName="
				+ pName + ", pPrice=" + pPrice + ", pDesc=" + pDesc + ", pBrand=" + pBrand + ", pStock=" + pStock
				+ ", pImage=" + pImage + ", admin=" + admin + ", retailer=" + retailer + ", wishlists=" + wishlists
				+ ", compares=" + compares + ", carts=" + carts + ", orderDetails=" + orderDetails + "]";
	}

	public Product(String pCategory, String pSubCategory, String pName, double pPrice, String pDesc, String pBrand,
			int pStock, String pImage, Admin admin, int retailer, Set<WishList> wishlists, Set<Compare> compares,
			Set<Cart> carts, Set<OrderDetail> orderDetails) {
		super();
		this.pCategory = pCategory;
		this.pSubCategory = pSubCategory;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pDesc = pDesc;
		this.pBrand = pBrand;
		this.pStock = pStock;
		this.pImage = pImage;
		this.admin = admin;
		this.retailer = retailer;
		this.wishlists = wishlists;
		this.compares = compares;
		this.carts = carts;
		this.orderDetails = orderDetails;
	}

	public Product() {

	}

}