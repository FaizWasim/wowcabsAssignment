package com.wowcabs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	
	@Column
	@OneToMany(targetEntity = Cab.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id",referencedColumnName = "id")
	private List<Cab> cab;

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(Integer id, String name, List<Cab> cab) {
		super();
		this.id = id;
		this.name = name;
		this.cab = cab;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cab> getCab() {
		return cab;
	}

	public void setCab(List<Cab> cab) {
		this.cab = cab;
	}
	
	}
