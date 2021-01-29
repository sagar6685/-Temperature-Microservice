package com.spd.temperaturedata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Temperature")
public class Temperature {

	@Id
	private int id;
	private String userName;
	private String temperatureValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(String temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
