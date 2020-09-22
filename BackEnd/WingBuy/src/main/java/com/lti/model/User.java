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
@Table(name = "USER")
public class User {
	@Id
	@Column(name = "U_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uId;

	@Column(name = "U_NAME")
	private String uName;

	@Column(name = "U_EMAIL")
	private String uEmail;

	@Column(name = "U_PASSWORD")
	private String uPassword;

	@Column(name = "U_ADDRESS")
	private String uAddress;

	@Column(name = "U_MOBILE")
	private long uMobile;

	@OneToMany(mappedBy = "wUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<WishList> wishlists;

	@OneToMany(mappedBy = "compUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Compare> compares;

	@OneToMany(mappedBy = "cUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Cart> carts;

	@OneToMany(mappedBy = "pUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Payment> payments;

	public void addProductToCart(Cart cart) {
		carts.add(cart);
	}

	public User() {

	}

	public User(String uName, String uEmail, String uPassword, String uAddress, long uMobile, Set<WishList> wishlists,
			Set<Compare> compares, Set<Cart> carts, Set<Payment> payments) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uMobile = uMobile;
		this.wishlists = wishlists;
		this.compares = compares;
		this.carts = carts;
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword
				+ ", uAddress=" + uAddress + ", uMobile=" + uMobile + ", wishlists=" + wishlists + ", compares="
				+ compares + ", carts=" + carts + ", payments=" + payments + "]";
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

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public long getuMobile() {
		return uMobile;
	}

	public void setuMobile(long uMobile) {
		this.uMobile = uMobile;
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

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
