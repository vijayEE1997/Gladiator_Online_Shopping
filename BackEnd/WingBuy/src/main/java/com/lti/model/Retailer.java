package com.lti.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "RETAILER_TBL")
public class Retailer {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "R_ID")
		private int rId;
		
		@Column(name = "R_NAME")
		private String rName;

		@Column(name = "R_EMAIL")
		private String rEmail;

		@Column(name = "R_PASSWORD")
		private String rPassword;

		@Column(name = "R_MOBILE")
		private int rMobile;
		
		@OneToMany(mappedBy="retailer",cascade=CascadeType.ALL)
		private Set<Product> products;
		
		@OneToMany(mappedBy="retailer",cascade=CascadeType.ALL)
		private Set<ProductForApproval> productsFA;

		
		public Retailer() {
			super();
		}

		public Retailer(int rId, String rName, String rEmail, String rPassword, int rMobile) {
			super();
			this.rId = rId;
			this.rName = rName;
			this.rEmail = rEmail;
			this.rPassword = rPassword;
			this.rMobile = rMobile;
		}

		public int getrId() {
			return rId;
		}

		public void setrId(int rId) {
			this.rId = rId;
		}

		public String getrName() {
			return rName;
		}

		public void setrName(String rName) {
			this.rName = rName;
		}

		public String getrEmail() {
			return rEmail;
		}

		public void setrEmail(String rEmail) {
			this.rEmail = rEmail;
		}

		public String getrPassword() {
			return rPassword;
		}

		public void setrPassword(String rPassword) {
			this.rPassword = rPassword;
		}

		public int getrMobile() {
			return rMobile;
		}

		public void setrMobile(int rMobile) {
			this.rMobile = rMobile;
		}

		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}

		public Set<ProductForApproval> getProductsFA() {
			return productsFA;
		}

		public void setProductsFA(Set<ProductForApproval> productsFA) {
			this.productsFA = productsFA;
		}

		@Override
		public String toString() {
			return "Retailer [rId=" + rId + ", rName=" + rName + ", rEmail=" + rEmail + ", rPassword=" + rPassword
					+ ", rMobile=" + rMobile + "]";
		}
		
}