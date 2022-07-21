package com.honey.Barber.Beans;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Month {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Day> Days;
	@Column
	private String siteId;
	@Column
	private int monthNumber;
	
	@Column
	private int year;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Day> getDays() {
		return Days;
	}
	public void setDays(List<Day> days) {
		Days = days;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public int getMonthNumber() {
		return monthNumber;
	}
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	
	public Month(int id, List<Day> days, String siteId, int monthNumber, int year) {
		super();
		this.id = id;
		Days = days;
		this.siteId = siteId;
		this.monthNumber = monthNumber;
		this.year = year;
	}
	public Month() {
		super();
	}
	
	
}
