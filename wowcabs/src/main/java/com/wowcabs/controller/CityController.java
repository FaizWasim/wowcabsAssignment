package com.wowcabs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wowcabs.dto.DTOCity;
import com.wowcabs.exception.ResourceNotFoundException;
import com.wowcabs.model.Cab;
import com.wowcabs.model.City;
import com.wowcabs.repository.CabRepo;
import com.wowcabs.repository.CityRepo;
import com.wowcabs.repository.Repo;

@RestController
@RequestMapping(value = "/api/")
public class CityController {

	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private CabRepo cabRepo;
	@Autowired
	private Repo repo;

//create cities restAPI
	@PostMapping("/city")
	public City createCity(@RequestBody DTOCity city) {
		return cityRepo.save(city.getCity());
	}

//get city by cityId(id)
	@GetMapping("/city/{id}")
	public ResponseEntity<City> getCityById(@PathVariable Integer id) {
		City city = cityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("City not availbale with the id : " + id));
		return ResponseEntity.ok(city);
	}

//get all cities restAPI
	@GetMapping("/getAllCites")
	public List<City> getAllCity() {
		return cityRepo.findAll();
	}

//update city by cityId(id)
	@PutMapping("/city/{id}")
	public ResponseEntity<City> updateCity(@PathVariable Integer id, @RequestBody City cityDetails) {
		City city = cityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("City not available with the id : " + id));

		city.setName(cityDetails.getName());

		City updatedCity = cityRepo.save(city);
		return ResponseEntity.ok(updatedCity);
	}

//delete city by cityId(id)
	@DeleteMapping("/city/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCity(@PathVariable Integer id) {
		City city = cityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("City not available with the id : " + id));

		cityRepo.delete(city);

		Map<String, Boolean> response = new HashMap<>();
		response.put("DELETED", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

//get all cabs
	@GetMapping("/getAllCabs")
	public List<Cab> getAllCab() {
		return cabRepo.findAll();
	}

//get cabs by cityId
	@GetMapping("/cabs/{city_id}")
	public List<Cab> getCabByCityId(@PathVariable Integer city_id) {
		List<Cab> cab = repo.findByCityId(city_id);
		return cab;
	}

//create cab restAPI
	@PostMapping("/cabs")
		public Cab createCab(@RequestBody Cab cab) {
			return cabRepo.save(cab);
	}

// delete cab by cabId(cid)
	@DeleteMapping("/cab/{cid}")
	public ResponseEntity<Map<String, Boolean>> deleteCab(@PathVariable Integer cid) {
		Cab cab = cabRepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("Cab not availbale with the id : " + cid));

		cabRepo.delete(cab);

		Map<String, Boolean> response = new HashMap<>();
		response.put("DELETED", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
