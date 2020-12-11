package com.wowcabs.dto;

import com.wowcabs.model.City;

public class DTOCity {
	private City city;
	public DTOCity() {
		// TODO Auto-generated constructor stub
	}
	public DTOCity(City city) {
		super();
		this.city = city;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
}
