package com.honey.Barber.Beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.honey.Barber.DAO.SiteProperty.SitePropertyIMP;
import com.honey.Barber.DAO.SiteProperty.SitePropertyRepository;

@Entity
public class Day {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@ManyToOne
	private Month month;
	
	@OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
	private List<Customer> customers;
	@Column
	private LocalDate Date;
	@Column
	private String siteId;
	@Column
	private LocalTime startTime;
	@Column
	private LocalTime timePerCustomer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getTimePerCustomer() {
		return timePerCustomer;
	}

	public void setTimePerCustomer(LocalTime timePerCustomer) {
		this.timePerCustomer = timePerCustomer;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	
	

	public Day(int id, List<Customer> customers, LocalDate date, String siteId,
			LocalTime timePerCustomer) {
		super();
		this.id = id;
		this.customers = customers;
		this.Date = date;
		this.siteId = siteId;
		this.startTime = LocalTime.parse(SitePropertyIMP.getSitePropertyByName("startTime",siteId).getValue());
		this.timePerCustomer = LocalTime.parse(SitePropertyIMP.getSitePropertyByName("timePerCustomer",siteId).getValue());;
	}
	public Day(List<Customer> customers, LocalDate date, String siteId,
			LocalTime timePerCustomer) {
		super();
		this.customers = customers;
		this.Date = date;
		this.siteId = siteId;
		this.startTime = LocalTime.parse(SitePropertyIMP.getSitePropertyByName("startTime",siteId).getValue());
		this.timePerCustomer = LocalTime.parse(SitePropertyIMP.getSitePropertyByName("timePerCustomer",siteId).getValue());;
	}

	@Override
	public String toString() {
		return "Day [id=" + id + ", customers=" +
	customers +
	", Date=" + Date + ", siteId=" + siteId + ", startTime="
				+ startTime + ", timePerCustomer=" + timePerCustomer + "]";
	}

	public Day() {
		super();
	}
	
}
