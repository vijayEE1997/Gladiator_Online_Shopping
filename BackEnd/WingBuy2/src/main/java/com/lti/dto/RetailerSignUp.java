package com.lti.dto;

public class RetailerSignUp {
private String rEmail;
private long rMobile;
private String rName;
private String rPassword;

public RetailerSignUp(){
	
}

@Override
public String toString() {
	return "RetailerSignUp [rEmail=" + rEmail + ", rMobile=" + rMobile + ", rName=" + rName + ", rPassword=" + rPassword
			+ "]";
}


public RetailerSignUp(String rEmail, long rMobile, String rName, String rPassword) {
	super();
	this.rEmail = rEmail;
	this.rMobile = rMobile;
	this.rName = rName;
	this.rPassword = rPassword;
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


}
