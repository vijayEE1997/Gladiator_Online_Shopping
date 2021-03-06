package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "ADMIN_T")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products_f_a","products"})
public class Admin implements Serializable {

	@Id
	@Column(name = "A_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aId;
	@Column(name = "A_NAME")
	private String aName;
	@Column(name = "A_EMAIL")
	private String aEmail;
	@Column(name = "A_PASSWORD")
	private String aPassword;

//	@JsonManagedReference
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private Set<ProductForApproval> products_f_a;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private Set<Product> products;

	public Admin() {
	}

	public Admin(String aName, String aEmail, String aPassword) {
		super();
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}
	
	public void addProductForA(ProductForApproval pfa) {
		if(this.products_f_a==null)
			this.products_f_a=new HashSet<>();
		this.products_f_a.add(pfa);
	}
	public void removeProductFromApproval(ProductForApproval pfa) {
		System.out.println(this.products_f_a.size());
		this.products_f_a.remove(pfa);
		System.out.println(this.products_f_a.size());
		if(this.products_f_a.size()==0)
			this.products_f_a=null;
	}

	public void addProduct(Product p) {
		if(this.products==null)
			this.products=new HashSet<>();
		this.products.add(p);
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

	public Set<ProductForApproval> getProducts_f_a() {
		return products_f_a;
	}

	public void setProducts_f_a(Set<ProductForApproval> products_f_a) {
		this.products_f_a = products_f_a;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aEmail=" + aEmail + ", aPassword=" + aPassword + "]";
	}

}