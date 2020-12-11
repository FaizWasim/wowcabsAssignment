package com.wowcabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wowcabs.model.City;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {

//subquery	@Query("select * from cab where city_id in(select id from city where id=2);")
	
//	@Query("select * from cab join city on city_id=id")
//	public String getAllInformation();
}
