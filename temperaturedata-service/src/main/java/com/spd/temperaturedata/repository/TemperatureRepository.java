package com.spd.temperaturedata.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spd.temperaturedata.model.Temperature;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, Integer> {

	public List<Temperature> findByUserName(String userName);
}
