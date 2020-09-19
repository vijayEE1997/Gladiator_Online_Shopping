package com.lti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_TBL")
public class Payment {
	@Id
	@Column(name="PAY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String payId;
	
	@Column(name="PAY_TYPE")
	private String payType;
	
	private User uId;
	public Payment() {
		
		// TODO Auto-generated constructor stub
	}

	
	
	


}