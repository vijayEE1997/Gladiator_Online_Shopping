package com.lti.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "O_ID")
	private int oId;

	@Column(name = "O_PRICE")
	private double oPrice;

	@Column(name = "O_QTY")
	private int oQty;

	@Column(name = "O_PURCHASE_DATE")
	@Temporal(TemporalType.DATE)
	private Date oPurchaseDate;

	@Column(name = "O_DELIVERY_DATE")
	@Temporal(TemporalType.DATE)
	private Date oDeliveryDate;

	@Column(name = "O_ADDRESS")
	private String oAddress;

	@OneToOne
	@JoinColumn(name = "PAY_ID")
	private Payment payment;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "ORDER_DETAIL_TBL", joinColumns = { @JoinColumn(name = "O_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "P_ID") })
//	private Set<Product> pOrderDetails;
	@OneToMany(mappedBy="odOrders")
	private Set<OrderDetail> oOrderdetails;
	public Order() {

	}
	public Order(double oPrice, int oQty, Date oPurchaseDate, Date oDeliveryDate, String oAddress, Payment payment,
			Set<OrderDetail> oOrderdetails) {
		super();
		this.oPrice = oPrice;
		this.oQty = oQty;
		this.oPurchaseDate = oPurchaseDate;
		this.oDeliveryDate = oDeliveryDate;
		this.oAddress = oAddress;
		this.payment = payment;
		this.oOrderdetails = oOrderdetails;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public double getoPrice() {
		return oPrice;
	}
	public void setoPrice(double oPrice) {
		this.oPrice = oPrice;
	}
	public int getoQty() {
		return oQty;
	}
	public void setoQty(int oQty) {
		this.oQty = oQty;
	}
	public Date getoPurchaseDate() {
		return oPurchaseDate;
	}
	public void setoPurchaseDate(Date oPurchaseDate) {
		this.oPurchaseDate = oPurchaseDate;
	}
	public Date getoDeliveryDate() {
		return oDeliveryDate;
	}
	public void setoDeliveryDate(Date oDeliveryDate) {
		this.oDeliveryDate = oDeliveryDate;
	}
	public String getoAddress() {
		return oAddress;
	}
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Set<OrderDetail> getoOrderdetails() {
		return oOrderdetails;
	}
	public void setoOrderdetails(Set<OrderDetail> oOrderdetails) {
		this.oOrderdetails = oOrderdetails;
	}
	@Override
	public String toString() {
		return "Order [oId=" + oId + ", oPrice=" + oPrice + ", oQty=" + oQty + ", oPurchaseDate=" + oPurchaseDate
				+ ", oDeliveryDate=" + oDeliveryDate + ", oAddress=" + oAddress + "]";
	}
	
	

	
}
