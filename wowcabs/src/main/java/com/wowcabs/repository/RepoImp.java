package com.wowcabs.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wowcabs.model.Cab;

@Repository
public class RepoImp implements Repo {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Cab> findByCityId(Integer city_id) {
		Session session = entityManager.unwrap(Session.class);

			String query = "from Cab where city_id=:city_id";
			@SuppressWarnings("unchecked")
			List<Cab> cab = session.createQuery(query).setParameter("city_id", city_id).getResultList();
			return cab;
		}

}