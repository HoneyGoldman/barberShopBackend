package com.honey.Barber.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Location(int id, String location) {
		super();
		this.id = id;
		this.location = location;
	}
	public Location() {
		super();
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + "]";
	}
	
	
}



	