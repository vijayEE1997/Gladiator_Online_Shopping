package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* aId VARCHAR(20) NOT NULL,
aName VARCHAR(30) NOT NULL,
aEmail VARCHAR(50) NOT NULL,
aPassword VARCHAR(15) NOT NULL,
PRIMARY KEY (aId)
*/
@Entity
@Table(name="ADMIN_TBL")
//@SequenceGenerator(name="seq",sequenceName="admin_seq",initialValue=1, allocationSize= 1)
public class Admin {
	@Id
	@Column(name="A_ID")
	@GeneratedValue( strategy=GenerationType.AUTO)
	private int aId;
	@Column(name="A_NAME")
	private String aName;
	@Column(name="A_EMAIL")
	private String aEmail;
	@Column(name="A_PASSWORD")
	private String aPassword;
	
	public Admin(){
		
	}
	
	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aEmail=" + aEmail + ", aPassword=" + aPassword + "]";
	}
	public Admin(int aId, String aName, String aEmail, String aPassword) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaEmail() {
		return aEmail;
	}
	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}
	public String getaPassword() {
		return aPassword;
	}
	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	
	
}
