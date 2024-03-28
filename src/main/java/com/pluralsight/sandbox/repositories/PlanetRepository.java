package com.pluralsight.sandbox.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pluralsight.sandbox.model.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {
	public Planet findByOrderFromSun(int orderFromSun);
}
