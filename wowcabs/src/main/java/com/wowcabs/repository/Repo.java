package com.wowcabs.repository;

import java.util.List;

import com.wowcabs.model.Cab;

public interface Repo {
	public List<Cab> findByCityId(Integer cityId);
}
