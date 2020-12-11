package com.wowcabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wowcabs.model.Cab;

@Repository
public interface CabRepo extends JpaRepository<Cab, Integer> {

}
