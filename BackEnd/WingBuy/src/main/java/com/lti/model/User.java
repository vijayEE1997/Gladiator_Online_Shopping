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
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;
	
	@Column(name="USER_NAME")
	private String uName;
	
	@Column(name="USER_ADDRESS")
	private String uAddress;
	
	@Column(name="USER_MOBILE")
	private int uMobile;
	
	@Column(name="USER_EMAIL")
	private String uEmail;
	
	@Column(name="USER_PASSWORD")
	private String uPassword;
	
	
	/*//onetoone between user and cart
		@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private Set<Cart> carts;
		
		@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private Set<WishList> wishlists;*/
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="CART_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")}
			)
	private Set<Product> cproducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="WISHLIST_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")}
			)
	private Set<Product> wproducts;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="COMPARE_TBL", 
	joinColumns = {@JoinColumn(name="U_ID")},
	inverseJoinColumns ={@JoinColumn(name="P_ID")}
			)
	private Set<Product> comproducts;
	
	
	
	
		

		@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private Set<Payment> payments;
		
		@OneToMany(mappedBy="user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		private Set<Payment> orders;
	
		public User() {
		
	}
		

		public Set<Product> getCproducts() {
			return cproducts;
		}


		public void setCproducts(Set<Product> cproducts) {
			this.cproducts = cproducts;
		}


		public Set<Product> getWproducts() {
			return wproducts;
		}


		public void setWproducts(Set<Product> wproducts) {
			this.wproducts = wproducts;
		}

		public Set<Product> getComproducts() {
			return comproducts;
		}


		public void setComproducts(Set<Product> comproducts) {
			this.comproducts = comproducts;
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
			return "User [uId=" + uId + ", uName=" + uName + ", uAddress=" + uAddress + ", uMobile=" + uMobile
					+ ", uEmail=" + uEmail + ", uPassword=" + uPassword + ", cproducts=" + cproducts + ", wproducts="
					+ wproducts + ", payments=" + payments + ", orders=" + orders + "]";
		}

		public User(int uId, String uName, String uAddress, int uMobile, String uEmail, String uPassword) {
			super();
			this.uId = uId;
			this.uName = uName;
			this.uAddress = uAddress;
			this.uMobile = uMobile;
			this.uEmail = uEmail;
			this.uPassword = uPassword;
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
		
	

}