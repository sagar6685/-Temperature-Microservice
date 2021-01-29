package com.spd.temperaturedata.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spd.temperaturedata.constant.TemperatureConstant;
import com.spd.temperaturedata.model.Temperature;
import com.spd.temperaturedata.service.TemperatureService;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

	private static final Logger logger = LoggerFactory.getLogger(TemperatureController.class);

	@Autowired
	private TemperatureService temperatureService;

	@PostMapping("/upload")
	public String uploadTemperatureData(@RequestBody Temperature temperature) {
		logger.info("Inside uploadTemperatureData method of TemperatureController");
		temperatureService.saveTemperatureData(temperature);
		return TemperatureConstant.SUCCESS_RESPONSE + " " + temperature.getId();
	}

	@GetMapping("/findByUserName/{userName}")
	public List<Temperature> getTemperatureByUserName(@PathVariable("userName") String userName) {
		logger.info("Inside getTemperatureByUserName method of TemperatureController");
		return temperatureService.findByUserName(userName);
	}

	@GetMapping("/findTemperatureById/{id}")
	public Optional<Temperature> getTemperatureById(@PathVariable int id) {
		logger.info("Inside getTemperatureById method of TemperatureController");
		return temperatureService.temperatureById(id);
	}

	@Timed(value = "getAllTemperature", 
			histogram = true, 
			percentiles = { 0.95, 0.99 }, 
			extraTags = { "version","1.0" })
	@GetMapping("/findAllTemperatur")
	public List<Temperature> getAllTemperature() {
		logger.info("Inside getAllTemperature method of TemperatureController");
		return temperatureService.getAllTemperature();
	}

}
