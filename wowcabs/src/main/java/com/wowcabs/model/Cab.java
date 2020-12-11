package com.wowcabs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cab")
public class Cab {

	@Id
	private Integer cid;
	@Column
	private String cabType;
	@Column
	private int perKmPrice;
	
	@Column
	private Integer city_id;
	
	public Cab() {
		// TODO Auto-generated constructor stub
	}
	

	public Integer getCityId() {
		return city_id;
	}


	public void setCityId(Integer city_id) {
		this.city_id = city_id;
	}


	public Cab(Integer cid, String cabType, int perKmPrice, Integer city_id) {
		super();
		this.cid = cid;
		this.cabType = cabType;
		this.perKmPrice = perKmPrice;
		this.city_id = city_id;
	}


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public int getPerKmPrice() {
		return perKmPrice;
	}

	public void setPerKmPrice(int perKmPrice) {
		this.perKmPrice = perKmPrice;
	}
	
}
