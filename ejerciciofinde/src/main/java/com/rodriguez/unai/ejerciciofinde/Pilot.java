package com.rodriguez.unai.ejerciciofinde;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer license;
	@OneToOne
	private Aircraft aircraft;
	
	public Pilot() {
		
	}
	
	public Pilot(String name, Integer license) {
		this.name = name;
		this.license = license;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLicense() {
		return license;
	}

	public void setLicense(Integer license) {
		this.license = license;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", name=" + name + ", license=" + license + ", aircraft=" + aircraft + "]";
	}
	
	

}
