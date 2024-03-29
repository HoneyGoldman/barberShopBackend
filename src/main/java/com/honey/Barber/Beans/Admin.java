package com.honey.Barber.Beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String name;
	
	@Column
	private String familyName;
	
	@Column
	private String siteId;
	
	@Column
	private String phoneNumber;
	
	@OneToMany
	private List<Location> locations;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
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

	public Admin() {
		super();
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", familyName="
				+ familyName + ", siteId=" + siteId + ", phoneNumber=" + phoneNumber + ", locations=" + locations + "]";
	}

	public Admin(int id, String password, String email, String name, String familyName, String siteId,
			String phoneNumber, List<Location> locations) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.familyName = familyName;
		this.siteId = siteId;
		this.phoneNumber = phoneNumber;
		this.locations = locations;
	}

	

}
