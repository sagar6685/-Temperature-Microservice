package com.spd.temperaturedata.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spd.temperaturedata.model.Temperature;
import com.spd.temperaturedata.repository.TemperatureRepository;
import com.spd.temperaturedata.service.TemperatureService;

@Service("TemperatureServiceImpl")
public class TemperatureServiceImpl implements TemperatureService {

	private static final Logger logger = LoggerFactory.getLogger(TemperatureServiceImpl.class);
	
	@Autowired
	private TemperatureRepository temperatureRepository;

	public Temperature saveTemperatureData(Temperature temperature) {
		logger.info("Inside saveTemperatureData of TemperatureService");
		return temperatureRepository.save(temperature);
	}

	public List<Temperature> findByUserName(String userName) {
		logger.info("Inside findByUserName of TemperatureService");
		return temperatureRepository.findByUserName(userName);
	}

	public List<Temperature> getAllTemperature() {
		logger.info("Inside getAllTemperature of TemperatureService");
		return temperatureRepository.findAll();
	}

	public Optional<Temperature> temperatureById(int id) {
		logger.info("Inside temperatureById of TemperatureService");
		return temperatureRepository.findById(id);
	}

}
