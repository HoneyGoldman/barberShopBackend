package com.honey.Barber.Beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	String siteId;
//	"DATETIME default '1900-01-01 00:00:00'"
	@Column
	@JsonFormat(pattern="dd-MM-yyyy")
	LocalDate date;
	
	@Column
	@JsonFormat(pattern="HH:mm:ss")
	LocalTime startTime;
	
	@OneToOne
	Customer customer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public Appointment() {
		super();
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Appointment(int id, String siteId, LocalDate date, LocalTime startTime, Customer customer) {
		super();
		this.id = id;
		this.siteId = siteId;
		this.date = date;
		this.startTime = startTime;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", siteId=" + siteId + ", date=" + date + ", startTime=" + startTime
				+ ", customer=" + customer + "]";
	}


}
