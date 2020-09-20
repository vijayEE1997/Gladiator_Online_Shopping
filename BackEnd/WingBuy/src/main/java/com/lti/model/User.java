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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_TBL")
public class User {
	@Id
	@Column(name="U_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;
	
	@Column(name="U_NAME")
	private String uName;
	
	@Column(name="U_EMAIL")
	private String uEmail;
	
	@Column(name="U_PASSWORD")
	private String uPassword;
	
	@Column(name="U_ADDRESS")
	private String uAddress;
	
	@Column(name="U_MOBILE")
	private int uMobile;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CART_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")})
	private Set<Product> cProducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="WISHLIST_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")})
	private Set<Product> wProducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="COMPARE_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")})
	private Set<Product> comProducts;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Payment> payments;
		
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Payment> orders;
	
	public User() {
		
	}
		
	public User(int uId, String uName, String uEmail, String uPassword, String uAddress, int uMobile) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uMobile = uMobile;
	}


	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public int getuMobile() {
		return uMobile;
	}

	public void setuMobile(int uMobile) {
		this.uMobile = uMobile;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public Set<Product> getcProducts() {
		return cProducts;
	}

	public void setcProducts(Set<Product> cProducts) {
		this.cProducts = cProducts;
	}

	public Set<Product> getwProducts() {
		return wProducts;
	}

	public void setwProducts(Set<Product> wProducts) {
		this.wProducts = wProducts;
	}

	public Set<Product> getComProducts() {
		return comProducts;
	}

	public void setComProducts(Set<Product> comProducts) {
		this.comProducts = comProducts;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<Payment> getOrders() {
		return orders;
	}

	public void setOrders(Set<Payment> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword
				+ ", uAddress=" + uAddress + ", uMobile=" + uMobile + "]";
	}	
		
	
}