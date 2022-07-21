package com.honey.Barber.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import net.bytebuddy.utility.nullability.MaybeNull;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String phoneNumber;
	
	@Column
	private String siteId;
	
	@Column
	private String source;
	
	@Column
	private String email;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
	public Customer(int id, String name, String phoneNumber, String siteId) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.siteId = siteId;
		this.email="no mail";
		this.source="default";
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", siteId=" + siteId
				+ ", source=" + source + ", email=" + email + "]";
	}
	
	public Customer() {
		super();
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(int id, String name, String phoneNumber, String siteId, String source, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.siteId = siteId;
		this.source = source;
		this.email = email;
	}
	public Customer(String name, String phoneNumber, String siteId, String source, String email) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.siteId = siteId;
		this.source = source;
		this.email = email;
	}
	

	}
