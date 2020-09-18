package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "RETAILER_TBL")
public class Retailer {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "R_ID")
		private int rId;

		@Column(name = "R_EMAIL")
		private String rEmail;

		@Column(name = "R_MOBILE")
		private int rMobile;

		@Column(name = "R_NAME")
		private String rName;

		@Column(name = "R_PASSWORD")
		private String rPassword;
		
		public Retailer(){
			
		}

		@Override
		public String toString() {
			return "Retailer [rId=" + rId + ", rEmail=" + rEmail + ", rMobile=" + rMobile + ", rName=" + rName
					+ ", rPassword=" + rPassword + "]";
		}

		public Retailer(int rId, String rEmail, int rMobile, String rName, String rPassword) {
			super();
			this.rId = rId;
			this.rEmail = rEmail;
			this.rMobile = rMobile;
			this.rName = rName;
			this.rPassword = rPassword;
		}

		public int getrId() {
			return rId;
		}

		public void setrId(int rId) {
			this.rId = rId;
		}

		public String getrEmail() {
			return rEmail;
		}

		public void setrEmail(String rEmail) {
			this.rEmail = rEmail;
		}

		public int getrMobile() {
			return rMobile;
		}

		public void setrMobile(int rMobile) {
			this.rMobile = rMobile;
		}

		public String getrName() {
			return rName;
		}

		public void setrName(String rName) {
			this.rName = rName;
		}

		public String getrPassword() {
			return rPassword;
		}

		public void setrPassword(String rPassword) {
			this.rPassword = rPassword;
		}
		
		
}
