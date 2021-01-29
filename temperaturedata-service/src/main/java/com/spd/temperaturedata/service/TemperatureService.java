package com.spd.temperaturedata.service;

import java.util.List;
import java.util.Optional;

import com.spd.temperaturedata.model.Temperature;

public interface TemperatureService {

	public Temperature saveTemperatureData(Temperature temperature);

	public List<Temperature> findByUserName(String userName);

	public List<Temperature> getAllTemperature();

	public Optional<Temperature> temperatureById(int id);

}
