package com.lti.model;
//owner
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="ORDER_TBL")
public class Order implements Serializable {
	@Id
	@Column(name="ORDER_ID")
	private long oId;
	
	@Column(name="ORDER_PRICE")
	private int oPrice;
	
	@Column(name="ORDER_QUANTITY")
	private int oQty;
	
	@Column(name="ORDER_ADDRESS")
	private String oAddress;
	
	@Column(name="ORDER_DELIVERY_DATE")
	@Temporal(TemporalType.DATE)
	private Date oDeliveryDate;
	
	@Column(name="ORDER_PURCHASE_DATE")
	@Temporal(TemporalType.DATE)
	private Date oPurchaseDate;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ORDER_DETAILS_TBL", 
		joinColumns= {@JoinColumn(name="ORDER_ID")}, 
		inverseJoinColumns= { @JoinColumn(name="PRODUCT_ID") })
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "PAY_ID")
//	
//	private Payment payment;
//    public Payment getPayment() {
//        return payment;
//    }
// 
//    public void setAuthor(Payment payment) {
//        this.payment = payment;
//    }
//	
	private Set<Product> products;
	
	public void addProduct(Product product){
		products.add(product);
	}

	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

    public Order() {
		
	}
	public Order(long oId, int oPrice, int oQty, String oAddress, Date oDeliveryDate, Date oPurchaseDate) {
		super();
		this.oId = oId;
		this.oPrice = oPrice;
		this.oQty = oQty;
		this.oAddress = oAddress;
		this.oDeliveryDate = oDeliveryDate;
		this.oPurchaseDate = oPurchaseDate;
	}


	@Override
	public String toString() {
		return "Order [oId=" + oId + ", oPrice=" + oPrice + ", oQty=" + oQty + ", oAddress=" + oAddress
				+ ", oDeliveryDate=" + oDeliveryDate + ", oPurchaseDate=" + oPurchaseDate + ", products=" + products
				+ "]";
	}


	public long getoId() {
		return oId;
	}


	public void setoId(long oId) {
		this.oId = oId;
	}


	public int getoPrice() {
		return oPrice;
	}


	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}


	public int getoQty() {
		return oQty;
	}


	public void setoQty(int oQty) {
		this.oQty = oQty;
	}


	public String getoAddress() {
		return oAddress;
	}


	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}


	public Date getoDeliveryDate() {
		return oDeliveryDate;
	}


	public void setoDeliveryDate(Date oDeliveryDate) {
		this.oDeliveryDate = oDeliveryDate;
	}


	public Date getoPurchaseDate() {
		return oPurchaseDate;
	}


	public void setoPurchaseDate(Date oPurchaseDate) {
		this.oPurchaseDate = oPurchaseDate;
	}
	
	
}
