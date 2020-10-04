package com.lti.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@Scope(scopeName="prototype")
@Entity
@Table(name = "ORDER_T")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","pOrderDetails"})
public class Order {

	@Id
	@Column(name = "O_ID")
	private long oId;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAY_ID")
	private Payment payment;

	@OneToMany(mappedBy = "odOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<OrderDetail> pOrderDetails;

	public Order() {

	}

	public Order(double oPrice, int oQty, Date oPurchaseDate, Date oDeliveryDate, String oAddress) {
		super();
		this.oPrice = oPrice;
		this.oQty = oQty;
		this.oPurchaseDate = oPurchaseDate;
		this.oDeliveryDate = oDeliveryDate;
		this.oAddress = oAddress;
	}
	
	public void addProductToOrder(OrderDetail od) {
		if(this.pOrderDetails==null)
			this.pOrderDetails=new HashSet<>();
		this.pOrderDetails.add(od);
	}
	
	public long getoId() {
		return oId;
	}
	public void setoId(long oId) {
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

	public Set<OrderDetail> getpOrderDetails() {
		return pOrderDetails;
	}

	public void setpOrderDetails(Set<OrderDetail> pOrderDetails) {
		this.pOrderDetails = pOrderDetails;
	}

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", oPrice=" + oPrice + ", oQty=" + oQty + ", oPurchaseDate=" + oPurchaseDate
				+ ", oDeliveryDate=" + oDeliveryDate + ", oAddress=" + oAddress + "]";
	}


}
