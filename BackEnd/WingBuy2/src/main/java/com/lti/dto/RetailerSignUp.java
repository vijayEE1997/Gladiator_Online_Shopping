package com.lti.dto;

public class RetailerSignUp {
	private int rId;
	private String rEmail;
	private long rMobile;
	private String rName;
	private String rPassword;

	public RetailerSignUp() {

	}

	public RetailerSignUp(int rId, String rEmail, long rMobile, String rName, String rPassword) {
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

	public long getrMobile() {
		return rMobile;
	}

	public void setrMobile(long rMobile) {
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

	@Override
	public String toString() {
		return "RetailerSignUp [rId=" + rId + ", rEmail=" + rEmail + ", rMobile=" + rMobile + ", rName=" + rName
				+ ", rPassword=" + rPassword + "]";
	}

	
}
