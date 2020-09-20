package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PRODUCT_F_A_TBL")
public class ProductForApproval {	
		
		@Id
		@Column(name="P_REQ_ID")
		@GeneratedValue( strategy=GenerationType.AUTO)
		private int pReqId;
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
		@Column(name="P_STATUS")
		private char pStatus;
		
		@ManyToOne
		@JoinColumn(name="A_ID")
		private Admin admin;
		
		@ManyToOne
		@JoinColumn(name="R_ID")
		private Retailer retailer;
		
		public ProductForApproval(){
			
		}
		

		}
