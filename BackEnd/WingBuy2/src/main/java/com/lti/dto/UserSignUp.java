package com.lti.dto;

public class UserSignUp {

	private String uName;
	private String uEmail;
	private String uPassword;
	private String uAddress;
	private long uMobile;
	
	public UserSignUp(){
		
	}
	@Override
	public String toString() {
		return "UserSignUp [uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword + ", uAddress="
				+ uAddress + ", uMobile=" + uMobile + "]";
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
	public UserSignUp(String uName, String uEmail, String uPassword, String uAddress, long uMobile) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uMobile = uMobile;
	}
	
}
