package com.lti.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public User() {
		
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uAddress=" + uAddress + ", uMobile=" + uMobile + ", uEmail="
				+ uEmail + ", uPassword=" + uPassword + "]";
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